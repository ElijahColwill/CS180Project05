package testGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TestFrame extends JComponent {

    public static JTextField logInUserNameStrField;
    public static JTextField logInPasswordStrField;
    public static JButton signInButton;
    public static JButton signUpButton;

    public static void signInScreen() {

        JFrame frame = new JFrame("sign in");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

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
        content.add(panel, BorderLayout.CENTER);
    }

    public static void signUpScreen() {
        JTextField signUpNameStrField;
        JTextField signUpUserNameStrField;
        JTextField signUpPasswordStrField;
        JButton registerButton;

        JFrame frame = new JFrame("sign up");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

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
        content.add(panel, BorderLayout.CENTER);

        registerButton.addActionListener(e -> {

        });
    }

    public static void profilePage () {
        JFrame frame = new JFrame("Profile");

        Container content = frame.getContentPane();
        content.setLayout(new BorderLayout());

        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        JButton button = new JButton("Button");

        JPanel panel = new JPanel();
        panel.add(button);
        content.add(panel, BorderLayout.NORTH);
    }

}
