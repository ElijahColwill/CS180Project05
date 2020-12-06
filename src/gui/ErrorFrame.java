package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * HomeFrame.java
 *
 * Home frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 19, 2020
 */
public final class ErrorFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel titlePanel;
    private final JPanel contentPanel;

    private final JLabel errorIconLabel;
    private final JLabel errorTitleLabel;
    private final JLabel errorMessageLabel;

    public final JButton closeButton;

    /**
     * Constructor that creates an error frame, letting the user know an error occurred.
     *
     * @param message the error message that is displayed on the frame.
     */
    public ErrorFrame(String message) {
        super("Social | Error");

        frameContainer = this.getContentPane();

        titlePanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());

        errorIconLabel = new JLabel();
        errorTitleLabel = new JLabel("Error");
        errorMessageLabel = new JLabel(message);

        closeButton = new JButton("Close");

        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        errorTitleLabel.setFont(Constants.HEADER_FONT);

        errorMessageLabel.setFont(Constants.MAIN_FONT);

        titlePanel.setBackground(Constants.BACKGROUND_COLOR);
        contentPanel.setBackground(Constants.BACKGROUND_COLOR);

        errorIconLabel.setIcon(Constants.ERROR_64);

        errorTitleLabel.setForeground(Constants.ERROR_COLOR);
        errorMessageLabel.setForeground(Constants.ERROR_COLOR);

        SwingUtils.addComponent(titlePanel, errorIconLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(titlePanel, errorTitleLabel, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(contentPanel, errorMessageLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, closeButton, 0, 1, 1, 1, GridBagConstraints.CENTER);

        frameContainer.add(titlePanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
