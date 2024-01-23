package org.example.snake_and_food;

import org.example.Constants;
import org.example.Game;
import org.example.view.View;

import java.awt.*;
import java.util.ArrayList;




public class Snake {


    private Food food;
    ArrayList<Point> snakeList = new ArrayList<Point>();
    int direction;
    private boolean gameOver = false;

    public Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            snakeList.add(point);
        }
        this.direction = direction;
    }


    boolean isInsideSnake(int x, int y) {
        for (Point point : snakeList) {
            if ((point.getX() == x) && (point.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    boolean foundFood(Point food) {
        return ((snakeList.get(0).getX() == food.getX()) && (snakeList.get(0).getY() == food.getY()));
    }

    public void move() {
        int x = snakeList.get(0).getX();
        int y = snakeList.get(0).getY();
        if (direction == Constants.LEFT) {
            x--;
        }
        if (direction == Constants.RIGHT) {
            x++;
        }
        if (direction == Constants.UP) {
            y--;
        }
        if (direction == Constants.DOWN) {
            y++;
        }
        if (x > Constants.FILLED_WIDTH - 1) {
            x = 0;
        }
        if (x < 0) {
            x = Constants.FILLED_WIDTH - 1;
        }
        if (y > Constants.FILLED_HEIGHT - 1) {
            y = 0;
        }
        if (y < 0) {
            y = Constants.FILLED_HEIGHT - 1;
        }
        gameOver = isInsideSnake(x, y);//check for cross itselves
        snakeList.add(0, new Point(x, y));

        food = Game.game.food;
        if (foundFood(food)) { // если наехала на еду?
            food.eat(); // съесть еду
            View.frame.setTitle(Constants.TITLE_OF_PROGRAM + " : " + snakeList.size());
        } else {
            snakeList.remove(snakeList.size() - 1);
        }
    }

    public void setDirection(int direction) {
        if ((direction >= Constants.LEFT) && (direction <= Constants.DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    public void paint(Graphics g) {
        for (Point point : snakeList) {
            point.paint(g);
        }
    }
}
