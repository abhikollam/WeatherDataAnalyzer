package com.app.weather.entities;

import java.util.List;
import java.util.Map;

/*
 * Common entity class holds the common data which needs to be shared across the application
 * It stores the History lookup data for stations and the processing data
 */
public class CommonEntity {

	private String dataProvider;
	private String inputFilePath;
	private String environment;
	private static Map<String, Map<String, String>> isdHistoryMap;
	private static List<WeatherLiteData> weatherLiteData;
	private static Map<String, List<WeatherLiteData>> weatherLiteDataMap;


	public static Map<String, List<WeatherLiteData>> getWeatherLiteDataMap() {
		return weatherLiteDataMap;
	}

	public static void setWeatherLiteDataMap(Map<String, List<WeatherLiteData>> weatherLiteDataMap) {
		CommonEntity.weatherLiteDataMap = weatherLiteDataMap;
	}

	public static List<WeatherLiteData> getWeatherLiteData() {
		return weatherLiteData;
	}

	public static void setWeatherLiteData(List<WeatherLiteData> weatherLiteData) {
		CommonEntity.weatherLiteData = weatherLiteData;
	}

	public static Map<String, Map<String, String>> getIsdHistoryMap() {
		return isdHistoryMap;
	}

	public static void setIsdHistoryMap(Map<String, Map<String, String>> isdHistoryMap) {
		CommonEntity.isdHistoryMap = isdHistoryMap;
	}

	public String getDataProvider() {
		return dataProvider;
	}

	public void setDataProvider(String dataProvider) {
		this.dataProvider = dataProvider;
	}

	public String getInputFilePath() {
		return inputFilePath;
	}

	public void setInputFilePath(String inputFilePath) {
		this.inputFilePath = inputFilePath;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

}
