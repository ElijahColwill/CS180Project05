package assets;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * CS180 - Project 5
 * Constants.java
 *
 * Global constants for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 19, 2020
 */
public final class Constants {
    private static final java.net.URL LOGO_URL = Constants.class.getResource("Logo_80x80.png");
    public static final ImageIcon LOGO = new ImageIcon(LOGO_URL);

    public static final Color HEADER_BACKGROUND_COLOR = new Color(147, 188, 255);
    private static final Color HEADER_BORDER_COLOR = new Color(128, 128, 128);
    public static final Color BACKGROUND_COLOR = new Color(40, 40, 40);
    private static final Color BUTTON_BORDER_COLOR = new Color(198, 198, 198);
    private static final Color NAVIGATION_BORDER_COLOR = new Color(198, 198, 198);
    public static final Color GREEN_COLOR = new Color(0, 153, 51);
    public static final Color RED_COLOR = new Color(255, 0, 0);

    public static final Border HEADER_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, HEADER_BORDER_COLOR);
    public static final Border BUTTON_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, BUTTON_BORDER_COLOR);
    public static final Border NAVIGATION_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, NAVIGATION_BORDER_COLOR);

    public static final Font HEADER_FONT = new Font("Impact", Font.BOLD, 40);
    public static final Font SUB_HEADER_FONT = new Font("Impact", Font.BOLD, 26);
    public static final Font MAIN_FONT = new Font("Lucida Grande", Font.PLAIN, 16);
}
