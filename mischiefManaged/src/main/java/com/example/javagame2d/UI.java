package com.example.javagame2d;

import objects.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {
    GamePanel gp;
    Graphics2D G2;
    Font arial_40,arial_80B;
    //BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp)
    {
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        arial_80B = new Font("Arial",Font.BOLD,80);
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
        if(gp.gameState == gp.playState)
        {

        }
        if(gp.gameState == gp.pauseState)
        {
            drawPauseScreen();
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
    public void drawPauseScreen()
    {
        String text = "PAUSED";
        int x = getXforCenteredText(text);
        int y = gp.screenHeight/2;
        G2.drawString(text,x,y);
    }

    public int getXforCenteredText(String text)
    {
        int length = (int)G2.getFontMetrics().getStringBounds(text,G2).getWidth();
        int x = gp.screenWidth/2 - length/2;
        return x;
    }

}
