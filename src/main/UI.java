package main;

import object.OBJ_Boot;
import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gamePanel;
    private static final Font ARIEL_40 = new Font("Arial", Font.PLAIN, 40);
    BufferedImage keyImage;
    BufferedImage bootImage;

    public UI(GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        OBJ_Key key = new OBJ_Key();
        keyImage = key.image[key.state];

        OBJ_Boot boot = new OBJ_Boot();
        bootImage = boot.image[key.state];
    }

    public void draw(Graphics2D g2) {
        g2.setFont(ARIEL_40);
        g2.setColor(Color.ORANGE);

        g2.drawImage(keyImage, gamePanel.tileSize / 4, gamePanel.tileSize / 4, gamePanel.tileSize, gamePanel.tileSize, null);
        g2.drawImage(bootImage, gamePanel.tileSize / 4, gamePanel.tileSize * 4 / 3, gamePanel.tileSize, gamePanel.tileSize, null);

        g2.drawString(": " + gamePanel.player.hasKey, gamePanel.tileSize, gamePanel.tileSize);
        g2.drawString(": " + gamePanel.player.hasBoots, gamePanel.tileSize, gamePanel.tileSize * 2);
    }
}
