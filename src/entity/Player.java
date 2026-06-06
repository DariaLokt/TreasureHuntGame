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

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);

        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.height = 32;
        solidArea.width = 32;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gamePanel.tileSize * 23;
        worldY = gamePanel.tileSize * 21;
        speed = 4;
        movingStatus = "still";
        direction = "up";
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
        if (!keyHandler.rightPressed && !keyHandler.leftPressed &&
                !keyHandler.downPressed && !keyHandler.upPressed) {
            this.setMovingStatus("still");
        }
        if (keyHandler.upPressed) {
            this.setMovingStatus("moving");
            this.setDirection("up");
        }
        if (keyHandler.downPressed) {
            this.setMovingStatus("moving");
            this.setDirection("down");
        }
        if (keyHandler.rightPressed) {
            this.setMovingStatus("moving");
            this.setDirection("right");
        }
        if (keyHandler.leftPressed) {
            this.setMovingStatus("moving");
            this.setDirection("left");
        }

        /*
        CHECK COLLISION
         */
        this.setCollisionOn(false);
        gamePanel.collisionManager.checkTile(this);

        if (!collisionOn && movingStatus.equals("moving")) {
            switch (direction) {
                case "up" -> worldY -= speed;
                case "down" -> worldY += speed;
                case "left" -> worldX -= speed;
                case "right" -> worldX += speed;
            }
        }

        changeSpriteNumber();
    }

    private void changeSpriteNumber() {
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
        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
