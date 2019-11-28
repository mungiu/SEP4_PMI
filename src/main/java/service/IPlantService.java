package service;

import model.domain.IPlant;
import utils.exceptions.MissingDataException;

import java.sql.SQLException;

public interface IPlantService {
    IPlant getPlantById(String plantID) throws SQLException;
    void deletePlant(String plantID) throws  SQLException;
    void updatePlant(IPlant plant) throws  SQLException, MissingDataException;
    void createPlant(IPlant plant) throws SQLException, MissingDataException;
}
