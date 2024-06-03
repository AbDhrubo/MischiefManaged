package objects;

import com.example.javagame2d.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Statue extends SuperObject
{
    GamePanel gp;
    public Statue(GamePanel gp)
    {
        name = "Statue";
        try
        {image = ImageIO.read(getClass().getResourceAsStream("/objects/statue.png"));
        uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
