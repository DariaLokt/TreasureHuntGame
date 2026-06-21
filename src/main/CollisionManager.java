package main;

import entity.Entity;
import object.SuperObject;

public class CollisionManager {
    GamePanel gamePanel;

    public CollisionManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public void checkTile(Entity entity) {
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entityLeftWorldX + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entityTopWorldY + entity.solidArea.height;

        int entityLeftCol = entityLeftWorldX / gamePanel.tileSize;
        int entityRightCol = entityRightWorldX / gamePanel.tileSize;
        int entityTopRow = entityTopWorldY / gamePanel.tileSize;
        int entityBottomRow = entityBottomWorldY / gamePanel.tileSize;

        int tileNum1;
        int tileNum2;

        switch (entity.direction) {
            case "up" -> {
                entityTopRow = (entityTopWorldY - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if (gamePanel.tileManager.tile[tileNum1].collision ||
                        gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "down" -> {
                entityBottomRow = (entityBottomWorldY + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision ||
                        gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "left" -> {
                entityLeftCol = (entityLeftWorldX - entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision ||
                        gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
            case "right" -> {
                entityRightCol = (entityRightWorldX + entity.speed) / gamePanel.tileSize;
                tileNum1 = gamePanel.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if (gamePanel.tileManager.tile[tileNum1].collision ||
                        gamePanel.tileManager.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
            }
        }
    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gamePanel.objects.length; i++) {
            SuperObject object = gamePanel.objects[i];
            if (object != null) {
                entity.solidArea.x = entity.getWorldX() + entity.solidArea.x;
                entity.solidArea.y = entity.getWorldY() + entity.solidArea.y;

                object.solidArea.x = object.getWorldX() + object.solidArea.x;
                object.solidArea.y = object.getWorldY() + object.solidArea.y;

                switch (entity.direction) {
                    case "up" -> {
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.isCollision()) {
                                entity.setCollisionOn(true);
                                entity.setWorldY(entity.getWorldY() + gamePanel.tileSize / 2);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case "down" -> {
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.isCollision()) {
                                entity.setCollisionOn(true);
                                entity.setWorldY(entity.getWorldY() - gamePanel.tileSize / 2);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case "left" -> {
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.isCollision()) {
                                entity.setCollisionOn(true);
                                entity.setWorldX(entity.getWorldX() + gamePanel.tileSize / 2);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                    case "right" -> {
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(object.solidArea)) {
                            if (object.isCollision()) {
                                entity.setCollisionOn(true);
                                entity.setWorldX(entity.getWorldX() - gamePanel.tileSize / 2);
                            }
                            if (player) {
                                index = i;
                            }
                        }
                    }
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                object.solidArea.x = object.solidAreaDefaultX;
                object.solidArea.y = object.solidAreaDefaultY;
            }
        }

        return index;
    }
}
