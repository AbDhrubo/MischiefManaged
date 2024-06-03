package objects;

import com.example.javagame2d.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Door extends SuperObject{
    GamePanel gp;
    public OBJ_Door(GamePanel gp)
    {
        this.gp = gp;
        name = "Door";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/doorr.png"));
            uTool.scaleImage(image,gp.tileSize,gp.tileSize);
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }

        collision = true;
    }
}
