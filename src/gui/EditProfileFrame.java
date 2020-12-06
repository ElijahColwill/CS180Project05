package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * CS180 - Project 5
 * EditProfileFrame.java
 *
 * Edit profile frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 25, 2020
 */
public final class EditProfileFrame extends JFrame {
    private final Container frameContainer;

    private final JPanel headerPanel;
    private final JPanel contentPanel;
    private final JPanel editProfilePanel;
    private final JPanel namePanel;
    private final JPanel usernamePanel;
    private final JPanel emailPanel;
    private final JPanel passwordPanel;
    private final JPanel locationPanel;
    private final JPanel bioPanel;
    private final JPanel interestsPanel;
    private final JPanel navigationPanel;

    private final JLabel logoLabel;
    private final JLabel headerLabel;
    private final JLabel editProfileLabel;
    private final JLabel editProfileDescriptionLabel;
    private final JLabel nameLabel;
    private final JLabel usernameLabel;
    private final JLabel emailLabel;
    private final JLabel passwordLabel;
    private final JLabel locationLabel;
    private final JLabel bioLabel;
    private final JLabel interestsLabel;

    public final JButton updateProfileButton;
    public final JButton deleteAccountButton;
    public final JButton backButton;

    public final JTextField nameField;
    public final JTextField usernameField;
    public final JTextField emailField;
    public final JPasswordField passwordField;
    public final JTextField locationField;
    public final JTextField bioField;
    public final JTextField interestsField;

    /**
     * Constructor that creates a frame that allows the user to edit their profile.
     * Testing:
     * Verify that window has correct title Social | Edit Profile
     * Verify that a Frame is created that contains a header with social Icon/Text, middle content and footer with back button.
     * Verify that Frame contains correct text and all buttons/text fields.
     * Verify actionListeners in dependant classes exist for buttons.
     * Verify that all text fields take input and have correct text next to them
     * @param fullName the full name of the user editing the profile.
     * @param username the username of the user editing the profile.
     * @param email the email of the user editing the profile.
     * @param location the location of the user editing the profile.
     * @param bio the biography of the user editing the profile.
     * @param interests the interests of the user editing the profile.
     */
    public EditProfileFrame(String fullName, String username, String email,
                            String location, String bio, String interests) {
        super("Social | Edit Profile");

        frameContainer = this.getContentPane();

        headerPanel = new JPanel(new GridBagLayout());
        contentPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        editProfilePanel = new JPanel(new GridBagLayout());
        namePanel = new JPanel(new GridBagLayout());
        usernamePanel = new JPanel(new GridBagLayout());
        emailPanel = new JPanel(new GridBagLayout());
        passwordPanel = new JPanel(new GridBagLayout());
        locationPanel = new JPanel(new GridBagLayout());
        bioPanel = new JPanel(new GridBagLayout());
        interestsPanel = new JPanel(new GridBagLayout());
        navigationPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        logoLabel = new JLabel();
        headerLabel = new JLabel("Social");
        editProfileLabel = new JLabel("Edit Profile");
        editProfileDescriptionLabel = new JLabel("Enter your details below to edit your profile.");
        nameLabel = new JLabel("Full Name:");
        usernameLabel = new JLabel("Username:");
        emailLabel = new JLabel("Email:        ");
        passwordLabel = new JLabel("Password:");
        locationLabel = new JLabel("Location: ");
        bioLabel = new JLabel("Bio:           ");
        interestsLabel = new JLabel("Interests:  ");

        updateProfileButton = new JButton("Update Profile");
        deleteAccountButton = new JButton("Delete Account");
        backButton = new JButton("Back");

        nameField = new JTextField(12);
        usernameField = new JTextField(12);
        emailField = new JTextField(12);
        passwordField = new JPasswordField(12);
        locationField = new JTextField(12);
        bioField = new JTextField(12);
        interestsField = new JTextField(12);

        this.setSize(450, 650);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        presetFields(fullName, username, email, location, bio, interests);

        headerLabel.setFont(Constants.HEADER_FONT);
        editProfileLabel.setFont(Constants.SUB_HEADER_FONT);

        editProfileDescriptionLabel.setFont(Constants.MAIN_FONT);
        nameLabel.setFont(Constants.MAIN_FONT);
        usernameLabel.setFont(Constants.MAIN_FONT);
        emailLabel.setFont(Constants.MAIN_FONT);
        passwordLabel.setFont(Constants.MAIN_FONT);
        locationLabel.setFont(Constants.MAIN_FONT);
        bioLabel.setFont(Constants.MAIN_FONT);
        interestsLabel.setFont(Constants.MAIN_FONT);
        updateProfileButton.setFont(Constants.MAIN_FONT);
        deleteAccountButton.setFont(Constants.MAIN_FONT);
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

        SwingUtils.addComponent(locationPanel, locationLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(locationPanel, locationField, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(bioPanel, bioLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(bioPanel, bioField, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(interestsPanel, interestsLabel, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(interestsPanel, interestsField, 1, 0, 1, 1, GridBagConstraints.LINE_START);

        SwingUtils.addComponent(editProfilePanel, editProfileLabel, 0, 0, 1, 1, GridBagConstraints.PAGE_END);
        SwingUtils.addComponent(editProfilePanel, editProfileDescriptionLabel, 0, 1, 1, 1, GridBagConstraints.PAGE_START);
        SwingUtils.addComponent(editProfilePanel, namePanel, 0, 2, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, usernamePanel, 0, 3, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, emailPanel, 0, 4, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, passwordPanel, 0, 5, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, locationPanel, 0, 6, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, bioPanel, 0, 7, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, interestsPanel, 0, 8, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, updateProfileButton, 0, 9, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(editProfilePanel, deleteAccountButton, 0, 10, 1, 1, GridBagConstraints.PAGE_END);

        contentPanel.add(editProfilePanel);

        navigationPanel.add(backButton);

        frameContainer.add(headerPanel, BorderLayout.NORTH);
        frameContainer.add(contentPanel, BorderLayout.CENTER);
        frameContainer.add(navigationPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    /**
     * Pre-fills all the text fields with existing information about the user.
     * Testing:
     * Verify that fields are preset with information from User when testing overall project.
     * @param name the full name of the user editing the profile.
     * @param username the username of the user editing the profile.
     * @param email the email of the user editing the profile.
     * @param location the location of the user editing the profile.
     * @param bio the biography of the user editing the profile.
     * @param interests the interests of the user editing the profile.
     */
    public void presetFields(String name, String username, String email,
                             String location, String bio, String interests) {
        nameField.setText(name);
        usernameField.setText(username);
        emailField.setText(email);
        locationField.setText(location);
        bioField.setText(bio);
        interestsField.setText(interests);
    }
}
