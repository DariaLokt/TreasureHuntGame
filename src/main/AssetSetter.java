package main;

import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {
    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void setObject() {
        gamePanel.objects[0] = new OBJ_Key();
        gamePanel.objects[0].setWorldX(32 * gamePanel.tileSize);
        gamePanel.objects[0].setWorldY(27 * gamePanel.tileSize);

        gamePanel.objects[1] = new OBJ_Key();
        gamePanel.objects[1].setWorldX(40 * gamePanel.tileSize);
        gamePanel.objects[1].setWorldY(10 * gamePanel.tileSize);

        gamePanel.objects[2] = new OBJ_Door();
        gamePanel.objects[2].setWorldX(16 * gamePanel.tileSize);
        gamePanel.objects[2].setWorldY(22 * gamePanel.tileSize);
    }
}
