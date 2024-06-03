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
        soundURL[0] = getClass().getResource(
                "/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[1] = getClass().getResource(
                "/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[2] = getClass().getResource(
                "/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[3] = getClass().getResource(
                "/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[4] = getClass().getResource(
                "/Sound/gourab-das-harmonica_feluda-theme-titan-mozart-s-symphony-no-25-shuffle-rhythm-gourab-das-harmonica.wav");
        soundURL[5] = getClass().getResource("/Sound/villager.wav");
        soundURL[6] = getClass().getResource("/Sound/doorbell.wav");
        soundURL[7] = getClass().getResource("/Sound/old_telephone.wav");
        soundURL[8] = getClass().getResource("/Sound/door_unlocking.wav");
        soundURL[9] = getClass().getResource("/Sound/key.wav");
        soundURL[10] = getClass().getResource("/Sound/paper.wav");
        soundURL[11] = getClass().getResource("/Sound/chest.wav");
        soundURL[12] = getClass().getResource("/Sound/victory.wav");
        soundURL[13] = getClass().getResource("/Sound/valorant_ace_sound.wav");
        soundURL[14] = getClass().getResource("/Sound/divine.wav");
        soundURL[15] = getClass().getResource("/Sound/water.wav");
    }

    public void setFile(int i) {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }

        catch (Exception e) {

        }
    }

    public void play() {
        state = true;
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        state = false;
        clip.stop();
    }
}
