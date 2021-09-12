package com.mms;
import java.sql.*;


public class Database {
    Connection myConn;
    Statement st;
    int val;
    ResultSet rows;
    public Database(){
        String url = "jdbc:mysql://localhost:3306/database";
        String user = "root";
        String password = "root";

        try {
            myConn = DriverManager.getConnection(url,user,password);

            if(myConn!=null){
                System.out.println("Connection is Successful!");
            }else{
                System.out.println("There is an error.");
            }
            st = myConn.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int insert(String query){
        try {
            val = st.executeUpdate(query);
        }catch (Exception throwables){
            throwables.printStackTrace();
        }
    return val;


    }
    public ResultSet select(String query) {
        try {
            rows = st.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }
    public static void main(String[]Args){
        new Database();
    }
}
