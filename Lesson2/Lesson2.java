package ru.geekbrains.java2.lesson2;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Arrays;

public class Lesson2 {
    static String a="10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";


    public static void main(String[] arg) {
        try {
            String[][] arr1=vMassiv(a);
            System.out.println();
            int[][] arr=vInt(arr1);
            System.out.println();
            System.out.println(sum(arr));
        } catch (exeption4_4 e){
            e.printStackTrace();
            System.out.println("Введите строку являющуюся массивом 4/4");
        } catch (NumberFormatException e){
            e.printStackTrace();
            System.out.println("В массиве символы не являющиеся интами");
    }}

    public static String[][] vMassiv(String a) throws exeption4_4 {
        String[] arr=a.split("\n");
        System.out.println(Arrays.toString(arr));
        String[][] arrString=new String[4][4];
        for (int i=0; i<arrString.length; i++) {
            if (arr.length!=4){
                throw new exeption4_4();
            }
            for (int j=0; j<arrString[0].length; j++){

                String[] s=arr[i].split(" ");
                if (s.length!=4){
                    throw new exeption4_4();
                }
                arrString[i][j]=s[j];
            }
            System.out.println(Arrays.toString(arrString[i]));

        }
        return arrString;

    }

    public static int[][] vInt(String[][] b) throws NumberFormatException{
        int[][] arrInt=new int[4][4];
        for (int i=0; i<b.length; i++){
            for (int j=0; j<b[0].length; j++){
                arrInt[i][j]=Integer.parseInt(b[i][j]);
            }

            System.out.println(Arrays.toString(arrInt[i]));
        }


        return arrInt;
    }

    public static float sum(int[][] c){
        float summa=0;
        for (int i=0;i<c.length;i++){
            for (int j=0;j<c[0].length;j++){
                summa+=c[i][j];
            }
        }
        summa=summa/2f;
        return summa;
    }


}
