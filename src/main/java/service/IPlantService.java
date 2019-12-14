package service;

import model.domain.IPlant;
import utils.exceptions.MissingDataException;

import java.sql.SQLException;

public interface IPlantService {
    IPlant getPlantById(int plantID) throws SQLException;
    void deletePlant(int plantID) throws  SQLException;
    void updatePlant(IPlant plant) throws  SQLException, MissingDataException;
    void createPlant(IPlant plant) throws SQLException, MissingDataException;
}
