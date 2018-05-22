package com.app.weather.driver;

import com.app.weather.constants.Constants;
import com.app.weather.entities.CommonEntity;
import com.app.weather.exception.WeatherDataAnalyzerException;
import com.app.weather.factory.SetupWeatherfactory;
import com.app.weather.service.SetupWeatherService;
import com.app.weather.utils.CommonUtils;

/*
 * This is the application driver class
 * Invokes all the modules and handles the custome exceptions
 */
public class WeatherDataAnalyzer {

	private static CommonEntity commonEntity;

	public static void main(String[] args) {

		WeatherDataAnalyzer driver = new WeatherDataAnalyzer();
		driver.processWeatherData(args);

	}

	private void processWeatherData(String[] args) {

		try {
			commonEntity = new CommonEntity();
			if (args != null && args.length == 3) {
				
				System.out.println("======================================================");
				System.out.println("===========Weather Data Analyzer======================");
				System.out.println("======================================================");

				System.out.println("\nUsing this system you can analyze the weather data !! \n");

				commonEntity.setDataProvider(args[0]);
				commonEntity.setInputFilePath(args[1]);
				commonEntity.setEnvironment(args[2]);

				if (!CommonUtils.isEmpty(args[0], args[1], args[2])) {

					/*
					 * Getting the service instance for this data provider
					 */
					SetupWeatherService service = SetupWeatherfactory.getWetherServiceInstance(commonEntity);
					service.setup(commonEntity);

				} else {

					/*
					 * Custom exceptions are thrown
					 */
					throw new WeatherDataAnalyzerException("Process Weather Data", Constants.CODE1,
							"WeatherDataAnalyzer Expect the below arguments \n1.Data Provider \n2.Input File Path \n3.Environemnt",
							Constants.NO_ACTION_REQUIRED);
				}

			} else {
				throw new WeatherDataAnalyzerException("Process Weather Data", Constants.CODE1,
						"WeatherDataAnalyzer Expect the below arguments \n1.Data Provider \n2.Input File Path \n3.Environemnt",
						Constants.NO_ACTION_REQUIRED);
			}
		} catch (WeatherDataAnalyzerException e) {

			/*
			 * Handling custom exceptions buy invoking separate modules which take care of all the prod support activities
			 */
			CommonUtils.reportError(e, commonEntity);

		} catch (Exception e) {

			e.printStackTrace();
			// Add the general exception logging like redirect error messages to log file or
			// invoke the custom exception reporting methods

		}

	}
}
