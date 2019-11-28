package model;

import model.domain.IPlant;

import java.util.ArrayList;
import java.util.List;

public class PlantList
{
    private List<IPlant> plants;

    public PlantList() {
        plants = new ArrayList<>();
    }

    public PlantList(List<IPlant> plants){
        this.plants = plants;
    }

    public List<IPlant> getClients() {
        return plants;
    }
    public IPlant getPlant(int index){
        return plants.get(index);
    }
    public int size(){
        return plants.size();

    }
    public void addPlant(IPlant plant){
        plants.add(plant);
    }
}