package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CS180 - Project 5
 * FriendListFrame.java
 *
 * Friend list frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 20, 2020
 */
public final class FriendsListFrame extends JFrame implements ActionListener {
    private final Container frameContainer;

    private final JPanel titlePanel;
    private final JPanel buttonPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel titleLabel;
    private final JLabel descriptionLabel;

    private final JButton enterButton;
    private final JButton exitButton;

    public FriendsListFrame() {
        super("Social | Friends List");

        frameContainer = this.getContentPane();

        titlePanel = new JPanel(new GridBagLayout());
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        titleLabel = new JLabel("Friends List");
        descriptionLabel = new JLabel("Below is a list of your friends.");

        enterButton = new JButton("Enter");
        exitButton = new JButton("Exit");

        this.setSize(470, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        titleLabel.setFont(Constants.HEADER_FONT);
        descriptionLabel.setFont(Constants.MAIN_FONT);
        enterButton.setFont(Constants.MAIN_FONT);
        exitButton.setFont(Constants.MAIN_FONT);

        frameContainer.setBackground(Constants.HEADER_BACKGROUND_COLOR);

        navigationPanel.setBorder(Constants.NAVIGATION_BORDER);

        logoLabel.setIcon(Constants.LOGO);

        enterButton.addActionListener(this);
        exitButton.addActionListener(this);

        SwingUtils.addComponent(titlePanel, logoLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(titlePanel, titleLabel, 0, 1, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(titlePanel, descriptionLabel, 0, 2, 1, 1, GridBagConstraints.PAGE_END);

        buttonPanel.add(enterButton);

        navigationPanel.add(enterButton);
        navigationPanel.add(exitButton);

        frameContainer.add(titlePanel, BorderLayout.NORTH);
        frameContainer.add(buttonPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        if (buttonPressed == enterButton) {
            MainFrame mainFrame = new MainFrame();
            this.dispose();
        }
        if (buttonPressed == exitButton) {
            return;
        }

    }

}
