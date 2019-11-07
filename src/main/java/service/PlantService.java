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
    private final SimpleDateFormat SDF;
    private IUserService addressService;
    private Connection connection;

    public PlantService(Connection dbConnection) {
        this.SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.addressService = new UserService();
        this.connection = dbConnection;
<<<<<<< HEAD
        this.DB_NAME = Database.getDbNameFromConnection(connection);

=======
>>>>>>> c360db5228cb9fa6f3db46b5b977e47be404da20
    }

    /**
     * Queries a database and returns a specific plant
     *
     * @param Plant_ID of the client to be returned
     * @return client
     */
    public Plant getPlantById(String Plant_ID) throws SQLException {
        Plant plant = null;

        Statement statement = Database.getConnection().createStatement();
<<<<<<< HEAD
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".Users WHERE User_ID = '" + Plant_ID + "';");
=======
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Database.DB_NAME + ".clients WHERE ID_client = '" + plantID + "';");
>>>>>>> c360db5228cb9fa6f3db46b5b977e47be404da20

        if (resultSet.next()) {
            plant = populatePlant(resultSet);
        }

        return plant;
    }

    /**
     * Queries a database and returns list of all clients
     *
     * @return clients
     */
    public PlantList getMyPlants(String User_ID) throws SQLException {
        PlantList plantList = new PlantList();
        Statement statement = Database.getConnection().createStatement();
<<<<<<< HEAD
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + DB_NAME + ".Users;");
=======
        ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Database.DB_NAME + ".clients;");
>>>>>>> c360db5228cb9fa6f3db46b5b977e47be404da20

        while (resultSet.next()) {
            plantList.getClients().add(populatePlant(resultSet));
        }

        return plantList;
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
     * @param Plant_ID clientId of the client to be deleted
     */
    @Override
    public void deletePlant(String Plant_ID) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
<<<<<<< HEAD
        statement.executeUpdate("DELETE FROM " + DB_NAME + ".clients WHERE(User_ID = '" + Plant_ID + "');");
=======
        statement.executeUpdate("DELETE FROM " + Database.DB_NAME + ".clients WHERE(ID_client = '" + plantID + "');");
>>>>>>> c360db5228cb9fa6f3db46b5b977e47be404da20
    }

    /**
     * Updates an existing plant with details from plant object passed into parameter
     *
     * @param plant updated plant
     *              sensorID, name, co2, temperature, humidity, light
     */
    @Override
    public void updatePlant(Plant plant) throws SQLException {
        Statement statement = Database.getConnection().createStatement();
<<<<<<< HEAD
        statement.executeUpdate("UPDATE " + DB_NAME + ".Users SET company_name = '"/* + plant.getCompanyName()
=======
        statement.executeUpdate("UPDATE " + Database.DB_NAME + ".clients SET company_name = '"/* + plant.getCompanyName()
>>>>>>> c360db5228cb9fa6f3db46b5b977e47be404da20
                + "',ID_address= '" + addressService.getUserId(plant.getUser()) + "',email= '" + plant.getEmail()
                + "',tel_no='" + plant.getTelephoneNumber()
                + "',client_type='" + plant.getClientType()*/ + "' WHERE User_ID = " + plant.getId() + ";");
    }
}




