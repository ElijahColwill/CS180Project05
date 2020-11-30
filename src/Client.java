import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

import gui.*;

public class Client extends JComponent implements Runnable, ActionListener {

    private static int portNum;

    PrintWriter writer;
    BufferedReader reader;

    gui.HomeFrame homeFrame = new gui.HomeFrame();
    gui.MainFrame mainFrame = new gui.MainFrame();
    gui.SignUpFrame signUpFrame = new gui.SignUpFrame();
    gui.AddFriendFrame addFriendFrame = new gui.AddFriendFrame();
    gui.FriendsListFrame friendsListFrame = new gui.FriendsListFrame();
    gui.ProfileFrame profileFrame = new gui.ProfileFrame();

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

        if (buttonPressed == homeFrame.enterButton) {
            sendMessage(String.format("sign in\n%s\n%s", homeFrame.username.getText(), homeFrame.password.getText()));
            String signInResponse = receiveMessage();
            if (signInResponse.equals("incorrect username or password")) {
                JOptionPane.showMessageDialog(null, "Incorrect Username or Password",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (signInResponse.equals("success")) {
                mainFrame.setVisible(true);
                homeFrame.dispose();
            }
        }

        if (buttonPressed == homeFrame.signUpButton) {
            signUpFrame.setVisible(true);
            homeFrame.dispose();
        }

        if (buttonPressed == signUpFrame.signUpButton) {
            sendMessage(String.format("sign up\n%s\n%s\n%s", signUpFrame.usernameField.getText(),
                    signUpFrame.passwordField.getText(),
                    signUpFrame.lastNameField.getText() + ", " + signUpFrame.firstNameField.getText()));
            String signUpResponse = receiveMessage();
            if (signUpResponse.equals("Username already taken!")) {
                JOptionPane.showMessageDialog(null, "Username Taken",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (signUpResponse.equals("Success")) {
                mainFrame.setVisible(true);
                signUpFrame.dispose();
            }
        }

        if (buttonPressed == signUpFrame.backButton) {
            homeFrame.setVisible(true);
            signUpFrame.dispose();
        }

        if (buttonPressed == mainFrame.BACK_BUTTON) {
            homeFrame.setVisible(true);
            mainFrame.dispose();
        }

        if (buttonPressed == mainFrame.profileButton) {
            profileFrame.setVisible(true);
            mainFrame.dispose();
        }

        if (buttonPressed == profileFrame.updateProfileButton) {
            sendMessage(String.format("change profile\n%s\n%s\n%s\n%s", profileFrame.emailField.getText(),
                    profileFrame.aboutMeField.getText(),
                    profileFrame.lastNameField.getText(), profileFrame.firstNameField.getText()));
            String signUpResponse = receiveMessage();
            if (signUpResponse.equals("Error")) {
                JOptionPane.showMessageDialog(null, "Error",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else if (signUpResponse.equals("Success")) {
                mainFrame.setVisible(true);
                signUpFrame.dispose();
            }
        }

        if (buttonPressed == profileFrame.backButton) {
            mainFrame.setVisible(true);
            profileFrame.dispose();
        }

    }

    public void run() {

        homeFrame.setVisible(true);

        homeFrame.enterButton.addActionListener(this);
        homeFrame.signUpButton.addActionListener(this);

        signUpFrame.signUpButton.addActionListener(this);
        signUpFrame.backButton.addActionListener(this);

        mainFrame.profileButton.addActionListener(this);
        mainFrame.BACK_BUTTON.addActionListener(this);

        profileFrame.backButton.addActionListener(this);
        profileFrame.updateProfileButton.addActionListener(this);
    }

}
