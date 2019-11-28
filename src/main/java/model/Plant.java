package model;

public class Plant implements IPlant{

	private String deviceId;
	private String plantName;
	private IPlantProfile plantProfile;
	// TODO: Don't we need interface for the PlantData class just as we have it for the PlantProfile?
	// TODO: Do we even need to have PlantData inside of the Plant class?
	private PlantData co2, humidity, temperature, light;

	public String getDeviceId() { return deviceId; }

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getPlantName() {
		return plantName;
	}

	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}

	public IPlantProfile getPlantProfile() {
		return plantProfile;
	}

	public void setPlantProfile(IPlantProfile plantProfile) {
		this.plantProfile = plantProfile;
	}

	@Override
	public PlantData getCo2() {
		return co2;
	}

	@Override
	public void setCo2(PlantData co2) {
		this.co2 = co2;
	}

	@Override
	public PlantData getHumidity() {
		return humidity;
	}

	@Override
	public void setHumidity(PlantData humidity) {
		this.humidity = humidity;
	}

	@Override
	public PlantData getTemperature() {
		return temperature;
	}

	@Override
	public void setTemperature(PlantData temperature) {
		this.temperature = temperature;
	}

	@Override
	public PlantData getLight() {
		return light;
	}

	@Override
	public void setLight(PlantData light) {
		this.light = light;
	}

	public Plant() { }

	public Plant(String deviceId, String plantName, IPlantProfile plantProfile, PlantData co2, PlantData temperature, PlantData humidity, PlantData light) {
		this.deviceId = deviceId;
		this.plantName = plantName;
		this.plantProfile = plantProfile;
		this.co2 = co2;
		this.temperature = temperature;
		this.humidity = humidity;
		this.light = light;
	}

	public Plant(String plantName, IPlantProfile plantProfile) {
		this.plantName = plantName;
		this.plantProfile = plantProfile;
	}

	public Plant(String deviceId, String plantName, IPlantProfile plantProfile) {
		this.deviceId = deviceId;
		this.plantName = plantName;
		this.plantProfile = plantProfile;
	}
}