import org.junit.Before;
import org.junit.Test;
import service.IUserService;
import service.UserService;

import java.sql.SQLException;
import java.text.ParseException;

public class UserServiceTest {

    IUserService userService;

    @Before
    public void setup(){
        userService = new UserService();
    }

    @Test
    public void testGetUser(){
        try {
            userService.getUserById("naya7777@gmail.com");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }



}
