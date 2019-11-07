package service;

import model.User;
import model.PlantProfile;
import model.PlantProfileList;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.Database.DB_NAME;


public class PlantProfileService implements IPlantProfileService
{
    private final SimpleDateFormat SDF;
    private IUserService addressService;

    private Connection connection;

    public PlantProfileService(Connection dbConnection) {
        this.SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.addressService = new UserService();
        this.connection = dbConnection;
    }

    /**
     * Queries a database and returns a PlantProfile
     *
     * @param    Profile_ID of the PlantProfile to be returned
     * @return plantProfile
     */
    @Override
    public PlantProfile getPlantProfileById(String Profile_ID) throws SQLException
    {
        PlantProfile plantProfile = null;

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".plantProfile WHERE User_ID = '" + Profile_ID + "';");

        if (resultSet.next())
        {
            plantProfile = populatePlantProfile(resultSet);
        }

        return plantProfile;
    }

    /**
     * Queries a database and returns a ProfileList of all profile related to a user with the User_ID passed
     * in as a parameter. It checks for a clientType and selects a right query to use.
     *
     *
     * @return profiles
     */
    @Override
    public PlantProfileList getMyPlantProfiles(String User_ID) throws SQLException
    {
        PlantProfileList profiles = new PlantProfileList();

//        String clientType = getClientType(clientId);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet;
//        if (clientType.equals("customer")) {
//            resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".order WHERE ID_company = " + clientId + " ORDER BY pick_up_deadline;");
//        } else {
//            resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME
//                    + ".order AS o WHERE EXISTS(SELECT * FROM "
//                    + DB_NAME + ".takenorders AS o2 WHERE o.ID_order = o2.ID_order AND o2.ID_responsible_company = "+clientId+");");
//        }
//
//        while (resultSet.next())
//        {
//            profiles.getPlantProfiles().add(populatePlantProfile(resultSet));
//        }
//
        return profiles;
    }

    /**
     * Insert a new plantProfile into a database
     *
     * @param plantProfile   to be inserted
     */
    @Override
    public void createPlantProfile(PlantProfile plantProfile) throws SQLException
    {
        Statement statement = connection.createStatement();
      /*  statement.executeUpdate("INSERT INTO " + DB_NAME + ".PlantProfile VALUES (NULL,"
                + addressService.(plantProfile.getPickUpUser()) + ","
                + addressService.getUserId(plantProfile.getDropOffUser())
                + "," + plantProfile.getCompanyID()
                + ",'" + SDF.format(plantProfile.getPickUpDeadline())
                + "','" + SDF.format(plantProfile.getDropOffDeadline())
               + "'," + plantProfile.getPrice()
                + ",'" + plantProfile.getContentDescription()
                + "','" + plantProfile.getSize()
                + "'," + plantProfile.getWeight()
                + ",'" + plantProfile.getContainerSize()
             + "','" + plantProfile.getDistance() + "');");*/
    }

    /**
     * Updates an existing order with details from orderObj
     *
     * @param plantProfileObj      updated object
     */
    @Override
    public void updatePlantProfile(PlantProfile plantProfileObj) throws SQLException
    {
//        Statement statement = connection.createStatement();
//        statement.executeUpdate("UPDATE " + DB_NAME + ".order SET pick_up_address= '"/*
//                + addressService.getUserId(plantProfileObj.getPickUpUser())
//                + "',drop_off_address= '" + addressService.getUserId(plantProfileObj.getDropOffUser())*/
//                + "',pick_up_deadline= '" + SDF.format(plantProfileObj.getPickUpDeadline())
//                + "',drop_off_deadline= '" + SDF.format(plantProfileObj.getDropOffDeadline())
//                + "',price= '" + plantProfileObj.getPrice()
//                + "',description= '" + plantProfileObj.getContentDescription()
//                + "',`size` = '" + plantProfileObj.getSize()
//                + "',weight= '" + plantProfileObj.getWeight()
//                + "',container_size= '" + plantProfileObj.getContainerSize()
//                + "',distance= '" + plantProfileObj.getDistance() + "' WHERE ID_order ="+ plantProfileObj.getOrderNumber()+";");
//
//        statement.executeUpdate(" UPDATE " + DB_NAME + ".takenorders SET awaiting_pick_up = " + plantProfileObj.isAwaitingPickUp()
//                + ", picked_up = " + plantProfileObj.isPickedUp() + ", delivered = " + plantProfileObj.isDelivered()
//                + ", late_delivery = " + plantProfileObj.isLateDelivery()
//                + " WHERE ID_order = " + plantProfileObj.getOrderNumber() + ";");
    }

    /**
     * Deletes a plant
     *
     * @param Profile_ID       Profile_ID  to be deleted
     */
    @Override
    public void deletePlantProfile(String Profile_ID) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM " + DB_NAME + ".PlantProfile WHERE ID_order = '" + Profile_ID
                + "';");
        statement.executeUpdate("DELETE FROM " + DB_NAME + ".PlantProfile WHERE ID_order = '" + Profile_ID + "';");
    }

    /**
     * Initializes an Order object from the ResultSet and returns it
     *
     * @param resultSet         resultSet from database query
     * @return plantProfile
     */
    private PlantProfile populatePlantProfile(ResultSet resultSet) throws SQLException
    {
        Date pickUpDate = null;
        Date dropOffDate = null;

        try {
            pickUpDate = SDF.parse(resultSet.getString("pick_up_deadline"));
            dropOffDate = SDF.parse(resultSet.getString("drop_off_deadline"));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Couldn't parse SimpleDateFormat object in GetOrders() method.");
        }

     //   User user = addressService.getPlantProfileById(resultSet.getInt("pick_up_address"));
    //    User dropOffUser = addressService.getUserById(resultSet.getInt("drop_off_address"));

        PlantProfile plantProfile = new PlantProfile(

                /*
                resultSet.getString("ID_order"),
                resultSet.getString("ID_company"),
                pickUpUser,
                pickUpDate,
                dropOffUser,
                dropOffDate,
                resultSet.getString("description"),
                resultSet.getString("container_size"),
                resultSet.getDouble("weight"),
                resultSet.getString("size"),
                resultSet.getDouble("price"),
                false,
                false,
                false,
                false,
                resultSet.getDouble("distance")*/

        );
        Statement statement = connection.createStatement();

//        resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".takenorders WHERE ID_order = " + plantProfile.getOrderNumber() + ";");

        if(resultSet.next())
        {
//            plantProfile = populateOrderWithStatus(plantProfile,resultSet);
        }
        return plantProfile;
    }
}
