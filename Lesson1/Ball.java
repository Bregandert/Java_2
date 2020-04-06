package ru.geekbrains.java2.lesson1;

import java.awt.*;

public class Ball extends Sprite {

    private final Color color = new Color ( //задаем цвет
            (int)(Math.random() * 255),     //кодировка цвета по цветам. красный
            (int)(Math.random() * 255),     //зеленый
            (int)(Math.random() * 255)      //голубой
    );                                       //что еще за 4ый инт в конструкторе?
    private float vX = (float)(100f + (Math.random() * 200f)); //скорость случайное число. Начальная скорость 100
    private float vY = (float)(100f + (Math.random() * 200f));  //в нашем случае в пикселях в секунду

    Ball() {                                            //конструктор мячика
        halfHeight = 20 + (float)(Math.random() * 50f);
        halfWidth = halfHeight;
    }

    @Override
    void update(GameCanvas canvas, float deltaTime) {       //мячик обновляется
        x += vX * deltaTime;                                //координата х изменяется на Vx за такт
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) {                 //левая граница шарика меньше по координатам левой границы канвы
            setLeft(canvas.getLeft());
            vX = -vX;                                       //шарик разворачивается по иксу
        }
        if (getRight() > canvas.getRight()) {
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) {
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) {
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    void render(GameCanvas canvas, Graphics g) { //мячик понимает как он рисуется. у него есть объект графики
        g.setColor(color);                        //устанавливаю ему цвет
        g.fillOval((int) getLeft(), (int) getTop(), //рисую заполненный овал с такими координатами
                (int) getWidth(), (int) getHeight());   //и такого размера
    }


}
