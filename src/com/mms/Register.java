package com.mms;

import javax.swing.*;
import java.awt.*;

public class Register {
    JFrame register;
    JLabel lbl_heading, lbl_fname, lbl_lname, lbl_email, lbl_pass, lbl_cpass;
    JButton btn_register, btn_cancel;
    JTextField txt_fname, txt_lnamae, txt_email;
    JPasswordField pw, cpw;
    Font fon1, fon2;
    public Register() {
        register = new JFrame(" registration page");
        fon1 = new Font("Cambria", Font.BOLD, 22);
        fon2 = new Font("Cambria", Font.BOLD, 15);
        lbl_heading = new JLabel("Register Your New Account");
        lbl_heading.setForeground(Color.gray);
        lbl_heading.setBounds(70, 10, 330, 60);
        lbl_heading.setFont(fon1);
        register.add(lbl_heading);

        lbl_fname = new JLabel("First Name");
        lbl_fname.setForeground(Color.gray);
        lbl_fname.setFont(fon2);
        lbl_fname.setBounds(30, 60, 150, 60);
        register.add(lbl_fname);

        // text field
        txt_fname = new JTextField();
        txt_fname.setFont(fon1);
        txt_fname.setBounds(200, 65, 250, 50);
        register.add(txt_fname);

        lbl_lname = new JLabel("Last Name");
        lbl_lname.setForeground(Color.gray);
        lbl_lname.setFont(fon2);
        lbl_lname.setBounds(30, 120, 150, 60);
        register.add(lbl_lname);

        // text field
        txt_lnamae = new JTextField();
        txt_lnamae.setFont(fon1);
        txt_lnamae.setBounds(200, 125, 250, 50);
        register.add(txt_lnamae);

        lbl_email = new JLabel("Email");
        lbl_email.setForeground(Color.gray);
        lbl_email.setFont(fon2);
        lbl_email.setBounds(30, 180, 150, 60);
        register.add(lbl_email);

        // text field
        txt_email = new JTextField();
        txt_email.setFont(fon1);
        txt_email.setBounds(200, 185, 250, 50);
        register.add(txt_email);

        // Password
        lbl_pass = new JLabel("Password");
        lbl_pass.setForeground(Color.gray);
        lbl_pass.setFont(fon2);
        lbl_pass.setBounds(30, 240, 150, 60);
        register.add(lbl_pass);

        pw = new JPasswordField();
        pw.setFont(fon1);
        pw.setBounds(200, 245, 250, 50);
        register.add(pw);
        // Password
        lbl_cpass = new JLabel("Confirm Password");
        lbl_cpass.setForeground(Color.gray);
        lbl_cpass.setFont(fon2);
        lbl_cpass.setBounds(30, 300, 150, 60);
        register.add(lbl_cpass);
        cpw = new JPasswordField();
        cpw.setFont(fon1);
        cpw.setBounds(200, 305, 250, 50);
        register.add(cpw);

        btn_register = new JButton("Submit");
        btn_register.setFont(fon2);
        btn_register.setBounds(220, 370, 100, 30);
        register.add(btn_register);

        btn_cancel = new JButton("Quit");
        btn_cancel.setFont(fon2);
        btn_cancel.setBounds(340, 370, 100, 30);
        register.add(btn_cancel);


        register.setLayout(null);
        register.setSize(800, 640);
        register.setVisible(true);
        register.setLocation(500,50);
        register.getContentPane().setBackground(Color.decode("#5375e2"));
        register.setResizable(false);

    }
    public static void main(String[]Args){
        new Register();
    }
}
