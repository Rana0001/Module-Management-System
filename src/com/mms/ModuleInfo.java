package com.mms;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ModuleInfo  implements ActionListener {
    JFrame module_info;
    JPanel contentPane;
    JTable data_module;
    JButton btn_quit;
    String [] header;
    DefaultTableModel dtm;
    Font font;


    public ModuleInfo() {
        module_info = new JFrame("Module Information");

        module_info.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icons/books.png"));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        module_info.setContentPane(contentPane);
        contentPane.setLayout(null);
        font = new Font("Cambria", Font.BOLD, 18);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 899, 663);
        panel.setBackground(Color.decode("#a4bffa"));
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lbl_banner = new JLabel("");
        lbl_banner.setIcon(new ImageIcon("src/icons/cropped-Softwarica-logo.png"));
        lbl_banner.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_banner.setBounds(0, 10, 899, 100);
        panel.add(lbl_banner);

        btn_quit = new JButton("Quit");
        btn_quit.setFont(new Font("Cambria", Font.BOLD, 18));
        btn_quit.addActionListener(this);
        btn_quit.setBounds(384, 611, 104, 42);
        btn_quit.setForeground(Color.decode("#E9EDF5"));
        btn_quit.setBackground(Color.decode("#1A2B63"));
        panel.add(btn_quit);

        JLabel lbl_firstname = new JLabel("First Name");
        lbl_firstname.setForeground(Color.black);
        lbl_firstname.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_firstname.setBounds(20,120,150,50);
        lbl_firstname.setFont(font);
        panel.add(lbl_firstname);

        JLabel lbl_lastname = new JLabel("Last Name");
        lbl_lastname.setForeground(Color.black);
        lbl_lastname.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_lastname.setBounds(200,120,150,50);
        lbl_lastname.setFont(font);
        panel.add(lbl_lastname);

        JLabel lbl_modulename = new JLabel("Module Name");
        lbl_modulename.setForeground(Color.black);
        lbl_modulename.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_modulename.setBounds(420,120,150,50);
        lbl_modulename.setFont(font);
        panel.add(lbl_modulename);

        JLabel lbl_credit = new JLabel("Credit");
        lbl_credit.setForeground(Color.black);
        lbl_credit.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_credit.setBounds(720,120,150,50);
        lbl_credit.setFont(font);
        panel.add(lbl_credit);


        data_module = new JTable();
        header = new String[]{"First Name","Last Name","Module Name","Credit"};
        data_module.setFont(new Font("Cambria", Font.BOLD, 18));
        dtm = new DefaultTableModel(header,0);
        data_module.setModel(dtm);
        data_module.setRowHeight(25);
        data_module.getColumnModel().getColumn(0).setPreferredWidth(99);
        data_module.getColumnModel().getColumn(0).setMinWidth(20);
        data_module.getColumnModel().getColumn(1).setPreferredWidth(150);
        data_module.getColumnModel().getColumn(1).setMinWidth(150);
        data_module.getColumnModel().getColumn(2).setPreferredWidth(250);
        data_module.getColumnModel().getColumn(2).setMinWidth(250);
        data_module.getColumnModel().getColumn(3).setPreferredWidth(50);
        data_module.getColumnModel().getColumn(3).setMinWidth(50);
        data_module.setBounds(0, 163, 899, 426);
        panel.add(data_module);
        displayResult();



        module_info.add(panel);
        module_info.setBounds(100, 100, 913, 700);
        module_info.setLocation(400,50);
        module_info.setVisible(true);
    }
    public void displayResult(){
        try {
            Database db = new Database();
            String query = "select leader_fname, leader_lname, module_name, credit from module_leader as ml, module as m where ml.leader_id = m.leader_id order by leader_fname asc";
            ResultSet rs = db.select(query);
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] obj = {rs.getString("leader_fname"), rs.getString("leader_lname"),rs.getString("module_name"),rs.getString("credit")};
                dtm.addRow(obj);
            }
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_quit){
            int choice = JOptionPane.showConfirmDialog(null, "Do you want to close this?");
            if (choice==0){
                module_info.dispose();
            }
        }
    }
}

