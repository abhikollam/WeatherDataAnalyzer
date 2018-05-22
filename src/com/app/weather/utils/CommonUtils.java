package com.app.weather.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.app.weather.constants.Constants;
import com.app.weather.entities.CommonEntity;
import com.app.weather.entities.WeatherLiteData;
import com.app.weather.exception.WeatherDataAnalyzerException;

/*
 * Commonutils handles all the common methods or the application
 */
public class CommonUtils {

	/*
	 * isEmpty method gets set of input strings and checks whether any of the values
	 * are null or empty
	 */
	public static boolean isEmpty(String... values) {

		for (String val : values) {
			if (val == null || val.trim().isEmpty()) {
				return true;
			}

		}
		return false;
	}

	public static void reportError(WeatherDataAnalyzerException e, CommonEntity commonEntity) {

		System.out.println(e);

		if (commonEntity.getDataProvider() != null
				&& Constants.LITE_NOAA_PROVIDER.equalsIgnoreCase(commonEntity.getDataProvider())) {

			if (e.isActionRequired()) {

				// Do the necessary actions like report this error to provider specific error
				// services or send email to production support team etc..

				System.out.println("Sending notification to Poduction Support !!");

			} else {
				System.out.println("No action required for this error");
			}
		} else {

			// Do the necessary actions like report this error to provider specific error
			// services or send email to production support team etc..

			System.out.println("Sending notification to Poduction Support !!");
		}

	}

	public static void loadIsdHistoryData(CommonEntity commonEntity) {

		Scanner scanner = null;
		try {

			scanner = new Scanner(CommonUtils.class.getClassLoader().getResourceAsStream(Constants.ISD_HISTORY_FILE));
			Map<String, Map<String, String>> isdHistoryMap = new HashMap<>();

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();

				if (line != null && !line.trim().isEmpty() && !line.startsWith("#")) {

					if (line.length() > 50) {

						HashMap<String, String> valueMap = new HashMap<>();
						valueMap.put(Constants.AIR_FORCE_STATIO_ID, line.substring(0, 6).trim());
						valueMap.put(Constants.WBAN, line.substring(7, 12).trim());
						valueMap.put(Constants.STATION_NAME, line.substring(12, 42).trim());
						isdHistoryMap.put(line.substring(0, 6).trim(), valueMap);
					}
				}
			}
			CommonEntity.setIsdHistoryMap(isdHistoryMap);
			System.out.println("Loaded IsdHistoryData.....!!");

		} catch (Exception e) {
			throw new WeatherDataAnalyzerException("Load ISD History File", Constants.CODE1,
					"File Loading Failed " + e.getMessage(), Constants.ACTION_REQUIRED);
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

	}

	public static void loadLiteNoaaData(CommonEntity commonEntity) {

		Scanner scnr = null;
		List<WeatherLiteData> weatherLiteData = new ArrayList<>();
		Map<String, List<WeatherLiteData>> weatherDataMap = new HashMap<>();

		Map<String, Map<String, String>> isdHistoryMap = CommonEntity.getIsdHistoryMap();
		try {
			File directory = new File(commonEntity.getInputFilePath().trim());
			String[] directoryContents = directory.list();
			for (String direName : directoryContents) {

				File temp = new File(String.valueOf(directory), direName);
				File dir = new File(String.valueOf(temp));
				String[] dirContents = dir.list();
				for (String fileName : dirContents) {
					File filePath = new File(String.valueOf(dir), fileName);
					scnr = new Scanner(new File(String.valueOf(filePath)));

					while (scnr.hasNextLine()) {
						String line = scnr.nextLine();

						if (line != null && !line.trim().isEmpty() && line.length() >= 61) {

							int year = Integer.parseInt(line.substring(0, 4).trim());
							int month = Integer.parseInt(line.substring(5, 7).trim());
							int day = Integer.parseInt(line.substring(8, 11).trim());
							int hour = Integer.parseInt(line.substring(11, 13).trim());
							int airTemperature = Integer.parseInt(line.substring(14, 19).trim());
							int dewPointTemperature = Integer.parseInt(line.substring(20, 25).trim());
							int seaLevelPreasure = Integer.parseInt(line.substring(25, 31).trim());
							int windDirection = Integer.parseInt(line.substring(32, 37).trim());
							int windSpeedRate = Integer.parseInt(line.substring(38, 43).trim());
							int skyConditionCovCode = Integer.parseInt(line.substring(44, 49).trim());
							int liquidPrecipitationHourly = Integer.parseInt(line.substring(50, 55).trim());
							int liquidPrecipitationSixHour = Integer.parseInt(line.substring(56, 61).trim());
							String stationName = null;
							String[] fileNameSplit = fileName.split("-");
							if (fileNameSplit.length > 0) {
								String airForceStationId = fileNameSplit[0].trim();
								if (isdHistoryMap.containsKey(airForceStationId)) {
									if (isdHistoryMap.get(airForceStationId).get(Constants.STATION_NAME) != null) {
										stationName = isdHistoryMap.get(airForceStationId).get(Constants.STATION_NAME);
									} else {
										stationName = "NA";
									}

								}
							}

							WeatherLiteData obj = new WeatherLiteData(year, month, day, hour, airTemperature,
									dewPointTemperature, seaLevelPreasure, windDirection, windSpeedRate,
									skyConditionCovCode, liquidPrecipitationHourly, liquidPrecipitationSixHour,
									stationName);

							weatherLiteData.add(obj);

							// Storing as a map for key as station name value as list of objects

							if (weatherDataMap.containsKey(stationName)) {
								List<WeatherLiteData> innerList = weatherDataMap.get(stationName);
								innerList.add(obj);
								weatherDataMap.put(stationName, innerList);

							} else {
								List<WeatherLiteData> innerList = new ArrayList<>();
								innerList.add(obj);
								weatherDataMap.put(stationName, innerList);
							}

						}
					}

				}

			}

			CommonEntity.setWeatherLiteData(weatherLiteData);
			CommonEntity.setWeatherLiteDataMap(weatherDataMap);
			System.out.println("Loaded WeatherLiteNoAA Data.....!!");

		} catch (Exception e) {
			e.printStackTrace();
			throw new WeatherDataAnalyzerException("Load ISD Data File", Constants.CODE1,
					"ISD Data File Loading Failed " + e.getMessage(), Constants.ACTION_REQUIRED);
		} finally {
			if (scnr != null) {
				scnr.close();
			}
		}

	}

	public static void isNumberCheck(String year) {

		try {
			Integer.parseInt(year);
		} catch (Exception e) {
			throw new WeatherDataAnalyzerException("Number Check", "Code 3",
					"Invalid Number parsing failed !! " + e.getMessage(), Constants.NO_ACTION_REQUIRED);
		}

	}

}
