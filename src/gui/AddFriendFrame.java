package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * CS180 - Project 5
 * AddFriendFrame.java
 *
 * Add friend frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 20, 2020
 */
public final class AddFriendFrame extends JFrame implements ActionListener {
    private final JComboBox<String> userList = new JComboBox<String>();

    public AddFriendFrame() {
        super("Social | Add Friend");

    }

    public void getUserList() {
        // TODO: ADD LOGIC FOR GETTING USERS
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();
    }
}
