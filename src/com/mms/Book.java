package com.mms;

import javax.swing.*;
import java.awt.*;

public class Book {
    JFrame book;
    JLabel book_id,book_name,book_aurthor;
    JTextField txt_bookid,txt_bookname,txt_bookaurthor;
    JPanel leftpanel;
    JButton btn_add,btn_delete,btn_update,btn_refresh;
    Font font,font1;
    public Book(){
        book = new JFrame("MANAGE BOOK");
        font = new Font("Cambria",Font.BOLD,20);
        font1 = new Font("Cambria",Font.BOLD,18);


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

        book_aurthor = new JLabel("Book Aurthor");
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
        book.add(btn_add);

        btn_delete = new JButton("DELETE");
        btn_delete.setBounds(200,380,130,40);
        book.add(btn_delete);


        btn_update = new JButton("UPDATE");
        btn_update.setBounds(30,450,130,40);
        book.add(btn_update);


        btn_refresh = new JButton("REFRESH");
        btn_refresh.setBounds(200,450,130,40);
        book.add(btn_refresh);


        leftpanel = new JPanel();
        leftpanel.setBounds(5,5,350,650);
        leftpanel.setBorder(BorderFactory.createMatteBorder(8,8,8,8,Color.decode("#1A2B63")));
        leftpanel.setBackground(Color.decode("#E9EDF5"));
        book.add(leftpanel);


        book.setLayout(null);
        book.setSize(1080, 700);
        book.setVisible(true);
        book.setLocation(200,10);
        book.getContentPane().setBackground(Color.decode("#5375e2"));
        book.setResizable(false);




    }
    public static void main(String[]Args){
        new Book();
    }
}
