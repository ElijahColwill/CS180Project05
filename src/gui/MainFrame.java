package gui;

import assets.Constants;
import assets.utils.SwingUtils;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * CS180 - Project 5
 * MainFrame.java
 *
 * Main frame for the application.
 *
 * @author Henrik Berg, henrik@purdue.edu
 * @version November 20, 2020
 */
public final class MainFrame extends JFrame implements ActionListener {
    private final JPanel HEADER_PANEL;
    private final JPanel CONTENT_PANEL;
    private final JPanel EXTRA_PANEL;
    private final JPanel NET_WORTH_PANEL;
    private final JPanel EXTRA_BUTTON_PANEL;
    private final JPanel LEFT_PANEL;
    private final JPanel LEFT_BUTTON_PANEL;
    private final JPanel LEFT_INFORMATION_PANEL;
    private final JPanel RIGHT_PANEL;
    private final JPanel RIGHT_BUTTON_PANEL;
    private final JPanel RIGHT_INFORMATION_PANEL;
    private final JPanel NAVIGATION_PANEL;

    private final JLabel LOGO_LABEL;
    private final JLabel HEADER_LABEL;
    private final JLabel ACCOUNT_ID_LABEL;
    private final JLabel LEFT_LABEL;
    private final JLabel RIGHT_LABEL;

    private final JButton HELP_BUTTON;
    private final JButton BACK_BUTTON;

    public MainFrame() {
        super("Social | Main");

        HEADER_PANEL = new JPanel(new GridBagLayout());
        CONTENT_PANEL = new JPanel(new GridBagLayout());
        EXTRA_PANEL = new JPanel(new GridBagLayout());
        NET_WORTH_PANEL = new JPanel(new GridBagLayout());
        EXTRA_BUTTON_PANEL = new JPanel(new GridBagLayout());
        LEFT_PANEL = new JPanel(new GridBagLayout());
        LEFT_BUTTON_PANEL = new JPanel(new GridBagLayout());
        LEFT_INFORMATION_PANEL = new JPanel(new GridBagLayout());
        RIGHT_PANEL = new JPanel(new GridBagLayout());
        RIGHT_BUTTON_PANEL = new JPanel(new GridBagLayout());
        RIGHT_INFORMATION_PANEL = new JPanel(new GridBagLayout());
        NAVIGATION_PANEL = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        LOGO_LABEL = new JLabel();
        HEADER_LABEL = new JLabel("Social");
        ACCOUNT_ID_LABEL = new JLabel("Account ID: X");
        LEFT_LABEL = new JLabel("Left Panel");
        RIGHT_LABEL = new JLabel("Right Panel");

        HELP_BUTTON = new JButton("Help");
        BACK_BUTTON = new JButton("Back");

        this.setSize(1540, 830);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setResizable(false);

        HEADER_PANEL.setBackground(Constants.HEADER_BACKGROUND_COLOR);

        HEADER_PANEL.setBorder(Constants.HEADER_BORDER);
        NAVIGATION_PANEL.setBorder(Constants.NAVIGATION_BORDER);

        LOGO_LABEL.setIcon(Constants.LOGO);

        HEADER_LABEL.setFont(Constants.HEADER_FONT);
        ACCOUNT_ID_LABEL.setFont(Constants.MAIN_FONT);
        LEFT_LABEL.setFont(Constants.SUB_HEADER_FONT);
        RIGHT_LABEL.setFont(Constants.SUB_HEADER_FONT);
        HELP_BUTTON.setFont(Constants.MAIN_FONT);
        BACK_BUTTON.setFont(Constants.MAIN_FONT);

        HELP_BUTTON.addActionListener(this);
        BACK_BUTTON.addActionListener(this);

        SwingUtils.addComponent(HEADER_PANEL, LOGO_LABEL, 0, 0, 1, 1, GridBagConstraints.LINE_END);
        SwingUtils.addComponent(HEADER_PANEL, HEADER_LABEL, 1, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 2, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 3, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 4, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 5, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 6, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 7, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 8, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 9, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 10, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 11, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(HEADER_PANEL, new JLabel(" "), 12, 0, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(EXTRA_BUTTON_PANEL, ACCOUNT_ID_LABEL, 0, 0, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(EXTRA_PANEL, NET_WORTH_PANEL, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(EXTRA_PANEL, EXTRA_BUTTON_PANEL, 0, 1, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(LEFT_BUTTON_PANEL, LEFT_LABEL, 1, 0, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(LEFT_PANEL, LEFT_BUTTON_PANEL, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(LEFT_PANEL, LEFT_INFORMATION_PANEL, 0, 1, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(RIGHT_BUTTON_PANEL, RIGHT_LABEL, 1, 0, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(RIGHT_PANEL, RIGHT_BUTTON_PANEL, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(RIGHT_PANEL, RIGHT_INFORMATION_PANEL, 0, 1, 1, 1, GridBagConstraints.CENTER);

        SwingUtils.addComponent(CONTENT_PANEL, EXTRA_PANEL, 0, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(CONTENT_PANEL, LEFT_PANEL, 1, 0, 1, 1, GridBagConstraints.CENTER);
        SwingUtils.addComponent(CONTENT_PANEL, RIGHT_PANEL, 2, 0, 1, 1, GridBagConstraints.CENTER);

        NAVIGATION_PANEL.add(HELP_BUTTON);
        NAVIGATION_PANEL.add(BACK_BUTTON);

        this.add(HEADER_PANEL, BorderLayout.NORTH);
        this.add(CONTENT_PANEL, BorderLayout.CENTER);
        this.add(NAVIGATION_PANEL, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPressed = e.getSource();

        if(buttonPressed == BACK_BUTTON) {
            HomeFrame homeFrame = new HomeFrame();
            this.dispose();
        }
    }

}
