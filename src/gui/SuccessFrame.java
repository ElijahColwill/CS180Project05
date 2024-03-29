package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * SuccessFrame.java
 *
 * Success frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 23, 2020
 */
public final class SuccessFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel titlePanel;
    private final JPanel contentPanel;

    private final JLabel successIconLabel;
    private final JLabel successTitleLabel;
    private final JLabel successMessageLabel;

    public final JButton closeButton;

    /**
     * Constructor that creates a success frame, letting the user know their action succeeded.
     * Testing:
     * Verify that window has correct title Social | Success
     * Verify that a Frame is created that contains a title and content panel.
     * Verify that correct Icon, message and Title are present for Success message.
     * Verify that close button is present.
     * Verify actionListeners in dependant classes exist for button.
     * @param message String the error message that is displayed on the frame.
     */
    public SuccessFrame(String message) {
        super("Social | Success");

        frameContainer = this.getContentPane();

        titlePanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());

        successIconLabel = new JLabel();
        successTitleLabel = new JLabel("Success");
        successMessageLabel = new JLabel(message);

        closeButton = new JButton("Close");

        this.setSize(300, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        successTitleLabel.setFont(Constants.HEADER_FONT);

        successMessageLabel.setFont(Constants.MAIN_FONT);

        titlePanel.setBackground(Constants.BACKGROUND_COLOR);
        contentPanel.setBackground(Constants.BACKGROUND_COLOR);

        successIconLabel.setIcon(Constants.SUCCESS_64);

        successTitleLabel.setForeground(Constants.SUCCESS_COLOR);
        successMessageLabel.setForeground(Constants.SUCCESS_COLOR);

        SwingUtils.addComponent(titlePanel, successIconLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(titlePanel, successTitleLabel, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(contentPanel, successMessageLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, closeButton, 0, 1, 1, 1, GridBagConstraints.CENTER);

        frameContainer.add(titlePanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
    }
}
