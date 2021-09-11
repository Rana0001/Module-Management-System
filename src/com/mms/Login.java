package com.mms;

import javax.swing.*;
import java.awt.*;

public class Login {
    JFrame frame;
    //    Image img;
    JLabel lbl_username, lbl_password, txt_title;
    JButton btn_login, btn_register;
    JTextField txt_username;
    JPasswordField txt_password;
    Font fn, fn1;

    public Login() {
        frame = new JFrame("Login");
        fn = new Font("Cambria", Font.BOLD, 25);

        fn1 = new Font("Cambria", Font.ITALIC, 15);

        // Inserting Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        frame.setIconImage(icon);

        txt_title = new JLabel("Login Credentials");
        txt_title.setFont(fn);
        txt_title.setBounds(150, 50, 215, 30);

        lbl_username = new JLabel("User Name");
        lbl_username.setFont(fn1);
        lbl_username.setBounds(210, 100, 100, 20);

        lbl_password = new JLabel("Password");
        lbl_password.setFont(fn1);
        lbl_password.setBounds(210, 200, 100, 20);

        txt_username = new JTextField();
        txt_username.setBounds(150, 130, 210, 40);


        txt_password = new JPasswordField();
        txt_password.setBounds(150, 230, 210, 40);


        btn_login = new JButton("Login");
        btn_login.setForeground(Color.darkGray);
        btn_login.setBackground(Color.CYAN);
        btn_login.setBounds(150, 300, 100, 30);
        frame.add(btn_login);

        btn_register = new JButton("Register");
        btn_register.setForeground(Color.darkGray);
        btn_register.setBackground(Color.CYAN);
        btn_register.setBounds(260, 300, 100, 30);

        frame.add(btn_register);

        frame.getContentPane().setBackground(Color.pink);
        frame.add(txt_title);
        frame.add(lbl_username);
        frame.add(lbl_password);
        frame.add(txt_password);
        frame.add(txt_username);
        frame.setLayout(null);
        frame.setSize(500, 450);
        frame.setVisible(true);
        frame.setLocation(500,200);
        frame.setResizable(false);

    }
    public static void main(String[]Args){
        new Login();
    }
}
