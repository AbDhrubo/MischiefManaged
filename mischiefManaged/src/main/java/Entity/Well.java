package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Well extends Entity{
    public Well(GamePanel gp)
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
        dialogues[0] = "eito chabi !";
    }

    public void speak()
    {

        if (gp.player.stage == 14)
        {
            dialogueIndex = 0;
            gp.player.stage = 15;
            dialogue = false;

            gp.ui.currentDialogue = dialogues[dialogueIndex];
            gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);

        }

        gp.playSound(15);
    }
}