package org.example.view;

import org.example.Constants;
import org.example.Game;
import org.example.snake_and_food.Food;
import org.example.snake_and_food.Snake;

import javax.swing.*;
import java.awt.*;

public class Canvasik extends JPanel {

    private Snake snake = Game.game.snake;
    private Food food = Game.game.food;
    @Override
    public void paint(Graphics q) {
        super.paint(q);
        snake.paint(q);
        food.paint(q);
        if (Game.gameOver) {
            q.setColor(Color.red);
            q.setFont(new Font("Arial", Font.BOLD, 38));
            FontMetrics fm = q.getFontMetrics();
            q.drawString(Constants.GAME_OVER_MSG, (
                    Constants.FILLED_WIDTH * Constants.POINT_RADIUS + Constants.FILLED_DX - fm.stringWidth(Constants.GAME_OVER_MSG)) / 2,
                    (Constants.FILLED_HEIGHT * Constants.POINT_RADIUS + Constants.FILLED_DY) / 2);
        }
    }

}
