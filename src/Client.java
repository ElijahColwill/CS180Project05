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

    gui.HomeFrame homeFrame = new gui.HomeFrame();
    gui.MainFrame mainFrame = new gui.MainFrame();

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        if (buttonPressed == homeFrame.enterButton) {
            mainFrame.setVisible(true);
            homeFrame.dispose();
        }

        if (buttonPressed == homeFrame.exitButton) {

        }

        if (buttonPressed == mainFrame.BACK_BUTTON) {
            homeFrame.setVisible(true);
            mainFrame.dispose();
        }

    }

    public void run() {

        homeFrame.setVisible(true);

        homeFrame.enterButton.addActionListener(this);
        mainFrame.BACK_BUTTON.addActionListener(this);
    }

}
