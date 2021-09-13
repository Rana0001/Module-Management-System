package com.mms;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Event implements MouseListener, ActionListener {
    JFrame event;
    JLabel event_id,event_name,event_date,event_notice;
    JTextField txt_eventid,txt_eventname,txt_eventdate,txt_eventnotice;
    JPanel leftpanel;
    JButton btn_add,btn_delete,btn_update,btn_refresh;
    Font font,font1,font2;
    JTable table;
    ArrayList<EventDetails> event_detail;
    DefaultTableModel dtm;
    String[] header;
    public Event(){
        event = new JFrame("MANAGE EVENT");
        font = new Font("Cambria",Font.BOLD,20);
        font1 = new Font("Cambria",Font.BOLD,18);
//        font2 = new Font("Cambria",Font.BOLD,18);


        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        event.setIconImage(icon);

        event_id = new JLabel("Event Id");
        event_id.setBounds(135,20,150,30);
        event_id.setForeground(Color.decode("#1A2B63"));
        event_id.setFont(font);
        event.add(event_id);

        txt_eventid = new JTextField();
        txt_eventid.setFont(font1);
        txt_eventid.setBounds(30, 60, 300, 40);
        event.add(txt_eventid);


        event_name = new JLabel("Event Name");
        event_name.setBounds(120,120,150,30);
        event_name.setForeground(Color.decode("#1A2B63"));
        event_name.setFont(font);
        event.add(event_name);

        txt_eventname = new JTextField();
        txt_eventname.setFont(font1);
        txt_eventname.setBounds(30, 160, 300, 40);
        event.add(txt_eventname);

        event_date = new JLabel("Event Date");
        event_date.setBounds(125,220,150,30);
        event_date.setForeground(Color.decode("#1A2B63"));
        event_date.setFont(font);
        event.add(event_date);

        txt_eventdate = new JTextField();
        txt_eventdate.setFont(font1);
        txt_eventdate.setBounds(30, 260, 300, 40);
        event.add(txt_eventdate);

        event_notice = new JLabel("Event Notice");
        event_notice.setBounds(115,320,150,30);
        event_notice.setForeground(Color.decode("#1A2B63"));
        event_notice.setFont(font);
        event.add(event_notice);

        txt_eventnotice = new JTextField();
        txt_eventnotice.setFont(font1);
        txt_eventnotice.setBounds(30, 360, 300, 40);
        event.add(txt_eventnotice);

        btn_add = new JButton("ADD");
        btn_add.setBounds(30,480,130,40);
        btn_add.setForeground(Color.decode("#E9EDF5"));
        btn_add.setBackground(Color.decode("#1A2B63"));
        btn_add.addActionListener(this);
        event.add(btn_add);

        btn_delete = new JButton("DELETE");
        btn_delete.setBounds(200,480,130,40);
        btn_delete.setBackground(Color.decode("#1A2B63"));
        btn_delete.setForeground(Color.decode("#E9EDF5"));
        btn_delete.addActionListener(this);
        event.add(btn_delete);


        btn_update = new JButton("UPDATE");
        btn_update.setBounds(30,550,130,40);
        btn_update.addActionListener(this);
        btn_update.setForeground(Color.decode("#E9EDF5"));
        btn_update.setBackground(Color.decode("#1A2B63"));
        event.add(btn_update);


        btn_refresh = new JButton("CLEAR");
        btn_refresh.setBounds(200,550,130,40);
        btn_refresh.addActionListener(this);
        btn_refresh.setForeground(Color.decode("#E9EDF5"));
        btn_refresh.setBackground(Color.decode("#1A2B63"));
        event.add(btn_refresh);


        leftpanel = new JPanel();
        leftpanel.setBounds(5,5,350,650);
        leftpanel.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.decode("#1A2B63")));
        leftpanel.setBackground(Color.decode("#E9EDF5"));
        event.add(leftpanel);

        JLabel eventid = new JLabel("Event Id");
        eventid.setBounds(450,40,250,40);
        eventid.setFont(font);
        eventid.setForeground(Color.decode("#E9EDF5"));
        event.add(eventid);

        JLabel eventname = new JLabel("Event Name");
        eventname.setBounds(650,40,250,40);
        eventname.setFont(font);
        eventname.setForeground(Color.decode("#E9EDF5"));
        event.add(eventname);

        JLabel eventdate = new JLabel("Event Date");
        eventdate.setBounds(850,40,250,40);
        eventdate.setFont(font);
        eventdate.setForeground(Color.decode("#E9EDF5"));
        event.add(eventdate);

        JLabel eventnotice = new JLabel("Event Notice");
        eventnotice.setBounds(1050,40,250,40);
        eventnotice.setFont(font);
        eventnotice.setForeground(Color.decode("#E9EDF5"));
        event.add(eventnotice);
//

        header = new String[]{"Event Id","Event Name","Event Date","Event Notice"};
        table = new JTable();
        table.addMouseListener(this);
        event_detail = new ArrayList<>();
        dtm = new DefaultTableModel(header,0);
        table.setModel(dtm);
        dtm.fireTableDataChanged();
        table.setRowHeight(25);
        table.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#1A2B63")));
        table.setBounds(400,80,850,400);
        table.setFont(font);
        event.add(table);
        displayResult();

        event.setLayout(null);
        event.setSize(1280, 700);
        event.setVisible(true);
        event.setLocation(200,10);
        event.getContentPane().setBackground(Color.decode("#5375e2"));
        event.setResizable(false);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btn_add) {
//            Database db = new Database();
//            String query = "Insert into user(book_id,book_name,book_author) values('"+book_id+"','"+book_name+"','"+book_author+"')";
//            db.insert(query);

            EventDetails detail = new EventDetails(txt_eventid.getText(), txt_eventname.getText(), txt_eventdate.getText(),txt_eventnotice.getText());
            event_detail.add(detail);
            displayResult();
        }else if (e.getSource()==btn_refresh){
            txt_eventid.setText("");
            txt_eventname.setText("");
            txt_eventdate.setText("");
            txt_eventnotice.setText("");
        }else if (e.getSource()==btn_delete){
            try {
                Database db = new Database();

                String query = "Delete from event where event_name ='" + txt_eventname.getText() + "'";
                int i = table.getSelectedRow();
//               int choice = JOptionPane.showConfirmDialog(book, "Do you want to delete this data?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
                if (i >= 0) {
                    dtm.removeRow(i);
                    JOptionPane.showMessageDialog(event, "Data Deleted Successfully");
                    db.delete(query);
                    displayResult();
                }
            }catch (IndexOutOfBoundsException exception){
                exception.printStackTrace();
            }
        }else if (e.getSource()==btn_update) {
            try {
                Database db = new Database();
                String query = "Update event SET event_id='"+txt_eventid.getText()+"',event_name='"+txt_eventname.getText()+"',event_date='"+txt_eventdate.getText()+"'," +
                        "event_notice='"+txt_eventnotice.getText()+"' where event_id='"+txt_eventid.getText()+"'";

                int i = table.getSelectedRow();

                dtm.setValueAt(txt_eventid.getText(), i, 0);
                dtm.setValueAt(txt_eventname.getText(), i, 1);
                dtm.setValueAt(txt_eventdate.getText(), i, 2);
                dtm.setValueAt(txt_eventnotice.getText(), i, 3);
                JOptionPane.showMessageDialog(event, "Data Updated Successfully");
                db.update(query);
                displayResult();
            }catch (Exception throwables){
                throwables.printStackTrace();
            }
        }

    }
    public void displayResult(){
        try {
            Database db = new Database();
            String query = "Select * from event";
            ResultSet rs = db.select(query);
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] obj = {rs.getString("event_id"), rs.getString("event_name"), rs.getString("event_date"),rs.getString("event_notice")};
                dtm.addRow(obj);
            }
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int i = table.getSelectedRow();
        txt_eventid.setText(dtm.getValueAt(i,0).toString());
        txt_eventname.setText(dtm.getValueAt(i,1).toString());
        txt_eventdate.setText(dtm.getValueAt(i,2).toString());
        txt_eventnotice.setText(dtm.getValueAt(i,3).toString());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
