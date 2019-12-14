package dao;

import model.domain.IUser;
import model.domain.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import utils.Queries;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class UserDaoTest {
//    @Deployment
//    public static JavaArchive createDeployment() {
//        return ShrinkWrap.create(JavaArchive.class)
//                .addClass(UserDao.class)
//                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//    }

    User user = new User();
    UserDao userDao = new UserDao();

    @Test
    public void userExists() throws SQLException {

       // user.setEmail("ziad7777@gmail.com");
        Assert.assertTrue(userDao.userExists("ziad7777@gmail.com"));

    }

    @Test
    public void validLogin() throws SQLException {
        user.setEmail("ziad7777@gmail.com");
        user.setPassword("23456");
        IUser iUser = null;
        Assert.assertTrue(userDao.validLogin(user));


    }

    @Test
    public void createUser() throws SQLException {
        IUser iUser = null;
        user.setEmail("testZiad7777@gmail.com");
        user.setPassword("test23456");
//      userDao.createUser(user);
//      assertNotNull(user);
       // Assert.assertTrue(userDao.createUser();
        //assertEquals("test23456", user.getPassword());

    }
}
