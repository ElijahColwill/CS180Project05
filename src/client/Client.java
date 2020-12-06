package client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
/**
 * A Client class that handles the User connecting to the network and interacting
 * with the Server.
 *
 * <p>Purdue University -- CS18000 -- Fall 2020 -- Project 05</p>
 *
 * @author Henry Peng
 * @version December 02, 2020
 */
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

    gui.ErrorFrame errorFrame = new gui.ErrorFrame("");
    gui.SuccessFrame successFrame = new gui.SuccessFrame("");

    /**
     * Constructor that creates a Client class with the port number.
     * Testing:
     * Verify that portNun, reader, and writer fields are set correctly.
     * @param portNum int Port to connect to Server with.
     */
    public Client(int portNum) throws IOException {
        this.portNum = portNum;

        Socket socket = new Socket("localHost", portNum);

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    /**
     * Main method that creates and runs an instance of Client with port 2400.
     * Testing:
     * Verify that instance of Client class is created when class initialized with correct information.
     * @param args String[] Default parameter for main method.
     */
    public static void main(String[] args) {
        try {
            SwingUtilities.invokeLater(new Client(2400));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that send information to the server.
     * Testing:
     * Verify that when testing overall project, server receives message sent when method is called.
     * Verify that string parameter sends the correct text.
     * @param message String Message to be sent to Server.
     */
    private void sendMessage(String message) {
        writer.write(message);
        writer.println();
        writer.flush();

        //System.out.println("Sent: " + message);
    }

    /**
     * Method that receives information from the server.
     * Testing:
     * Verify that when testing overall project, Server sends correct message and Client receives that same
     * message sent without a significant delay.
     * Verify that returned message equals the message sent by Server.
     * @return String message received from server.
     */
    private String receiveMessage() {
        try {
            String message = reader.readLine();
            //System.out.println("Recieved: " + message);
            return message;
        } catch (IOException ex) {

        }
        return "";
    }

    /**
     * Method that contains action Listeners and information for buttons pressed by User.
     * Sends message to server based on button pressed so that Server can complete interaction.
     * Testing:
     * Verify that method connects to Server and GUI and is triggered when action is performed.
     * Verify that homeFrame.signInButton sends correct message and initializes/disposes correct Frames.
     * Verify that homeFrame.signUpButton sends correct message and initializes/disposes correct Frames.
     * Verify that signUpFrame.signUpButton sends correct message and initializes/disposes correct Frames.
     * Verify that signUpFrame.backButton sends correct message and initializes/disposes correct Frames.
     * Verify that profileFrame.editProfileButton sends correct message and initializes/disposes correct Frames.
     * Verify that profileFrame.viewFriendsButton sends correct message and initializes/disposes correct Frames.
     * Verify that profileFrame.addFriendButton sends correct message and initializes/disposes correct Frames.
     * Verify that profileFrame.viewRequestsButton sends correct message and initializes/disposes correct Frames.
     * Verify that profileFrame.signOutButton sends correct message and initializes/disposes correct Frames.
     * Verify that editProfileFrame.updateProfileButton sends correct message and initializes/disposes correct Frames.
     * Verify that editProfileFrame.deleteAccountButton sends correct message and initializes/disposes correct Frames.
     * Verify that editProfileFrame.backButton sends correct message and initializes/disposes correct Frames.
     * Verify that friendsListFrame.backButton sends correct message and initializes/disposes correct Frames.
     * Verify that friendsListFrame.viewProfileButton sends correct message and initializes/disposes correct Frames.
     * Verify that incomingFriendRequestsFrame.backButton sends correct message and initializes/disposes correct Frames.
     * Verify that incomingFriendRequestsFrame.acceptRequestButton sends correct message and initializes/disposes correct Frames.
     * Verify that incomingFriendRequestsFrame.denyRequestButton sends correct message and initializes/disposes correct Frames.
     * Verify that outgoingFriendRequestsFrame.backButton sends correct message and initializes/disposes correct Frames.
     * Verify that outgoingFriendRequestsFrame.nextButton sends correct message and initializes/disposes correct Frames.
     * Verify that outgoingFriendRequestsFrame.cancelRequestButton sends correct message and initializes/disposes correct Frames.
     * Verify that sendFriendRequestFrame.backButton sends correct message and initializes/disposes correct Frames.
     * Verify that sendFriendRequestFrame.sendRequestButton sends correct message and initializes/disposes correct Frames.
     * Verify that profileFrameRestricted.backButton sends correct message and initializes/disposes correct Frames.
     * Verify that profileFrameRestricted.viewFriendsButton sends correct message and initializes/disposes correct Frames.
     * Verify that viewRequestsFrame.incomingRequestsButton sends correct message and initializes/disposes correct Frames.
     * Verify that viewRequestsFrame.outgoingRequestsButton sends correct message and initializes/disposes correct Frames.
     * Verify that viewRequestsFrame.backButton sends correct message and initializes/disposes correct Frames.
     * @param e ActionEvent from button pressed/drop down menu/etc.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        //Home
        if (buttonPressed == homeFrame.signInButton) {
            sendMessage(String.format("sign in\n%s\n%s", homeFrame.usernameField.getText(),
                    String.valueOf(homeFrame.passwordField.getPassword())));
            String signInResponse = receiveMessage();
            if (signInResponse.equals("incorrect username or password")) {
                showErrorFrame("Username or Password is Incorrect");
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
                    String.valueOf(signUpFrame.passwordField.getPassword()),
                    signUpFrame.nameField.getText(),
                    signUpFrame.emailField.getText()));
            String signUpResponse = receiveMessage();
            if (signUpResponse.equals("Username already taken")) {
                showErrorFrame("Username Taken");
            } else if (signUpResponse.equals("Success")) {
                currentUsername = signUpFrame.usernameField.getText();
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
                showErrorFrame("Error");
            } else if (signUpResponse.equals("Success")) {

            }
        }
        if (buttonPressed == editProfileFrame.deleteAccountButton) {
            sendMessage("delete account");
            String deleteAccountResponse = receiveMessage();
            if (deleteAccountResponse.equals("Error")) {
                showErrorFrame("Error");
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
                showErrorFrame("Error");
            }
        }
        if (buttonPressed == incomingFriendRequestsFrame.denyRequestButton) {
            sendMessage(String.format("Deny request\n%s\n%s", currentUsername, temp));
            String response = receiveMessage();
            if (response.equals("Success")) {
                incomingFriendRequestsFrame.dispose();
                showIncomingFriendRequestFrame(currentUsername);
            } else {
                showErrorFrame("Error");
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
            //System.out.println(String.valueOf(sendFriendRequestFrame.userComboBox.getSelectedIndex()));
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
            viewRequestsFrame.dispose();
        }
        if (buttonPressed == viewRequestsFrame.outgoingRequestsButton) {
            showOutgoingFriendRequestFrame(currentUsername);
            viewRequestsFrame.dispose();
        }
        if (buttonPressed == viewRequestsFrame.backButton) {
            showProfileFrame(currentUsername, false);
            viewRequestsFrame.dispose();
        }

        //Success Frame
        if (buttonPressed == successFrame.closeButton) {
            successFrame.dispose();
        }

        //Error Frame
        if (buttonPressed == errorFrame.closeButton) {
            errorFrame.dispose();
        }
    }

    /**
     * Method that displays homeFrame.
     * Testing:
     * Verify that homeFrame is displayed properly.
     */
    private void showHomeFrame() {
        homeFrame.setVisible(true);
    }

    /**
     * Method that sets up and displays signUpFrame with actionListeners.
     * Testing:
     * Verify that signUpFrame is initialized with correct actionListeners.
     */
    private void showSignUpFrame() {
        signUpFrame = new gui.SignUpFrame();
        signUpFrame.signUpButton.addActionListener(this);
        signUpFrame.backButton.addActionListener(this);
        signUpFrame.setVisible(true);
    }

    /**
     * Method that sets up and displays profileFrame with actionListeners, depending on if user can
     * edit profile or not.
     * Testing:
     * Verify that profileFrame is initialized with correct actionListeners.
     * Verify that username is passed to Server.
     * Verify that client allows/denys editing based on isRestricted.
     * @param username User name of user's profile being displayed.
     * @param isRestricted boolean to determine if user can edit profile or not.
     */
    private void showProfileFrame(String username, boolean isRestricted) {
        sendMessage(String.format("Information for user\n%s", username));
        String userName = receiveMessage();
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
            profileFrame.setVisible(true);
        } else {
            profileFrameRestricted = new gui.ProfileFrameRestricted(userName, userUsername, userLocation, userBio, userInterests);
            profileFrameRestricted.backButton.addActionListener(this);
            profileFrameRestricted.viewFriendsButton.addActionListener(this);
            profileFrameRestricted.setVisible(true);
        }
    }

    /**
     * Method that sets up and displays editProfileFrame with actionListeners.
     * Testing:
     * Verify that editProfileFrame is initialized with correct actionListeners.
     * Verify that correct user is being edited.
     * @param username String name of user being edited.
     */
    private void showEditProfileFrame(String username) {
        sendMessage(String.format("Information for user\n%s", username));
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
        editProfileFrame.setVisible(true);
    }

    /**
     * Method that sets up and displays friendsListFrame with actionListeners.
     * Testing:
     * Verify that friendsListFrame is initialized with correct actionListeners.
     * Verify that the correct user is being displayed.
     * @param username String username of user having friends list displayed.
     */
    private void showFriendsListFrame(String username) {
        sendMessage(String.format("Friends for user\n%s", username));
        String[] friendsListFullName = receiveMessage().split(",");
        String[] friendsListUsername = receiveMessage().split(",");
        friendsListFrame = new gui.FriendsListFrame(friendsListFullName, friendsListUsername);
        friendsListFrame.backButton.addActionListener(this);
        friendsListFrame.viewProfileButton.addActionListener(this);
        friendsListFrame.setVisible(true);
    }

    /**
     * Method that sets up and displays incomingFriendRequestFrame with actionListeners.
     * Testing:
     * Verify that incomingFriendRequestFrame is initialized with correct actionListeners.
     * Verify that the correct user is being displayed.
     * @param username String username of user having friend requests displayed.
     */
    private void showIncomingFriendRequestFrame(String username) {
        sendMessage(String.format("Incoming friend request for user\n%s", username));
        String incomingUserExists = receiveMessage();
        String incomingFullName = receiveMessage();
        String incomingUsername = receiveMessage();
        if (incomingUserExists.equals("User does not exist")) {
            showErrorFrame("User does not exist");
        }
        temp = incomingUsername;
        incomingFriendRequestsFrame = new gui.IncomingFriendRequestsFrame(incomingFullName, incomingUsername);
        incomingFriendRequestsFrame.backButton.addActionListener(this);
        incomingFriendRequestsFrame.acceptRequestButton.addActionListener(this);
        incomingFriendRequestsFrame.denyRequestButton.addActionListener(this);
        incomingFriendRequestsFrame.setVisible(true);
    }

    /**
     * Method that sets up and displays outgoingFriendRequestFrame with actionListeners.
     * Testing:
     * Verify that outgoingFriendRequestFrame is initialized with correct actionListeners.
     * Verify that the correct user is being displayed.
     * @param username String username of user having friend requests displayed.
     */
    private void showOutgoingFriendRequestFrame(String username) {
        sendMessage(String.format("Outgoing friend request for user\n%s", username));
        String outgoingUserExists = receiveMessage();
        String outgoingFullName = receiveMessage();
        String outgoingUsername = receiveMessage();
        if (outgoingUserExists.equals("User does not exist")) {
            showErrorFrame("User does not exist");
        }
        temp = outgoingUsername;
        outgoingFriendRequestsFrame = new gui.OutgoingFriendRequestsFrame(outgoingFullName, outgoingUsername);
        outgoingFriendRequestsFrame.backButton.addActionListener(this);
        outgoingFriendRequestsFrame.nextButton.addActionListener(this);
        outgoingFriendRequestsFrame.cancelRequestButton.addActionListener(this);
        outgoingFriendRequestsFrame.setVisible(true);
    }

    /**
     * Method that sets up and displays sendFriendRequestFrame with actionListeners.
     * Testing:
     * Verify that sendFriendRequestFrame is initialized with correct actionListeners.
     * Verify that the correct user if being called.
     * @param username String username of user sending friend request.
     */
    private void showSendFriendRequestFrame(String username) {
        sendMessage(String.format("Get all users\n%s", username));
        String[] allUsers = receiveMessage().split(",");
        sendFriendRequestFrame = new gui.SendFriendRequestFrame(allUsers);
        sendFriendRequestFrame.backButton.addActionListener(this);
        sendFriendRequestFrame.sendRequestButton.addActionListener(this);
        sendFriendRequestFrame.setVisible(true);
    }

    /**
     * Method that sets up and displays viewRequestsFrame with actionListeners.
     * Testing:
     * Verify that viewRequestsFrame is initialized with correct actionListeners.
     */
    private void showViewRequestsFrame() {
        viewRequestsFrame = new gui.ViewRequestsFrame();
        viewRequestsFrame.backButton.addActionListener(this);
        viewRequestsFrame.incomingRequestsButton.addActionListener(this);
        viewRequestsFrame.outgoingRequestsButton.addActionListener(this);
        viewRequestsFrame.setVisible(true);
    }

    private void showSuccessFrame(String message) {
        successFrame = new gui.SuccessFrame(message);
        successFrame.closeButton.addActionListener(this);
        successFrame.setVisible(true);
    }

    private void showErrorFrame(String message) {
        errorFrame = new gui.ErrorFrame(message);
        errorFrame.closeButton.addActionListener(this);
        errorFrame.setVisible(true);
    }

    /**
     * Method that runs instance of Client and sets up all necessary GUI components and actionListeners.
     * Testing:
     * Verify that when testing overall project for a variety of functions, the correct Frame is always called depending on user action.
     * Verify all actionListeners are added to correct buttons and are working.
     */
    public void run() {

        showHomeFrame();

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

        successFrame.closeButton.addActionListener(this);
        errorFrame.closeButton.addActionListener(this);

    }

}
