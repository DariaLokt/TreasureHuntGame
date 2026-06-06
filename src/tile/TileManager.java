package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gamePanel;
    public Tile[] tile;
    public int[][] mapTileNum;
    final static String MAP_1 = "/maps/Map01.txt";
    final static String WORLD_1 = "/maps/World01.txt";

    public TileManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        tile = new Tile[10];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRaw];
        getTileImage();
        loadMap(WORLD_1);
    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png")));

            tile[1] = new Tile();
            tile[1].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png")));
            tile[1].setCollision(true);

            tile[2] = new Tile();
            tile[2].setImage(ImageIO.read(getClass().getResourceAsStream("/tiles/water.png")));
            tile[2].setCollision(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int worldCol = 0;
        int worldRaw = 0;

        while (worldCol < gamePanel.maxWorldCol && worldRaw < gamePanel.maxWorldRaw) {
            int tileNum = mapTileNum[worldCol][worldRaw];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRaw * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                    worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                    worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY
            ) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }
            worldCol++;
            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRaw++;
            }
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRaw) {
                String line = br.readLine();
                while (col < gamePanel.maxWorldCol) {
                    String[] numbers = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gamePanel.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        } catch (Exception e) {

        }
    }
}
