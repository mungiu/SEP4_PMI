package service;

import model.PlantData;

import java.text.ParseException;

public interface IPlantDataService {
    PlantData[] serializePlantDataFromJSON(CharSequence data) throws ParseException;
}
