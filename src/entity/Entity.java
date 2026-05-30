package entity;

import java.awt.image.BufferedImage;

public class Entity {
    public int x, y;
    public int speed;

    public BufferedImage still, moving1, moving2;
    public String movingStatus;

    public int spriteCounter = 0;
    public int spriteNumber = 1;
}
