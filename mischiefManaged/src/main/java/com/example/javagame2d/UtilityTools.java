package com.example.javagame2d;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UtilityTools {
    public BufferedImage scaleImage(BufferedImage original,int width,int height)
    {
        BufferedImage scaledImage = new BufferedImage(width,height,original.getType());
        Graphics2D G2 = scaledImage.createGraphics();
        G2.drawImage(original,0,0,width,height,null);
        G2.dispose();
        return scaledImage;
    }
}
