package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Purohit extends Entity{
    public Purohit(GamePanel gp)
    {
        super(gp);
        direction = "down";
        speed = 1;
        dialogue = false;
        getOldManImage();
        setDialogue();
    }
    public void getOldManImage()
    {
        up1 = setup("/NPC/oldman_up_11");
        up2 = setup("/NPC/oldman_up_22");
        down1 = setup("/NPC/oldman_down_11");
        down2 = setup("/NPC/oldman_down_22");
        left1 = setup("/NPC/oldman_left_11");
        left2 = setup("/NPC/oldman_left_22");
        right1 = setup("/NPC/oldman_right_11");
        right2 = setup("/NPC/oldman_right_22");
    }

    public void setDialogue()
    {
        dialogues[0] = "ke apni?..blabla..bolbona .. blabla";
        dialogues[1] = "Who is he?";
        dialogues[2] = "তুমি ঘটনাটা ফেলুবাবুকে বলো, ফোন করো।";
        dialogues[3] = "তুমি তাহলে একবার গিয়ে দেখবে?";
    }
    public void setAction()
    {
        actionLockCounter++;
        if(actionLockCounter == 120)
        {
            Random random = new Random();
            int i = random.nextInt(100) + 1;
            if(i <= 25)
            {
                direction = "up";
            }
            if(i > 25 && i <= 50)
            {
                direction = "down";
            }

            if(i > 50 && i <= 75)
            {
                direction = "left";
            }

            if(i > 75 && i <= 100)
            {
                direction = "right";
            }
            actionLockCounter = 0;
        }

    }
    public void speak()
    {
        if(gp.player.stage == 8 || gp.player.stage == 9)
        {
            dialogueIndex = 0;
            gp.npc[1][4].dialogue = true;
            gp.player.stage = 9;
            dialogue = false;
        }
        if(gp.player.stage == 13){
            dialogueIndex = 0;
            gp.npc[1][4].dialogue = true;
            gp.player.stage = 9;
            dialogue = false;
        }

        gp.ui.currentDialogue = dialogues[dialogueIndex];
        gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);
        gp.gameState = gp.storyState;

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