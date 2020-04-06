package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;

public class BackGround extends Sprite {    //бэкграунд у нас наследник двумерной графики спрайта


    int r=(int)(Math.random() * 255);
    int g=(int)(Math.random() * 255);
    int b=(int)(Math.random() * 255);
    private Color color=new Color(r,g,b);
    int Vr=1;
    int Vg=1;
    int Vb=5;
    //сделал стробоскоп, потом нашел код судя по всему копипаст с Вашего (возможно с изменениям. аля чтоб никто не заподозрил :)) и постарался в нем разобраться
    //все основано на синусах или косинусах и том что они принимают значения от -1 до 1. при этом значение меняется плавно
    //то есть мы используем для смены цветов не рандом а плавное изменение кодировки цвета по каждому из цветов
    //умножение времени на 2f и 3f как я понял чтобы цифры не меняли одинаково. Хотя в этом случае вроде цвет должен меняться от холодного к теплому и наоборот. могу ошибаться не силен в цветах
    //вопрос: в коде мы округляем параметры, чтобы привести их к инту. но color в качестве параметров может принимать и флоат. только вот когда я попытался это сделать программа выдала исключение. что за исключение?


    //Ну и собственно менее изящный способ плавного переключения цвета
    @Override
    void update(GameCanvas canvas, float deltaTime) {
        if (r>=255-Math.abs(Vr)||r<=0+Math.abs(Vr)){
            Vr=Vr*(-1);
        }
        r+=Vr;
        if (g>=255-Math.abs(Vg)||g<=0+Math.abs(Vg)){
            Vg=Vg*(-1);
        }
        g+=Vg;
        if (b>=255-Math.abs(Vb)||b<=0+Math.abs(Vb)){
            Vb=Vb*(-1);
        }
        b+=Vb;

        color=new Color (r,g,b);
                /*(int) (Math.random() * 255),
                (int) (Math.random() * 255),
                (int) (Math.random() * 255)
        );*/
    }

    @Override
    void render(GameCanvas canvas, Graphics g) { //мячик понимает как он рисуется. у него есть объект графики
        canvas.setBackground(color);

    }

}
