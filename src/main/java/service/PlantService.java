package service;

import model.Plant;
import model.PlantList;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class PlantService implements IPlantService {
    private static String DB_NAME;
    private final SimpleDateFormat SDF;
    private IUserService addressService;
    private Connection connection;

    public PlantService(Connection dbConnection) {
        this.SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.addressService = new UserService();
        this.connection = dbConnection;
        this.DB_NAME = Database.getDbNameFromConnection(connection);
    }

    /**
     * Queries a database and returns a specific client
     *
     * @param plantID of the client to be returned
     * @return client
     */
    public Plant getPlantById(String plantID) throws SQLException {
        Plant client = null;

        Statement statement = Database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".clients WHERE ID_client = '" + plantID + "';");

        if (resultSet.next()) {
            client = populatePlant(resultSet);
        }

        return client;
    }

    /**
     * Queries a database and returns list of all clients
     *
     * @return clients
     */
    public PlantList getMyPlants(String userID) throws SQLException {
        PlantList clients = new PlantList();
        Statement statement = Database.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".clients;");

        while (resultSet.next()) {
            clients.getClients().add(populatePlant(resultSet));
        }

        return clients;
    }

    /**
     * Inserts a new client to a database
     *
     * @param plant client to be inserted
     */
    public void createPlant(Plant plant) throws SQLException {
//        Statement statement = Database.getConnection().createStatement();
//        plant.setClientType(plant.getClass() == Contractor.class ? "contractor" : "customer");
//        statement.executeUpdate("INSERT INTO " + DB_NAME + ".clients VALUES (null,"
//                + addressService.getAddressId(plant.getUserProfile())
//                + ",'"+ plant.getCompanyName() + "','" + plant.getEmail() + "','" + plant.getTelephoneNumber()
//                + "','" + plant.getClientType() + "','" + plant.getPasswordHash()+"');");
    }

    /**
     * Initializes a Contractor or Customer object (based on the clientType attribute) from the ResultSet and returns it
     *
     * @param resultSet resultSet from database query
     * @return client
     */
    public Plant populatePlant(ResultSet resultSet) throws SQLException {
        Plant plant = new Plant().populateFromResultSet(resultSet, addressService);
        return plant;
    }

    /**
     * Deletes a client
     *
     * @param plantID clientId of the client to be deleted
     */
    @Override
    public void deletePlant(String plantID) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        statement.executeUpdate("DELETE FROM " + DB_NAME + ".clients WHERE(ID_client = '" + plantID + "');");
    }

    /**
     * Updates an existing client with details from client object passed into parameter
     *
     * @param plant updated client
     */
    @Override
    public void updatePlant(Plant plant) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
        statement.executeUpdate("UPDATE " + DB_NAME + ".clients SET company_name = '"/* + plant.getCompanyName()
                + "',ID_address= '" + addressService.getUserId(plant.getUser()) + "',email= '" + plant.getEmail()
                + "',tel_no='" + plant.getTelephoneNumber()
                + "',client_type='" + plant.getClientType()*/ + "' WHERE ID_client = " + plant.getUserID() + ";");
    }
}




