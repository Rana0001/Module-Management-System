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

public class Module implements MouseListener, ActionListener {
    JFrame module;
    JLabel module_id,leader_id,module_name,credit;
    JTextField txt_moduleid,txt_leaderid,txt_modulename,txt_credit;
    JPanel leftpanel;
    JButton btn_add,btn_delete,btn_update,btn_refresh;
    Font font,font1,font2;
    JTable table;
    ArrayList<ModuleDetails> module_detail;
    DefaultTableModel dtm;
    String[] header;
    public Module(){
        module = new JFrame("MANAGE MODULE");
        font = new Font("Cambria",Font.BOLD,20);
        font1 = new Font("Cambria",Font.BOLD,18);
//        font2 = new Font("Cambria",Font.BOLD,18);


        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        module.setIconImage(icon);

        module_id = new JLabel("Module Id");
        module_id.setBounds(120,20,150,30);
        module_id.setForeground(Color.decode("#1A2B63"));
        module_id.setFont(font);
        module.add(module_id);

        txt_moduleid = new JTextField();
        txt_moduleid.setFont(font1);
        txt_moduleid.setBounds(30, 60, 300, 40);
        module.add(txt_moduleid);


        leader_id = new JLabel("Leader Id");
        leader_id.setBounds(120,120,150,30);
        leader_id.setForeground(Color.decode("#1A2B63"));
        leader_id.setFont(font);
        module.add(leader_id);

        txt_leaderid = new JTextField();
        txt_leaderid.setFont(font1);
        txt_leaderid.setBounds(30, 160, 300, 40);
        module.add(txt_leaderid);

        module_name = new JLabel("Module Name");
        module_name.setBounds(105,220,150,30);
        module_name.setForeground(Color.decode("#1A2B63"));
        module_name.setFont(font);
        module.add(module_name);

        txt_modulename = new JTextField();
        txt_modulename.setFont(font1);
        txt_modulename.setBounds(30, 260, 300, 40);
        module.add(txt_modulename);

        credit = new JLabel("Credit");
        credit.setBounds(135,320,150,30);
        credit.setForeground(Color.decode("#1A2B63"));
        credit.setFont(font);
        module.add(credit);

        txt_credit = new JTextField();
        txt_credit.setFont(font1);
        txt_credit.setBounds(30, 360, 300, 40);
        module.add(txt_credit);

        btn_add = new JButton("ADD");
        btn_add.setBounds(30,480,130,40);
        btn_add.setForeground(Color.decode("#E9EDF5"));
        btn_add.setBackground(Color.decode("#1A2B63"));
        btn_add.addActionListener(this);
        module.add(btn_add);

        btn_delete = new JButton("DELETE");
        btn_delete.setBounds(200,480,130,40);
        btn_delete.setBackground(Color.decode("#1A2B63"));
        btn_delete.setForeground(Color.decode("#E9EDF5"));
        btn_delete.addActionListener(this);
        module.add(btn_delete);


        btn_update = new JButton("UPDATE");
        btn_update.setBounds(30,550,130,40);
        btn_update.addActionListener(this);
        btn_update.setForeground(Color.decode("#E9EDF5"));
        btn_update.setBackground(Color.decode("#1A2B63"));
        module.add(btn_update);


        btn_refresh = new JButton("CLEAR");
        btn_refresh.setBounds(200,550,130,40);
        btn_refresh.addActionListener(this);
        btn_refresh.setForeground(Color.decode("#E9EDF5"));
        btn_refresh.setBackground(Color.decode("#1A2B63"));
        module.add(btn_refresh);


        leftpanel = new JPanel();
        leftpanel.setBounds(5,5,350,650);
        leftpanel.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.decode("#1A2B63")));
        leftpanel.setBackground(Color.decode("#E9EDF5"));
        module.add(leftpanel);

        JLabel moduleid = new JLabel("Module Id");
        moduleid.setBounds(450,40,250,40);
        moduleid.setFont(font);
        moduleid.setForeground(Color.decode("#E9EDF5"));
        module.add(moduleid);

        JLabel leaderid = new JLabel("Leader id");
        leaderid.setBounds(650,40,250,40);
        leaderid.setFont(font);
        leaderid.setForeground(Color.decode("#E9EDF5"));
        module.add(leaderid);

        JLabel modulename = new JLabel("Module Name");
        modulename.setBounds(850,40,250,40);
        modulename.setFont(font);
        modulename.setForeground(Color.decode("#E9EDF5"));
        module.add(modulename);

        JLabel module_credit = new JLabel("Credit");
        module_credit.setBounds(1050,40,250,40);
        module_credit.setFont(font);
        module_credit.setForeground(Color.decode("#E9EDF5"));
        module.add(module_credit);
//

        header = new String[]{"Module Name","Leader Id","Module Name","Credit"};
        table = new JTable();
        table.addMouseListener(this);
        module_detail = new ArrayList<>();
        dtm = new DefaultTableModel(header,0);
        table.setModel(dtm);
        dtm.fireTableDataChanged();
        table.setRowHeight(25);
        table.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#1A2B63")));
        table.setBounds(400,80,850,400);
        table.setFont(font);
        module.add(table);
        displayResult();

        module.setLayout(null);
        module.setSize(1280, 700);
        module.setVisible(true);
        module.setLocation(200,10);
        module.getContentPane().setBackground(Color.decode("#5375e2"));
        module.setResizable(false);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btn_add) {
//            Database db = new Database();
//            String query = "Insert into user(book_id,book_name,book_author) values('"+book_id+"','"+book_name+"','"+book_author+"')";
//            db.insert(query);

            ModuleDetails detail = new ModuleDetails(txt_moduleid.getText(), txt_leaderid.getText(), txt_modulename.getText(),txt_credit.getText());
            module_detail.add(detail);
            displayResult();
        }else if (e.getSource()==btn_refresh){
            txt_moduleid.setText("");
            txt_leaderid.setText("");
            txt_modulename.setText("");
            txt_credit.setText("");
        }else if (e.getSource()==btn_delete){
            try {
                Database db = new Database();

                String query = "Delete from module where module_name ='" + txt_modulename.getText() + "'";
                int i = table.getSelectedRow();
//               int choice = JOptionPane.showConfirmDialog(book, "Do you want to delete this data?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
                if (i >= 0) {
                    dtm.removeRow(i);
                    JOptionPane.showMessageDialog(null, "Data Deleted Successfully");
                    db.delete(query);
                    displayResult();
                }
            }catch (IndexOutOfBoundsException exception){
                exception.printStackTrace();
            }
        }else if (e.getSource()==btn_update) {
            try {
                Database db = new Database();
                String query = "Update event SET module_id='"+txt_moduleid.getText()+"',leader_id='"+txt_leaderid.getText()+"',module_name='"+txt_modulename.getText()+"'," +
                        "credit='"+txt_credit.getText()+"' where module_id='"+txt_moduleid.getText()+"'";

                int i = table.getSelectedRow();

                dtm.setValueAt(txt_moduleid.getText(), i, 0);
                dtm.setValueAt(txt_leaderid.getText(), i, 1);
                dtm.setValueAt(txt_modulename.getText(), i, 2);
                dtm.setValueAt(txt_credit.getText(), i, 3);
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
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
            String query = "Select * from module";
            ResultSet rs = db.select(query);
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] obj = {rs.getString("module_id"), rs.getString("leader_id"), rs.getString("module_name"),rs.getString("credit")};
                dtm.addRow(obj);
            }
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int i = table.getSelectedRow();
        txt_moduleid.setText(dtm.getValueAt(i,0).toString());
        txt_leaderid.setText(dtm.getValueAt(i,1).toString());
        txt_modulename.setText(dtm.getValueAt(i,2).toString());
        txt_credit.setText(dtm.getValueAt(i,3).toString());
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
