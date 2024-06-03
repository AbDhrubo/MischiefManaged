package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Empty_chest_1 extends Entity{
    public Empty_chest_1(GamePanel gp)
    {
        super(gp);
        direction = "down";
        speed = 0;
        dialogue = false;
//        getOldManImage();
        setDialogue();
    }

    public void setDialogue()
    {
        dialogues[0] = "Oh no chest is empty :(";
    }

    public void speak()
    {

        if (gp.player.stage >= 7 )
        {
            dialogueIndex = 0;
            gp.player.stage = 8;
            dialogue = false;
            gp.npc[1][3].dialogue = true;

            gp.ui.currentDialogue = dialogues[dialogueIndex];
            gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);

        }
    }
}