package Entity;

import com.example.javagame2d.GamePanel;
import com.example.javagame2d.KeyHandler;
import com.example.javagame2d.UtilityTools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity
{
    //GamePanel gp;
    KeyHandler keyH;
    public final int screenX;
    public final int screenY;

    public int stage = 0;

    public int hasKey = 0;
    public int hasDoorKey = 0;

    public Player(GamePanel gp,KeyHandler keyH)
    {
        super(gp);
        //this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - - (gp.tileSize/2);
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 16;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 32;
        solidArea.height = 32;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues()
    {
        if(gp.currentMap == 0) {
            worldX = gp.tileSize * 13;
            worldY = gp.tileSize * 10;
            speed = 7;
            direction = "down";
        }

    }
    public void getPlayerImage()
    {
        up1 = setup("/player/boy_up_1");
        up2 = setup("/player/boy_up_2");
        down1 = setup("/player/boy_down_1");
        down2 = setup("/player/boy_down_2");
        left1 = setup("/player/boy_left_1");
        left2 = setup("/player/boy_left_2");
        right1 = setup("/player/boy_right_1");
        right2 = setup("/player/boy_right_2");
    }

    public void update()
    {
        if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true)
        {
            if(keyH.upPressed == true)
            {
                direction = "up";
                //worldY -= speed;
            }

            else if(keyH.downPressed == true)
            {
                direction = "down";
                //worldY += speed;
            }

            else if(keyH.leftPressed == true)
            {
                direction = "left";
                //worldX -= speed;
            }

            else if(keyH.rightPressed == true)
            {
                direction = "right";
                //worldX += speed;
            }

            collisionOn = false;
            gp.cChecker.checkTile(this);
            gp.cChecker.checkObject(this,true);
            int objIndex = gp.cChecker.checkObject(this,true);
            pickUpObject(objIndex);
            int npcIndex = gp.cChecker.checkEntity(this,gp.npc);
            interactNPC(npcIndex);
            int temponpcIndex = gp.cChecker.checkEntity(this,gp.temponpc);
            interactTempoNPC(temponpcIndex);
            if(collisionOn == false)
            {
                switch(direction)
                {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if(spriteCounter > 10)
            {
                if(spriteNumber == 1)
                {
                    spriteNumber = 2;
                }
                else if(spriteNumber == 2)
                {
                    spriteNumber = 1;
                }
                spriteCounter = 0;
            }


        }
        else {
            direction = "down";
        }
    }
public void pickUpObject(int i)
{
    if(i != 999)
    {
        String objectName = gp.obj[1][i].name;
        switch(objectName)
        {
            case "Key":
                if(stage > 5) {
                    System.out.println(1);
                    gp.obj[1][i] = null;
                    hasKey++;
                }
                //gp.ui.showMessage("You got a key!");
            break;

            case "Doorkey":
                if(stage >= 10) {
                    System.out.println(1);
                    gp.obj[1][i] = null;
                    hasDoorKey++;
                }
                //gp.ui.showMessage("You got a key!");
                break;

            case "Door":
                if(hasDoorKey > 0) {
                    gp.obj[1][i] = null;

                    gp.player.stage = 12;

                    gp.npc[1][7].dialogueIndex = 1;
                    gp.ui.currentDialogue = dialogues[dialogueIndex];
                    gp.ui.dialogueImage = gp.ui.dialogueImages.get(2);
                    gp.npc[1][7] = null;

                    gp.ui.showMessage("You opened the door!");
                }
                else {
                    gp.ui.showMessage("You need a key!");
                }
                break;
            case "Statue":

                gp.obj[1][3] = null;
                gp.player.stage = 13;
                break;
            case "Chest":
            gp.ui.gameFinished = true;
            gp.stopMusic();

        }
    }
}
public void interactNPC(int i)
{
    if(i != 999)
    {
        if(gp.npc[gp.currentMap][i].dialogue)
        {
            gp.gameState = gp.dialogueState;
            gp.npc[gp.currentMap][i].speak();
        }
    }
    gp.keyH.enterPressed = false;
}

    public void interactTempoNPC(int i)
    {
        if(i != 999)
        {
            if(gp.temponpc[gp.currentMap][i].dialogue)
            {
                gp.gameState = gp.dialogueState;
                gp.temponpc[gp.currentMap][i].speak();
            }
        }
        gp.keyH.enterPressed = false;
    }
    public void draw(Graphics2D G2)
    {
        //G2.setColor(Color.white);
        //G2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image = null;

        switch(direction)
        {
            case "up":
                if(spriteNumber == 1)
                {
                    image = up1;
                }
                if(spriteNumber == 2)
                {
                    image = up2;
                }
                break;
            case "down":
                if(spriteNumber == 1)
                {
                    image = down1;
                }
                if(spriteNumber == 2)
                {
                    image = down2;
                }
                break;
            case "left":
                if(spriteNumber == 1)
                {
                    image = left1;
                }
                if(spriteNumber == 2)
                {
                    image = left2;
                }
                break;
            case "right":
                if(spriteNumber == 1)
                {
                    image = right1;
                }
                if(spriteNumber == 2)
                {
                    image = right2;
                }
                break;

        }

        G2.drawImage(image,screenX,screenY,null);
    }
}
