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

public class Book implements ActionListener, MouseListener {
    JFrame book;
    JLabel book_id,book_name,book_aurthor;
    JTextField txt_bookid,txt_bookname,txt_bookaurthor;
    JPanel leftpanel;
    JButton btn_add,btn_delete,btn_update,btn_refresh;
    Font font,font1,font2;
    JTable table;
    ArrayList<BookDetail> book_detail;
    DefaultTableModel dtm;
    String[] header;
    public Book(){
        book = new JFrame("MANAGE BOOK");
        font = new Font("Cambria",Font.BOLD,20);
        font1 = new Font("Cambria",Font.BOLD,18);
//        font2 = new Font("Cambria",Font.BOLD,18);


        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        book.setIconImage(icon);

        book_id = new JLabel("Book Id");
        book_id.setBounds(135,50,150,30);
        book_id.setForeground(Color.decode("#1A2B63"));
        book_id.setFont(font);
        book.add(book_id);

        txt_bookid = new JTextField();
        txt_bookid.setFont(font1);
        txt_bookid.setBounds(30, 100, 300, 40);
        book.add(txt_bookid);


        book_name = new JLabel("Book Name");
        book_name.setBounds(120,150,150,30);
        book_name.setForeground(Color.decode("#1A2B63"));
        book_name.setFont(font);
        book.add(book_name);

        txt_bookname = new JTextField();
        txt_bookname.setFont(font1);
        txt_bookname.setBounds(30, 200, 300, 40);
        book.add(txt_bookname);

        book_aurthor = new JLabel("Book Author");
        book_aurthor.setBounds(110,250,150,30);
        book_aurthor.setForeground(Color.decode("#1A2B63"));
        book_aurthor.setFont(font);
        book.add(book_aurthor);

        txt_bookaurthor = new JTextField();
        txt_bookaurthor.setFont(font1);
        txt_bookaurthor.setBounds(30, 300, 300, 40);
        book.add(txt_bookaurthor);

        btn_add = new JButton("ADD");
        btn_add.setBounds(30,380,130,40);
        btn_add.setForeground(Color.decode("#E9EDF5"));
        btn_add.setBackground(Color.decode("#1A2B63"));
        btn_add.addActionListener(this);
        book.add(btn_add);

        btn_delete = new JButton("DELETE");
        btn_delete.setBounds(200,380,130,40);
        btn_delete.setBackground(Color.decode("#1A2B63"));
        btn_delete.setForeground(Color.decode("#E9EDF5"));
        btn_delete.addActionListener(this);
        book.add(btn_delete);


        btn_update = new JButton("UPDATE");
        btn_update.setBounds(30,450,130,40);
        btn_update.addActionListener(this);
        btn_update.setForeground(Color.decode("#E9EDF5"));
        btn_update.setBackground(Color.decode("#1A2B63"));
        book.add(btn_update);


        btn_refresh = new JButton("CLEAR");
        btn_refresh.setBounds(200,450,130,40);
        btn_refresh.addActionListener(this);
        btn_refresh.setForeground(Color.decode("#E9EDF5"));
        btn_refresh.setBackground(Color.decode("#1A2B63"));
        book.add(btn_refresh);


        leftpanel = new JPanel();
        leftpanel.setBounds(5,5,350,650);
        leftpanel.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.decode("#1A2B63")));
        leftpanel.setBackground(Color.decode("#E9EDF5"));
        book.add(leftpanel);

        JLabel bookid = new JLabel("Book Id");
        bookid.setBounds(450,40,250,40);
        bookid.setFont(font);
        bookid.setForeground(Color.decode("#E9EDF5"));
        book.add(bookid);

        JLabel bookname = new JLabel("Book Name");
        bookname.setBounds(650,40,250,40);
        bookname.setFont(font);
        bookname.setForeground(Color.decode("#E9EDF5"));
        book.add(bookname);

        JLabel bookauthor = new JLabel("Book Author");
        bookauthor.setBounds(850,40,250,40);
        bookauthor.setFont(font);
        bookauthor.setForeground(Color.decode("#E9EDF5"));
        book.add(bookauthor);
//

        header = new String[]{"Book Id","Book Name","Book Author"};
        table = new JTable();
        table.addMouseListener(this);
        book_detail = new ArrayList<>();
        dtm = new DefaultTableModel(header,0);
        table.setModel(dtm);
        dtm.fireTableDataChanged();
        table.setRowHeight(25);
        table.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.decode("#1A2B63")));
        table.setBounds(400,80,650,400);
        table.setFont(font);
        book.add(table);
        displayResult();

        book.setLayout(null);
        book.setSize(1080, 700);
        book.setVisible(true);
        book.setLocation(200,10);
        book.getContentPane().setBackground(Color.decode("#5375e2"));
        book.setResizable(false);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btn_add) {
//            Database db = new Database();
//            String query = "Insert into user(book_id,book_name,book_author) values('"+book_id+"','"+book_name+"','"+book_author+"')";
//            db.insert(query);

            BookDetail detail = new BookDetail(txt_bookid.getText(), txt_bookname.getText(), txt_bookaurthor.getText());
            book_detail.add(detail);
            displayResult();
        }else if (e.getSource()==btn_refresh){
            txt_bookid.setText("");
            txt_bookname.setText("");
            txt_bookaurthor.setText("");
        }else if (e.getSource()==btn_delete){
           try {
               Database db = new Database();

               String query = "Delete from book where book_name ='" + txt_bookname.getText() + "'";
               int i = table.getSelectedRow();
//               int choice = JOptionPane.showConfirmDialog(book, "Do you want to delete this data?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
               if (i >= 0) {
                   dtm.removeRow(i);
                   JOptionPane.showMessageDialog(book, "Data Deleted Successfully");
                   db.delete(query);
                   displayResult();
               }
           }catch (IndexOutOfBoundsException exception){
               exception.printStackTrace();
           }
        }else if (e.getSource()==btn_update) {
            try {
                Database db = new Database();
                String query = "Update book SET book_id='"+txt_bookid.getText()+"',book_name='"+txt_bookname.getText()+"',book_author='"+txt_bookaurthor.getText()+"' " +
                        "where book_id='"+txt_bookid.getText()+"'";

               int i = table.getSelectedRow();

               dtm.setValueAt(txt_bookid.getText(), i, 0);
               dtm.setValueAt(txt_bookname.getText(), i, 1);
               dtm.setValueAt(txt_bookaurthor.getText(), i, 2);
               JOptionPane.showMessageDialog(book, "Data Updated Successfully");
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
            String query = "Select * from book";
            ResultSet rs = db.select(query);
            dtm.setRowCount(0);
            while (rs.next()) {
                Object[] obj = {rs.getString("book_id"), rs.getString("book_name"), rs.getString("book_author")};
                dtm.addRow(obj);
            }
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int i = table.getSelectedRow();
        txt_bookid.setText(dtm.getValueAt(i,0).toString());
        txt_bookname.setText(dtm.getValueAt(i,1).toString());
        txt_bookaurthor.setText(dtm.getValueAt(i,2).toString());
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
