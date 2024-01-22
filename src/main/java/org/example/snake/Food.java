package org.example.snake;

import org.example.Constants;
import org.example.GameSnake;

import java.util.Random;

public class Food extends Point {

    private GameSnake gameSnake= GameSnake.instance();
    private Snake snake = gameSnake.snake;
    private Random random = new Random();

    public Food() {
        super(-1, -1);
        this.color = Constants.FOOD_COLOR;
    }

    void eat() {
        this.setXY(-1, -1);
    }

    public boolean isEaten() {
        return this.getX() == -1;
    }

    public void next() {
        int x, y;
        do {
            x = random.nextInt(Constants.FILLED_WIDTH);
            y = random.nextInt(Constants.FILLED_HEIGHT);
        } while (snake.isInsideSnake(x, y));
        this.setXY(x, y);

    }


}
