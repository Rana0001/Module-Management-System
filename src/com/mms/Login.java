package com.mms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;


public class Login implements ActionListener {
    JFrame frame;
    //    Image img;
    JLabel lbl_username, lbl_password, txt_title, img_lbl;
    JButton btn_login, btn_register;
    JTextField txt_username;
    JPasswordField txt_password;
    Font fn, fn1,fn2;
    ImageIcon img;

    public Login() {
        frame = new JFrame("Login");
        fn = new Font("Cambria", Font.BOLD, 25);
        fn2 = new Font("Cambria", Font.BOLD, 20);

        fn1 = new Font("Cambria", Font.ITALIC, 15);

        // Inserting Icon
        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        frame.setIconImage(icon);



//        txt_title = new JLabel("Login Credentials");
//        txt_title.setFont(fn);
//        txt_title.setForeground(Color.decode("#E9EDF5"));
//        txt_title.setBounds(270, 30, 215, 30);

        lbl_username = new JLabel("User Name");
        lbl_username.setFont(fn1);
        lbl_username.setForeground(Color.decode("#FFFFFF"));
        lbl_username.setBounds(320, 220, 100, 20);

        lbl_password = new JLabel("Password");
        lbl_password.setFont(fn1);
        lbl_password.setForeground(Color.decode("#FFFFFF"));
        lbl_password.setBounds(320, 300, 100, 20);

        txt_username = new JTextField();
        txt_username.setFont(fn2);
        txt_username.setBounds(200, 250, 300, 40);


        txt_password = new JPasswordField();
        txt_password.setFont(fn2);
        txt_password.setBounds(200, 330, 300, 40);




        btn_login = new JButton("Login");
        btn_login.setForeground(Color.decode("#E9EDF5"));
        btn_login.setBackground(Color.decode("#1A2B63"));
        btn_login.addActionListener(this);
        btn_login.setBounds(235, 385, 100, 40);
        frame.add(btn_login);

        btn_register = new JButton("Register");
        btn_register.setForeground(Color.decode("#E9EDF5"));
        btn_register.setBackground(Color.decode("#1A2B63"));
        btn_register.addActionListener(this);
        btn_register.setBounds(375, 385, 100, 40);

        //Inserting Login Icon
        img= new ImageIcon(new ImageIcon("src\\icons\\login_page.png").getImage().getScaledInstance(700, 700, Image.SCALE_SMOOTH));
        img_lbl = new JLabel(img);
        img_lbl.setIcon(img);
        img_lbl.setBounds(0, 0, 700, 700);



        frame.add(btn_register);
//        frame.add(txt_title);
        frame.add(lbl_username);
        frame.add(lbl_password);
        frame.add(txt_password);
        frame.add(txt_username);
        frame.add(img_lbl);
        frame.setLayout(null);
        frame.setSize(700, 700);
        frame.setVisible(true);
        frame.setLocation(400,0);
        frame.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String email = txt_username.getText();
        String password = txt_password.getText();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        if (e.getSource()==btn_login){
            String query = "Select email,password from user where email='"+email+"'and password ='"
                    +password+"'";
            Database db =new Database();
            ResultSet rs= db.select(query);
            try {
                if (email.length()==0 && password.length()==0){
                    JOptionPane.showMessageDialog(btn_login,"Please! Re-enter your information.");
                }else if (rs.next()){
                    JOptionPane.showMessageDialog(btn_login,"Login Successfully.");
                    new Dashboard(user.getEmail());
                    frame.dispose();
                }else{
                    JOptionPane.showMessageDialog(btn_login,"Please! Enter Correct Information.");
                }

            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }else if (e.getSource()==btn_register){
            new Register();
            frame.dispose();
        }
    }
}