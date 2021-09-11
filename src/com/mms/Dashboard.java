package com.mms;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Dashboard {
    JFrame dashboard;
    JLabel label,banner_label;
    JButton btn;
    JPanel leftpanel,mainpanel;
    JOptionPane msg;
    public Dashboard(){
        dashboard = new JFrame("DashBoard");

        leftpanel = new JPanel();
        leftpanel.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.decode("#1A2B63")));
        leftpanel.setBounds(1,0,300,722);
        dashboard.add(leftpanel);

        // Add Banner Image in DashBoard
        ImageIcon bannerIcon = new ImageIcon(new ImageIcon("src\\icons\\banner.png").getImage().getScaledInstance(700, 300, Image.SCALE_SMOOTH));
        JLabel banner_label = new JLabel(bannerIcon);
        banner_label.setIcon(bannerIcon);
        banner_label.setBounds(320,20,700,300);
        dashboard.add(banner_label);




        dashboard.setLayout(null);
        dashboard.setSize(1080, 760);
        dashboard.setVisible(true);
        dashboard.setLocation(200,20);
        dashboard.getContentPane().setBackground(Color.decode("#5375e2"));
        dashboard.setResizable(false);

    }
    public static void main(String[]Args){
        new Dashboard();
    }
}
