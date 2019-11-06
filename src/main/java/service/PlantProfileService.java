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


public class PlantProfileService implements IPlantProfileService
{
    private static String DB_NAME;
    private final SimpleDateFormat SDF;
    private IUserService addressService;
    private Connection connection;

    public PlantProfileService(Connection dbConnection) {
        this.SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.addressService = new UserService();
        this.connection = dbConnection;
        this.DB_NAME = Database.getDbNameFromConnection(connection);
    }

    /**
     * Queries a database and returns a specific order
     *
     * @param plantProfileID   of the order to be returned
     * @return order
     */
    @Override
    public PlantProfile getPlantProfileById(String plantProfileID) throws SQLException
    {
        PlantProfile plantProfile = null;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".order WHERE ID_order = '" + plantProfileID + "';");

        if (resultSet.next())
        {
            plantProfile = populatePlantProfile(resultSet);
        }

        return plantProfile;
    }

    /**
     * Queries a database and returns an OrderList of all orders related to a client with the clientId passed
     * in as a parameter. It checks for a clientType and selects a right query to use.
     *
     * For customer clientType it returns all orders created by a customer
     * For contractor clientType it returns all orders accepted by a contractor
     *
     * @return orders
     */
    @Override
    public PlantProfileList getMyPlantProfiles(String userID) throws SQLException
    {
        PlantProfileList orders = new PlantProfileList();
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
//            orders.getPlantProfiles().add(populatePlantProfile(resultSet));
//        }
//
        return orders;
    }

    /**
     * Insert a new order into a database
     *
     * @param plantProfile     order to be inserted
     */
    @Override
    public void createPlantProfile(PlantProfile plantProfile) throws SQLException
    {
//        Statement statement = connection.createStatement();
//        statement.executeUpdate("INSERT INTO " + DB_NAME + ".order VALUES (NULL,"/*
//                + addressService.getUserId(plantProfile.getPickUpUser()) + ","
//                + addressService.getUserId(plantProfile.getDropOffUser())*/
//                + "," + plantProfile.getCompanyID()
//                + ",'" + SDF.format(plantProfile.getPickUpDeadline())
//                + "','" + SDF.format(plantProfile.getDropOffDeadline())
//                + "'," + plantProfile.getPrice()
//                + ",'" + plantProfile.getContentDescription()
//                + "','" + plantProfile.getSize()
//                + "'," + plantProfile.getWeight()
//                + ",'" + plantProfile.getContainerSize()
//                + "','" + plantProfile.getDistance() + "');");
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
     * Deletes an order
     *
     * @param plantProfileID       orderNumber of the order to be deleted
     */
    @Override
    public void deletePlantProfile(String plantProfileID) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("DELETE FROM " + DB_NAME + ".takenorders WHERE ID_order = '" + plantProfileID
                + "';");
        statement.executeUpdate("DELETE FROM " + DB_NAME + ".order WHERE ID_order = '" + plantProfileID + "';");
    }

    /**
     * Initializes an Order object from the ResultSet and returns it
     *
     * @param resultSet         resultSet from database query
     * @return order
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

        User pickUpUser = addressService.getUserById(resultSet.getInt("pick_up_address"));
        User dropOffUser = addressService.getUserById(resultSet.getInt("drop_off_address"));

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
