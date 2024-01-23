package org.example.view;

import org.example.Constants;
import org.example.Game;
import org.example.snake_and_food.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View {
    public static JFrame frame;
    public static Snake snake = Game.snake;
    public static Canvasik canvasik = new Canvasik();
    public static void viewField(){
        frame = new JFrame(Constants.TITLE_OF_PROGRAM + " : " + Constants.START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.FILLED_WIDTH * Constants.POINT_RADIUS + Constants.FILLED_DX, Constants.FILLED_HEIGHT * Constants.POINT_RADIUS + Constants.FILLED_DY);
        frame.setLocation(Constants.START_LOCATION, Constants.START_LOCATION);
        frame.setResizable(false);

        canvasik.setBackground(Color.white);

        frame.getContentPane().add(BorderLayout.CENTER, canvasik);
        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
                System.out.println(e.getKeyCode());
            }
        });

        frame.setVisible(true);
    }
}
