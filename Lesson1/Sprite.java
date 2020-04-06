package ru.geekbrains.java2.lesson1;

import java.awt.*;

public abstract class Sprite {      //класс двумерного объекта
                                    //двумерный объект. который может рисоваться
                                    //объект который где то находится и имеет какие то размеры
    protected float x;              //координаты объекта. центр
    protected float y;
    protected float halfWidth;      //полуширина
    protected float halfHeight;     //полувысота. мы хотим окружность рисовать от центра

    protected float getLeft() {         //достать левую границу
        return x - halfWidth;
    }
    protected void setLeft(float left) { //установка левой границы
        x = left + halfWidth;
    }
    protected float getRight() {
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() {
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }
    protected float getWidth() {        //достать ширину
        return 2f * halfWidth;
    }
    protected float getHeight() {       //достать высоту
        return 2f * halfHeight;         //точная координата высчитывается с флоутом, потому что движется объект
                                        //потом они приведутся к инту
    }

    void update(GameCanvas canvas, float deltaTime) {} //спрайт может обновляться
    void render(GameCanvas canvas, Graphics g) {}      //и отрисовываться

}
