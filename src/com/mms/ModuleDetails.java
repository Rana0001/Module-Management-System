package com.mms;

import javax.swing.*;

public class ModuleDetails {
    String module_id;
    String leader_id;
    String module_name;
    String credit;


    public ModuleDetails(String module_id, String leader_id, String module_name, String credit) {
        this.module_id = module_id;
        this.leader_id = leader_id;
        this.module_name = module_name;
        this.credit = credit;
        try {
            Database db = new Database();
            String query = "Insert into module(module_id,leader_id,module_name,credit) values('" + this.module_id + "','" + this.leader_id + "','" + this.module_name + "','" + this.credit + "')";
            int ans = db.insert(query);
            if (ans > 0) {
                JOptionPane.showMessageDialog(null, "Data Inserted Sucessfully..");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}