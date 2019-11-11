package model;

import java.util.ArrayList;
import java.util.List;

public class PlantProfileList {

    private List<PlantProfile> plantProfiles;

    public PlantProfileList() {
        plantProfiles = new ArrayList<PlantProfile>();
    }

    public List<PlantProfile> getPlantProfiles() {
        return plantProfiles;
    }
    public int size(){
        return plantProfiles.size();
    }
    public void addPlantProfile(PlantProfile profile){
        plantProfiles.add(profile);
    }
}
