package objects;

import com.example.javagame2d.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class OBJ_Chest extends SuperObject{
    GamePanel gp;
    public OBJ_Chest(GamePanel gp)
    {
        this.gp = gp;
        name = "Chest";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.png"));
        }

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
