package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldX, worldY;
    public int speed;

    public BufferedImage still, moving1, moving2;
    public String movingStatus;
    public String direction;

    public int spriteCounter = 0;
    public int spriteNumber = 1;

    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public int getWorldX() {
        return worldX;
    }

    public void setWorldX(int worldX) {
        this.worldX = worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public void setWorldY(int worldY) {
        this.worldY = worldY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public BufferedImage getStill() {
        return still;
    }

    public void setStill(BufferedImage still) {
        this.still = still;
    }

    public BufferedImage getMoving1() {
        return moving1;
    }

    public void setMoving1(BufferedImage moving1) {
        this.moving1 = moving1;
    }

    public BufferedImage getMoving2() {
        return moving2;
    }

    public void setMoving2(BufferedImage moving2) {
        this.moving2 = moving2;
    }

    public String getMovingStatus() {
        return movingStatus;
    }

    public void setMovingStatus(String movingStatus) {
        this.movingStatus = movingStatus;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getSpriteCounter() {
        return spriteCounter;
    }

    public void setSpriteCounter(int spriteCounter) {
        this.spriteCounter = spriteCounter;
    }

    public int getSpriteNumber() {
        return spriteNumber;
    }

    public void setSpriteNumber(int spriteNumber) {
        this.spriteNumber = spriteNumber;
    }

    public Rectangle getSolidArea() {
        return solidArea;
    }

    public void setSolidArea(Rectangle solidArea) {
        this.solidArea = solidArea;
    }

    public boolean isCollisionOn() {
        return collisionOn;
    }

    public void setCollisionOn(boolean collisionOn) {
        this.collisionOn = collisionOn;
    }
}
