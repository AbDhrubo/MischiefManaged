package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Buddha extends Entity{
    public Buddha(GamePanel gp)
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
        dialogues[0] = "পানিতেই জনম, পানিতে মরণ,\n" +
                "করিল বুদ্ধ জপে অনুধাবন।";
    }

    public void speak()
    {

        if (gp.player.stage == 9)
        {
            dialogueIndex = 0;
            dialogue = false;
            gp.npc[1][5].dialogue = true;
            gp.player.stage = 10;

            gp.ui.currentDialogue = dialogues[dialogueIndex];
            gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);

        }
        gp.playSound(14);
    }
}