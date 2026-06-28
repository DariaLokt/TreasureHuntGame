package main;

import object.OBJ_Boot;
import object.OBJ_Chest;
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

        gamePanel.objects[3] = new OBJ_Boot();
        gamePanel.objects[3].setWorldX(6 * gamePanel.tileSize);
        gamePanel.objects[3].setWorldY(23 * gamePanel.tileSize);

        gamePanel.objects[4] = new OBJ_Boot();
        gamePanel.objects[4].setWorldX(23 * gamePanel.tileSize);
        gamePanel.objects[4].setWorldY(25 * gamePanel.tileSize);

        gamePanel.objects[5] = new OBJ_Boot();
        gamePanel.objects[5].setWorldX(28 * gamePanel.tileSize);
        gamePanel.objects[5].setWorldY(25 * gamePanel.tileSize);

        gamePanel.objects[6] = new OBJ_Key();
        gamePanel.objects[6].setWorldX(27 * gamePanel.tileSize);
        gamePanel.objects[6].setWorldY(29 * gamePanel.tileSize);

        gamePanel.objects[7] = new OBJ_Chest();
        gamePanel.objects[7].setWorldX(34 * gamePanel.tileSize);
        gamePanel.objects[7].setWorldY(35 * gamePanel.tileSize);
    }
}
