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

        //Inserting Login Icon
        ImageIcon login_icon = new ImageIcon("src\\icons\\login_icon.png");
        JLabel login_label = new JLabel(login_icon);
        login_label.setBounds(150,100,250,150);
        frame.add(login_label);


        txt_title = new JLabel("Login Credentials");
        txt_title.setFont(fn);
        txt_title.setForeground(Color.decode("#E9EDF5"));
        txt_title.setBounds(160, 50, 215, 30);

        lbl_username = new JLabel("User Name");
        lbl_username.setFont(fn1);
        lbl_username.setForeground(Color.decode("#E9EDF5"));
        lbl_username.setBounds(210, 250, 100, 20);

        lbl_password = new JLabel("Password");
        lbl_password.setFont(fn1);
        lbl_password.setForeground(Color.decode("#E9EDF5"));
        lbl_password.setBounds(210, 350, 100, 20);

        txt_username = new JTextField();
        txt_username.setBounds(150, 280, 210, 40);


        txt_password = new JPasswordField();
        txt_password.setBounds(150, 380, 210, 40);

        // Inserting Image on Button


        btn_login = new JButton("Login");
        btn_login.setForeground(Color.decode("#E9EDF5"));
        btn_login.setBackground(Color.decode("#1A2B63"));
        btn_login.setBounds(150, 450, 100, 40);
        frame.add(btn_login);

        btn_register = new JButton("Register");
        btn_register.setForeground(Color.decode("#E9EDF5"));
        btn_register.setBackground(Color.decode("#1A2B63"));
        btn_register.addActionListener(this);
        btn_register.setBounds(260, 450, 100, 40);

        frame.add(btn_register);

        frame.getContentPane().setBackground(Color.decode("#5375e2"));
        frame.add(txt_title);
        frame.add(lbl_username);
        frame.add(lbl_password);
        frame.add(txt_password);
        frame.add(txt_username);
        frame.setLayout(null);
        frame.setSize(500, 600);
        frame.setVisible(true);
        frame.setLocation(500,100);
        frame.setResizable(false);


    }
    public static void main(String[]Args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btn_register){
            new Register();
        }
    }
}
