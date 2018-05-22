package com.app.weather.entities;

/*
 * This is the base class for holding all the LITE NOAA Weather data elements
 */
public class WeatherLiteData implements Comparable<WeatherLiteData>{

	private String stationName;
	private int year;
	private int month;
	private int day;
	private int hour;
	private int airTemperature;
	private int dewPointTemperature;
	private int seaLevelPreasure;
	private int windDirection;
	private int windSpeedRate;
	private int skyConditionCovCode;
	private int liquidPrecipitationHourly;
	private int liquidPrecipitationSixHour;
	
	
	
	public WeatherLiteData(int year, int month, int day, int hour, int airTemperature, int dewPointTemperature,
			int seaLevelPreasure, int windDirection, int windSpeedRate, int skyConditionCovCode,
			int liquidPrecipitationHourly, int liquidPrecipitationSixHour, String stationName) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.airTemperature = airTemperature;
		this.dewPointTemperature = dewPointTemperature;
		this.seaLevelPreasure = seaLevelPreasure;
		this.windDirection = windDirection;
		this.windSpeedRate = windSpeedRate;
		this.skyConditionCovCode = skyConditionCovCode;
		this.liquidPrecipitationHourly = liquidPrecipitationHourly;
		this.liquidPrecipitationSixHour = liquidPrecipitationSixHour;
		this.stationName = stationName;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getAirTemperature() {
		return airTemperature;
	}
	public void setAirTemperature(int airTemperature) {
		this.airTemperature = airTemperature;
	}
	public int getDewPointTemperature() {
		return dewPointTemperature;
	}
	public void setDewPointTemperature(int dewPointTemperature) {
		this.dewPointTemperature = dewPointTemperature;
	}
	public int getSeaLevelPreasure() {
		return seaLevelPreasure;
	}
	public void setSeaLevelPreasure(int seaLevelPreasure) {
		this.seaLevelPreasure = seaLevelPreasure;
	}
	public int getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(int windDirection) {
		this.windDirection = windDirection;
	}
	public int getWindSpeedRate() {
		return windSpeedRate;
	}
	public void setWindSpeedRate(int windSpeedRate) {
		this.windSpeedRate = windSpeedRate;
	}
	public int getSkyConditionCovCode() {
		return skyConditionCovCode;
	}
	public void setSkyConditionCovCode(int skyConditionCovCode) {
		this.skyConditionCovCode = skyConditionCovCode;
	}
	public int getLiquidPrecipitationHourly() {
		return liquidPrecipitationHourly;
	}
	public void setLiquidPrecipitationHourly(int liquidPrecipitationHourly) {
		this.liquidPrecipitationHourly = liquidPrecipitationHourly;
	}
	public int getLiquidPrecipitationSixHour() {
		return liquidPrecipitationSixHour;
	}
	public void setLiquidPrecipitationSixHour(int liquidPrecipitationSixHour) {
		this.liquidPrecipitationSixHour = liquidPrecipitationSixHour;
	}

	@Override
	public String toString() {
		return "WeatherLiteData [stationName=" + stationName + ", year=" + year + ", month=" + month + ", day=" + day
				+ ", hour=" + hour + ", airTemperature=" + airTemperature + ", dewPointTemperature="
				+ dewPointTemperature + ", seaLevelPreasure=" + seaLevelPreasure + ", windDirection=" + windDirection
				+ ", windSpeedRate=" + windSpeedRate + ", skyConditionCovCode=" + skyConditionCovCode
				+ ", liquidPrecipitationHourly=" + liquidPrecipitationHourly + ", liquidPrecipitationSixHour="
				+ liquidPrecipitationSixHour + "]";
	}

	@Override
	public int compareTo(WeatherLiteData o) {
		
		
	    int deptComp = this.getStationName().compareTo(o.getStationName());


		if(deptComp == 0) {
			
			if(this.getYear() > o.getYear()) {
				return -1;
			}else {
				//need shuffle
				return 1;

			}
			
		}
		
		return -1;

		
	}
	
	


	
}
