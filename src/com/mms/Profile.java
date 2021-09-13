package com.mms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profile implements ActionListener {
    JFrame update;
    JLabel lbl_heading,lbl_subheading, lbl_fname, lbl_lname, lbl_email, lbl_pass, lbl_cpass,lbl_contact;
    JButton btn_register, btn_cancel;
    JTextField txt_fname, txt_lname, txt_email,txt_contact;
    JPasswordField password;
    JComboBox check;
    Font fon1, fon2;
    JOptionPane message;
    String username;
    public Profile(String username) {
        this.username = username;
        update = new JFrame(" Update Profile ");
        fon1 = new Font("Cambria", Font.BOLD, 22);
        fon2 = new Font("Cambria", Font.BOLD, 15);
        lbl_subheading = new JLabel("Update Your Information");
        lbl_subheading.setForeground(Color.decode("#E9EDF5"));
        lbl_subheading.setBounds(250, 220, 330, 60);
        lbl_subheading.setFont(fon1);
        update.add(lbl_subheading);

        lbl_heading = new JLabel(" !!! Update Your Account Here !!! ");
        lbl_heading.setForeground(Color.decode("#E9EDF5"));
        lbl_heading.setBounds(220, 20, 330, 60);
        lbl_heading.setFont(fon1);
        update.add(lbl_heading);


        Image icon = Toolkit.getDefaultToolkit().getImage("src\\icons\\books.png");
        update.setIconImage(icon);


        //Inserting Login Icon


//        ImageIcon register_icon = new ImageIcon("src\\icons\\file.png");

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src\\icons\\register.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        JLabel register_label = new JLabel(imageIcon);
        register_label.setIcon(imageIcon);
        register_label.setBounds(300,80,200,150);
        update.add(register_label);

        lbl_fname = new JLabel("First Name");
        lbl_fname.setFont(fon2);
        lbl_fname.setForeground(Color.decode("#E9EDF5"));
        lbl_fname.setBounds(160, 270, 150, 60);
        update.add(lbl_fname);

        // text field
        txt_fname = new JTextField();
        txt_fname.setFont(fon1);
        txt_fname.setBounds(100, 320, 220, 30);
        update.add(txt_fname);

        lbl_lname = new JLabel("Last Name");
        lbl_lname.setFont(fon2);
        lbl_lname.setForeground(Color.decode("#E9EDF5"));
        lbl_lname.setBounds(520, 270, 150, 60);
        update.add(lbl_lname);

        // text field
        txt_lname = new JTextField();
        txt_lname.setFont(fon1);
        txt_lname.setBounds(450, 320, 220, 30);
        update.add(txt_lname);

        lbl_email = new JLabel("Email");
        lbl_email.setForeground(Color.decode("#E9EDF5"));
        lbl_email.setFont(fon2);
        lbl_email.setBounds(170, 350, 150, 60);
        update.add(lbl_email);

        // text field
        txt_email = new JTextField();
        txt_email.setFont(fon1);
//        txt_email.setEditable(false);
        txt_email.setBounds(100, 400, 220, 30);
        update.add(txt_email);

        lbl_contact = new JLabel("Contact No");
        lbl_contact.setForeground(Color.decode("#E9EDF5"));
        lbl_contact.setFont(fon2);
        lbl_contact.setBounds(520, 350, 150, 60);
        update.add(lbl_contact);

        // text field
        txt_contact = new JTextField();
        txt_contact.setFont(fon1);
        txt_contact.setBounds(450, 400, 220, 30);
        update.add(txt_contact);



        // Password
        lbl_pass = new JLabel("Password");
        lbl_pass.setForeground(Color.decode("#E9EDF5"));
        lbl_pass.setFont(fon2);
        lbl_pass.setBounds(160, 430, 150, 60);
        update.add(lbl_pass);

        password = new JPasswordField();
        password.setFont(fon1);
        password.setBounds(100, 480, 220, 30);
        update.add(password);
        //Confirm Password

        lbl_cpass = new JLabel("Gender");
        lbl_cpass.setForeground(Color.decode("#E9EDF5"));
        lbl_cpass.setFont(fon2);
        lbl_cpass.setBounds(530, 430, 150, 60);
        update.add(lbl_cpass);

        String list[]={"Male","Female","Not Specified"};
        check = new JComboBox(list);
        check.setBounds(450,480,220,30);
//        confirmpass = new JPasswordField();
//        confirmpass.setFont(fon1);
//        confirmpass.setBounds(450, 480, 220, 30);
        update.add(check);

        btn_register = new JButton("Submit");
        btn_register.setFont(fon2);
        btn_register.addActionListener(this);
        btn_register.setForeground(Color.decode("#E9EDF5"));
        btn_register.setBackground(Color.decode("#1A2B63"));
        btn_register.setBounds(280, 540, 100, 50);
        update.add(btn_register);

        btn_cancel = new JButton("Quit");
        btn_cancel.setFont(fon2);
        btn_cancel.addActionListener(this);
        btn_cancel.setForeground(Color.decode("#E9EDF5"));
        btn_cancel.setBackground(Color.decode("#1A2B63"));
        btn_cancel.setBounds(420, 540, 100, 50);
        update.add(btn_cancel);
        displayData();

        update.setLayout(null);
        update.setSize(800, 640);
        update.setVisible(true);
        update.setLocation(500,50);
        update.getContentPane().setBackground(Color.decode("#5375e2"));
        update.setResizable(false);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String firstName = txt_fname.getText();
        String lastName = txt_lname.getText();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        String pass = password.getText();
        String gender = check.getSelectedItem().toString();

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setContact(contact);
        user.setPassword(pass);
        user.setCheck(gender);
        if (e.getSource() == btn_register) {
            Database db = new Database();
            String query = "Update user SET firstName='" + user.getFirstName() + "',lastName='" + user.getLastName() + "',email='" + user.getEmail() + "'," +
                    "contact='" + user.getContact() + "',password='" + user.getPassword() + "',gender='" + user.getCheck() + "' where email='" + user.getEmail() + "'";
            db.insert(query);
            JOptionPane.showMessageDialog(update,"Profile Update Successful..");
            update.dispose();

        } else if (e.getSource() == btn_cancel) {
            update.dispose();
        }
    }
     public void displayData() {
         try {
             Database db = new Database();
             String query = "Select * from user where email='" + username + "'";
             ResultSet rs = db.select(query);
             while (rs.next()) {
                txt_fname.setText(rs.getString("firstName"));
                txt_lname.setText(rs.getString("lastName"));
                txt_email.setText(rs.getString("email"));
                txt_contact.setText(rs.getString("contact"));
                password.setText(rs.getString("password"));
                check.setSelectedItem(rs.getString("gender"));
             }
         }catch (SQLException throwables){
             throwables.printStackTrace();
         }
     }

}
