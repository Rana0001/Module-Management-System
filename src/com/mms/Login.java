package com.mms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Login implements ActionListener {
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
        ImageIcon img_login = new ImageIcon("src\\icons\\login.png");


        btn_login = new JButton("Login");
        btn_login.setForeground(Color.decode("#E9EDF5"));
        btn_login.setBackground(Color.decode("#1A2B63"));
        btn_login.addActionListener(this);
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
        frame.setSize(500, 650);
        frame.setVisible(true);
        frame.setLocation(500,50);
        frame.setResizable(false);

    }
    public static void main(String[]Args){

        new Login();
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

                }
                frame.dispose();
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }else if (e.getSource()==btn_register){
            new Register();
            frame.dispose();
    }
    }
}
