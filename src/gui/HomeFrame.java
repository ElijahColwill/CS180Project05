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
public final class HomeFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel signUpPanel;
    private final JPanel signInPanel;
    private final JPanel signInFieldPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel signUpLabel;
    private final JLabel signUpDescriptionLabel;
    private final JLabel signInLabel;
    private final JLabel signInDescriptionLabel;
    private final JLabel usernameLabel;
    private final JLabel passwordLabel;

    public final JButton signUpButton;
    public final JButton signInButton;
    public final JButton exitButton;
    public final JButton enterButton;

    public final JTextField usernameField;
    public final JPasswordField passwordField;

    /**
     * Constructor that creates the home frame.
     * Testing:
     * Verify that window has correct title Social | Welcome
     * Verify that a Frame is created that contains a header with social Icon/Text,
     * middle content and footer with exit button.
     * Verify that content area has Sign In and Sign Up titles with divider and descriptions
     * Verify that Username and Password fields take input, are present, and have correct text next to them.
     * Verify actionListeners in dependant classes exist for buttons.
     */
    public HomeFrame() {
        super("Social | Welcome");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signUpPanel = new JPanel(new GridBagLayout());
        signInPanel = new JPanel(new GridBagLayout());
        signInFieldPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        signUpLabel = new JLabel("Sign Up");
        signUpDescriptionLabel = new JLabel("Press the button below to sign up.");
        signInLabel = new JLabel("Sign In");
        signInDescriptionLabel = new JLabel("Enter your credentials below to sign in.");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");

        signUpButton = new JButton("Sign Up");
        signInButton = new JButton("Sign In");
        exitButton = new JButton("Exit");
        enterButton = new JButton("Enter");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        this.setSize(450, 475);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        signUpLabel.setFont(Constants.SUB_HEADER_FONT);
        signInLabel.setFont(Constants.SUB_HEADER_FONT);

        signUpDescriptionLabel.setFont(Constants.MAIN_FONT);
        signInDescriptionLabel.setFont(Constants.MAIN_FONT);
        usernameLabel.setFont(Constants.MAIN_FONT);
        passwordLabel.setFont(Constants.MAIN_FONT);
        signUpButton.setFont(Constants.MAIN_FONT);
        signInButton.setFont(Constants.MAIN_FONT);
        exitButton.setFont(Constants.MAIN_FONT);

        headerPanel.setBackground(Constants.HEADER_BACKGROUND_COLOR);
        navigationPanel.setBackground(Constants.BACKGROUND_COLOR);

        headerPanel.setBorder(Constants.HEADER_BORDER);
        signUpPanel.setBorder(Constants.NAVIGATION_BORDER);
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

        SwingUtils.addComponent(signInFieldPanel, usernameLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(signInFieldPanel, usernameField, 1, 0,1, 1, GridBagConstraints.LINE_START);
        SwingUtils.addComponent(signInFieldPanel, passwordLabel, 0, 1, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(signInFieldPanel, passwordField, 1, 1, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(signInPanel, signInLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_END);
        SwingUtils.addComponent(signInPanel, signInDescriptionLabel, 0, 1, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(signInPanel, signInFieldPanel, 0, 2, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(signInPanel, signInButton, 0, 3, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(signUpPanel, signUpLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_END);
        SwingUtils.addComponent(signUpPanel, signUpDescriptionLabel, 0, 1, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(signUpPanel, signUpButton, 0, 2, 1, 1, GridBagConstraints.CENTER);

        contentPanel.add(signInPanel);
        contentPanel.add(signUpPanel);

        navigationPanel.add(exitButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);
    }
}
