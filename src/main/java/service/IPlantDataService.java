package service;

import model.PlantData;
import utils.exceptions.PlantNotFoundException;

import java.sql.SQLException;
import java.text.ParseException;

public interface IPlantDataService {
    PlantData[] serializePlantDataFromJSON(CharSequence data) throws ParseException, PlantNotFoundException, SQLException;
}
