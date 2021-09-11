package com.mms;

import javax.swing.*;
import java.awt.*;

public class Dashboard {
    JFrame dashboard;
    JLabel label;
    JButton btn;
    JOptionPane msg;
    public Dashboard(){
        dashboard = new JFrame("DashBoard");
        dashboard.setLayout(null);
        dashboard.setSize(800, 640);
        dashboard.setVisible(true);
        dashboard.setLocation(500,50);
        dashboard.getContentPane().setBackground(Color.decode("#5375e2"));
        dashboard.setResizable(false);

    }
    public static void main(String[]Args){
        new Dashboard();
    }
}
