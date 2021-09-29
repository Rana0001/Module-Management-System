package com.mms;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
public class Dashboard implements ActionListener {
    String username;
    JFrame dashboard;
    JButton btn_module,btn_leader,btn_event,btn_about;


    public Dashboard(String username) {
        this.username = username;
        initialize();
    }


    private void initialize() {
        dashboard = new JFrame();
        dashboard.setTitle("Dashboard");
        dashboard.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icons/books.png"));
        dashboard.setResizable(false);
        dashboard.setBounds(100, 20, 1280, 720);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.getContentPane().setLayout(null);
        dashboard.setVisible(true);
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#2f3655"));
        panel.setBounds(0, 0, 369, 683);
        dashboard.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_logout = new JPanel();
        panel_logout.setBackground(new Color(255, 255, 255));
        panel_logout.setBounds(0, 548, 369, 70);
        panel_logout.addMouseListener(new PanelButtonMouseAdapter(panel_logout) {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(JOptionPane.showConfirmDialog(null, "Are you sure want to log out?")==0) {
                    dashboard.dispose();
                }
            }
        });
        panel.add(panel_logout);
        panel_logout.setLayout(null);

        JLabel lbl_logout = new JLabel("Log out");
        lbl_logout.setFont(new Font("Cambria", Font.BOLD, 22));
        lbl_logout.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_logout.setBounds(130, 0, 111, 70);
        lbl_logout.setForeground(Color.decode("#ffffff"));
        panel_logout.add(lbl_logout);
        panel_logout.setBackground(Color.decode("#3d456e"));

        JLabel img_logout = new JLabel("");
        img_logout.setHorizontalAlignment(SwingConstants.CENTER);
        img_logout.setIcon(new ImageIcon("src/icons/log-out (3).png"));
        img_logout.setBounds(48, 0, 72, 70);
        panel_logout.add(img_logout);

        JPanel panel_profile = new JPanel();
        panel_profile.setBackground(new Color(255, 255, 255));
		panel_profile.addMouseListener(new PanelButtonMouseAdapter(panel_profile) {
			@Override
			public void mouseClicked(MouseEvent e) {
            new Profile(username);
			}
		});
        panel_profile.setBounds(0, 195, 369, 70);
        panel.add(panel_profile);
        panel_profile.setLayout(null);

        JLabel lbl_profile = new JLabel(" Profile");
        lbl_profile.setFont(new Font("Cambria", Font.BOLD, 22));
        lbl_profile.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_profile.setForeground(Color.decode("#ffffff"));
        lbl_profile.setBounds(124, 0, 111, 63);
        panel_profile.add(lbl_profile);
        panel_profile.setBackground(Color.decode("#3d456e"));

        JLabel img_profile = new JLabel("");
        img_profile.setHorizontalAlignment(SwingConstants.CENTER);
        img_profile.setIcon(new ImageIcon("src/icons/man (1).png"));
        img_profile.setBounds(30, 0, 84, 70);
        panel_profile.add(img_profile);

        JPanel panel_module = new JPanel();
        panel_module.setBounds(0, 275, 369, 70);
        panel_module.addMouseListener(new PanelButtonMouseAdapter(panel_module) {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Module();
            }
        });
        panel.add(panel_module);
        panel_module.setLayout(null);

        JLabel lbl_module = new JLabel(" Module");
        lbl_module.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_module.setFont(new Font("Cambria", Font.BOLD, 22));
        lbl_module.setForeground(Color.decode("#ffffff"));
        lbl_module.setBounds(113, 0, 133, 70);
        panel_module.add(lbl_module);
        panel_module.setBackground(Color.decode("#3d456e"));

        JLabel img_module = new JLabel("");
        img_module.setHorizontalAlignment(SwingConstants.CENTER);
        img_module.setIcon(new ImageIcon("src/icons/study (1).png"));
        img_module.setBounds(29, 0, 83, 70);
        panel_module.add(img_module);

        JPanel panel_event = new JPanel();
        panel_event.setBounds(0, 355, 369, 70);
        panel_event.addMouseListener(new PanelButtonMouseAdapter(panel_event){
            @Override
            public void mouseClicked(MouseEvent e){
                new Event();
            }
        });
        panel.add(panel_event);
        panel_event.setLayout(null);

        JLabel lbl_event = new JLabel("Event");
        lbl_event.setFont(new Font("Cambria", Font.BOLD, 22));
        lbl_event.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_event.setEnabled(true);
        lbl_event.setBounds(130, 0, 103, 70);
        lbl_event.setForeground(Color.decode("#ffffff"));
        panel_event.add(lbl_event);
        panel_event.setBackground(Color.decode("#3d456e"));

        JLabel img_event = new JLabel("");
        img_event.setHorizontalAlignment(SwingConstants.CENTER);
        img_event.setIcon(new ImageIcon("src/icons/schedule.png"));
        img_event.setBounds(32, 0, 82, 70);
        panel_event.add(img_event);

        JLabel lbl_school = new JLabel("");
        lbl_school.setBounds(79, 31, 216, 137);
        panel.add(lbl_school);
        lbl_school.setIcon(new ImageIcon("src/icons/school.png"));
        lbl_school.setHorizontalAlignment(SwingConstants.CENTER);


        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.decode("#a4bffa"));
        panel_1.setBounds(369, 137, 897, 546);
        dashboard.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lbl_teacher = new JLabel("");
        lbl_teacher.setIcon(new ImageIcon("src/icons/teacher.png"));
        lbl_teacher.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_teacher.setBounds(305, 0, 282, 546);
        panel_1.add(lbl_teacher);

        JPanel panel_module_1 = new JPanel();
        panel_module_1.setBackground(new Color(244, 164, 96));
        panel_module_1.setBounds(21, 87, 282, 177);
        panel_1.add(panel_module_1);
        panel_module_1.setLayout(null);

        JPanel panel_module_2 = new JPanel();
        panel_module_2.setBorder(new LineBorder(new Color(210, 105, 30), 3));
        panel_module_2.setBackground(new Color(255, 140, 0));
        panel_module_2.setBounds(0, 0, 282, 45);
        panel_module_1.add(panel_module_2);
        panel_module_2.setLayout(null);

        JLabel lbl_module_1 = new JLabel("Module");
        lbl_module_1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_module_1.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_module_1.setBounds(83, 0, 97, 45);
        lbl_module_1.setForeground(Color.decode("#ffffff"));
        panel_module_2.add(lbl_module_1);

        btn_module = new JButton("Open Module");
        btn_module.setBackground(new Color(255, 255, 255));
        btn_module.setFont(new Font("Cambria", Font.BOLD, 16));
        btn_module.setForeground(Color.decode("#ffffff"));
        btn_module.addActionListener(this);
        btn_module.setBackground(new Color(255, 140, 0));
        btn_module.setBounds(68, 91, 136, 39);
        panel_module_1.add(btn_module);

        JPanel panel_leader_1 = new JPanel();
        panel_leader_1.setBounds(597, 87, 290, 177);
        panel_1.add(panel_leader_1);
        panel_leader_1.setBackground(Color.decode("#64bcfa"));
        panel_leader_1.setLayout(null);

        JPanel panel_leader_2 = new JPanel();
        panel_leader_2.setBorder(new LineBorder(new Color(70, 130, 180), 3));
        panel_leader_2.setBounds(0, 0, 290, 45);
        panel_leader_2.setBackground(Color.decode("#2c93dc"));
        panel_leader_1.add(panel_leader_2);
        panel_leader_2.setLayout(null);

        JLabel lbl_leader = new JLabel("Module Leader");
        lbl_leader.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_leader.setForeground(Color.decode("#ffffff"));
        lbl_leader.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_leader.setBounds(73, 0, 145, 39);
        panel_leader_2.add(lbl_leader);

        btn_leader = new JButton("Show ML");
        btn_leader.setFont(new Font("Cambria", Font.BOLD, 16));
        btn_leader.setForeground(Color.decode("#ffffff"));
        btn_leader.setBackground(Color.decode("#2c93dc"));
        btn_leader.addActionListener(this);
        btn_leader.setBounds(68, 92, 145, 39);
        panel_leader_1.add(btn_leader);

        JPanel panel_event_1 = new JPanel();
        panel_event_1.setBounds(21, 355, 282, 165);
        panel_event_1.setBackground(Color.decode("#beaa37"));
        panel_1.add(panel_event_1);
        panel_event_1.setLayout(null);

        JPanel panel_event_2 = new JPanel();
        panel_event_2.setBorder(new LineBorder(new Color(128, 128, 0), 3));
        panel_event_2.setBounds(0, 0, 282, 45);
        panel_event_2.setBackground(Color.decode("#918128"));
        panel_event_1.add(panel_event_2);
        panel_event_2.setLayout(null);

        JLabel lbl_event_1 = new JLabel("Event");
        lbl_event_1.setBounds(75, 0, 120, 45);
        panel_event_2.add(lbl_event_1);
        lbl_event_1.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_event_1.setForeground(Color.decode("#ffffff"));
        lbl_event_1.setHorizontalAlignment(SwingConstants.CENTER);

        btn_event = new JButton("Check Event");
        btn_event.setFont(new Font("Cambria", Font.BOLD, 16));
        btn_event.setForeground(Color.decode("#ffffff"));
        btn_event.addActionListener(this);
        btn_event.setBackground(Color.decode("#918128"));
        btn_event.setBounds(76, 79, 129, 39);
        panel_event_1.add(btn_event);

        JPanel panel_about = new JPanel();
        panel_about.setBounds(597, 355, 290, 165);
        panel_1.add(panel_about);
        panel_about.setLayout(null);

        JPanel panel_about_1 = new JPanel();
        panel_about_1.setBounds(0, 0, 290, 45);
        panel_about.add(panel_about_1);
        panel_about_1.setBackground(Color.decode("#6f2b8a"));
        panel_about.setBackground(Color.decode("#a03ec6"));
        panel_about_1.setLayout(null);

        JLabel lbl_about = new JLabel("About Us");
        lbl_about.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_about.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_about.setBounds(84, 0, 109, 45);
        lbl_about.setForeground(Color.decode("#ffffff"));
        panel_about_1.add(lbl_about);

        btn_about = new JButton("Learn about us !");
        btn_about.setFont(new Font("Cambria", Font.BOLD, 16));
        btn_about.setForeground(Color.decode("#ffffff"));
        btn_about.setBackground(Color.decode("#6f2b8a"));
        btn_event.addActionListener(this);
        btn_about.setBounds(65, 78, 161, 39);
        panel_about.add(btn_about);

        JPanel panel_banner = new JPanel();
        panel_banner.setBounds(369, 0, 897, 139);
        dashboard.getContentPane().add(panel_banner);
        panel_banner.setBorder(null);
        panel_banner.setBackground(new Color(255, 255, 255));
        panel_banner.setBackground(Color.decode("#a4bffa"));
        panel_banner.setLayout(null);

        JLabel img_banner = new JLabel("");
        img_banner.setBounds(0, 0, 897, 137);
        panel_banner.add(img_banner);
        img_banner.setHorizontalAlignment(SwingConstants.CENTER);
        img_banner.setIcon(new ImageIcon("src/icons/cropped-Softwarica-logo.png"));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_module){
            new ModuleInfo();
        }
        else if(e.getSource()==btn_leader){
            new ModulePanel();
        }
        else if(e.getSource()==btn_event){
            new EventInfo();
        }
        else if (e.getSource()==btn_about){
            new AboutUs();
        }
    }

    private class PanelButtonMouseAdapter extends MouseAdapter{
        JPanel panel;
        public PanelButtonMouseAdapter(JPanel panel) {
            this.panel = panel;
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            panel.setBackground(Color.decode("#2596be"));
        }
        public void mouseExited(MouseEvent e) {
            panel.setBackground(Color.decode("#3d456e"));
        }
        public void mousePressed(MouseEvent e) {
            panel.setBackground(new Color(255, 140, 0));
        }
        public void mouseReleased(MouseEvent e) {
            panel.setBackground(Color.decode("#3d456e"));
        }

    }
}
