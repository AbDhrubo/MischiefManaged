package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Mystery_Man extends Entity{
    public Mystery_Man(GamePanel gp)
    {
        super(gp);
        direction = "down";
        speed = 0;
        getOldManImage();
        setDialogue();
    }
    public void getOldManImage()
    {
        up1 = setup("/NPC/oldman_up_1");
        up2 = setup("/NPC/oldman_up_2");
        down1 = setup("/NPC/mystery_man");
        down2 = setup("/NPC/mystery_man");
        left1 = setup("/NPC/oldman_left_1");
        left2 = setup("/NPC/oldman_left_2");
        right1 = setup("/NPC/oldman_right_1");
        right2 = setup("/NPC/oldman_right_2");
    }

    public void setDialogue()
    {
        dialogues[0] = "Is Prodosh Mittir home?";
        dialogues[1] = "এই ফাইলটা রাখুন তো! ফেলুবাবুকে দিবেন!";
    }
    public void setAction()
    {
        actionLockCounter++;
        if(actionLockCounter == 20)
        {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if(i <= 100)
            {
                direction = "down";
            }
            else if(i > 25 && i <= 50)
            {
                direction = "down";
            }

            else if(i > 50 && i <= 75)
            {
                direction = "left";
            }

            else if(i > 75 && i <= 100)
            {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }
    public void speak()
    {
        if(gp.player.stage == 1)
        {
            dialogueIndex = 0;
            gp.player.stage = 2;
        }
        if(gp.player.stage == 2)
        {
            dialogueIndex = 1;
            gp.dialogueLevel = 1;
            gp.player.stage = 3;
            gp.temponpc[gp.currentMap][0] = null;
        }

        gp.playSound(5);
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        switch (gp.player.direction)
        {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }
}