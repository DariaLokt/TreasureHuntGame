package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
        movingStatus = "still";
    }

    public void getPlayerImage() {
        try {
            still = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/1.png"));
            moving1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/2.png"));
            moving2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyHandler.upPressed) {
            y -= speed;
            movingStatus = "moving";
        }
        if (keyHandler.downPressed) {
            y += speed;
            movingStatus = "moving";
        }
        if (keyHandler.rightPressed) {
            x += speed;
            movingStatus = "moving";
        }
        if (keyHandler.leftPressed) {
            x -= speed;
            movingStatus = "moving";
        }
        if (!keyHandler.upPressed && !keyHandler.downPressed && !keyHandler.rightPressed && !keyHandler.leftPressed) {
            movingStatus = "still";
        }

        spriteCounter++;
        if (spriteCounter > 20) {
            if (spriteNumber == 1) {
                spriteNumber = 2;
            } else if (spriteNumber == 2) {
                spriteNumber = 1;
            }
            spriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {
//        g2.setColor(Color.pink);
//        g2.fillRect(x, y, gamePanel.tileSize, gamePanel.tileSize);
        BufferedImage image;
        image = switch (movingStatus) {
            case "moving" -> {
                if (spriteNumber == 1) {
                    yield moving1;
                }
                if (spriteNumber == 2) {
                    yield moving2;
                } else yield still;
            }
            case "still" -> still;
            default -> throw new IllegalStateException("Unexpected value: " + movingStatus);
        };
        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
