import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

import testGUI.*;

public class Client extends JComponent implements Runnable {

    private static int portNum;

    PrintWriter writer;
    BufferedReader reader;

    // Constructor for Client, needs port number
    public Client(int portNum) throws IOException {
        this.portNum = portNum;

        Socket socket = new Socket("localHost", portNum);

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
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

    public void run() {

        testGUI.TestFrame.signInScreen();

        testGUI.TestFrame.signUpButton.addActionListener(e -> {
            testGUI.TestFrame.signUpScreen();
        });

        testGUI.TestFrame.signInButton.addActionListener(e -> {
            sendMessage(String.format("%s, %s",
                    testGUI.TestFrame.logInUserNameStrField.getText(),
                    testGUI.TestFrame.logInPasswordStrField.getText()));
            if (receiveMessage().contains("success")) {
                testGUI.TestFrame.profilePage();
            }
        });

    }

}
