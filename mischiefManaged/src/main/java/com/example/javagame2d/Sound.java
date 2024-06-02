package com.example.javagame2d;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;

    public boolean state = false;
    URL soundURL[] = new URL[30];

    public Sound() {
        soundURL[0] = getClass().getResource("/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[1] = getClass().getResource("/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[2] = getClass().getResource("/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[3] = getClass().getResource("/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[4] = getClass().getResource("/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
    }

    public void setFile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }

        catch (Exception e)
        {

        }
    }

    public void play()
    {
        state = true;
        clip.start();
    }

    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop()
    {
        state = false;
        clip.stop();
    }
}




