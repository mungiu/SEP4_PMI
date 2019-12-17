package service;

import model.WeeklyPlant;
import model.domain.IPlant;
import utils.exceptions.MissingDataException;

import java.sql.SQLException;
import java.text.ParseException;

public interface IPlantService {
    WeeklyPlant getPlantById(int plantID) throws SQLException;
    void deletePlant(int plantID) throws  SQLException;
    void updatePlant(IPlant plant) throws  SQLException, MissingDataException;
    void createPlant(IPlant plant) throws SQLException, MissingDataException;
}
