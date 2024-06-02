package Tile;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class tileManager {
    GamePanel gp;
    public tile[][] Tile;
    public int mapTileNum[][][];

    public tileManager(GamePanel gp) {
        this.gp = gp;
        Tile = new tile[2][150];

        mapTileNum = new int[gp.maxMap][50][50];
        getTileImage(gp.currentMap);
        loadMap("/maps/level_3.txt", 0);
        // loadMap("/maps/level_2.txt",1);
    }

    public void getTileImage(int currentmap) {
        try {
            int index;
            for (index = 0; index < 138; index++) {
                Tile[0][index] = new tile();
                String str = "/level_3/" + index + ".png";
                Tile[0][index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(str)));
                if (index != 0 && index != 4 && index != 59 && index != 84 && index != 85 && index != 108
                        && index != 109 && index != 21 && index != 23 && index != 24 && index != 26 && index != 99
                        && index != 97)
                    Tile[0][index].collision = true;
            }

            System.out.println((2));
            for (index = 0; index < 61; index++) {
                Tile[1][index] = new tile();
                String str = "/level_2/" + index + ".png";
                Tile[1][index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(str)));
                if (index != 0 && index != 30 && index != 31 && index != 29 && index != 45 && index != 7 && index != 52)
                    Tile[1][index].collision = true;
            }
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // public void getTileImage()
    // {
    // int index;
    // for (index = 0; index < 138; index++)
    // {
    // boolean collision = false;
    // if( index!= 0 && index!=4 && index!=59 && index!=84 && index!=85 &&
    // index!=108 && index!=109 && index!=21 && index!=23 && index!=24 && index!=26
    // && index!=99 && index!=97) collision = true;
    ////
    // setup(index, collision);
    // }
    // }
    //
    // public void setup(int index, boolean collision)
    // {
    // UtilityTools uTool = new UtilityTools();
    //
    // try
    // {
    // Tile[index] = new tile();
    // String str = "/level_3/" + index + ".png";
    // Tile[index].image =
    // ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream(str)));
    // Tile[index].image =
    // uTool.scaleImage(Tile[index].image,gp.tileSize,gp.tileSize);
    // Tile[index].collision = collision;
    // }
    //
    // catch(IOException e)
    // {
    // e.printStackTrace();
    // }
    // }
    public void loadMap(String filePath, int map) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[map][col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }

        catch (Exception e) {

        }
    }

    public void draw(Graphics2D G2) {
        int worldCol = 0;
        int worldRow = 0;
        // System.out.println(gp.maxWorldCol);

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[gp.currentMap][worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.player.worldX + gp.player.screenX;
            int screenY = worldY - gp.player.worldY + gp.player.screenY;
            if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
                    worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
                    worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
                    worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
                // G2.drawImage(Tile[tileNum].image,screenX,screenY,null);
                if (gp.currentMap == 0) {
                    G2.drawImage(Tile[0][tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                } else if (gp.currentMap == 1) {
                    G2.drawImage(Tile[1][tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
                }
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;
                worldRow++;

            }
        }
    }
}
