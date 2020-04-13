package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[3];      //массив спрайтов из 10 элемонтов
    BackGround bg= new BackGround();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        GameCanvas canvas = new GameCanvas(this);
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        initApplication();



        setVisible(true);
    }
    void Sharic(GameCanvas canvas,Graphics g){
      canvas.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseReleased(MouseEvent e) {
            int i=0;
            sprites[i]=new Ball();
            sprites[i].render(canvas,g);
            i++;
        }}
    );
    }

    private void initApplication() {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }

    void onCanvasRepainted(GameCanvas canvas, Graphics g, float deltaTime) { //состоит из пользовательского ввода, обновления и отрисовки
        update(canvas, deltaTime);              //обновление. обновлять будем объекты на канве, относительно прошедшего времени
        render(canvas, g);                      //отрисовка. компоненты на канве, при побощи объекты графики
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
        bg.update(canvas,deltaTime);
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
        bg.render(canvas,g);
        Sharic(canvas,g);

    }
}
