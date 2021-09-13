package com.mms;

import javax.swing.*;

public class EventDetails {
    String event_id;
    String event_name;
    String event_date;
    String event_notice;
    public EventDetails(String event_id,String event_name,String event_date,String event_notice){
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.event_notice = event_notice;

        Database db = new Database();
        String query = "Insert into event(event_id,event_name,event_date,event_notice) values('"+this.event_id+"','"+this.event_name+"','"+this.event_date+"','"+this.event_notice+"')";
        int ans = db.insert(query);
        if (ans>0){
            JOptionPane.showMessageDialog(null,"Data Inserted Sucessfully..");
        }

    }}
