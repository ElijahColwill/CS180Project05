package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * SignUpFrame.java
 *
 * Sign up frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 20, 2020
 */
public final class SignUpFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel signUpPanel;
    private final JPanel namePanel;
    private final JPanel usernamePanel;
    private final JPanel emailPanel;
    private final JPanel passwordPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel signUpLabel;
    private final JLabel signUpDescriptionLabel;
    private final JLabel nameLabel;
    private final JLabel usernameLabel;
    private final JLabel emailLabel;
    private final JLabel passwordLabel;

    public final JButton signUpButton;
    public final JButton backButton;

    public final JTextField nameField;
    public final JTextField usernameField;
    public final JTextField emailField;
    public final JPasswordField passwordField;

    public SignUpFrame() {
        super("Social | Sign Up");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        signUpPanel = new JPanel(new GridBagLayout());
        namePanel = new JPanel(new GridBagLayout());
        usernamePanel = new JPanel(new GridBagLayout());
        emailPanel = new JPanel(new GridBagLayout());
        passwordPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        signUpLabel = new JLabel("Sign Up");
        signUpDescriptionLabel = new JLabel("Enter your details below to sign up.");
        nameLabel = new JLabel("Name:");
        usernameLabel = new JLabel("Username:");
        emailLabel = new JLabel("Email:        ");
        passwordLabel = new JLabel("Password:");

        signUpButton = new JButton("Sign Up");
        backButton = new JButton("Back");

        nameField = new JTextField(12);
        usernameField = new JTextField(12);
        emailField = new JTextField(12);
        passwordField = new JPasswordField(12);

        this.setSize(450, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        headerLabel.setFont(Constants.HEADER_FONT);
        signUpLabel.setFont(Constants.SUB_HEADER_FONT);

        signUpDescriptionLabel.setFont(Constants.MAIN_FONT);
        nameLabel.setFont(Constants.MAIN_FONT);
        usernameLabel.setFont(Constants.MAIN_FONT);
        emailLabel.setFont(Constants.MAIN_FONT);
        passwordLabel.setFont(Constants.MAIN_FONT);
        signUpButton.setFont(Constants.MAIN_FONT);
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

        SwingUtils.addComponent(namePanel, nameLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(namePanel, nameField, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(usernamePanel, usernameLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(usernamePanel, usernameField, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(emailPanel, emailLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(emailPanel, emailField, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(passwordPanel, passwordLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(passwordPanel, passwordField, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(signUpPanel, signUpLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_END);
        SwingUtils.addComponent(signUpPanel, signUpDescriptionLabel, 0, 1, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(signUpPanel, namePanel, 0, 2, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(signUpPanel, usernamePanel, 0, 3, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(signUpPanel, emailPanel, 0, 4, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(signUpPanel, passwordPanel, 0, 5, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(signUpPanel, signUpButton, 0, 6, 1, 1, GridBagConstraints.CENTER);

        contentPanel.add(signUpPanel);

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
