package com.mms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;

public class AboutUs {

    private JPanel contentPane;
    JFrame frame;

    public AboutUs() {
        frame = new JFrame("About Us");
        frame.setFont(new Font("Cambria", Font.BOLD, 16));
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Hacker\\IdeaProjects\\Module-Management-System\\src\\icons\\books.png"));


        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#a4bffa"));
        panel.setBounds(0, 0, 884, 738);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel img_main = new JLabel("");
        img_main.setIcon(new ImageIcon("C:\\Users\\Hacker\\IdeaProjects\\Module-Management-System\\src\\icons\\About Us.png"));
        img_main.setHorizontalAlignment(SwingConstants.CENTER);
        img_main.setBounds(0, 0, 884, 738);
        panel.add(img_main);

        frame.add(panel);
        frame.setBounds(100, 100, 908, 785);
        frame.setLocation(400,20);
        frame.setVisible(true);
    }
}
