package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Armour extends Entity{
    public Armour(GamePanel gp)
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
        dialogues[0] = "চাবি? এখানে চাবি কোথা থেকে এলো? এ জায়গাটা আসলে কি?\n";
    }

    public void speak()
    {

        if (gp.player.stage == 6)
        {
            dialogueIndex = 0;
            dialogue = false;
            gp.npc[1][2].dialogue = true;
            gp.npc[1][6].dialogue = true;

            gp.player.stage = 7;

            gp.ui.currentDialogue = dialogues[dialogueIndex];
            gp.ui.dialogueImage = gp.ui.dialogueImages.get(0);

        }
        gp.playSound(9);
    }
}