package assets.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * CS180 - Project 5
 * ImageUtils.java
 *
 * Utilities for images in Swing.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 19, 2020
 */
public final class ImageUtils {
    /**
     * Method to resize ImageIcons.
     *
     * @param imageIcon the image icon to resize.
     * @param width the desired width after resizing.
     * @param height the desired height after resizing.
     */
    public static ImageIcon resizeImageIcon(ImageIcon imageIcon, Integer width, Integer height) {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);

        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(imageIcon.getImage(), 0, 0, width, height, null);
        graphics2D.dispose();

        return new ImageIcon(bufferedImage, imageIcon.getDescription());
    }
}
