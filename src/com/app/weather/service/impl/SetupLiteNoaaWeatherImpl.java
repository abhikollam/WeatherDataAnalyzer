package com.app.weather.service.impl;

import java.util.Scanner;

import com.app.weather.constants.Constants;
import com.app.weather.data.processor.WeatherLiteDataProcessor;
import com.app.weather.entities.CommonEntity;
import com.app.weather.service.SetupWeatherService;
import com.app.weather.utils.CommonUtils;

/*
 * SetupLiteNoaaWeatherImpl implements all the service functionalities for the LiteNoaaWeather data
 */
public class SetupLiteNoaaWeatherImpl implements SetupWeatherService {

	@Override
	public void setup(CommonEntity commonEntity) {
		System.out.println("Data Loading in Progresss......Please wait... :-)");
		CommonUtils.loadIsdHistoryData(commonEntity);
		CommonUtils.loadLiteNoaaData(commonEntity);
		
		Scanner scanner = new Scanner(System.in);
		String choice;

		while (true) {

			System.out.print("\nPlease select an analyzer feature you wish to use from below ");
			System.out.println("\n1. Weather Records \n2. Averages \n3. Maximums  \n4. Exit");
			choice = scanner.nextLine();

			switch (choice.trim()) {

			case "1":
				System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
				String fiterChoice = scanner.nextLine();
				subSectionForWeatherFilter(scanner, fiterChoice);
				break;

			case "2":
				System.out.println(
						"Please select any of below \n1. Air temperature  \n2. Sea level pressure  \n3. Dew point temperature \n4. Wind speed \n5. Liquid precipitation Hourly \n6. Exit");
				String avgChoice = scanner.nextLine();
				subSectionForAverageFilter(scanner, avgChoice);
				break;
			case "3":
				System.out.println(
						"Please select any of below \n1. Air temperature  \n2. Sea level pressure  \n3. Dew point temperature \n4. Wind speed \n5. Liquid precipitation Hourly \n6. Exit");
				String maxChoice = scanner.nextLine();
				subSectionForMaxFilter(scanner, maxChoice);
				break;
			case "4":
				System.out.println("Exit.. !!");
				System.exit(0);

			default:
				System.out.println("Invalid Option..!! Please try again");

			}

		}

	}

	private void subSectionForMaxFilter(Scanner scanner, String maxChoice) {
		

		switch (maxChoice.trim()) {
		case "1":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoice = scanner.nextLine();
			subSectionForMaxTempFilter(scanner, fiterChoice);
			break;

		case "2":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoicePreasure = scanner.nextLine();
			subSectionForMaxSeaLvlPreasureFilter(scanner, fiterChoicePreasure);
			break;

		case "3":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoiceDewPoint = scanner.nextLine();
			subSectionForMaxDewPointFilter(scanner, fiterChoiceDewPoint);
			break;

		case "4":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoiceWindSpeed = scanner.nextLine();
			subSectionForMaxWindSpeedFilter(scanner, fiterChoiceWindSpeed);
			break;
			
		case "5":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoiceLiquidPres = scanner.nextLine();
			subSectionForMaxLiqdPresFilter(scanner, fiterChoiceLiquidPres);
			break;
			
		case "6":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForMaxLiqdPresFilter(Scanner scanner, String fiterChoiceLiquidPres) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoiceLiquidPres.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Constants.LQID_PRES);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Integer.parseInt(month),Constants.LQID_PRES);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.LQID_PRES);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.LQID_PRES);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForMaxWindSpeedFilter(Scanner scanner, String fiterChoiceWindSpeed) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoiceWindSpeed.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Constants.WIND_SPEED);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Integer.parseInt(month),Constants.WIND_SPEED);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.WIND_SPEED);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.WIND_SPEED);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForMaxDewPointFilter(Scanner scanner, String fiterChoiceDewPoint) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoiceDewPoint.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Constants.DEW);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Integer.parseInt(month),Constants.DEW);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.DEW);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.DEW);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	
		// TODO Auto-generated method stub
		
	}

	private void subSectionForMaxSeaLvlPreasureFilter(Scanner scanner, String fiterChoicePreasure) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoicePreasure.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Constants.SEA_LVL_PRE);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Integer.parseInt(month),Constants.SEA_LVL_PRE);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.SEA_LVL_PRE);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.SEA_LVL_PRE);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	
		// TODO Auto-generated method stub
		
	}

	private void subSectionForMaxTempFilter(Scanner scanner, String fiterChoice) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoice.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Constants.AIR_TEMP);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year),Integer.parseInt(month),Constants.AIR_TEMP);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.AIR_TEMP);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getMaxValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.AIR_TEMP);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForAverageFilter(Scanner scanner, String avgChoice) {
		

		switch (avgChoice.trim()) {
		case "1":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoice = scanner.nextLine();
			subSectionForAverageTempFilter(scanner, fiterChoice);
			break;

		case "2":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoicePreasure = scanner.nextLine();
			subSectionForAverageSeaLvlPreasureFilter(scanner, fiterChoicePreasure);
			break;

		case "3":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoiceDewPoint = scanner.nextLine();
			subSectionForAverageDewPointFilter(scanner, fiterChoiceDewPoint);
			break;

		case "4":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoiceWindSpeed = scanner.nextLine();
			subSectionForAverageWindSpeedFilter(scanner, fiterChoiceWindSpeed);
			break;
			
		case "5":
			System.out.println("Please select Filter criterie \n1. Yearly \n2. Monthly \n3. Daily \n4. Hourly \n5. Exit");
			String fiterChoiceLiquidPres = scanner.nextLine();
			subSectionForAverageLiqdPresFilter(scanner, fiterChoiceLiquidPres);
			break;
			
		case "6":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForAverageLiqdPresFilter(Scanner scanner, String fiterChoiceLiquidPres) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoiceLiquidPres.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Constants.LQID_PRES);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Integer.parseInt(month),Constants.LQID_PRES);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.LQID_PRES);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.LQID_PRES);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForAverageWindSpeedFilter(Scanner scanner, String fiterChoiceWindSpeed) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoiceWindSpeed.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Constants.WIND_SPEED);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Integer.parseInt(month),Constants.WIND_SPEED);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.WIND_SPEED);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.WIND_SPEED);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForAverageDewPointFilter(Scanner scanner, String fiterChoiceDewPoint) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoiceDewPoint.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Constants.DEW);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Integer.parseInt(month),Constants.DEW);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.DEW);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.DEW);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForAverageSeaLvlPreasureFilter(Scanner scanner, String fiterChoicePreasure) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoicePreasure.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Constants.SEA_LVL_PRE);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Integer.parseInt(month),Constants.SEA_LVL_PRE);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.SEA_LVL_PRE);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.SEA_LVL_PRE);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForAverageTempFilter(Scanner scanner, String fiterChoice) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoice.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Constants.AIR_TEMP);
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year),Integer.parseInt(month),Constants.AIR_TEMP);
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day),Constants.AIR_TEMP);
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getAverageValue(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour),Constants.AIR_TEMP);
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

	private void subSectionForWeatherFilter(Scanner scanner, String fiterChoice) {
		String year;
		String month;
		String day;
		String hour;

		switch (fiterChoice.trim()) {
		case "1":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			WeatherLiteDataProcessor.getWeatherRecord(Integer.parseInt(year));
			break;

		case "2":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			WeatherLiteDataProcessor.getWeatherRecord(Integer.parseInt(year), Integer.parseInt(month));
			break;

		case "3":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			WeatherLiteDataProcessor.getWeatherRecord(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day));
			break;

		case "4":
			System.out.println("Please Enter year in (YYYY format)");
			year = scanner.nextLine();
			CommonUtils.isNumberCheck(year);
			System.out.println("Please Enter month in (MM format)");
			month = scanner.nextLine();
			CommonUtils.isNumberCheck(month);
			System.out.println("Please Enter Day (DD format)");
			day = scanner.nextLine();
			CommonUtils.isNumberCheck(day);
			System.out.println("Please Enter Hour (HH format)");
			hour = scanner.nextLine();
			CommonUtils.isNumberCheck(hour);
			WeatherLiteDataProcessor.getWeatherRecord(Integer.parseInt(year), Integer.parseInt(month),
					Integer.parseInt(day), Integer.parseInt(hour));
			break;
			
		case "5":
			System.out.println("Exit !!");
			System.exit(0);

		default:
			System.out.println("Invalid Option..!! Please try again");

		}
	}

}
