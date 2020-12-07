package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * ProfileFrame.java
 *
 * Profile frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 21, 2020
 */
public final class ProfileFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel profilePanel;
    private final JPanel imagePanel;
    private final JPanel namePanel;
    private final JPanel buttonPanel;
    private final JPanel friendButtonPanel;
    private final JPanel informationPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel imageLabel;
    private final JLabel nameLabel;
    private final JLabel usernameLabel;
    private final JLabel locationHeaderLabel;
    private final JLabel locationLabel;
    private final JLabel bioHeaderLabel;
    private final JLabel bioLabel;
    private final JLabel interestsHeaderLabel;
    private final JLabel interestsLabel;

    public final JButton editProfileButton;
    public final JButton viewFriendsButton;
    public final JButton addFriendButton;
    public final JButton viewRequestsButton;
    public final JButton signOutButton;

    /**
     * Constructor that creates a frame for a user's profile.
     * Testing:
     * Verify that window has correct title Social | Profile
     * Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with sign out button.
     * Verify that profile name, username, Profile Icon, and edit profile button are present with correct text.
     * Verify that below profile information is area for Location/Bio/Interests with correct text for the User.
     * Verify that in bottom of content area View Friends, Add Friend and View Request buttons exist with correct text.
     * Verify actionListeners in dependant classes exist for buttons.
     * @param fullName String the full name of the user.
     * @param username String the username of the user.
     * @param location String the location of the user.
     * @param bio String the biography of the user.
     * @param interests String the interests of the user.
     */
    public ProfileFrame(String fullName, String username, String location, String bio, String interests) {
        super("Social | Profile");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        profilePanel = new JPanel(new GridBagLayout());
        imagePanel = new JPanel(new GridBagLayout());
        namePanel = new JPanel(new GridBagLayout());
        friendButtonPanel = new JPanel(new GridBagLayout());
        buttonPanel = new JPanel(new GridBagLayout());
        informationPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        imageLabel = new JLabel();
        nameLabel = new JLabel(fullName);
        usernameLabel = new JLabel("@" + username);
        locationHeaderLabel = new JLabel("Location");
        locationLabel = new JLabel(location);
        bioHeaderLabel = new JLabel("Bio");
        bioLabel = new JLabel(bio);
        interestsHeaderLabel = new JLabel("Interests");
        interestsLabel = new JLabel(interests);

        editProfileButton = new JButton("Edit Profile");
        viewFriendsButton = new JButton("View Friends");
        addFriendButton = new JButton("Add Friend");
        viewRequestsButton = new JButton("View Requests");
        signOutButton = new JButton("Sign Out");

        this.setSize(550, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        nameLabel.setFont(Constants.SUB_HEADER_FONT);

        locationHeaderLabel.setFont(Constants.SUB_SUB_HEADER_FONT);
        bioHeaderLabel.setFont(Constants.SUB_SUB_HEADER_FONT);
        interestsHeaderLabel.setFont(Constants.SUB_SUB_HEADER_FONT);

        usernameLabel.setFont(Constants.MAIN_FONT);
        locationLabel.setFont(Constants.MAIN_FONT);
        bioLabel.setFont(Constants.MAIN_FONT);
        interestsLabel.setFont(Constants.MAIN_FONT);
        editProfileButton.setFont(Constants.MAIN_FONT);
        viewFriendsButton.setFont(Constants.MAIN_FONT);
        addFriendButton.setFont(Constants.MAIN_FONT);
        viewRequestsButton.setFont(Constants.MAIN_FONT);
        signOutButton.setFont(Constants.MAIN_FONT);

        headerPanel.setBackground(Constants.HEADER_BACKGROUND_COLOR);
        navigationPanel.setBackground(Constants.BACKGROUND_COLOR);

        headerPanel.setBorder(Constants.HEADER_BORDER);
        navigationPanel.setBorder(Constants.NAVIGATION_BORDER);

        logoLabel.setIcon(Constants.LOGO_64);
        imageLabel.setIcon(Constants.USER_100);

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

        SwingUtils.addComponent(imagePanel, imageLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(namePanel, nameLabel, 0, 0, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(buttonPanel, editProfileButton, 0, 0, 1, 1, GridBagConstraints.LAST_LINE_END);

        SwingUtils.addComponent(profilePanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(profilePanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(profilePanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LAST_LINE_END);

        SwingUtils.addComponent(informationPanel, locationHeaderLabel, 0, 0,
                1, 1, GridBagConstraints.FIRST_LINE_START);
        SwingUtils.addComponent(informationPanel, locationLabel, 0, 1, 1, 1, GridBagConstraints.FIRST_LINE_START);
        SwingUtils.addComponent(informationPanel, bioHeaderLabel, 0, 2, 1, 1, GridBagConstraints.FIRST_LINE_START);
        SwingUtils.addComponent(informationPanel, bioLabel, 0, 3, 1, 1, GridBagConstraints.FIRST_LINE_START);
        SwingUtils.addComponent(informationPanel, interestsHeaderLabel, 0, 4,
                1, 1, GridBagConstraints.FIRST_LINE_START);
        SwingUtils.addComponent(informationPanel, interestsLabel, 0, 5, 1, 1, GridBagConstraints.FIRST_LINE_START);

        SwingUtils.addComponent(friendButtonPanel, viewFriendsButton, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(friendButtonPanel, addFriendButton, 1, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(friendButtonPanel, viewRequestsButton, 2, 0, 1, 1, GridBagConstraints.LINE_END);

        SwingUtils.addComponent(contentPanel, profilePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, informationPanel, 0, 1, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, friendButtonPanel, 0, 2, 1, 1, GridBagConstraints.CENTER);

        navigationPanel.add(signOutButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);
    }
}
