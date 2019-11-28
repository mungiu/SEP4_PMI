package model;

public class PlantProfile implements IPlantProfile{
	private int id;
	private String name;
	private IUser user;
	private SensorBoundaries co2, temperature, humidity, light;

	public PlantProfile() {
	}

	public PlantProfile(int id, String name, IUser user, SensorBoundaries co2, SensorBoundaries temperature,
			SensorBoundaries humidity, SensorBoundaries light) {
		this.id = id;
		this.name = name;
		this.user = user;
		this.co2 = co2;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
	}

	public PlantProfile(String name, IUser user, SensorBoundaries co2, SensorBoundaries temperature,
						SensorBoundaries humidity, SensorBoundaries light) {
		this.name = name;
		this.user = user;
		this.co2 = co2;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
	}


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setUser(IUser user) {
		this.user = user;
	}

	@Override
	public IUser getUser() {
		return user;
	}

	public SensorBoundaries getCo2() {
		return co2;
	}

	public void setCo2(SensorBoundaries co2) {
		this.co2 = co2;
	}

	public SensorBoundaries getTemperature() {
		return temperature;
	}

	public void setTemperature(SensorBoundaries temperature) {
		this.temperature = temperature;
	}

	public SensorBoundaries getHumidity() {
		return humidity;
	}

	public void setHumidity(SensorBoundaries humidity) {
		this.humidity = humidity;
	}

	public SensorBoundaries getLight() {
		return light;
	}

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void setLight(SensorBoundaries light) {
		this.light = light;
	}

}