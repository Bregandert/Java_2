package ru.geekbrains.java2.lesson5;

import org.w3c.dom.ls.LSOutput;

public class Main {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        metod1(size);
        metod2(size,h);
    }

    private static void metod1(int size) {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//            System.out.print(arr[i]+" ");
        }
        System.out.println("Время на один поток: "+(System.currentTimeMillis() - a));
    }

    private static void metod2(int size, int h) {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < h; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(a1, 0, arr, 0, h);
            }
        };
        Runnable r2=new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < h; i++) {
                    a2[i] = (float) (a2[i]* Math.sin(0.2f + (h+i)/ 5) * Math.cos(0.2f + (h+i)/ 5) * Math.cos(0.4f + (h+i) / 2));
                }
                System.arraycopy(a2, 0, arr, h, h);
            }
        };
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Время на два потока: "+(System.currentTimeMillis() - a));

//        for (int i = 0; i < size; i++) {
//            System.out.print(arr[i]+" ");
//        }

    }
}
