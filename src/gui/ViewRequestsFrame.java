package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * ViewRequestsFrame.java
 *
 * View requests frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version December 2, 2020
 */
public final class ViewRequestsFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel buttonPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel viewRequestsLabel;
    private final JLabel viewRequestsDescriptionLabel;

    public final JButton incomingRequestsButton;
    public final JButton outgoingRequestsButton;
    public final JButton backButton;

    /**
     * Constructor that creates a frame to select incoming or outgoing friend requests.
     * Testing:
     * Verify that window has correct title Social | View Requests
     * Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
     * Verify that View Friend Requests title is present and centered at top of content area, with correct description
     * Verify that Incoming Requests and Outgoing Requests buttons are present below description, centered, and with correct text.
     * Verify actionListeners in dependant classes exist for buttons.
     */
    public ViewRequestsFrame() {
        super("Social | View Requests");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new GridBagLayout());
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        viewRequestsLabel = new JLabel("View Friend Requests");
        viewRequestsDescriptionLabel = new JLabel("Press to view your incoming or outgoing friend requests.");

        incomingRequestsButton = new JButton("Incoming Requests");
        outgoingRequestsButton = new JButton("Outgoing Requests");
        backButton = new JButton("Back");

        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        viewRequestsLabel.setFont(Constants.SUB_HEADER_FONT);

        viewRequestsDescriptionLabel.setFont(Constants.MAIN_FONT);
        incomingRequestsButton.setFont(Constants.MAIN_FONT);
        outgoingRequestsButton.setFont(Constants.MAIN_FONT);
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

        buttonPanel.add(incomingRequestsButton);
        buttonPanel.add(outgoingRequestsButton);

        SwingUtils.addComponent(contentPanel, viewRequestsLabel, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, viewRequestsDescriptionLabel, 0, 1, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(contentPanel, buttonPanel, 0, 2, 1, 1, GridBagConstraints.CENTER);

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);
    }
}
