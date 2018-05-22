package com.app.weather.entities;

/*
 * This class contains the data filenames correspond with the station numbers.
 * Use this class to populate the station name ,state, latitude,longitude  etc.. 
 */
public class LiteIsdHistory {

	
	private String airForceStationId;
	private String wban;
	private String stationName;
	private String fipsCountryId;
	private String state;
	private String latitude;
	private String longitude;
	private String elevation;
	private String beginRecord;
	private String endRecord;
	
	
	public LiteIsdHistory(String airForceStationId, String wban, String stationName, String fipsCountryId, String state,
			String latitude, String longitude, String elevation, String beginRecord, String endRecord) {
		super();
		this.airForceStationId = airForceStationId;
		this.wban = wban;
		this.stationName = stationName;
		this.fipsCountryId = fipsCountryId;
		this.state = state;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
		this.beginRecord = beginRecord;
		this.endRecord = endRecord;
	}
	public String getAirForceStationId() {
		return airForceStationId;
	}
	public void setAirForceStationId(String airForceStationId) {
		this.airForceStationId = airForceStationId;
	}
	public String getWban() {
		return wban;
	}
	public void setWban(String wban) {
		this.wban = wban;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getFipsCountryId() {
		return fipsCountryId;
	}
	public void setFipsCountryId(String fipsCountryId) {
		this.fipsCountryId = fipsCountryId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getElevation() {
		return elevation;
	}
	public void setElevation(String elevation) {
		this.elevation = elevation;
	}
	public String getBeginRecord() {
		return beginRecord;
	}
	public void setBeginRecord(String beginRecord) {
		this.beginRecord = beginRecord;
	}
	public String getEndRecord() {
		return endRecord;
	}
	public void setEndRecord(String endRecord) {
		this.endRecord = endRecord;
	}
	@Override
	public String toString() {
		return "LiteIsdHistory [airForceStationId=" + airForceStationId + ", wban=" + wban + ", stationName="
				+ stationName + ", fipsCountryId=" + fipsCountryId + ", state=" + state + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", elevation=" + elevation + ", beginRecord=" + beginRecord
				+ ", endRecord=" + endRecord + "]";
	}


	
	
}
