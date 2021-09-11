package com.mms;

import javax.swing.*;
import java.awt.*;

public class Register {
    JFrame register;
    JLabel lbl_heading,lbl_subheading, lbl_fname, lbl_lname, lbl_email, lbl_pass, lbl_cpass,lbl_contact;
    JButton btn_register, btn_cancel;
    JTextField txt_fname, txt_lnamae, txt_email,txt_contact;
    JPasswordField password, confirmpass;
    Font fon1, fon2;
    public Register() {
        register = new JFrame(" Registration ");
        fon1 = new Font("Cambria", Font.BOLD, 22);
        fon2 = new Font("Cambria", Font.BOLD, 15);
        lbl_subheading = new JLabel("Complete Your Information");
        lbl_subheading.setForeground(Color.decode("#E9EDF5"));
        lbl_subheading.setBounds(250, 220, 330, 60);
        lbl_subheading.setFont(fon1);
        register.add(lbl_subheading);

        lbl_heading = new JLabel(" !!! Create Your Account Free !!! ");
        lbl_heading.setForeground(Color.decode("#E9EDF5"));
        lbl_heading.setBounds(220, 20, 330, 60);
        lbl_heading.setFont(fon1);
        register.add(lbl_heading);


        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        register.setIconImage(icon);


        //Inserting Login Icon


//        ImageIcon register_icon = new ImageIcon("src\\icons\\file.png");

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src\\icons\\register.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel register_label = new JLabel(imageIcon);
        register_label.setIcon(imageIcon);
        register_label.setBounds(300,80,200,150);
        register.add(register_label);

        lbl_fname = new JLabel("First Name");
        lbl_fname.setFont(fon2);
        lbl_fname.setForeground(Color.decode("#E9EDF5"));
        lbl_fname.setBounds(160, 270, 150, 60);
        register.add(lbl_fname);

        // text field
        txt_fname = new JTextField();
        txt_fname.setFont(fon1);
        txt_fname.setBounds(100, 320, 220, 30);
        register.add(txt_fname);

        lbl_lname = new JLabel("Last Name");
        lbl_lname.setFont(fon2);
        lbl_lname.setForeground(Color.decode("#E9EDF5"));
        lbl_lname.setBounds(520, 270, 150, 60);
        register.add(lbl_lname);

        // text field
        txt_lnamae = new JTextField();
        txt_lnamae.setFont(fon1);
        txt_lnamae.setBounds(450, 320, 220, 30);
        register.add(txt_lnamae);

        lbl_email = new JLabel("Email");
        lbl_email.setForeground(Color.decode("#E9EDF5"));
        lbl_email.setFont(fon2);
        lbl_email.setBounds(170, 350, 150, 60);
        register.add(lbl_email);

        // text field
        txt_email = new JTextField();
        txt_email.setFont(fon1);
        txt_email.setBounds(100, 400, 220, 30);
        register.add(txt_email);

        lbl_contact = new JLabel("Contact No");
        lbl_contact.setForeground(Color.decode("#E9EDF5"));
        lbl_contact.setFont(fon2);
        lbl_contact.setBounds(520, 350, 150, 60);
        register.add(lbl_contact);

        // text field
        txt_contact = new JTextField();
        txt_contact.setFont(fon1);
        txt_contact.setBounds(450, 400, 220, 30);
        register.add(txt_contact);



        // Password
        lbl_pass = new JLabel("Password");
        lbl_pass.setForeground(Color.decode("#E9EDF5"));
        lbl_pass.setFont(fon2);
        lbl_pass.setBounds(160, 430, 150, 60);
        register.add(lbl_pass);

        password = new JPasswordField();
        password.setFont(fon1);
        password.setBounds(100, 480, 220, 30);
        register.add(password);
        //Confirm Password

        lbl_cpass = new JLabel("Confirm Password");
        lbl_cpass.setForeground(Color.decode("#E9EDF5"));
        lbl_cpass.setFont(fon2);
        lbl_cpass.setBounds(500, 430, 150, 60);
        register.add(lbl_cpass);

        confirmpass = new JPasswordField();
        confirmpass.setFont(fon1);
        confirmpass.setBounds(450, 480, 220, 30);
        register.add(confirmpass);

        btn_register = new JButton("Submit");
        btn_register.setFont(fon2);
        btn_register.setBounds(280, 540, 100, 50);
        register.add(btn_register);

        btn_cancel = new JButton("Quit");
        btn_cancel.setFont(fon2);
        btn_cancel.setBounds(420, 540, 100, 50);
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
