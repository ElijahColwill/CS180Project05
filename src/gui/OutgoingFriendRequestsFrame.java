package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * OutgoingFriendRequestsFrame.java
 *
 * Outgoing friend requests frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version December 2, 2020
 */
public final class OutgoingFriendRequestsFrame extends JFrame {
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
    private final JLabel outgoingFriendRequestsLabel;
    private final JLabel outgoingFriendRequestsDescriptionLabel;
    private final JLabel imageLabel;
    private final JLabel nameLabel;
    private final JLabel usernameLabel;

    public final JButton cancelRequestButton;
    public final JButton backButton;
    public final JButton nextButton;

    /**
     * Constructor that creates a frame for each outgoing friend request.
     * Testing:
     * Verify that window has correct title Social | Outgoing Friend Requests
     * Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
     * Verify that Outgoing Friend Requests title and text is present in content area.
     * Verify that Friend Request is present with profile icon, Name and user name
     * Verify that Cancel Request button is present with correct text.
     * Verify actionListeners in dependant classes exist for buttons.
     * @param fullName String the full name of the user that you requested as a friend.
     * @param username String the username of the user that you requested as a friend.
     */
    public OutgoingFriendRequestsFrame(String fullName, String username) {
        super("Social | Outgoing Friend Requests");

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
        outgoingFriendRequestsLabel = new JLabel("Outgoing Friend Requests");
        outgoingFriendRequestsDescriptionLabel = new JLabel("Below are your outgoing friend requests." +
                " You are able to cancel your requests.");
        imageLabel = new JLabel();
        nameLabel = new JLabel(fullName);
        usernameLabel = new JLabel("@" + username);

        cancelRequestButton = new JButton("Cancel Request");
        backButton = new JButton("Back");
        nextButton = new JButton("Next");

        this.setSize(600, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        outgoingFriendRequestsLabel.setFont(Constants.SUB_HEADER_FONT);
        nameLabel.setFont(Constants.SUB_HEADER_FONT);

        outgoingFriendRequestsDescriptionLabel.setFont(Constants.MAIN_FONT);
        usernameLabel.setFont(Constants.MAIN_FONT);
        cancelRequestButton.setFont(Constants.MAIN_FONT);
        backButton.setFont(Constants.MAIN_FONT);
        nextButton.setFont(Constants.MAIN_FONT);

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

        buttonPanel.add(cancelRequestButton);

        SwingUtils.addComponent(requestPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(requestPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(requestPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LINE_END);

        contentPanel.add(outgoingFriendRequestsLabel);
        contentPanel.add(outgoingFriendRequestsDescriptionLabel);
        contentPanel.add(requestPanel);

        navigationPanel.add(backButton);
        navigationPanel.add(nextButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);
    }
}
