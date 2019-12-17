package utils.exceptions;

public class PlantNotFoundException extends Exception {
    public PlantNotFoundException(){
        super("Device Id is not assigned to any plant");
    }
}
