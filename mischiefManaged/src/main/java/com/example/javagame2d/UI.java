package com.example.javagame2d;

import javafx.scene.effect.DropShadow;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
    public String currentDialogue = "ekti bhari mojar golpo";
    public BufferedImage dialogueImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/NPC/oldman_right_1.png")));
    public BufferedImage arrowImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/misc/rightArrow.png")));
    public BufferedImage enterImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/misc/enter.png")));
    public BufferedImage nullImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/NPC/oldman_right_1.png")));
    public ArrayList<BufferedImage> dialogueImages;
    public ArrayList<BufferedImage> storyImages;

    public ArrayList<String> storyLines;;
    public int storyIndex = 0;
    public int commandNumber = 0;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) throws IOException {
        this.gp = gp;
        arial_40 = new Font("Arial",Font.PLAIN,40);
        arial_80B = new Font("Arial",Font.BOLD,80);

        this.dialogueImages = new ArrayList<>();
        this.storyImages = new ArrayList<>();
        this.storyLines = new ArrayList<>();
        initiateStory();

        for(int i = 0; i<4; i++){
            System.out.println(STR."/models/\{i}.png");
            BufferedImage temp = ImageIO.read(Objects.requireNonNull(getClass().getResource(STR."/models/\{i}.png")));
            dialogueImages.add(temp);
        }
        //OBJ_Key key = new OBJ_Key(gp);
        //keyImage = key.image;
    }

    private void initiateStory() throws IOException {
        storyLines.add("কলকাতার গরমের মধ্যে এক ব্যস্ত ক্লান্ত দুপুর, ফেলুদা বাসায় নেই।");
        storyLines.add("বাদশাহী আংটির কেসের পর থেকে ফেলুদা অনেক ব্যস্ত হয়ে পড়েছে।");
        storyLines.add("তপসে আর জটায়ু পায়চারি করছি বাড়িতে।");
        storyLines.add("হুট করে বেজে ওঠে ডিং ডং!");
        storyLines.add("লোকটা কি রকম অদ্ভুত! শুধু ফাইলটা দিয়েই চলে গেলো!");
        storyLines.add("ফাইলে ছিল কিছু কাগজ, সাথে একটা ম্যাপ। ভাঁজ খুলতেই দেখি, কলকাতার ম্যাপ।");
        storyLines.add("খুবই জীর্ণশীর্ণ, কিন্তু দেখা যায় পার্কস্ট্রিট, ভিক্টোরিয়া মেমোরিয়াল আর…।");
        storyLines.add("শোভাবাজারে দাগ দেয়া?পুতুলবাড়িতে?কি আছে ওখানে?");
        storyLines.add("হুট করে বেজে ওঠে ক্রিং ক্রিং ক্রিং…");
        storyLines.add("হুট করে বেজে ওঠে ক্রিং ক্রিং ক্রিং…");
        storyLines.add("হুট করে বেজে ওঠে ক্রিং ক্রিং ক্রিং…");
        storyLines.add("হুট করে বেজে ওঠে ক্রিং ক্রিং ক্রিং…");
        storyLines.add("হুট করে বেজে ওঠে ক্রিং ক্রিং ক্রিং…");

        BufferedImage temp0 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/models/0.png")));
        BufferedImage temp1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/models/1.png")));
        BufferedImage temp2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/models/2.png")));
        BufferedImage temp3 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/models/4.png")));

        storyImages.add(temp3);
        storyImages.add(temp3);
        storyImages.add(temp3);
        storyImages.add(temp3);
        storyImages.add(temp0);
        storyImages.add(temp0);
        storyImages.add(temp0);
        storyImages.add(temp0);

    }

    public void showMessage(String text)
    {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D G2) throws IOException {
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
        if(gp.gameState == gp.storyState){
            drawStoryScreen();
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
        G2.drawImage(bgImage,gp.tileSize/64 - 150  ,gp.tileSize/64, null);
        G2.setFont(G2.getFont().deriveFont(Font.BOLD,33));
        String text = "Mischief Managed!";
        int x = getXforCenteredText(text);
        int y = gp.tileSize * 1;

        Color shadowColor = new Color(50, 50, 50, 150); // semi-transparent black
        int shadowOffset = 5;

        // Draw shadow
        G2.setColor(shadowColor);
        G2.drawString(text, x + shadowOffset, y + shadowOffset);

        GradientPaint gradient = new GradientPaint(x, y, Color.RED, x + 100, y, Color.BLUE);

        // Set gradient paint
        G2.setPaint(gradient);

        G2.setColor(Color.WHITE);
        G2.drawString(text,x,y);
//        AffineTransform originalTransform = G2.getTransform();
//        AffineTransform rotateTransform = new AffineTransform();
//        rotateTransform.rotate(Math.toRadians(60), x, y);
//
//        // Apply rotation
//        G2.setTransform(rotateTransform);
//        G2.drawString(text, x, y);
//
//        // Restore original transform
//        G2.setTransform(originalTransform);

        G2.setFont(G2.getFont().deriveFont(Font.BOLD,20f));
        text = "Start";
        x = 30;
        y += gp.tileSize + 10;
        G2.drawString(text,x,y);
        if(commandNumber == 0)
        {
            G2.drawImage(dialogueImages.get(3), x + gp.tileSize, y - 18, null, null);
            //G2.drawString(">",x - gp.tileSize,y);
        }

        G2.setFont(G2.getFont().deriveFont(Font.BOLD,20f));
        text = "How to play?";
        x = 30;
        y += gp.tileSize - 15;
        G2.drawString(text,x,y);
        if(commandNumber == 1)
        {
            G2.drawImage(dialogueImages.get(3), x + 2*gp.tileSize + 25, y - 18, null, null);
        }
//        G2.setFont(G2.getFont().deriveFont(Font.BOLD,20f));
//        text = "LOAD GAME";
//        x = getXforCenteredText(text);
//        y += gp.tileSize - 15;
//        G2.drawString(text,x,y);
//        if(commandNumber == 1)
//        {
//            G2.drawString(">",x - gp.tileSize,y);
//        }

        G2.setFont(G2.getFont().deriveFont(Font.BOLD,20f));
        text = "Music";
        x = 30;
        y += gp.tileSize - 15;
        G2.drawString(text,x,y);
        if(commandNumber == 2)
        {
            G2.drawImage(dialogueImages.get(3), x + gp.tileSize + 10, y - 18, null, null);
        }

//        G2.setFont(G2.getFont().deriveFont(Font.BOLD,20f));
//        text = "Music off";
//        x = getXforCenteredText(text);
//        y += gp.tileSize - 15;
//        G2.drawString(text,x,y);
//        if(commandNumber == 4)
//        {
//            G2.drawString(">",x - gp.tileSize,y);
//        }


        G2.setFont(G2.getFont().deriveFont(Font.BOLD,20f));
        text = "Quit";
        x = 30;
        y += gp.tileSize - 15;
        G2.drawString(text,x,y);
        if(commandNumber == 3)
        {
            G2.drawImage(dialogueImages.get(3), x + gp.tileSize - 6, y - 18, null, null);
        }




    }
    public void drawPauseScreen()
    {
        String text = "Paused";
        int x = gp.screenWidth/9 - 60;
        int y = gp.screenHeight/6 -55;
        G2.setFont(G2.getFont().deriveFont(Font.PLAIN,30f));
        G2.drawString(text,x,y);
    }
    public void drawStoryScreen() throws IOException {
        float x = gp.tileSize;
        float y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow((int)x, (int)y, width, height);
        drawSubWindow((int)x + width - gp.tileSize*2, (int)y+height + gp.tileSize*2, gp.tileSize* 3, gp.tileSize*2);
        G2.setFont(new Font("Arial", Font.PLAIN, 20));
        G2.setColor(Color.WHITE); // Set the text color to white
        G2.drawString("PRESS", (float)(x + width - (float)gp.tileSize*1.5), (int)y+height + gp.tileSize*3);

        int imageWidth = 3 * dialogueImage.getWidth(null); // Note the 'null' parameter
        int imageHeight = 3 * dialogueImage.getHeight(null);
        int imageX = (int) (x + width - (float)gp.tileSize*2 + 20);
        int imageY = (int)y+height + gp.tileSize*3;
        G2.drawImage(arrowImage, imageX, imageY, imageWidth, imageHeight, null);

        // Adjust image position and size

        imageWidth = 3 * dialogueImage.getWidth(null); // Note the 'null' parameter
        imageHeight = 3 * dialogueImage.getHeight(null);
        imageX = (int) (x + gp.tileSize);
        imageY = (int) (y + gp.tileSize);


//        G2.drawImage(dialogueImage, imageX, imageY, imageWidth, imageHeight, null);
        G2.drawImage(storyImages.get(gp.storyIndex), imageX, imageY, imageWidth, imageHeight, null);
        x += (float) (gp.tileSize * 2);
        y += (float) (gp.tileSize * 1.5);

        G2.setFont(gp.banglaFont);
        G2.setColor(Color.WHITE);
        java.util.List<String> lines = getStrings(storyLines.get(gp.storyIndex));

        // Draw each line
        for (String l : lines) {
            G2.drawString(l, x, y);
            y += gp.tileSize; 
        }


        
        
    }

    private java.util.List<String> getStrings(String s) {
        String[] words = s.split(" ");
        StringBuilder line = new StringBuilder();
        java.util.List<String> lines = new ArrayList<>();

        for (String word : words) {
            if (line.length() + word.length() <= 40) {
                if (line.length() > 0) {
                    line.append(" ");
                }
                line.append(word);
            } else {
                lines.add(line.toString());
                line = new StringBuilder(word);
            }
        }
        lines.add(line.toString());
        return lines;
    }


    public void drawDialogueScreen() {
        float x = gp.tileSize;
        float y = gp.tileSize / 2;
        int width = gp.screenWidth - (gp.tileSize * 4);
        int height = gp.tileSize * 4;
        drawSubWindow((int)x, (int)y, width, height);
        drawSubWindow((int)x + width - gp.tileSize*2, (int)y+height + gp.tileSize*2, gp.tileSize* 3, gp.tileSize*2);
        G2.setFont(new Font("Arial", Font.PLAIN, 20));
        G2.setColor(Color.WHITE); // Set the text color to white
        G2.drawString("PRESS", (float)(x + width - (float)gp.tileSize*1.5), (int)y+height + gp.tileSize*3);

        int imageWidth = 3 * dialogueImage.getWidth(null); // Note the 'null' parameter
        int imageHeight = 3 * dialogueImage.getHeight(null);
        int imageX = (int) (x + width - (float)gp.tileSize*2 + 20);
        int imageY = (int)y+height + gp.tileSize*3;
        G2.drawImage(enterImage, imageX, imageY, imageWidth, imageHeight, null);

        // Adjust image position and size
        imageWidth = 3 * dialogueImage.getWidth(null); // Note the 'null' parameter
        imageHeight = 3 * dialogueImage.getHeight(null);
        imageX = (int) (x + gp.tileSize);
        imageY = (int) (y + gp.tileSize);

        G2.drawImage(dialogueImage, imageX, imageY, imageWidth, imageHeight, null);

        // Adjust text position and set the custom Bengali font
        x += (float) (gp.tileSize * 2);
        y += (float) (gp.tileSize * 1.5); // Move the text down below the image

        G2.setFont(gp.banglaFont); // Set the custom Bengali font
        G2.setColor(Color.WHITE); // Set the text color to white

        // Split the text into lines of max 20 characters without breaking words
        java.util.List<String> lines = getStrings(currentDialogue);

        // Draw each line
        for (String l : lines) {
            G2.drawString(l, x, y);
            y += gp.tileSize; // Move down for the next line
        }
    }


    public void drawSubWindow(int x,int y, int width,int height)
    {
        System.out.println(width);
        System.out.println(height);
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


