import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Client extends JComponent implements Runnable {

    private static int portNum;

    JTextField logInUserNameStrField;
    JTextField logInPasswordStrField;
    JButton signInButton;
    JButton signUpButton;

    JTextField signUpNameStrField;
    JTextField signUpUserNameStrField;
    JTextField signUpPasswordStrField;
    JButton registerButton;

    Client clientGUI;

    PrintWriter writer;
    BufferedReader reader;

    // Constructor for Client, needs port number
    public Client(int portNum) throws IOException {
        this.portNum = portNum;

        Socket socket = new Socket("localHost", portNum);

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    // Temporary GUI for the sign up screen
    private void signUpScreen() {
        JFrame frame = new JFrame("Client");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(clientGUI, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        signUpUserNameStrField = new JTextField(10);
        signUpPasswordStrField = new JTextField(10);
        signUpNameStrField = new JTextField(10);
        registerButton = new JButton("Register");

        JPanel panel = new JPanel();
        panel.add(signUpUserNameStrField);
        panel.add(signUpPasswordStrField);
        panel.add(signUpNameStrField);
        panel.add(registerButton);
        content.add(panel, BorderLayout.NORTH);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writer.write(String.format("%s, %s, %s", signUpUserNameStrField.getText(),
                        signUpPasswordStrField.getText(), signUpNameStrField.getText()));
                writer.println();
                writer.flush();
            }
        });
    }

    // Temporary GUI for sign in screen
    private void signInScreen() {
        JFrame frame = new JFrame("Client");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(clientGUI, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        logInUserNameStrField = new JTextField(20);
        logInPasswordStrField = new JTextField(20);
        signInButton = new JButton("Sign-in");
        signUpButton = new JButton("Sign-up");

        JPanel panel = new JPanel();
        panel.add(logInUserNameStrField);
        panel.add(logInPasswordStrField);
        panel.add(signInButton);
        panel.add(signUpButton);
        content.add(panel, BorderLayout.NORTH);

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writer.write(String.format("%s, %s", logInUserNameStrField.getText(), logInPasswordStrField.getText()));
                writer.println();
                writer.flush();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUpScreen();
            }
        });
    }

    public void run() {
        try {
            this.clientGUI = new Client(this.portNum);

            // Keeps on asking for sign in/ sign up until a valid sign in/sign up is confirmed by server
            String validSignIn = "";
            while (!validSignIn.contains("success")) {
                signInScreen();
                validSignIn = reader.readLine();
            }

            // Main GUI
            boolean accessingProfile = true;
            while (accessingProfile) {
                // Put main GUI
            }

        } catch (IOException e) {

        }
    }

}
