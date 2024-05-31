package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class NPC_OldMan extends Entity{
    public NPC_OldMan(GamePanel gp)
    {
        super(gp);
        direction = "down";
        speed = 1;
        getOldManImage();
        setDialogue();
    }
    public void getOldManImage()
    {
        up1 = setup("/NPC/oldman_up_1");
        up2 = setup("/NPC/oldman_up_2");
        down1 = setup("/NPC/oldman_down_1");
        down2 = setup("/NPC/oldman_down_2");
        left1 = setup("/NPC/oldman_left_1");
        left2 = setup("/NPC/oldman_left_2");
        right1 = setup("/NPC/oldman_right_1");
        right2 = setup("/NPC/oldman_right_2");
    }

    public void setDialogue()
    {
        dialogues[0] = "Mysterious, Very Mysterious";
        dialogues[1] = "Khub Bhalo Korsos Topshe";
        dialogues[2] = "Ei kaj tore ke koirte koisse?!";
        dialogues[3] = "Dumbo GG No Cap fr fr";
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
        if(dialogues[dialogueIndex] == null)
        {
            dialogueIndex = 0;
        }
        gp.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
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