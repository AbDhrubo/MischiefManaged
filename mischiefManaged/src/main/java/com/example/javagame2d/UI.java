package com.example.javagame2d;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Objects;

public class UI {
    GamePanel gp;
    Graphics2D G2;
    Font arial_40,arial_80B;
    BufferedImage bgImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public BufferedImage dialogueImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/NPC/oldman_right_1.png")));
    public BufferedImage nullImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/NPC/oldman_right_1.png")));
    public ArrayList<BufferedImage> dialogueImages;
    public int commandNumber = 0;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) throws IOException {
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        arial_80B = new Font("Arial",Font.BOLD,80);

        this.dialogueImages = new ArrayList<>();

        for(int i = 0; i<3; i++){
            System.out.println(STR."/models/\{i}.png");
            BufferedImage temp = ImageIO.read(Objects.requireNonNull(getClass().getResource(STR."/models/\{i}.png")));
            dialogueImages.add(temp);
        }
        //OBJ_Key key = new OBJ_Key(gp);
        //keyImage = key.image;
    }

    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D G2)
    {
        this.G2 = G2;
        G2.setFont(arial_40);
        G2.setColor(Color.white);
        if(gp.gameState == gp.titleState)
        {
            drawTitleScreen();
        }
        if(gp.gameState == gp.playState)
        {

        }
        if(gp.gameState == gp.pauseState)
        {
            drawPauseScreen();
        }

        if(gp.gameState == gp.dialogueState)
        {
            drawDialogueScreen();
        }
        /*if(gameFinished == true)
        {
            G2.setFont(arial_40);
            G2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;
            text = "You found the treasure";
            textLength = (int)G2.getFontMetrics().getStringBounds(text,G2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight/2 - (gp.tileSize * 3);
            G2.drawString(text,x,y);

            text = "Your Time is:" + dFormat.format(playTime) + "!";
            textLength = (int)G2.getFontMetrics().getStringBounds(text,G2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight/2 + (gp.tileSize * 4);
            G2.drawString(text,x,y);

            G2.setFont(arial_80B);
            G2.setColor(Color.yellow);
            text = "Congratulations";
            textLength = (int)G2.getFontMetrics().getStringBounds(text,G2).getWidth();
            x = gp.screenWidth / 2 - textLength / 2;
            y = gp.screenHeight/2 - (gp.tileSize * 3);
            G2.drawString(text,x,y);
            gp.gameThread = null;
        }

        else
        {
            G2.setFont(arial_40);
            G2.setColor(Color.white);
            G2.drawImage(keyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
            G2.drawString("x " + gp.player.hasKey, 74, 65);
            playTime += (double)1/60;
            G2.drawString("Time:" + dFormat.format(playTime),gp.tileSize*11,65);
            if(messageOn == true)
            {
                G2.setFont(G2.getFont().deriveFont(30F));
                G2.drawString(message,gp.tileSize/2,gp.tileSize * 5);
                messageCounter++;

                if(messageCounter > 120)
                {
                    messageCounter = 0;
                    messageOn = false;
                }
            }
        }*/

    }
    public void drawTitleScreen()
    {

        try {
            bgImage = ImageIO.read(getClass().getResourceAsStream( "/player/Feluda_cover.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        G2.drawImage(bgImage,gp.tileSize/64 - 150  ,gp.tileSize/64,null);
        G2.setFont(G2.getFont().deriveFont(Font.BOLD,64));
        String text = "Mischief Managed!";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 5;
        G2.setColor(Color.white);
        G2.drawString(text,x,y);

        G2.setFont(G2.getFont().deriveFont(Font.BOLD,36f));
        text = "NEW GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize * 1;
        G2.drawString(text,x,y);
        if(commandNumber == 0)
        {
            G2.drawString(">",x - gp.tileSize,y);
        }
        G2.setFont(G2.getFont().deriveFont(Font.BOLD,36f));
        text = "LOAD GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        G2.drawString(text,x,y);
        if(commandNumber == 1)
        {
            G2.drawString(">",x - gp.tileSize,y);
        }
        G2.setFont(G2.getFont().deriveFont(Font.BOLD,36f));
        text = "QUIT";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        G2.drawString(text,x,y);
        if(commandNumber == 2)
        {
            G2.drawString(">",x - gp.tileSize,y);
        }

        G2.setFont(G2.getFont().deriveFont(Font.BOLD,36f));
        text = "SOUND ON";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        G2.drawString(text,x,y);
        if(commandNumber == 3)
        {
            G2.drawString(">",x - gp.tileSize,y);
        }

        G2.setFont(G2.getFont().deriveFont(Font.BOLD,36f));
        text = "SOUND OFF";
        x = getXforCenteredText(text);
        y += gp.tileSize;
        G2.drawString(text,x,y);
        if(commandNumber == 4)
        {
            G2.drawString(">",x - gp.tileSize,y);
        }

        G2.setFont(G2.getFont().deriveFont(Font.BOLD,36f));
        text = "HOW TO PLAY MISCHIEF MANAGED?";
        x = getXforCenteredText(text) + 1;
        y += gp.tileSize;
        G2.drawString(text,x,y);
        if(commandNumber == 5)
        {
            G2.drawString(">",x - gp.tileSize,y);
        }
    }
    public void drawPauseScreen()
    {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        G2.drawString(text,x,y);
    }
//    public void drawDialogueScreen()
//    {
//        int x = gp.tileSize;
//        int y = gp.tileSize/2;
//        int width = gp.screenWidth - (gp.tileSize * 4);
//        int height = gp.tileSize * 4;
//        drawSubWindow(x,y,width,height);
//        x += gp.tileSize;
//        y += gp.tileSize;
//        G2.drawString(currentDialogue,x,y);
//    }

    public void drawDialogueScreen() {
        int x = gp.tileSize;
        int y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow(x, y, width, height);

        // Adjust image position and size
        int imageWidth  = 3* dialogueImage.getWidth();
        int imageHeight = 3*dialogueImage.getHeight();
        int imageX = x + gp.tileSize;
        int imageY = y + gp.tileSize;

        G2.drawImage(dialogueImage, imageX, imageY, imageWidth, imageHeight, null);

        // Adjust text position and set a smaller font
        x += gp.tileSize*2;
        y += gp.tileSize*2; // Move the text down below the image

        G2.setFont(new Font("Comic-sans", Font.PLAIN, 24)); // Set a smaller font size
        G2.setColor(Color.WHITE); // Set the text color to white
        G2.drawString(currentDialogue, x, y);
    }


    public void drawSubWindow(int x,int y, int width,int height)
    {
        Color c = new Color(0,0,0,210);
        G2.setColor(c);
        G2.fillRoundRect(x,y,width,height,35,35);
        c = new Color(255,255,255);
        G2.setColor(c);
        G2.setStroke(new BasicStroke(5));
        G2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);
    }
    public int getXforCenteredText(String text)
    {
        int length = (int)G2.getFontMetrics().getStringBounds(text,G2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

}
