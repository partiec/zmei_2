package org.example;

import org.example.snake_and_food.Food;
import org.example.snake_and_food.Snake;
import org.example.view.View;

public class Game {

    public static Game game;
    public static Snake snake;
    public static Food food;
    public static boolean gameOver = false;



    public static void main(String[] args) {
        game = new Game();
        snake = new Snake(Constants.START_SNAKE_X, Constants.START_SNAKE_Y, Constants.START_SNAKE_SIZE, Constants.START_DIRECTION);
        food = new Food();
        game.go();
    }

    void go() {
        View.viewField();



        while (!gameOver) {
            snake.move();
            if (food.isEaten()) {
                food.next();
            }
            View.canvasik.repaint();
            try {
                Thread.sleep(Constants.SHOW_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}