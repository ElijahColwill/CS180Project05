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
    public static final ImageIcon LOGO_64 = new ImageIcon(Constants.class.getResource("images/Logo_64x64.png"));
    public static final ImageIcon LOGO_128 = new ImageIcon(Constants.class.getResource("images/Logo_128x128.png"));
    public static final ImageIcon LOGO_256 = new ImageIcon(Constants.class.getResource("images/Logo_256x256.png"));
    public static final ImageIcon LOGO_512 = new ImageIcon(Constants.class.getResource("images/Logo_512x512.png"));
    public static final ImageIcon ERROR_64 = new ImageIcon(Constants.class.getResource("images/Error_64x64.png"));
    public static final ImageIcon USER_100 = new ImageIcon(Constants.class.getResource("images/User_100x100.png"));
    public static final ImageIcon SUCCESS_64 = new ImageIcon(Constants.class.getResource("images/Checkmark_64x64.png"));
    public static final ImageIcon SETTINGS_48 = new ImageIcon(Constants.class.getResource("images/Settings_48x48.png"));

    public static final Color HEADER_BACKGROUND_COLOR = new Color(51, 51, 51);
    private static final Color HEADER_BORDER_COLOR = new Color(128, 128, 128);
    public static final Color BACKGROUND_COLOR = new Color(51, 51, 51);
    private static final Color BUTTON_BORDER_COLOR = new Color(198, 198, 198);
    private static final Color NAVIGATION_BORDER_COLOR = new Color(198, 198, 198);
    public static final Color GRAY_COLOR = new Color(51, 51, 51);
    public static final Color YELLOW_COLOR = new Color(248, 207, 55);
    public static final Color ERROR_COLOR = new Color(202, 56, 57);
    public static final Color SUCCESS_COLOR = new Color(80, 184, 72);

    public static final Border HEADER_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, HEADER_BORDER_COLOR);
    public static final Border BUTTON_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, BUTTON_BORDER_COLOR);
    public static final Border NAVIGATION_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, NAVIGATION_BORDER_COLOR);

    public static final Font HEADER_FONT = new Font("Futura", Font.BOLD, 40);
    public static final Font SUB_HEADER_FONT = new Font("Futura", Font.BOLD, 26);
    public static final Font SUB_SUB_HEADER_FONT = new Font("Futura", Font.BOLD, 16);
    public static final Font MAIN_FONT = new Font("Arial", Font.PLAIN, 16);
}
