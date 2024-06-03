package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class Letter_box extends Entity{
    public Letter_box(GamePanel gp)
    {
        super(gp);
        direction = "up";
        speed = 0;
//        getOldManImage();
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
        dialogues[0] = "erpor tolowar er kache jabe";
    }
    public void setAction()
    {
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

    }
    public void speak()
    {

        if(gp.player.stage == 5)
        {
            System.out.println("hoise");
            dialogueIndex = 0;
            gp.player.stage = 6;
            gp.npc[1][1].dialogue = true;
            gp.ui.currentDialogue = dialogues[dialogueIndex];
            gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);
        }

    }
}