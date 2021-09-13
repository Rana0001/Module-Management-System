package Test;


import com.mms.Database;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;


import static org.junit.Assert.*;

public class DatabaseTest {

    @org.junit.Test
    public void test_insert() {
        String first_name = "Test";
        String last_name = "Test";
        Database db = new Database();
        String query = "Insert into user(firstName,lastName) values('" + first_name + "','" + last_name + "')";
        int row = db.insert(query);
        assertEquals(1, row);

    }

    @org.junit.Test
    public void test_delete() {
        Database db = new Database();
        String query = "Delete from user where firstName = 'JUnit_Test'";
        int row = db.delete(query);
        assertEquals(0, row);
    }

    @org.junit.Test
    public void test_update() {
        Database db = new Database();
        String query = "Update user SET firstName = 'JUnit_Test' where firstName = 'Test'";
        int row = db.update(query);
        assertEquals(1, row);
    }

    @org.junit.Test
    public void test_select() throws SQLException {
        String result;
        String first_name = "Rana0001";
        Database db = new Database();
        String query = "Select firstName from user where name='Rana0001'";
        ResultSet rs = db.select(query);
        while (rs.next()) {
            result = rs.getString("email");
            assertEquals(first_name, result);
        }


    }

    @Test
    public void test_login() throws SQLException {
        String email_val;
        String password_val;
        String email = "Rana0001";
        String password = "12345";
        Database db = new Database();
        String query = "Select email,password from user where email='Rana0001' and password = '12345'";
        ResultSet rs = db.select(query);
        while (rs.next()) {
            email_val = rs.getString("email");
            password_val = rs.getString("password");
            assertEquals(email, email_val);
            assertEquals(password, password_val);
        }
    }
}