package Test;

import com.mms.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void test_FirstName() {
        String first_name = "Nishant";
        User user = new User();
        user.setFirstName("Prashant");
        String val = user.getFirstName();
        assertEquals(first_name,val);
    }


    @Test
    public void test_LastName() {
        String last_name = "Magar";
        User user = new User();
        user.setLastName("Magar");
        String val = user.getLastName();
        assertEquals(last_name,val);
    }


    @Test
    public void test_Email() {
        String email = "Magar";
        User user = new User();
        user.setEmail("Magar");
        String val = user.getEmail();
        assertEquals(email,val);
    }


    @Test
    public void test_Contact() {
        String contact = "981765465";
        User user = new User();
        user.setContact("321651321");
        String val = user.getContact();
        assertEquals(contact,val);
    }

    @Test
    public void test_Password() {
        String password = "pass";
        User user = new User();
        user.setPassword("pass");
        String val = user.getPassword();
        assertEquals(password,val);
    }

    @Test
    public void test_Check() {
        String gender = "Male";
        User user = new User();
        user.setCheck("Female");
        String val = user.getCheck();
        assertEquals(gender,val);
    }

}