package org.example.snake;

import org.example.Constants;
import org.example.GameSnake;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.Event.DOWN;


public class Snake {
    private GameSnake gameSnake = GameSnake.instance();
    private Food food = new Food();
    ArrayList<Point> snake = new ArrayList<Point>();
    int direction;
    private boolean gameOver = false;

    public Snake(int x, int y, int length, int direction) {
        for (int i = 0; i < length; i++) {
            Point point = new Point(x - i, y);
            snake.add(point);
        }
        this.direction = direction;
    }

    boolean isInsideSnake(int x, int y) {
        for (Point point : snake) {
            if ((point.getX() == x) && (point.getY() == y)) {
                return true;
            }
        }
        return false;
    }

    boolean isFood(Point food) {
        return ((snake.get(0).getX() == food.getX()) && (snake.get(0).getY() == food.getY()));
    }

    public void move() {
        int x = snake.get(0).getX();
        int y = snake.get(0).getY();
        if (direction == Constants.LEFT) {
            x--;
        }
        if (direction == Constants.RIGHT) {
            x++;
        }
        if (direction == Constants.UP) {
            y--;
        }
        if (direction == DOWN) {
            y++;
        }
        if (x > Constants.FILLED_WIDTH - 1) {
            x = 0;
        }
        if (x < 0) {
            x = Constants.FILLED_WIDTH - 1;
        }
        if (y > Constants.FILLED_WIDTH - 1) {
            y = 0;
        }
        if (y < 0) {
            y = Constants.FILLED_HEIGHT - 1;
        }
        gameOver = isInsideSnake(x, y);//check for cross itselves
        snake.add(0, new Point(x, y));
        if (isFood(food)) {
            food.eat();
            gameSnake.frame.setTitle(Constants.TITLE_OF_PROGRAM + " : " + snake.size());
        } else {
            snake.remove(snake.size() - 1);
        }
    }

    public void setDirection(int direction) {
        if ((direction >= Constants.LEFT) && (direction <= DOWN)) {
            if (Math.abs(this.direction - direction) != 2) {
                this.direction = direction;
            }
        }
    }

    void paint(Graphics g) {
        for (Point point : snake) {
            point.paint(g);
        }
    }
}
