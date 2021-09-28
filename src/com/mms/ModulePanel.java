package com.mms;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModulePanel implements ActionListener {

    private JPanel contentPane;
    JFrame frame;
    JButton btn_exit;

    public ModulePanel() {
        frame = new JFrame("Module Leader");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icons/books.png"));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);


        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#a4bffa"));
        panel.setBounds(0, 0, 904, 739);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lbl_banner = new JLabel("");
        lbl_banner.setIcon(new ImageIcon("src/icons/cropped-Softwarica-logo.png"));
        lbl_banner.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_banner.setBounds(0, 0, 893, 104);
        panel.add(lbl_banner);

        JLabel lbl_title = new JLabel("Module Leader");
        lbl_title.setFont(new Font("Cambria", Font.BOLD, 24));
        lbl_title.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_title.setBounds(332, 114, 215, 36);
        panel.add(lbl_title);

        JLabel img_leader1 = new JLabel("");
        img_leader1.setIcon(new ImageIcon("src/icons/Shyam_sir.png"));
        img_leader1.setHorizontalAlignment(SwingConstants.CENTER);
        img_leader1.setBounds(58, 162, 216, 200);
        panel.add(img_leader1);

        JLabel lbl_leader1 = new JLabel("Shyam Sundar Khatiwada");
        lbl_leader1.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_leader1.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_leader1.setBounds(58, 372, 216, 29);
        panel.add(lbl_leader1);

        JLabel img_leader2 = new JLabel("");
        img_leader2.setHorizontalAlignment(SwingConstants.CENTER);
        img_leader2.setIcon(new ImageIcon("src/icons/ganesh_sir.png"));
        img_leader2.setBounds(607, 162, 215, 200);
        panel.add(img_leader2);

        JLabel lbl_leader2 = new JLabel("Ganesh Bhusal");
        lbl_leader2.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_leader2.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_leader2.setBounds(606, 372, 216, 33);
        panel.add(lbl_leader2);

        JLabel img_leader3 = new JLabel("");
        img_leader3.setHorizontalAlignment(SwingConstants.CENTER);
        img_leader3.setIcon(new ImageIcon("src/icons/prerana_maam.png"));
        img_leader3.setBounds(58, 444, 216, 200);
        panel.add(img_leader3);

        JLabel lbl_leader3 = new JLabel("Prerana Pandit");
        lbl_leader3.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_leader3.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_leader3.setBounds(68, 654, 206, 29);
        panel.add(lbl_leader3);

        JLabel img_leader4 = new JLabel("");
        img_leader4.setHorizontalAlignment(SwingConstants.CENTER);
        img_leader4.setIcon(new ImageIcon("src/icons/bikash_sir.png"));
        img_leader4.setBounds(607, 444, 226, 200);
        panel.add(img_leader4);

        JLabel lbl_leader4 = new JLabel("Bikash Ghimirey");
        lbl_leader4.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_leader4.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_leader4.setBounds(617, 654, 205, 29);
        panel.add(lbl_leader4);

        btn_exit = new JButton("Exit");
        btn_exit.setForeground(Color.decode("#E9EDF5"));
        btn_exit.setBackground(Color.decode("#1A2B63"));
        btn_exit.addActionListener(this);
        btn_exit.setFont(new Font("Cambria", Font.BOLD, 18));
        btn_exit.setBounds(371, 387, 135, 50);

        panel.add(btn_exit);

        frame.add(panel);
        frame.setBounds(100, 100, 907, 766);
        frame.setLocation(400,50);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to close this?");
        if (choice == 0) {
            frame.dispose();
        }
    }
}
