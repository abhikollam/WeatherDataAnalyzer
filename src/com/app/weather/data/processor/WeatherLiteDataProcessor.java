package com.app.weather.data.processor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.weather.constants.Constants;
import com.app.weather.entities.CommonEntity;
import com.app.weather.entities.WeatherLiteData;

/*
 * Weather data processor maintains all the data processing methods needed for application.
 */
public class WeatherLiteDataProcessor {

	public static void getWeatherRecord(int year, int month, int day) {

		boolean isFound = false;
		for (WeatherLiteData data : CommonEntity.getWeatherLiteData()) {

			if (data.getYear() == year && data.getMonth() == month && data.getDay() == day) {
				System.out.println(data.toString());
				isFound = true;
			}

		}
		if (!isFound) {
			System.out.println("Weather Record Not Found !!!");
		}

	}

	public static void getWeatherRecord(int year, int month, int day, int hour) {

		boolean isFound = false;

		for (WeatherLiteData data : CommonEntity.getWeatherLiteData()) {

			if (data.getYear() == year && data.getMonth() == month && data.getDay() == day && data.getHour() == hour) {
				System.out.println(data.toString());
				isFound = true;

			}

		}
		if (!isFound) {
			System.out.println("Weather Record Not Found !!!");
		}

	}

	public static void getWeatherRecord(int year) {
		boolean isFound = false;

		for (WeatherLiteData data : CommonEntity.getWeatherLiteData()) {

			if (data.getYear() == year) {
				System.out.println(data.toString());
				isFound = true;

			}

		}
		if (!isFound) {
			System.out.println("Weather Record Not Found !!!");
		}

	}

	public static void getWeatherRecord(int year, int month) {
		boolean isFound = false;

		for (WeatherLiteData data : CommonEntity.getWeatherLiteData()) {

			if (data.getYear() == year && data.getMonth() == month) {
				System.out.println(data.toString());
				isFound = true;

			}

		}
		if (!isFound) {
			System.out.println("Weather Record Not Found !!!");
		}

	}

	public static void getAverageValue(int year, int month, String identifier) {

		boolean found = false;
		List<WeatherLiteData> dataList = CommonEntity.getWeatherLiteData().stream()
				.sorted(Comparator.comparing(WeatherLiteData::getStationName))
				.filter(x -> x.getYear() == year && x.getMonth() == month).collect(Collectors.toList());
		Map<String, List<WeatherLiteData>> weatherDataMap = new HashMap<>();

		// Storing as a map for key as station name value as list of objects
		for (int i = 0; i < dataList.size(); i++) {
			found = true;
			if (weatherDataMap.containsKey(dataList.get(i).getStationName())) {
				List<WeatherLiteData> innerList = weatherDataMap.get(dataList.get(i).getStationName());
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);

			} else {
				List<WeatherLiteData> innerList = new ArrayList<>();
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);
			}

		}

		// calculate average for each station
		if (found) {
			for (String key : weatherDataMap.keySet()) {

				int sum = 0;
				int count = 0;
				for (WeatherLiteData data : weatherDataMap.get(key)) {
					if (identifier.equalsIgnoreCase(Constants.DEW)) {
						sum = sum + data.getDewPointTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.AIR_TEMP)) {
						sum = sum + data.getAirTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.SEA_LVL_PRE)) {
						sum = sum + data.getSeaLevelPreasure();

					}
					if (identifier.equalsIgnoreCase(Constants.WIND_SPEED)) {
						sum = sum + data.getWindSpeedRate();

					}
					if (identifier.equalsIgnoreCase(Constants.LQID_PRES)) {
						sum = sum + data.getLiquidPrecipitationHourly();

					}
					count++;
				}
				System.out.println("Average in " + key + " station :: " + sum / count);

			}
		} else {
			System.out.println("Data Not found !!");
		}

	}

	public static void getAverageValue(int year, int month, int day, String identifier) {

		boolean found = false;
		List<WeatherLiteData> dataList = CommonEntity.getWeatherLiteData().stream()
				.sorted(Comparator.comparing(WeatherLiteData::getStationName))
				.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day)
				.collect(Collectors.toList());
		Map<String, List<WeatherLiteData>> weatherDataMap = new HashMap<>();

		// Storing as a map for key as station name value as list of objects
		for (int i = 0; i < dataList.size(); i++) {
			found = true;
			if (weatherDataMap.containsKey(dataList.get(i).getStationName())) {
				List<WeatherLiteData> innerList = weatherDataMap.get(dataList.get(i).getStationName());
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);

			} else {
				List<WeatherLiteData> innerList = new ArrayList<>();
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);
			}

		}

		// calculate average for each station
		if (found) {
			for (String key : weatherDataMap.keySet()) {

				int sum = 0;
				int count = 0;
				for (WeatherLiteData data : weatherDataMap.get(key)) {
					if (identifier.equalsIgnoreCase(Constants.DEW)) {
						sum = sum + data.getDewPointTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.AIR_TEMP)) {
						sum = sum + data.getAirTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.SEA_LVL_PRE)) {
						sum = sum + data.getSeaLevelPreasure();

					}
					if (identifier.equalsIgnoreCase(Constants.WIND_SPEED)) {
						sum = sum + data.getWindSpeedRate();

					}
					if (identifier.equalsIgnoreCase(Constants.LQID_PRES)) {
						sum = sum + data.getLiquidPrecipitationHourly();

					}
					count++;
				}
				System.out.println("Average in " + key + " station :: " + sum / count);

			}
		} else {
			System.out.println("Data Not found !!");
		}

	}

	public static void getAverageValue(int year, int month, int day, int hour, String identifier) {

		boolean found = false;
		List<WeatherLiteData> dataList = CommonEntity.getWeatherLiteData().stream()
				.sorted(Comparator.comparing(WeatherLiteData::getStationName))
				.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day && x.getHour() == hour)
				.collect(Collectors.toList());
		Map<String, List<WeatherLiteData>> weatherDataMap = new HashMap<>();

		// Storing as a map for key as station name value as list of objects
		for (int i = 0; i < dataList.size(); i++) {
			found = true;
			if (weatherDataMap.containsKey(dataList.get(i).getStationName())) {
				List<WeatherLiteData> innerList = weatherDataMap.get(dataList.get(i).getStationName());
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);

			} else {
				List<WeatherLiteData> innerList = new ArrayList<>();
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);
			}

		}

		// calculate average for each station
		if (found) {
			for (String key : weatherDataMap.keySet()) {

				int sum = 0;
				int count = 0;
				for (WeatherLiteData data : weatherDataMap.get(key)) {
					if (identifier.equalsIgnoreCase(Constants.DEW)) {
						sum = sum + data.getDewPointTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.AIR_TEMP)) {
						sum = sum + data.getAirTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.SEA_LVL_PRE)) {
						sum = sum + data.getSeaLevelPreasure();

					}
					if (identifier.equalsIgnoreCase(Constants.WIND_SPEED)) {
						sum = sum + data.getWindSpeedRate();

					}
					if (identifier.equalsIgnoreCase(Constants.LQID_PRES)) {
						sum = sum + data.getLiquidPrecipitationHourly();

					}
					count++;
				}
				System.out.println("Average in " + key + " station :: " + sum / count);

			}
		} else {
			System.out.println("Data Not found !!");
		}

	}

	public static void getAverageValue(int year, String identifier) {

		boolean found = false;
		List<WeatherLiteData> dataList = CommonEntity.getWeatherLiteData().stream()
				.sorted(Comparator.comparing(WeatherLiteData::getStationName)).filter(x -> x.getYear() == year)
				.collect(Collectors.toList());
		Map<String, List<WeatherLiteData>> weatherDataMap = new HashMap<>();

		// Storing as a map for key as station name value as list of objects
		for (int i = 0; i < dataList.size(); i++) {
			found = true;
			if (weatherDataMap.containsKey(dataList.get(i).getStationName())) {
				List<WeatherLiteData> innerList = weatherDataMap.get(dataList.get(i).getStationName());
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);

			} else {
				List<WeatherLiteData> innerList = new ArrayList<>();
				innerList.add(dataList.get(i));
				weatherDataMap.put(dataList.get(i).getStationName(), innerList);
			}

		}

		// calculate average for each station
		if (found) {
			for (String key : weatherDataMap.keySet()) {

				int sum = 0;
				int count = 0;
				for (WeatherLiteData data : weatherDataMap.get(key)) {
					if (identifier.equalsIgnoreCase(Constants.DEW)) {
						if (data.getDewPointTemperature() != Constants.MISSING_VALUE)
							sum = sum + data.getDewPointTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.AIR_TEMP)) {
						if (data.getAirTemperature() != Constants.MISSING_VALUE)
							sum = sum + data.getAirTemperature();

					}
					if (identifier.equalsIgnoreCase(Constants.SEA_LVL_PRE)) {
						if (data.getSeaLevelPreasure() != Constants.MISSING_VALUE)
							sum = sum + data.getSeaLevelPreasure();

					}
					if (identifier.equalsIgnoreCase(Constants.WIND_SPEED)) {
						if (data.getWindSpeedRate() != Constants.MISSING_VALUE)
							sum = sum + data.getWindSpeedRate();

					}
					if (identifier.equalsIgnoreCase(Constants.LQID_PRES)) {
						if (data.getLiquidPrecipitationHourly() != Constants.MISSING_VALUE)
							sum = sum + data.getLiquidPrecipitationHourly();

					}
					count++;
				}
				System.out.println("Average in " + key + " station :: " + sum / count);

			}
		} else {
			System.out.println("Data Not found !!");
		}

	}

	public static void getMaxValue(int year, String identifier) {

		boolean found = false;

		Map<String, List<WeatherLiteData>> weatherDataMap = CommonEntity.getWeatherLiteDataMap();
		List<WeatherLiteData> sortedDataList = new ArrayList<>();

		for (String eachStation : weatherDataMap.keySet()) {
			List<WeatherLiteData> dataList = weatherDataMap.get(eachStation);

			if (identifier.contentEquals(Constants.AIR_TEMP)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getAirTemperature).reversed())
						.filter(x -> x.getYear() == year).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max temparature for " + eachStation + " station :: "
							+ sortedDataList.get(0).getAirTemperature() + " Degrees Celsius");
				}
			}

			if (identifier.contentEquals(Constants.SEA_LVL_PRE)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getSeaLevelPreasure).reversed())
						.filter(x -> x.getYear() == year).collect(Collectors.toList());
				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Sea level Preasure for " + eachStation + " station :: "
							+ sortedDataList.get(0).getSeaLevelPreasure() + "Hectopascals");
				}
			}

			if (identifier.contentEquals(Constants.DEW)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getDewPointTemperature).reversed())
						.filter(x -> x.getYear() == year).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Dew for " + eachStation + " station :: "
							+ sortedDataList.get(0).getDewPointTemperature() + " Degrees Celsius");
				}

			}

			if (identifier.contentEquals(Constants.WIND_SPEED)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getWindSpeedRate).reversed())
						.filter(x -> x.getYear() == year).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Wind Speed for " + eachStation + " station :: "
							+ sortedDataList.get(0).getWindSpeedRate() + " meters per second");
				}

			}

			if (identifier.contentEquals(Constants.LQID_PRES)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getLiquidPrecipitationHourly).reversed())
						.filter(x -> x.getYear() == year).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Liquid Precipitation  for " + eachStation + " station :: "
							+ sortedDataList.get(0).getLiquidPrecipitationHourly() + " millimeters");
				}

			}

		}

		if (!found)
		{
			System.out.println("Data Not Found !!!");
		}

	}
	
	
	public static void getMaxValue(int year, int month, String identifier) {

		boolean found = false;

		Map<String, List<WeatherLiteData>> weatherDataMap = CommonEntity.getWeatherLiteDataMap();
		List<WeatherLiteData> sortedDataList = new ArrayList<>();

		for (String eachStation : weatherDataMap.keySet()) {
			List<WeatherLiteData> dataList = weatherDataMap.get(eachStation);

			if (identifier.contentEquals(Constants.AIR_TEMP)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getAirTemperature).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max temparature for " + eachStation + " station :: "
							+ sortedDataList.get(0).getAirTemperature() + " Degrees Celsius");
				}
			}

			if (identifier.contentEquals(Constants.SEA_LVL_PRE)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getSeaLevelPreasure).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month).collect(Collectors.toList());
				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Sea level Preasure for " + eachStation + " station :: "
							+ sortedDataList.get(0).getSeaLevelPreasure() + "Hectopascals");
				}
			}

			if (identifier.contentEquals(Constants.DEW)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getDewPointTemperature).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Dew for " + eachStation + " station :: "
							+ sortedDataList.get(0).getDewPointTemperature() + " Degrees Celsius");
				}

			}

			if (identifier.contentEquals(Constants.WIND_SPEED)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getWindSpeedRate).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Wind Speed for " + eachStation + " station :: "
							+ sortedDataList.get(0).getWindSpeedRate() + " meters per second");
				}

			}

			if (identifier.contentEquals(Constants.LQID_PRES)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getLiquidPrecipitationHourly).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Liquid Precipitation  for " + eachStation + " station :: "
							+ sortedDataList.get(0).getLiquidPrecipitationHourly() + " millimeters");
				}

			}

		}

		if (!found)
		{
			System.out.println("Data Not Found !!!");
		}

	}
	
	public static void getMaxValue(int year, int month, int day, String identifier) {

		boolean found = false;

		Map<String, List<WeatherLiteData>> weatherDataMap = CommonEntity.getWeatherLiteDataMap();
		List<WeatherLiteData> sortedDataList = new ArrayList<>();

		for (String eachStation : weatherDataMap.keySet()) {
			List<WeatherLiteData> dataList = weatherDataMap.get(eachStation);

			if (identifier.contentEquals(Constants.AIR_TEMP)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getAirTemperature).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max temparature for " + eachStation + " station :: "
							+ sortedDataList.get(0).getAirTemperature() + " Degrees Celsius");
				}
			}

			if (identifier.contentEquals(Constants.SEA_LVL_PRE)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getSeaLevelPreasure).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day).collect(Collectors.toList());
				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Sea level Preasure for " + eachStation + " station :: "
							+ sortedDataList.get(0).getSeaLevelPreasure() + "Hectopascals");
				}
			}

			if (identifier.contentEquals(Constants.DEW)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getDewPointTemperature).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Dew for " + eachStation + " station :: "
							+ sortedDataList.get(0).getDewPointTemperature() + " Degrees Celsius");
				}

			}

			if (identifier.contentEquals(Constants.WIND_SPEED)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getWindSpeedRate).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Wind Speed for " + eachStation + " station :: "
							+ sortedDataList.get(0).getWindSpeedRate() + " meters per second");
				}

			}

			if (identifier.contentEquals(Constants.LQID_PRES)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getLiquidPrecipitationHourly).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Liquid Precipitation  for " + eachStation + " station :: "
							+ sortedDataList.get(0).getLiquidPrecipitationHourly() + " millimeters");
				}

			}

		}

		if (!found)
		{
			System.out.println("Data Not Found !!!");
		}

	}
	
	public static void getMaxValue(int year, int month, int day, int hour, String identifier) {

		boolean found = false;

		Map<String, List<WeatherLiteData>> weatherDataMap = CommonEntity.getWeatherLiteDataMap();
		List<WeatherLiteData> sortedDataList = new ArrayList<>();

		for (String eachStation : weatherDataMap.keySet()) {
			List<WeatherLiteData> dataList = weatherDataMap.get(eachStation);

			if (identifier.contentEquals(Constants.AIR_TEMP)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getAirTemperature).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day && x.getHour() == hour).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max temparature for " + eachStation + " station :: "
							+ sortedDataList.get(0).getAirTemperature() + " Degrees Celsius");
				}
			}

			if (identifier.contentEquals(Constants.SEA_LVL_PRE)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getSeaLevelPreasure).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day && x.getHour() == hour).collect(Collectors.toList());
				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Sea level Preasure for " + eachStation + " station :: "
							+ sortedDataList.get(0).getSeaLevelPreasure() + "Hectopascals");
				}
			}

			if (identifier.contentEquals(Constants.DEW)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getDewPointTemperature).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day && x.getHour() == hour).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Dew for " + eachStation + " station :: "
							+ sortedDataList.get(0).getDewPointTemperature() + " Degrees Celsius");
				}

			}

			if (identifier.contentEquals(Constants.WIND_SPEED)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getWindSpeedRate).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day && x.getHour() == hour).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Wind Speed for " + eachStation + " station :: "
							+ sortedDataList.get(0).getWindSpeedRate() + " meters per second");
				}

			}

			if (identifier.contentEquals(Constants.LQID_PRES)) {
				sortedDataList = dataList.stream()
						.sorted(Comparator.comparing(WeatherLiteData::getLiquidPrecipitationHourly).reversed())
						.filter(x -> x.getYear() == year && x.getMonth() == month && x.getDay() == day && x.getHour() == hour).collect(Collectors.toList());

				if (!sortedDataList.isEmpty()) {
					found = true;
					System.out.println("Max Liquid Precipitation  for " + eachStation + " station :: "
							+ sortedDataList.get(0).getLiquidPrecipitationHourly() + " millimeters");
				}

			}

		}

		if (!found)
		{
			System.out.println("Data Not Found !!!");
		}

	}


	

}
