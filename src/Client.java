import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client extends JComponent implements Runnable {

    private static int portNum;

    JTextField userNameStrField;
    JTextField passwordStrField;
    JButton signInButton;
    JButton signUpButton;

    Client clientGUI;

    PrintWriter writer;
    BufferedReader reader;

    public Client(int portNum) throws IOException {
        this.portNum = portNum;

        Socket socket = new Socket("localHost", portNum);

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    private void signUpScreen() {
        JFrame frame = new JFrame("Client");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(clientGUI, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    private void signInScreen() {
        JFrame frame = new JFrame("Client");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add(clientGUI, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        userNameStrField = new JTextField(20);
        passwordStrField = new JTextField(20);
        signInButton = new JButton("Sign-in");
        signUpButton = new JButton("Sign-up");

        JPanel panel = new JPanel();
        panel.add(userNameStrField);
        panel.add(passwordStrField);
        panel.add(signInButton);
        panel.add(signUpButton);
        content.add(panel, BorderLayout.NORTH);
    }

    public void run() {
        try {
            this.clientGUI = new Client(this.portNum);
        } catch (IOException e) {

        }

        signInScreen();

        signInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writer.write(String.format("%s, %s", userNameStrField.getText(), passwordStrField.getText()));
                writer.println();
                writer.flush();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUpScreen();
            }
        });

        //writer.close();
        //reader.close();
    }

}
