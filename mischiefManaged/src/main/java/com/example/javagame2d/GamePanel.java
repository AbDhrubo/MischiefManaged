package com.example.javagame2d;

import Entity.Entity;
import Entity.Player;
import Tile.tileManager;
import objects.SuperObject;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 11;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;
    public final int maxWorldCol = 24;
    public final int maxWorldRow = 19;
    int FPS = 60;
    tileManager tileM = new tileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    Sound sound = new Sound();
    public UI ui = new UI(this);

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    Thread gameThread;
    public Player player = new Player(this,keyH);
    public SuperObject obj[] = new SuperObject[10];
    public Entity npc[] = new Entity[10];
    public final int titleState = 0;
    public int gameState;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame()
    {
        //aSetter.setObject();
        aSetter.setNPC();
        //playMusic(0);
        gameState = titleState;
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while(gameThread != null)
        {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 1)
            {
                update();

                repaint();

                delta--;

                drawCount++;
            }

            if(timer >= 1000000000)
            {
                System.out.println("FPS:" + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    private void update()
    {
        if(gameState == playState)
        {
            player.update();
            for(int i = 0;i < npc.length;i++)
            {
                if(npc[i] != null)
                {
                    npc[i].update();
                }
            }
        }
        if(gameState == pauseState)
        {
            //ui.drawPauseScreen();
            //ui.draw(ui.G2);

        }
    }

    public void paintComponent(Graphics G)
    {
        super.paintComponent(G);
        Graphics2D G2 =  (Graphics2D)G;
        long drawStart = 0;
        if(keyH.checkDrawTime)
        {
            drawStart = System.nanoTime();
        }
        if(gameState == titleState)
        {
            ui.draw(G2);
        }
        else {
            tileM.draw(G2);
            for(int i = 0;i < obj.length;i++)
            {
                if(obj[i] != null)
                {
                    obj[i].draw(G2,this);
                }
            }
            for(int i = 0;i < npc.length;i++)
            {
                if(npc[i] != null)
                {
                    npc[i].draw(G2);
                }
            }
            player.draw(G2);
            ui.draw(G2);
        }

        if(keyH.checkDrawTime == true)
        {
            long drawEnd = System.nanoTime();
            long passed = drawEnd - drawStart;
            G2.setColor(Color.white);
            G2.drawString("Draw Time: " + passed,10,400);
            System.out.println("Draw Time: " + passed);
        }

        G2.dispose();
    }

    public void playMusic(int i)
    {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic()
    {
        sound.stop();
    }

    public void playSE(int i)
    {
    sound.setFile(i);
    sound.play();
    }
}
