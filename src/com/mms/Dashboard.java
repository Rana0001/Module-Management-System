package com.mms;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.*;

public class Dashboard {
    JFrame dashboard;
    JLabel label,current_date,banner_label,txt_title,txt_access,txt_stats,txt_calender,txt_time;
    JButton btn_profile,btn_manageBook,btn_event,btn_manage,btn_logout;
    JPanel leftpanel,datepanel, timepanel, statpanel;
    JOptionPane msg;
    Font font,font1,font2;
//    Date date;
    LocalDate date;
    java.util.Date time;
    public Dashboard(String username){
        long millis=System.currentTimeMillis();
        time = new java.util.Date(millis);

        date = java.time.LocalDate.now();
//        time = java.time.LocalTime.now();
        dashboard = new JFrame("DashBoard");
        font = new Font("Cambria", Font.ITALIC, 35);
        font1 = new Font("Cambria", Font.ITALIC, 20);
        font2 = new Font("Cambria", Font.BOLD, 20);

        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        dashboard.setIconImage(icon);

        ImageIcon profile_icon = new ImageIcon(new ImageIcon("src\\icons\\profile.png").getImage().getScaledInstance(150, 120, Image.SCALE_SMOOTH));
        JLabel profile_label = new JLabel(profile_icon);
        profile_label.setBounds(80,50,150,120);
        dashboard.add(profile_label);

        label = new JLabel("Welcome "+username);
        label.setBounds(50,200,250,30);
        label.setForeground(Color.decode("#5375e2"));
        label.setFont(font1);
        dashboard.add(label);


        btn_profile = new JButton("PROFILE");
        btn_profile.setBounds(30,300,250,40);
        btn_profile.setForeground(Color.decode("#E9EDF5"));
        btn_profile.setBackground(Color.decode("#5375e2"));
        btn_profile.setFont(font2);
        dashboard.add(btn_profile);



        btn_manageBook = new JButton("MANAGE BOOK");
        btn_manageBook.setForeground(Color.decode("#E9EDF5"));
        btn_manageBook.setBackground(Color.decode("#5375e2"));
        btn_manageBook.setFont(font2);
        btn_manageBook.setBounds(30,380,250,40);
        dashboard.add(btn_manageBook);



        btn_event = new JButton("MANAGE EVENT");
        btn_event.setBounds(30,460,250,40);
        btn_event.setForeground(Color.decode("#E9EDF5"));
        btn_event.setBackground(Color.decode("#5375e2"));
        btn_event.setFont(font2);
        dashboard.add(btn_event);


        btn_logout = new JButton("LOG OUT");
        btn_logout.setBounds(30,600,250,40);
        btn_logout.setForeground(Color.decode("#E9EDF5"));
        btn_logout.setBackground(Color.decode("#5375e2"));
        btn_logout.setFont(font2);
        dashboard.add(btn_logout);





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


        txt_stats = new JLabel("STUDENT STAT");
        txt_stats.setForeground(Color.decode("#E9EDF5"));
        txt_stats.setFont(font1);
        txt_stats.setBounds(800,350,150,30);
        dashboard.add(txt_stats);


        txt_calender = new JLabel("CURRENT DATE");
        txt_calender.setForeground(Color.decode("#E9EDF5"));
        txt_calender.setFont(font1);
        txt_calender.setBounds(400,550,150,30);
        dashboard.add(txt_calender);

        datepanel = new JPanel();
        datepanel.setBackground(Color.decode("#E9EDF5"));
        datepanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.decode("#1A2B63")));
        datepanel.setBounds(380,600,200,50);
        dashboard.add(datepanel);

        current_date = new JLabel(String.valueOf(date));
        current_date.setBounds(100,100,20,20);
        current_date.setFont(font1);
        current_date.setForeground(Color.decode("#5375e2"));
        datepanel.add(current_date);



        txt_time = new JLabel("CURRENT TIME");
        txt_time.setForeground(Color.decode("#E9EDF5"));
        txt_time.setFont(font1);
        txt_time.setBounds(800,550,150,30);
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

        ImageIcon manage_book = new ImageIcon(new ImageIcon("src\\icons\\manage.png").getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
        btn_manage = new JButton(manage_book);
        btn_manage.setBounds(380,380,200,120);
        btn_manage.setForeground(Color.decode("#E9EDF5"));
        btn_manage.setBackground(Color.decode("#5375e2"));
        btn_manage.setFont(font2);
        dashboard.add(btn_manage);

        JLabel attend = new JLabel("CLASS ATTENDED");
        attend.setForeground(Color.decode("#5375e2"));
        attend.setFont(font1);
        attend.setBounds(790,380,180,30);
        dashboard.add(attend);

        JLabel present = new JLabel("100/112");
        present.setForeground(Color.decode("#5375e2"));
        present.setFont(font1);
        present.setBounds(820,420,180,30);
        dashboard.add(present);

        JLabel info = new JLabel("PRESENT/TOTAL CLASS");
        info.setForeground(Color.decode("#5375e2"));
        info.setFont(font1);
        info.setBounds(770,460,250,30);
        dashboard.add(info);


        statpanel = new JPanel();
        statpanel.setBounds(750,380,250,120);
        statpanel.setBackground(Color.decode("#E9EDF5"));
        statpanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3,Color.decode("#1A2B63")));
        dashboard.add(statpanel);


        dashboard.setLayout(null);
        dashboard.setSize(1080, 800);
        dashboard.setVisible(true);
        dashboard.setLocation(200,10);
        dashboard.getContentPane().setBackground(Color.decode("#5375e2"));
        dashboard.setResizable(false);



    }
}