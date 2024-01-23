package org.example.snake_and_food;

import org.example.Constants;
import org.example.Game;

import java.util.Random;

public class Food extends Point {


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
        } while (Game.snake.isInsideSnake(x, y));
        this.setXY(x, y);

    }


}
