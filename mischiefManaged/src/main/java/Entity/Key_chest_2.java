package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Key_chest_2 extends Entity{
    public Key_chest_2(GamePanel gp)
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
        dialogues[0] = "This must be a door key";
    }

    public void speak()
    {

        if (gp.player.stage == 10)
        {
            dialogueIndex = 0;
            gp.player.stage = 11;
            dialogue = false;
            gp.npc[1][6].dialogue = true;

            gp.ui.currentDialogue = dialogues[dialogueIndex];
            gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);

        }
    }
}