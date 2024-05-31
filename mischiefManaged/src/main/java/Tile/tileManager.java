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

public class tileManager {
    GamePanel gp;
    public tile[] Tile;
    public int mapTileNum[][];
    public tileManager(GamePanel gp)
    {
      this.gp = gp;
      Tile = new tile[10];


      mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
      getTileImage();
      loadMap("/maps/world_01.txt");
    }

    public void getTileImage()
    {
            setup(0,"grass",false);
            setup(1,"wall",true);
            setup(2,"water",false);
            setup(3,"earth",false);
            setup(4,"tree",true);
            setup(5,"sand",false);
    }
    public void setup(int index,String imagePath,boolean collision)
    {
        UtilityTools uTool = new UtilityTools();
        try
        {
            Tile[index] = new tile();
            Tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tiles/" + imagePath+".png"));
            Tile[index].image = uTool.scaleImage(Tile[index].image,gp.tileSize,gp.tileSize);
            Tile[index].collision = collision;
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void loadMap(String filePath)
    {
        try
        {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while(col < gp.maxWorldCol && row < gp.maxWorldRow)
            {
                String line = br.readLine();

                while(col < gp.maxWorldCol)
                {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxWorldCol)
                {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }

        catch(Exception e)
        {

        }
    }
    public void draw(Graphics2D G2)
    {
       int worldCol = 0;
       int worldRow = 0;

       while(worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow)
       {
           int tileNum = mapTileNum[worldCol][worldRow];

           int worldX = worldCol * gp.tileSize;
           int worldY = worldRow * gp.tileSize;
           int screenX = worldX - gp.player.worldX + gp.player.screenX;
           int screenY = worldY - gp.player.worldY + gp.player.screenY;
           if(worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
           worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
           worldY + gp.tileSize > gp.player.worldY - gp.player.screenY &&
           worldY - gp.tileSize < gp.player.worldY + gp.player.screenY)
           {
               G2.drawImage(Tile[tileNum].image,screenX,screenY,null);
           }

           worldCol++;

           if(worldCol == gp.maxWorldCol)
           {
               worldCol = 0;
               worldRow++;

           }
       }
    }
}
