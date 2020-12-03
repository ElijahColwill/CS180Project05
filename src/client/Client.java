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
    String temp;

    gui.HomeFrame homeFrame = new gui.HomeFrame();
    gui.SignUpFrame signUpFrame = new gui.SignUpFrame();

    gui.FriendsListFrame friendsListFrame = new gui.FriendsListFrame(new String[1], new String[1]);
    gui.ViewRequestsFrame viewRequestsFrame = new gui.ViewRequestsFrame();
    gui.IncomingFriendRequestsFrame incomingFriendRequestsFrame = new gui.IncomingFriendRequestsFrame("", "");
    gui.OutgoingFriendRequestsFrame outgoingFriendRequestsFrame = new gui.OutgoingFriendRequestsFrame("", "");
    gui.SendFriendRequestFrame sendFriendRequestFrame = new gui.SendFriendRequestFrame(new String[1]);

    gui.ProfileFrame profileFrame = new gui.ProfileFrame("", "", "", "", "");
    gui.EditProfileFrame editProfileFrame = new gui.EditProfileFrame("", "", "", "", "", "");

    gui.ProfileFrameRestricted profileFrameRestricted = new gui.ProfileFrameRestricted("", "", "", "","");

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
            showEditProfileFrame(currentUsername);
            profileFrame.dispose();
        }
        if (buttonPressed == profileFrame.viewFriendsButton) {
            showFriendsListFrame(currentUsername);
            profileFrame.dispose();
        }
        if (buttonPressed == profileFrame.addFriendButton) {
            showSendFriendRequestFrame(currentUsername);
            profileFrame.dispose();
        }
        if (buttonPressed == profileFrame.viewRequestsButton) {
            showViewRequestsFrame();
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
        if (buttonPressed == friendsListFrame.viewProfileButton) {
            showProfileFrame(currentUsername, true);
            friendsListFrame.dispose();
        }

        //Incoming requests
        if (buttonPressed == incomingFriendRequestsFrame.backButton) {
            showViewRequestsFrame();
            incomingFriendRequestsFrame.dispose();
        }
        if (buttonPressed == incomingFriendRequestsFrame.acceptRequestButton) {
            sendMessage(String.format("Accept request\n%s\n%s", currentUsername, temp));
            String response = receiveMessage();
            if (response.equals("Success")) {
                incomingFriendRequestsFrame.dispose();
                showIncomingFriendRequestFrame(currentUsername);
            } else {
                //Error message
            }
        }
        if (buttonPressed == incomingFriendRequestsFrame.denyRequestButton) {
            sendMessage(String.format("Deny request\n%s\n%s", currentUsername, temp));
            String response = receiveMessage();
            if (response.equals("Success")) {
                incomingFriendRequestsFrame.dispose();
                showIncomingFriendRequestFrame(currentUsername);
            } else {
                //Error message
            }
        }

        //Outgoing requests
        if (buttonPressed == outgoingFriendRequestsFrame.backButton) {
            showViewRequestsFrame();
            outgoingFriendRequestsFrame.dispose();
        }
        if (buttonPressed == outgoingFriendRequestsFrame.nextButton) {
            outgoingFriendRequestsFrame.dispose();
            showOutgoingFriendRequestFrame(currentUsername);
        }
        if (buttonPressed == outgoingFriendRequestsFrame.cancelRequestButton) {
            sendMessage(String.format("Cancel request\n%s\n%s", currentUsername, temp));
            outgoingFriendRequestsFrame.dispose();
            showOutgoingFriendRequestFrame(currentUsername);
        }

        //Send friend request
        if (buttonPressed == sendFriendRequestFrame.backButton) {
            showProfileFrame(currentUsername, false);
            sendFriendRequestFrame.dispose();
        }
        if (buttonPressed == sendFriendRequestFrame.sendRequestButton) {
            sendMessage(String.format("Send request\n%s\n%s", currentUsername,
                    String.valueOf(sendFriendRequestFrame.userComboBox.getSelectedIndex())));
            System.out.println(String.valueOf(sendFriendRequestFrame.userComboBox.getSelectedIndex()));
        }

        //Restricted profile page
        if (buttonPressed == profileFrameRestricted.backButton) {
            showProfileFrame(currentUsername, false);
            profileFrameRestricted.dispose();
        }
        if (buttonPressed == profileFrameRestricted.viewFriendsButton) {
            showFriendsListFrame(currentUsername);
            profileFrameRestricted.dispose();
        }

        //View Requests
        if (buttonPressed == viewRequestsFrame.incomingRequestsButton) {
            showIncomingFriendRequestFrame(currentUsername);
            profileFrameRestricted.dispose();
        }
        if (buttonPressed == viewRequestsFrame.outgoingRequestsButton) {
            showOutgoingFriendRequestFrame(currentUsername);
            profileFrameRestricted.dispose();
        }
        if (buttonPressed == viewRequestsFrame.backButton) {
            showProfileFrame(currentUsername, false);
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
        String userExists = receiveMessage();
        if (userExists.equals("User does not exist")) {
            //Error message
        }
        String userName= receiveMessage();
        String userUsername = receiveMessage();
        String userEmail = receiveMessage();
        String userLocation = receiveMessage();
        String userBio = receiveMessage();
        String userInterests = receiveMessage();
        if (!isRestricted) {
            profileFrame = new gui.ProfileFrame(userName, userUsername, userLocation, userBio, userInterests);
            profileFrame.editProfileButton.addActionListener(this);
            profileFrame.viewFriendsButton.addActionListener(this);
            profileFrame.addFriendButton.addActionListener(this);
            profileFrame.viewRequestsButton.addActionListener(this);
            profileFrame.signOutButton.addActionListener(this);
        } else {
            profileFrameRestricted = new gui.ProfileFrameRestricted(userName, userUsername, userLocation, userBio, userInterests);
            profileFrameRestricted.backButton.addActionListener(this);
            profileFrameRestricted.viewFriendsButton.addActionListener(this);
        }
    }

    private void showEditProfileFrame(String username) {
        sendMessage(String.format("Information for user\n%s", username));
        String userExists = receiveMessage();
        if (userExists.equals("User does not exist")) {
            //Error message
        }
        String userName= receiveMessage();
        String userUsername = receiveMessage();
        String userEmail = receiveMessage();
        String userLocation = receiveMessage();
        String userBio = receiveMessage();
        String userInterests = receiveMessage();
        editProfileFrame = new gui.EditProfileFrame(userName, userUsername, userEmail, userLocation, userBio, userInterests);
        editProfileFrame.updateProfileButton.addActionListener(this);
        editProfileFrame.deleteAccountButton.addActionListener(this);
        editProfileFrame.backButton.addActionListener(this);
    }

    private void showFriendsListFrame(String username) {
        sendMessage(String.format("Friends for user\n%s", username));
        String[] friendsListFullName = receiveMessage().split(",");
        String[] friendsListUsername = receiveMessage().split(",");
        friendsListFrame = new gui.FriendsListFrame(friendsListFullName, friendsListUsername);
        friendsListFrame.backButton.addActionListener(this);
        friendsListFrame.viewProfileButton.addActionListener(this);
    }

    private void showIncomingFriendRequestFrame(String username) {
        sendMessage(String.format("Incoming friend request for user\n%s", username));
        String incomingUserExists = receiveMessage();
        String incomingFullName = receiveMessage();
        String incomingUsername = receiveMessage();
        if (incomingUserExists.equals("User does not exist")) {
            //Error message
        }
        temp = incomingUsername;
        incomingFriendRequestsFrame = new gui.IncomingFriendRequestsFrame(incomingFullName, incomingUsername);
        incomingFriendRequestsFrame.backButton.addActionListener(this);
        incomingFriendRequestsFrame.acceptRequestButton.addActionListener(this);
        incomingFriendRequestsFrame.denyRequestButton.addActionListener(this);
    }

    private void showOutgoingFriendRequestFrame(String username) {
        sendMessage(String.format("Outgoing friend request for user\n%s", username));
        String outgoingUserExists = receiveMessage();
        String outgoingFullName = receiveMessage();
        String outgoingUsername = receiveMessage();
        if (outgoingUserExists.equals("User does not exist")) {
            //Error message
        }
        temp = outgoingUsername;
        outgoingFriendRequestsFrame = new gui.OutgoingFriendRequestsFrame(outgoingFullName, outgoingUsername);
        outgoingFriendRequestsFrame.backButton.addActionListener(this);
        outgoingFriendRequestsFrame.nextButton.addActionListener(this);
        outgoingFriendRequestsFrame.cancelRequestButton.addActionListener(this);
    }

    private void showSendFriendRequestFrame(String username) {
        sendMessage(String.format("Get all users\n%s", username));
        String[] allUsers = receiveMessage().split(",");
        sendFriendRequestFrame = new gui.SendFriendRequestFrame(allUsers);
        sendFriendRequestFrame.backButton.addActionListener(this);
        sendFriendRequestFrame.sendRequestButton.addActionListener(this);
    }

    private void showViewRequestsFrame() {
        viewRequestsFrame = new gui.ViewRequestsFrame();
        viewRequestsFrame.backButton.addActionListener(this);
        viewRequestsFrame.incomingRequestsButton.addActionListener(this);
        viewRequestsFrame.outgoingRequestsButton.addActionListener(this);
    }

    public void run() {

        signUpFrame.dispose();
        profileFrame.dispose();
        editProfileFrame.dispose();
        friendsListFrame.dispose();
        incomingFriendRequestsFrame.dispose();
        outgoingFriendRequestsFrame.dispose();
        sendFriendRequestFrame.dispose();
        profileFrameRestricted.dispose();
        viewRequestsFrame.dispose();

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
        friendsListFrame.viewProfileButton.addActionListener(this);

        incomingFriendRequestsFrame.backButton.addActionListener(this);
        incomingFriendRequestsFrame.acceptRequestButton.addActionListener(this);
        incomingFriendRequestsFrame.denyRequestButton.addActionListener(this);

        outgoingFriendRequestsFrame.backButton.addActionListener(this);
        outgoingFriendRequestsFrame.nextButton.addActionListener(this);
        outgoingFriendRequestsFrame.cancelRequestButton.addActionListener(this);

        sendFriendRequestFrame.backButton.addActionListener(this);
        sendFriendRequestFrame.sendRequestButton.addActionListener(this);

        profileFrameRestricted.backButton.addActionListener(this);
        profileFrameRestricted.viewFriendsButton.addActionListener(this);

        viewRequestsFrame.backButton.addActionListener(this);
        viewRequestsFrame.backButton.addActionListener(this);
        viewRequestsFrame.backButton.addActionListener(this);

    }

}
