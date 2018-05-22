package com.app.weather.factory;

import com.app.weather.constants.Constants;
import com.app.weather.entities.CommonEntity;
import com.app.weather.exception.WeatherDataAnalyzerException;
import com.app.weather.service.SetupWeatherService;
import com.app.weather.service.impl.SetupLiteNoaaWeatherImpl;

/*
 * Factory class responsible for instantiating the proper implementation class for each provider
 * This class is defined for making the application more generic. So that it can be used for multiple provider weather data
 */
public class SetupWeatherfactory {

	public static SetupWeatherService getWetherServiceInstance(CommonEntity commonEntity) {

		if (Constants.LITE_NOAA_PROVIDER.equalsIgnoreCase(commonEntity.getDataProvider().trim())) {

			return new SetupLiteNoaaWeatherImpl();

		} else {
			throw new WeatherDataAnalyzerException("Setup Weather Factory", Constants.CODE2,
					"Invalid Provider :: " + commonEntity.getDataProvider(), Constants.ACTION_REQUIRED);
		}

	}

}
