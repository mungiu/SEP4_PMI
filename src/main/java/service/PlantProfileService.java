package service;

import model.PlantProfile;
import model.PlantProfileList;
import utils.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PlantProfileService implements IPlantProfileService
{
    private Connection connection;

    public PlantProfileService(Connection dbConnection) {
        this.connection = dbConnection;
    }

    /**
     * todo
     */
    @Override
    public PlantProfileList getAllPlantProfiles() throws SQLException {
        return null;
    }

    /**
     * todo
     */
    @Override
    public PlantProfile getPlantProfileById(String plantProfileID) throws SQLException {
        PlantProfile plantProfile = null;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("TODO");

        if (resultSet.next())
        {
            // todo: Implement populatePlantProfile
            // plantProfile = populatePlantProfile(resultSet);
        }

        return plantProfile;
    }

    /**
     * todo
     */
    @Override
    public void createPlantProfile(PlantProfile plantProfile) throws SQLException {
    }

    /**
     * todo
     */
    @Override
    public void updatePlantProfile(PlantProfile plantProfileObj) throws SQLException {
    }

    /**
     * todo
     */
    @Override
    public void deletePlantProfile(String plantProfileID) throws SQLException
    {
        Statement statement = connection.createStatement();
        statement.executeUpdate("TODO");
    }
}
