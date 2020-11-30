package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * FriendsListFrame.java
 *
 * Friends list frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 20, 2020
 */
public final class FriendsListFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel friendsListLabel;
    private final JLabel friendsListDescriptionLabel;

    public final JButton backButton;

    public FriendsListFrame() {
        super("Social | Friends List");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        friendsListLabel = new JLabel("Your Friend's List");
        friendsListDescriptionLabel = new JLabel("Below is a list of your current friends. Click \"View Profile\" to visit their profile.");

        backButton = new JButton("Back");

        this.setSize(550, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        friendsListLabel.setFont(Constants.SUB_HEADER_FONT);

        friendsListDescriptionLabel.setFont(Constants.MAIN_FONT);
        backButton.setFont(Constants.MAIN_FONT);

        headerPanel.setBackground(Constants.HEADER_BACKGROUND_COLOR);
        navigationPanel.setBackground(Constants.BACKGROUND_COLOR);

        headerPanel.setBorder(Constants.HEADER_BORDER);
        navigationPanel.setBorder(Constants.NAVIGATION_BORDER);

        logoLabel.setIcon(Constants.LOGO_64);

        headerLabel.setForeground(Constants.YELLOW_COLOR);

        SwingUtils.addComponent(headerPanel, logoLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(headerPanel, headerLabel, 1, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 2, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 3, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 4, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 5, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 6, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 7, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 8, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 9, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 10, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 11, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(headerPanel, new JLabel(" "), 12, 0, 1, 1, GridBagConstraints.CENTER);

        contentPanel.add(friendsListLabel);
        contentPanel.add(friendsListDescriptionLabel);


//        for (int i = 0; i < user.getNumberOfFriends(); i++) {
//            JPanel friendPanel = new JPanel(new GridBagLayout());
//            JPanel imagePanel = new JPanel(new BorderLayout());
//            JPanel namePanel = new JPanel(new GridBagLayout());
//            JPanel buttonPanel = new JPanel(new BorderLayout());
//
//            JLabel imageLabel = new JLabel();
//            JLabel nameLabel = new JLabel(user.getFullName());
//            JLabel usernameLabel = new JLabel("@" + user.getUsername());
//
//            JButton viewProfileButton = new JButton("View Profile");
//
//            nameLabel.setFont(Constants.SUB_HEADER_FONT);
//            usernameLabel.setFont(Constants.MAIN_FONT);
//            viewProfileButton.setFont(Constants.MAIN_FONT);
//
//            imageLabel.setIcon(Constants.USER_100);
//
//            imagePanel.add(imageLabel);
//
//            SwingUtils.addComponent(namePanel, nameLabel,0, 0, 1, 1, GridBagConstraints.LINE_START);
//            SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);
//
//            buttonPanel.add(viewProfileButton);
//
//            SwingUtils.addComponent(friendPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
//            SwingUtils.addComponent(friendPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
//            SwingUtils.addComponent(friendPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LINE_END);
//
//            contentPanel.add(friendPanel);
//        }

        for (int i = 0; i < 3; i++) {
            JPanel friendPanel = new JPanel(new GridBagLayout());
            JPanel imagePanel = new JPanel(new BorderLayout());
            JPanel namePanel = new JPanel(new GridBagLayout());
            JPanel buttonPanel = new JPanel(new BorderLayout());

            JLabel imageLabel = new JLabel();
            JLabel nameLabel = new JLabel("Henrik Berg");
            JLabel usernameLabel = new JLabel("@henrikbg");

            JButton viewProfileButton = new JButton("View Profile");

            nameLabel.setFont(Constants.SUB_HEADER_FONT);
            usernameLabel.setFont(Constants.MAIN_FONT);
            viewProfileButton.setFont(Constants.MAIN_FONT);

            imageLabel.setIcon(Constants.USER_100);

            imagePanel.add(imageLabel);

            SwingUtils.addComponent(namePanel, nameLabel,0, 0, 1, 1, GridBagConstraints.LINE_START);
            SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);

            buttonPanel.add(viewProfileButton);

            SwingUtils.addComponent(friendPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
            SwingUtils.addComponent(friendPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
            SwingUtils.addComponent(friendPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LAST_LINE_END);

            contentPanel.add(friendPanel);
        }

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    // FOR TESTING THE FRAME
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new FriendsListFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}