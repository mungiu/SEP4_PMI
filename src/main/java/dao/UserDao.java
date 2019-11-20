package dao;

import utils.Database;

public class UserDao {
    private Database db;

    public UserDao() {
        db = Database.getInstance();
    }

}
