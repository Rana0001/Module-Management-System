package com.mms;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Dashboard {
    JFrame dashboard;
    JLabel label,banner_label,txt_title;
    JButton btn;
    JPanel leftpanel,mainpanel;
    JOptionPane msg;
    Font font;
    public Dashboard(){
        dashboard = new JFrame("DashBoard");
        font = new Font("Cambria", Font.ITALIC, 35);

        leftpanel = new JPanel();
        leftpanel.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.decode("#1A2B63")));
        leftpanel.setBounds(1,0,300,722);
        dashboard.add(leftpanel);

        txt_title = new JLabel("Welcome To Student Module");
        txt_title.setFont(font);
        txt_title.setForeground(Color.decode("#E9EDF5"));
        txt_title.setBounds(460,50,450,120);
        dashboard.add(txt_title);

        // Add Banner Image in DashBoard
        ImageIcon bannerIcon = new ImageIcon(new ImageIcon("src\\icons\\banner.png").getImage().getScaledInstance(700, 300, Image.SCALE_SMOOTH));
        banner_label = new JLabel(bannerIcon);
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
