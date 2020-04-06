package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;

public class GameCanvas extends JPanel {

    MainCircles listener;
    long lastFrameTime;                         //создаем ластфреймтайм

    GameCanvas(MainCircles listener) {          //конструктор канвы
                                                //при создании нашей канвы (панельки) мы должны указать
                                                // нашей панельке какой нибудь класс, который будет ее слушать
                                                //канва будет каждый раз говорить я отрисовалась
//                                              //а кто ее слушает (и будет ли вообще кто то случшать) ей плевать
        this.listener = listener;
        lastFrameTime = System.nanoTime();
    }



    @Override
    protected void paintComponent(Graphics g) { //что делает любой пэнт компонет - перерисовывается.
                                                //заставит нарисоваться все что есть на геймканвас
        super.paintComponent(g);                //рисует все что мы ему дали. мы передали графику
        //60 frames per second
        long currentTime = System.nanoTime();   //текущее время берем из нановремени. текущее время в наносекундах. системное время в общем
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f; //посчитали дельту между перерисовками
        lastFrameTime = currentTime;            //ластфреймтайм равно текущее
        listener.onCanvasRepainted(this, g, deltaTime);
        try {
            Thread.sleep(17);           //заставляем канву поспать не рисоваться 17мсек=1000мсек/60кадров
        } catch (InterruptedException e) {      //будем еще говорить про него
            e.printStackTrace();
        }
        repaint();              //заставляет пэнт компонент выполниться еще раз. напомню пэйнт компонент рисуется
                                // по факту пэйнт компонент и репэйнт это тот самый игровой (бесконечный) цикл. получили данные действие результат
                                //действие пишем между ними
    }

    public int getLeft() { return 0; }                      //простые геттеры
    public int getRight() { return getWidth() - 1; }        //вернут нам размеры панельки при вызове
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}