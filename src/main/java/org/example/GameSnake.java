package org.example;

import org.example.snake.Canvasik;
import org.example.snake.Food;
import org.example.snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameSnake {

    private static final  GameSnake INSTANCE = new GameSnake();

    public static Snake snake = null;
    public static Food food = null;
    //Poison poison;
    public static  JFrame frame = null;
    public static Canvasik canvasik = null;
    public boolean gameOver = false;

    private GameSnake(){

    }

    public static GameSnake instance(){
        if (INSTANCE == null){
            return new GameSnake();
        }
        return INSTANCE;
    }



    public static void main(String[] args) {
        new GameSnake().go();
    }

    void go() {
        frame = new JFrame(Constants.TITLE_OF_PROGRAM + " : " + Constants.START_SNAKE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Constants.FILLED_WIDTH * Constants.POINT_RADIUS + Constants.FILLED_DX, Constants.FILLED_HEIGHT * Constants.POINT_RADIUS + Constants.FILLED_DY);
        frame.setLocation(Constants.START_LOCATION_X, Constants.START_LOCATION_Y);
        frame.setResizable(false);

        canvasik = new Canvasik();
        canvasik.setBackground(Color.white);

        frame.getContentPane().add(BorderLayout.CENTER, canvasik);
        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                snake.setDirection(e.getKeyCode());
                System.out.println(e.getKeyCode());
            }
        });

        frame.setVisible(true);

        snake = new Snake(Constants.START_SNAKE_X, Constants.START_SNAKE_Y, Constants.START_SNAKE_SIZE, Constants.START_DIRECTION);
        food = new Food();

        while (!gameOver) {
            snake.move();
            if (food.isEaten()) {
                food.next();
            }
            canvasik.repaint();
            try {
                Thread.sleep(Constants.SHOW_DEALAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}