package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * ManageFriendRequestsFrame.java
 *
 * Manage requests frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 19, 2020
 */
public final class ManageFriendRequestsFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel outgoingFriendRequestsPanel;
    private final JPanel incomingFriendRequestsPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel outgoingFriendRequestsLabel;
    private final JLabel outgoingFriendRequestsDescriptionLabel;
    private final JLabel incomingFriendRequestsLabel;
    private final JLabel incomingFriendRequestsDescriptionLabel;

    public final JButton backButton;

    public ManageFriendRequestsFrame() {
        super("Social | Manage Requests");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        outgoingFriendRequestsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        incomingFriendRequestsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        outgoingFriendRequestsLabel = new JLabel("Outgoing Friend Requests");
        outgoingFriendRequestsDescriptionLabel = new JLabel("Below are your outgoing friend requests. Press \"Cancel\" to cancel a request.");
        incomingFriendRequestsLabel = new JLabel("Incoming Friend Requests");
        incomingFriendRequestsDescriptionLabel = new JLabel("Below are your incoming friend requests. Press \"Cancel\" to cancel a request.");

        backButton = new JButton("Back");

        this.setSize(1000, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        outgoingFriendRequestsLabel.setFont(Constants.SUB_HEADER_FONT);
        incomingFriendRequestsLabel.setFont(Constants.SUB_HEADER_FONT);

        outgoingFriendRequestsDescriptionLabel.setFont(Constants.MAIN_FONT);
        incomingFriendRequestsDescriptionLabel.setFont(Constants.MAIN_FONT);
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

        SwingUtils.addComponent(outgoingFriendRequestsPanel, outgoingFriendRequestsLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(outgoingFriendRequestsPanel, outgoingFriendRequestsDescriptionLabel, 0, 1, 1, 1, GridBagConstraints.CENTER);

//        for (int i = 0; i < user.getNumberOfOutGoingRequests(); i++) {
//            JPanel requestPanel = new JPanel(new GridBagLayout());
//            JPanel imagePanel = new JPanel(new BorderLayout());
//            JPanel namePanel = new JPanel(new GridBagLayout());
//            JPanel buttonPanel = new JPanel(new BorderLayout());
//
//            JLabel imageLabel = new JLabel();
//            JLabel nameLabel = new JLabel(user.getFullName());
//            JLabel usernameLabel = new JLabel("@" + user.getUsername());
//
//            JButton cancelRequestButton = new JButton("Cancel Request");
//
//            nameLabel.setFont(Constants.SUB_HEADER_FONT);
//            usernameLabel.setFont(Constants.MAIN_FONT);
//            cancelRequestButton.setFont(Constants.MAIN_FONT);
//
//            imageLabel.setIcon(Constants.USER_100);
//
//            imagePanel.add(imageLabel);
//
//            SwingUtils.addComponent(namePanel, nameLabel,0, 0, 1, 1, GridBagConstraints.LINE_START);
//            SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);
//
//            buttonPanel.add(cancelRequestButton);
//
//            SwingUtils.addComponent(requestPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
//            SwingUtils.addComponent(requestPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
//            SwingUtils.addComponent(requestPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LINE_END);
//
//            outgoingFriendRequestsPanel.add(requestPanel);
//        }

        for (int i = 0; i < 4; i++) {
            JPanel requestPanel = new JPanel(new GridBagLayout());
            JPanel imagePanel = new JPanel(new BorderLayout());
            JPanel namePanel = new JPanel(new GridBagLayout());
            JPanel buttonPanel = new JPanel(new BorderLayout());

            JLabel imageLabel = new JLabel();
            JLabel nameLabel = new JLabel("Henrik Berg");
            JLabel usernameLabel = new JLabel("@henrikbg");

            JButton cancelRequestButton = new JButton("Cancel Request");

            nameLabel.setFont(Constants.SUB_HEADER_FONT);
            usernameLabel.setFont(Constants.MAIN_FONT);
            cancelRequestButton.setFont(Constants.MAIN_FONT);

            imageLabel.setIcon(Constants.USER_100);

            imagePanel.add(imageLabel);

            SwingUtils.addComponent(namePanel, nameLabel,0, 0, 1, 1, GridBagConstraints.LINE_START);
            SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);

            buttonPanel.add(cancelRequestButton);

            SwingUtils.addComponent(requestPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
            SwingUtils.addComponent(requestPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
            SwingUtils.addComponent(requestPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LINE_END);

            outgoingFriendRequestsPanel.add(requestPanel);
        }

        SwingUtils.addComponent(incomingFriendRequestsPanel, incomingFriendRequestsLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(incomingFriendRequestsPanel, incomingFriendRequestsDescriptionLabel, 0, 1, 1, 1, GridBagConstraints.CENTER);

//        for (int i = 0; i < user.getNumberOfIncomingRequests(); i++) {
//            JPanel requestPanel = new JPanel(new GridBagLayout());
//            JPanel imagePanel = new JPanel(new BorderLayout());
//            JPanel namePanel = new JPanel(new GridBagLayout());
//            JPanel buttonPanel = new JPanel(new BorderLayout());
//
//            JLabel imageLabel = new JLabel();
//            JLabel nameLabel = new JLabel(user.getFullName());
//            JLabel usernameLabel = new JLabel("@" + user.getUsername());
//
//            JButton acceptRequestButton = new JButton("Accept Request");
//            JButton denyRequestButton = new JButton("Deny Request");
//
//            nameLabel.setFont(Constants.SUB_HEADER_FONT);
//            usernameLabel.setFont(Constants.MAIN_FONT);
//            acceptRequestButton.setFont(Constants.MAIN_FONT);
//            denyRequestButton.setFont(Constants.MAIN_FONT);
//
//            imageLabel.setIcon(Constants.USER_100);
//
//            imagePanel.add(imageLabel);
//
//            SwingUtils.addComponent(namePanel, nameLabel,0, 0, 1, 1, GridBagConstraints.LINE_START);
//            SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);
//
//            buttonPanel.add(acceptRequestButton);
//            buttonPanel.add(denyRequestButton);
//
//            SwingUtils.addComponent(requestPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
//            SwingUtils.addComponent(requestPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
//            SwingUtils.addComponent(requestPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LINE_END);
//
//            incomingFriendRequestsPanel.add(requestPanel);
//        }

        for (int i = 0; i < 2; i++) {
            JPanel requestPanel = new JPanel(new GridBagLayout());
            JPanel imagePanel = new JPanel(new BorderLayout());
            JPanel namePanel = new JPanel(new GridBagLayout());
            JPanel buttonPanel = new JPanel(new BorderLayout());

            JLabel imageLabel = new JLabel();
            JLabel nameLabel = new JLabel("Henrik Berg");
            JLabel usernameLabel = new JLabel("@henrikbg");

            JButton acceptRequestButton = new JButton("Accept Request");
            JButton denyRequestButton = new JButton("Deny Request");

            nameLabel.setFont(Constants.SUB_HEADER_FONT);
            usernameLabel.setFont(Constants.MAIN_FONT);
            acceptRequestButton.setFont(Constants.MAIN_FONT);
            denyRequestButton.setFont(Constants.MAIN_FONT);

            imageLabel.setIcon(Constants.USER_100);

            imagePanel.add(imageLabel);

            SwingUtils.addComponent(namePanel, nameLabel,0, 0, 1, 1, GridBagConstraints.LINE_START);
            SwingUtils.addComponent(namePanel, usernameLabel, 0, 1, 1, 1, GridBagConstraints.LINE_START);

            buttonPanel.add(acceptRequestButton);
            buttonPanel.add(denyRequestButton);

            SwingUtils.addComponent(requestPanel, imagePanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
            SwingUtils.addComponent(requestPanel, namePanel, 1, 0, 1, 1, GridBagConstraints.CENTER);
            SwingUtils.addComponent(requestPanel, buttonPanel, 2, 0, 1, 1, GridBagConstraints.LINE_END);

            incomingFriendRequestsPanel.add(requestPanel);
        }

        SwingUtils.addComponent(contentPanel, outgoingFriendRequestsPanel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, incomingFriendRequestsPanel, 1, 0, 1, 1, GridBagConstraints.CENTER);

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
                new ManageFriendRequestsFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
