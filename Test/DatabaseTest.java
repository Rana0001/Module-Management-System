package Test;


import com.mms.Database;

import java.sql.ResultSet;
import java.sql.SQLException;


import static org.junit.Assert.*;

public class DatabaseTest {

    @org.junit.Test
    public void test_insert() {
        String first_name = "Test";
        String last_name = "Test";
        Database db = new Database();
        String query = "Insert into user(firstName,lastName) values('"+first_name+"','"+last_name+"')";
        int row = db.insert(query);
        assertEquals(1,row);

    }

    @org.junit.Test
    public void test_delete() {
        Database db = new Database();
        String query = "Delete from user where firstName = 'JUnit_Test'";
        int row = db.delete(query);
        assertEquals(0,row);
    }

    @org.junit.Test
    public void test_update() {
        Database db = new Database();
        String query = "Update user SET firstName = 'JUnit_Test' where firstName = 'Test'";
        int row = db.update(query);
        assertEquals(1,row);
    }

    @org.junit.Test
    public void test_select() throws SQLException {
        String result;
        String email = "Rana0001";
        Database db = new Database();
        String query = "Select email from user where email='Rana0001'";
        ResultSet rs = db.select(query);
        while (rs.next()){
            result = rs.getString("email");
            assertEquals(email,result);
        }

    }
}