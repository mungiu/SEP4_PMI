package model;

import java.util.ArrayList;
import java.util.List;

public class PlantList
{
    private List<Plant> clients;

    public PlantList() {
        clients = new ArrayList<>();
    }

    public List<Plant> getClients() {
        return clients;
    }
}