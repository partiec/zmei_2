package org.example.snake_and_food;

import org.example.Constants;

import java.awt.*;

class Point {

    int x, y;
    Color color = Constants.DEFAULT_COLOR;

    public Point(int x, int y) {
        this.setXY(x, y);
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x * Constants.POINT_RADIUS, y * Constants.POINT_RADIUS, Constants.POINT_RADIUS, Constants.POINT_RADIUS);
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
