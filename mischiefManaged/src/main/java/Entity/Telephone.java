package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Telephone extends Entity{
    public Telephone(GamePanel gp)
    {
        super(gp);
        direction = "up";
        speed = 0;
        setDialogue();
        dialogue = false;
    }

    public void setDialogue()
    {
        dialogues[0] = "আমি এখন পারছি না তোপসে, তুই নিজে পারলে দেখ একটু।";
    }
//    public void setAction()
//    {
//        actionLockCounter++;
//        if(actionLockCounter == 120)
//        {
//            Random random = new Random();
//            int i = random.nextInt(100) + 1;
//            if(i <= 25)
//            {
//                direction = "up";
//            }
//            if(i > 25 && i <= 50)
//            {
//                direction = "down";
//            }
//
//            if(i > 50 && i <= 75)
//            {
//                direction = "left";
//            }
//
//            if(i > 75 && i <= 100)
//            {
//                direction = "right";
//            }
//            actionLockCounter = 0;
//        }
//
//    }
    public void speak()
    {

        if(gp.player.stage == 3)
        {
            dialogueIndex = 0;
            dialogue = false;
        }
        gp.player.stage = 4;
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        gp.ui.dialogueImage = gp.ui.dialogueImages.get(1);

    }
}