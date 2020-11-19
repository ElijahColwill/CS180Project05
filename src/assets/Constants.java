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
public class Constants {
    public static final Color BACKGROUND_COLOR = new Color(40, 40, 40);
    private static final Color BUTTON_BORDER_COLOR = new Color(198, 198, 198);
    public static final Color GREEN_COLOR = new Color(0, 153, 51);
    public static final Color RED_COLOR = new Color(255, 0, 0);

    public static final Border BUTTON_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, BUTTON_BORDER_COLOR);

    public static final Font HEADER_FONT = new Font("Impact", Font.BOLD, 40);
    public static final Font MAIN_FONT = new Font("Lucida Grande", Font.PLAIN, 16);
}
