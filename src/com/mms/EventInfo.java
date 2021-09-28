package com.mms;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class EventInfo implements ActionListener {
    JFrame event_info;
     JPanel contentPane;
     JTable table;
     String[] header;
    DefaultTableModel dtm;
    JButton btn_quit;


    public EventInfo() {
        event_info = new JFrame("Event Information");

        event_info.setIconImage(Toolkit.getDefaultToolkit().getImage("src/icons/books.png"));
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        event_info.setContentPane(contentPane);

        contentPane.setLayout(null);

        JPanel event_panel = new JPanel();
        event_panel.setBounds(0, 0, 880, 724);
            event_panel.setBackground(Color.decode("#a4bffa"));
        contentPane.add(event_panel);
        event_panel.setLayout(null);

        btn_quit = new JButton("Quit");
        btn_quit.setFont(new Font("Cambria", Font.BOLD, 18));
        btn_quit.setBounds(394, 638, 120, 50);
        btn_quit.setForeground(Color.decode("#E9EDF5"));
        btn_quit.setBackground(Color.decode("#1A2B63"));
        btn_quit.addActionListener(this);
        event_panel.add(btn_quit);

        JLabel lbl_banner = new JLabel("");
        lbl_banner.setIcon(new ImageIcon("src/icons/cropped-Softwarica-logo.png"));
        lbl_banner.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_banner.setBounds(10, 0, 870, 108);
        event_panel.add(lbl_banner);

        JLabel lbl_eventinfo = new JLabel("Event Information");
        lbl_eventinfo.setForeground(Color.decode("#ffffff"));
        lbl_eventinfo.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_eventinfo.setFont(new Font("Cambria", Font.BOLD, 24));
        lbl_eventinfo.setBounds(276, 118, 387, 26);
        event_panel.add(lbl_eventinfo);

        JLabel lbl_eventname = new JLabel("Event Name");
        lbl_eventname.setForeground(Color.decode("#ffffff"));
        lbl_eventname.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_eventname.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_eventname.setBounds(10, 179, 285, 26);
        event_panel.add(lbl_eventname);

        JLabel lbl_eventdate = new JLabel("Event Date");
        lbl_eventdate.setForeground(Color.decode("#ffffff"));
        lbl_eventdate.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_eventdate.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_eventdate.setBounds(297, 179, 331, 26);
        event_panel.add(lbl_eventdate);

        JLabel lbl_eventnotice = new JLabel("Event Notice");
        lbl_eventnotice.setForeground(Color.decode("#ffffff"));
        lbl_eventnotice.setFont(new Font("Cambria", Font.BOLD, 18));
        lbl_eventnotice.setHorizontalAlignment(SwingConstants.CENTER);
        lbl_eventnotice.setBounds(627, 179, 253, 26);
        event_panel.add(lbl_eventnotice);


        table = new JTable();
        header = new String[]{"Event Name","Event Date","Event Notice"};
        dtm = new DefaultTableModel(header,0);
        table.setFont(new Font("Cambria", Font.BOLD, 18));
        table.setModel(dtm);
        table.setRowHeight(25);
        table.getColumnModel().getColumn(0).setPreferredWidth(175);
        table.getColumnModel().getColumn(1).setPreferredWidth(225);
        table.getColumnModel().getColumn(2).setPreferredWidth(139);
        table.setBounds(10, 215, 870, 396);
        event_panel.add(table);
        displayResult();

        event_info.add(event_panel);
        event_info.setBounds(100, 100, 904, 761);
        event_info.setLocation(400,50);
        event_info.setVisible(true);

    }
    public void displayResult(){
        try {
            Database db = new Database();
            String query = "select event_name, event_date, event_notice from event;";
            ResultSet rs = db.select(query);
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] obj = {rs.getString("event_name"), rs.getString("event_date"),rs.getString("event_notice")};
                dtm.addRow(obj);

            }
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn_quit){
            int choose = JOptionPane.showConfirmDialog(null,"Do you want to close this?");
            if (choose==0){
                event_info.dispose();
            }
        }
    }
}

