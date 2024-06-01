package com.example.javagame2d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    GamePanel gp;
    public boolean upPressed,downPressed,leftPressed,rightPressed,enterPressed;
    public boolean checkDrawTime = false;
    public KeyHandler(GamePanel gp)
    {
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
                gp.ui.commandNumber = 5;
            }
        }

        if(code == KeyEvent.VK_S)
        {
            gp.ui.commandNumber++;
            if(gp.ui.commandNumber > 5)
            {
                gp.ui.commandNumber = 0;
            }
        }

        if(code == KeyEvent.VK_ENTER)
        {
            if(gp.ui.commandNumber == 0)
            {
                gp.gameState = gp.playState;
                gp.playMusic(0);
            }
            if(gp.ui.commandNumber == 2)
            {
                //gp.gameState = gp.playState;
                System.exit(0);
            }

            if(gp.ui.commandNumber == 3)
            {
                //gp.gameState = gp.playState;
                gp.playMusic(0);
            }

            if(gp.ui.commandNumber == 4)
            {
                //gp.gameState = gp.playState;
                gp.stopMusic();
            }
        }
    }
    if(gp.gameState == gp.playState)
    {
        if(code == KeyEvent.VK_W)
        {
            upPressed = true;
        }

        if(code == KeyEvent.VK_S)
        {
            downPressed = true;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = true;
        }



        if(code == KeyEvent.VK_P)
        {
            gp.gameState = gp.pauseState;
        }
        if(code == KeyEvent.VK_ENTER)
        {
           enterPressed = true;
        }

        if(code == KeyEvent.VK_T)
        {
            if(checkDrawTime == false)
            {
                checkDrawTime = true;
            }

            else if(checkDrawTime == true)
            {
                checkDrawTime = false;
            }
        }
    }

    if(gp.gameState == gp.pauseState)
    {
        if(code == KeyEvent.VK_P)
        {
            gp.gameState = gp.playState;
        }
    }

        if(gp.gameState == gp.dialogueState)
        {
            if(code == KeyEvent.VK_ENTER)
            {
                gp.gameState = gp.playState;
            }
        }

 }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W)
        {
            upPressed = false;
        }

        if(code == KeyEvent.VK_S)
        {
            downPressed = false;
        }
        if(code == KeyEvent.VK_A)
        {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D)
        {
            rightPressed = false;
        }
    }
}
