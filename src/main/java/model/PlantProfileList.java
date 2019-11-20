package model;

import java.util.ArrayList;
import java.util.List;

public class PlantProfileList {

    private List<IPlantProfile> plantProfiles;

    public PlantProfileList() {
        plantProfiles = new ArrayList<IPlantProfile>();
    }

    public PlantProfileList(List<IPlantProfile> profileList) {
        plantProfiles = profileList;
    }

    public List<IPlantProfile> getPlantProfiles() {
        return plantProfiles;
    }
    public int size(){
        return plantProfiles.size();
    }
    public void addPlantProfile(IPlantProfile profile){
        plantProfiles.add(profile);
    }

}
