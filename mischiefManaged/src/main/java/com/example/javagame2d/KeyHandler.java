package com.example.javagame2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
    public boolean checkDrawTime = false;

    public KeyHandler(GamePanel gp) {
        this.gp = gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(gp.gameState == gp.titleState)
        {
            if(code == KeyEvent.VK_W)
            {
                gp.ui.commandNumber--;
                if(gp.ui.commandNumber < 0)
                {
                    gp.ui.commandNumber = 3;
                }
            }

            if(code == KeyEvent.VK_S)
            {
                gp.ui.commandNumber++;
                if(gp.ui.commandNumber > 3)
                {
                    gp.ui.commandNumber = 0;
                }
            }

            if(code == KeyEvent.VK_ENTER)
            {
                if(gp.ui.commandNumber == 0)
                {
                    gp.gameState = gp.storyState;
                    gp.currentMap = 0;
                    //gp.playMusic(0);
                }
                if(gp.ui.commandNumber == 1)
                {
                    //gp.gameState = gp.playState;

                }

                if(gp.ui.commandNumber == 2)
                {
                    //gp.gameState = gp.playState;
                    if(gp.sound.state) gp.stopMusic();
                    else gp.playMusic(0);
                }

                if(gp.ui.commandNumber == 3)
                {
                    //gp.gameState = gp.playState;
                    System.exit(0);
                }
            }
        }

        if (gp.gameState == gp.playState) {
            if (code == KeyEvent.VK_W) {
                upPressed = true;
            }

            if (code == KeyEvent.VK_S) {
                downPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                leftPressed = true;
            }
            if (code == KeyEvent.VK_D) {
                rightPressed = true;
            }
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.pauseState;
                System.out.println(1);
            }
            if (code == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }

            if (code == KeyEvent.VK_T) {
                checkDrawTime = !checkDrawTime;
            }
            if (code == KeyEvent.VK_C) {
                gp.currentMap = 1;

                gp.player.worldX = gp.tileSize * 3;
                gp.player.worldY = gp.tileSize * 27;
                gp.player.speed = 4;
                gp.player.direction = "down";

                gp.maxWorldCol = 40;
                gp.maxWorldRow = 30;
                gp.tileM.loadMap("/maps/level_2.txt",1);
            }



        } else if (gp.gameState == gp.pauseState) {
            if (code == KeyEvent.VK_P) {
                gp.gameState = gp.playState;
//                System.out.println(2);
            }



        } else if (gp.gameState == gp.storyState){
            if (code == KeyEvent.VK_RIGHT){
                if(gp.progressionState > gp.storyLevel.get(gp.currLevel)){
                    gp.progressionState = 0;
                    gp.gameState = gp.playState;
                    gp.currLevel++;
                }

                else {
                    gp.progressionState++;
                }
                gp.storyIndex++;
            }
        }

        

        if (gp.gameState == gp.dialogueState) {
            if (code == KeyEvent.VK_ENTER) {
                if (gp.dialogueLevel == 0)
                    gp.gameState = gp.playState;
                else {
                    gp.gameState = gp.storyState;
                    gp.dialogueLevel = 0;
                }
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_W) {
            upPressed = false;
        }

        if (code == KeyEvent.VK_S) {
            downPressed = false;
        }
        if (code == KeyEvent.VK_A) {
            leftPressed = false;
        }
        if (code == KeyEvent.VK_D) {
            rightPressed = false;
        }
    }
}