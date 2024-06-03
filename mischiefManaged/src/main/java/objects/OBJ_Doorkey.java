package objects;

import com.example.javagame2d.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Doorkey extends SuperObject
{
    GamePanel gp;
    public OBJ_Doorkey(GamePanel gp)
    {
        name = "Doorkey";
//        try
//        {image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
//        uTool.scaleImage(image,gp.tileSize,gp.tileSize);
//        }
//
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
    }
}
