package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * IncomingFriendRequestsFrame.java
 *
 * Incoming friend requests frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version December 2, 2020
 */
public final class IncomingFriendRequestsFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel requestPanel;
    private final JPanel imagePanel;
    private final JPanel namePanel;
    private final JPanel buttonPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel incomingFriendRequestsLabel;
    private final JLabel incomingFriendRequestsDescriptionLabel;
    private final JLabel imageLabel;
    private final JLabel nameLabel;
    private final JLabel usernameLabel;

    public final JButton acceptRequestButton;
    public final JButton denyRequestButton;
    public final JButton backButton;

    /**
     * Constructor that creates a frame for each incoming friend request.
     * Testing:
     * Verify that window has correct title Social | Incoming Friend Requests
     * Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
     * Verify that Incoming Friend Requests title and text is present in content area.
     * Verify that Friend Request is present with profile icon, Name and user name
     * Verify that Accept and Deny Request buttons are present with correct text.
     * Verify actionListeners in dependant classes exist for buttons.
     * @param fullName the full name of the user that requested you as a friend.
     * @param username the username of the user that requested you as a friend.
     */
    public IncomingFriendRequestsFrame(String fullName, String username) {
        super("Social | Incoming Friend Requests");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        requestPanel = new JPanel(new GridBagLayout());
        imagePanel = new JPanel(new BorderLayout());
        namePanel = new JPanel(new GridBagLayout());
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        incomingFriendRequestsLabel = new JLabel("Incoming Friend Requests");
        incomingFriendRequestsDescriptionLabel = new JLabel("Below are your incoming friend requests." +
                " You can either accept or deny requests.");
        imageLabel = new JLabel();
        nameLabel = new JLabel(fullName);
        usernameLabel = new JLabel("@" + username);

        acceptRequestButton = new JButton("Accept Request");
        denyRequestButton = new JButton("Deny Request");
        backButton = new JButton("Back");

        this.setSize(600, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        incomingFriendRequestsLabel.setFont(Constants.SUB_HEADER_FONT);
        nameLabel.setFont(Constants.SUB_HEADER_FONT);

        incomingFriendRequestsDescriptionLabel.setFont(Constants.MAIN_FONT);
        usernameLabel.setFont(Constants.MAIN_FONT);
        acceptRequestButton.setFont(Constants.MAIN_FONT);
        denyRequestButton.setFont(Constants.MAIN_FONT);
        backButton.setFont(Constants.MAIN_FONT);

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

        imagePanel.add(imageLabel);

        SwingUtils.addComponent(namePanel, nameLabel,0, 0, 1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);

        buttonPanel.add(acceptRequestButton);
        buttonPanel.add(denyRequestButton);

        SwingUtils.addComponent(requestPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(requestPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(requestPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LINE_END);

        contentPanel.add(incomingFriendRequestsLabel);
        contentPanel.add(incomingFriendRequestsDescriptionLabel);
        contentPanel.add(requestPanel);

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
