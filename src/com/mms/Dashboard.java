package com.mms;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.*;

public class Dashboard {
    JFrame dashboard;
    JLabel label,current_date,banner_label,txt_title,txt_access,txt_stats,txt_calender,txt_time;
    JButton btn;
    JPanel leftpanel,datepanel, timepanel;
    JOptionPane msg;
    Font font,font1;
//    Date date;
    LocalDate date;
    java.util.Date time;
    public Dashboard(){
        long millis=System.currentTimeMillis();
        time = new java.util.Date(millis);

        date = java.time.LocalDate.now();
//        time = java.time.LocalTime.now();
        dashboard = new JFrame("DashBoard");
        font = new Font("Cambria", Font.ITALIC, 35);
        font1 = new Font("Cambria", Font.ITALIC, 20);

        leftpanel = new JPanel();
        leftpanel.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.decode("#1A2B63")));
        leftpanel.setBounds(10,20,300,700);
        leftpanel.setBackground(Color.decode("#E9EDF5"));
        dashboard.add(leftpanel);

        txt_title = new JLabel("Welcome To Student Module");
        txt_title.setFont(font);
        txt_title.setForeground(Color.decode("#E9EDF5"));
        txt_title.setBounds(460,40,450,120);
        dashboard.add(txt_title);

        // Add Banner Image in DashBoard
        ImageIcon bannerIcon = new ImageIcon(new ImageIcon("src\\icons\\banner.png").getImage().getScaledInstance(700, 300, Image.SCALE_SMOOTH));
        banner_label = new JLabel(bannerIcon);
        banner_label.setIcon(bannerIcon);
        banner_label.setBounds(320,10,700,300);
        dashboard.add(banner_label);

        txt_access = new JLabel("ACCESSORIES");
        txt_access.setForeground(Color.decode("#E9EDF5"));
        txt_access.setFont(font1);
        txt_access.setBounds(400,350,120,30);
        dashboard.add(txt_access);


        txt_stats = new JLabel("Student Stats");
        txt_stats.setForeground(Color.decode("#E9EDF5"));
        txt_stats.setFont(font1);
        txt_stats.setBounds(800,350,120,30);
        dashboard.add(txt_stats);


        txt_calender = new JLabel("Current Date");
        txt_calender.setForeground(Color.decode("#E9EDF5"));
        txt_calender.setFont(font1);
        txt_calender.setBounds(400,550,120,30);
        dashboard.add(txt_calender);

        datepanel = new JPanel();
        datepanel.setBackground(Color.decode("#E9EDF5"));
        datepanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.decode("#1A2B63")));
        datepanel.setBounds(380,600,200,50);
        dashboard.add(datepanel);

        JLabel current_date = new JLabel(String.valueOf(date));
        current_date.setBounds(100,100,20,20);
        current_date.setFont(font1);
        current_date.setForeground(Color.decode("#5375e2"));
        datepanel.add(current_date);




        txt_time = new JLabel("Current Time");
        txt_time.setForeground(Color.decode("#E9EDF5"));
        txt_time.setFont(font1);
        txt_time.setBounds(800,550,120,30);
        dashboard.add(txt_time);

        timepanel = new JPanel();
        timepanel.setBackground(Color.decode("#E9EDF5"));
        timepanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.decode("#1A2B63")));
        timepanel.setBounds(750,600,300,50);
        dashboard.add(timepanel);

        JLabel current_time = new JLabel(String.valueOf(time));
        current_time.setBounds(0,10,20,20);
        current_time.setFont(font1);
        current_time.setForeground(Color.decode("#5375e2"));
        timepanel.add(current_time);


        dashboard.setLayout(null);
        dashboard.setSize(1080, 800);
        dashboard.setVisible(true);
        dashboard.setLocation(200,10);
        dashboard.getContentPane().setBackground(Color.decode("#5375e2"));
        dashboard.setResizable(false);

    }
    public static void main(String[]Args){
        new Dashboard();
    }
}
