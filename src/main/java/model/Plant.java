package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import service.IUserService;

import java.sql.ResultSet;
import java.sql.SQLException;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "clientType")

public class Plant {
    private String userID;
    private String passwordHash;

    public Plant() {
    }

    public Plant(String userID) {
        this.userID = userID;
    }

    public Plant populateFromResultSet(ResultSet resultSet, IUserService addressService) throws SQLException {
        Plant plant = new Plant(
                resultSet.getString("ID_client")
        );

        return plant;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}