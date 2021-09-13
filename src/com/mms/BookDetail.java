package com.mms;

import javax.swing.*;

public class BookDetail {
    String book_id;
    String book_name;
    String book_aurther;

    public BookDetail(String book_id, String book_name, String book_aurther) {
        this.book_id = book_id;
        this.book_name = book_name;
        this.book_aurther = book_aurther;
        try {
            Database db = new Database();
            String query = "Insert into book(book_id,book_name,book_author) values('" + this.book_id + "','" + this.book_name + "','" + this.book_aurther + "')";
            int ans = db.insert(query);
            if (ans > 0) {
                JOptionPane.showMessageDialog(null, "Data Inserted Sucessfully..");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}