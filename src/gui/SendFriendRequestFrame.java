package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * SendFriendRequestFrame.java
 *
 * Send friend request frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 20, 2020
 */
public final class SendFriendRequestFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel sendFriendRequestLabel;
    private final JLabel sendFriendRequestDescriptionLabel;

    public final JButton sendRequestButton;
    public final JButton backButton;

    public final JComboBox<String> userComboBox;

    public SendFriendRequestFrame() {
        super("Social | Send Friend Request");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        sendFriendRequestLabel = new JLabel("Send Friend Request");
        sendFriendRequestDescriptionLabel = new JLabel("Select a user from the box below to send a friend request.");

        sendRequestButton = new JButton("Send Request");
        backButton = new JButton("Back");

        userComboBox = getUsers();

        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        sendFriendRequestLabel.setFont(Constants.SUB_HEADER_FONT);

        sendFriendRequestDescriptionLabel.setFont(Constants.MAIN_FONT);
        sendRequestButton.setFont(Constants.MAIN_FONT);
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

        contentPanel.add(sendFriendRequestLabel);
        contentPanel.add(sendFriendRequestDescriptionLabel);
        contentPanel.add(userComboBox);
        contentPanel.add(sendRequestButton);

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public JComboBox<String> getUsers() {
        return new JComboBox<>();
    }

    // FOR TESTING THE FRAME
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                new SendFriendRequestFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}