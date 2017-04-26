package group05.database.models;
public class Location {	
	
	private String locationName;
	private long locationId;

	public Location(String locationName, long locationId) {
		super();
		this.locationName = locationName;
		this.locationId = locationId;
	}

	public Location() {
		super();
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	

}
