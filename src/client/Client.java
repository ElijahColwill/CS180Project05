package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Client extends JComponent implements Runnable, ActionListener {

    private static int portNum;

    PrintWriter writer;
    BufferedReader reader;

    String currentUsername;

    gui.HomeFrame homeFrame = new gui.HomeFrame();
    gui.SignUpFrame signUpFrame = new gui.SignUpFrame();

    gui.FriendsListFrame friendsListFrame = new gui.FriendsListFrame();
    gui.ManageFriendRequestsFrame manageFriendRequestsFrame = new gui.ManageFriendRequestsFrame();
    gui.SendFriendRequestFrame sendFriendRequestFrame = new gui.SendFriendRequestFrame();

    gui.ProfileFrame profileFrame = new gui.ProfileFrame();
    gui.EditProfileFrame editProfileFrame = new gui.EditProfileFrame();

    gui.ProfileFrameRestricted profileFrameRestricted = new gui.ProfileFrameRestricted();

    public Client(int portNum) throws IOException {
        this.portNum = portNum;

        Socket socket = new Socket("localHost", portNum);

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new Client(2400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String message) {
        writer.write(message);
        writer.println();
        writer.flush();
    }

    private String receiveMessage() {
        try {
            return reader.readLine();
        } catch (IOException ex) {

        }
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        //Home
        if (buttonPressed == homeFrame.signInButton) {
            sendMessage(String.format("sign in\n%s\n%s", homeFrame.usernameField.getText(),
                    homeFrame.passwordField.getText()));
            String signInResponse = receiveMessage();
            if (signInResponse.equals("incorrect username or password")) {
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (signInResponse.equals("Success")) {
                currentUsername = homeFrame.usernameField.getText();
                showProfileFrame(currentUsername, false);
                homeFrame.dispose();
            }
        }
        if (buttonPressed == homeFrame.signUpButton) {
            showSignUpFrame();
            homeFrame.dispose();
        }

        //Sign up
        if (buttonPressed == signUpFrame.signUpButton) {
            sendMessage(String.format("sign up\n%s\n%s\n%s\n%s", signUpFrame.usernameField.getText(),
                    signUpFrame.passwordField,
                    signUpFrame.nameField.getText(),
                    signUpFrame.emailField.getText()));
            String signUpResponse = receiveMessage();
            if (signUpResponse.equals("Username already taken")) {
                JOptionPane.showMessageDialog(null, "Username Taken",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (signUpResponse.equals("Success")) {
                showProfileFrame(currentUsername, false);
                signUpFrame.dispose();
            }
        }
        if (buttonPressed == signUpFrame.backButton) {
            showHomeFrame();
            signUpFrame.dispose();
        }

        //Profile
        if (buttonPressed == profileFrame.editProfileButton) {
            showEditProfileFrame();
            profileFrame.dispose();
        }
        if (buttonPressed == profileFrame.viewFriendsButton) {
            showFriendsListFrame();
            profileFrame.dispose();
        }
        if (buttonPressed == profileFrame.addFriendButton) {
            showSendFriendRequestFrame();
            profileFrame.dispose();
        }
        if (buttonPressed == profileFrame.viewRequestsButton) {
            showFriendRequestsFrame();
            profileFrame.dispose();
        }
        if (buttonPressed == profileFrame.signOutButton) {
            showHomeFrame();
            profileFrame.dispose();
        }

        //Edit profile
        if (buttonPressed == editProfileFrame.updateProfileButton) {
            sendMessage(String.format("change profile\n%s\n%s\n%s\n%s\n%s\n%s\n%s",
                    editProfileFrame.nameField.getText(),
                    editProfileFrame.usernameField.getText(),
                    editProfileFrame.emailField.getText(),
                    editProfileFrame.passwordField,
                    editProfileFrame.locationField.getText(),
                    editProfileFrame.bioField.getText(),
                    editProfileFrame.interestsField.getText()));
            String signUpResponse = receiveMessage();
            if (signUpResponse.equals("Error")) {
                //Error Message
            } else if (signUpResponse.equals("Success")) {

            }
        }
        if (buttonPressed == editProfileFrame.deleteAccountButton) {
            sendMessage("delete account");
            String deleteAccountResponse = receiveMessage();
            if (deleteAccountResponse.equals("Error")) {
                //Error Message
            } else if (deleteAccountResponse.equals("Success")) {
                showHomeFrame();
                editProfileFrame.dispose();
            }
        }
        if (buttonPressed == editProfileFrame.backButton) {
            showProfileFrame(currentUsername, false);
            editProfileFrame.dispose();
        }

        //Friends list
        if (buttonPressed == friendsListFrame.backButton) {
            showProfileFrame(currentUsername, false);
            friendsListFrame.dispose();
        }

        //Manage friend request
        if (buttonPressed == manageFriendRequestsFrame.backButton) {
            showProfileFrame(currentUsername, false);
            manageFriendRequestsFrame.dispose();
        }

        //Send friend request
        if (buttonPressed == sendFriendRequestFrame.backButton) {
            showProfileFrame(currentUsername, false);
            sendFriendRequestFrame.dispose();
        }
        if (buttonPressed == sendFriendRequestFrame.sendRequestButton) {

        }

        //Restricted profile page
        if (buttonPressed == profileFrameRestricted.backButton) {
            showProfileFrame(currentUsername, false);
            profileFrameRestricted.dispose();
        }
        if (buttonPressed == profileFrameRestricted.viewFriendsButton) {
            showFriendsListFrame();
            profileFrameRestricted.dispose();
        }

    }

    private void showHomeFrame() {
        homeFrame = new gui.HomeFrame();
        homeFrame.signInButton.addActionListener(this);
        homeFrame.signUpButton.addActionListener(this);
    }

    private void showSignUpFrame() {
        signUpFrame = new gui.SignUpFrame();
        signUpFrame.signUpButton.addActionListener(this);
        signUpFrame.backButton.addActionListener(this);
    }

    private void showProfileFrame(String username, boolean isRestricted) {
        sendMessage(String.format("Information for user\n%s", username));
        String profilePageInfo = receiveMessage();
        if (profilePageInfo.equals("User does not exist")) {
            //Error message
        }
        if (!isRestricted) {
            profileFrame = new gui.ProfileFrame();
            profileFrame.editProfileButton.addActionListener(this);
            profileFrame.viewFriendsButton.addActionListener(this);
            profileFrame.addFriendButton.addActionListener(this);
            profileFrame.viewRequestsButton.addActionListener(this);
            profileFrame.signOutButton.addActionListener(this);
        } else {
            profileFrameRestricted = new gui.ProfileFrameRestricted();
            profileFrameRestricted.backButton.addActionListener(this);
            profileFrameRestricted.viewFriendsButton.addActionListener(this);
        }
    }

    private void showEditProfileFrame() {
        editProfileFrame = new gui.EditProfileFrame();
        editProfileFrame.updateProfileButton.addActionListener(this);
        editProfileFrame.deleteAccountButton.addActionListener(this);
        editProfileFrame.backButton.addActionListener(this);
    }

    private void showFriendsListFrame() {
        friendsListFrame = new gui.FriendsListFrame();
        friendsListFrame.backButton.addActionListener(this);
    }

    private void showFriendRequestsFrame() {
        manageFriendRequestsFrame = new gui.ManageFriendRequestsFrame();
        manageFriendRequestsFrame.backButton.addActionListener(this);
    }

    private void showSendFriendRequestFrame() {
        sendFriendRequestFrame = new gui.SendFriendRequestFrame();
        sendFriendRequestFrame.backButton.addActionListener(this);
        sendFriendRequestFrame.sendRequestButton.addActionListener(this);
    }

    public void run() {

        signUpFrame.dispose();
        profileFrame.dispose();
        editProfileFrame.dispose();
        friendsListFrame.dispose();
        manageFriendRequestsFrame.dispose();
        sendFriendRequestFrame.dispose();
        profileFrameRestricted.dispose();

        signUpFrame.signUpButton.addActionListener(this);
        signUpFrame.backButton.addActionListener(this);

        homeFrame.signInButton.addActionListener(this);
        homeFrame.signUpButton.addActionListener(this);

        profileFrame.editProfileButton.addActionListener(this);
        profileFrame.viewFriendsButton.addActionListener(this);
        profileFrame.addFriendButton.addActionListener(this);
        profileFrame.viewRequestsButton.addActionListener(this);
        profileFrame.signOutButton.addActionListener(this);

        editProfileFrame.updateProfileButton.addActionListener(this);
        editProfileFrame.deleteAccountButton.addActionListener(this);
        editProfileFrame.backButton.addActionListener(this);

        friendsListFrame.backButton.addActionListener(this);

        manageFriendRequestsFrame.backButton.addActionListener(this);

        sendFriendRequestFrame.backButton.addActionListener(this);
        sendFriendRequestFrame.sendRequestButton.addActionListener(this);

        profileFrameRestricted.backButton.addActionListener(this);
        profileFrameRestricted.viewFriendsButton.addActionListener(this);

    }

}
