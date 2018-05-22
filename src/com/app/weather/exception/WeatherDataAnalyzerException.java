package com.app.weather.exception;

/*
 * Custom exception class for the application
 */
@SuppressWarnings("serial")
public class WeatherDataAnalyzerException extends RuntimeException {

	private String step;
	private String errorCode;
	private String errorMessage;
	private boolean isActionRequired;

	public WeatherDataAnalyzerException(String step, String errorCode, String errorMessage, boolean isActionRequired) {
		super();
		this.step = step;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.isActionRequired = isActionRequired;
	}

	@Override
	public String getMessage() {
		return errorMessage;

	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isActionRequired() {
		return isActionRequired;
	}

	public void setActionRequired(boolean isActionRequired) {
		this.isActionRequired = isActionRequired;
	}

	@Override
	public String toString() {
		return "WeatherDataAnalyzerException [step=" + step + ", errorCode=" + errorCode + ", errorMessage="
				+ errorMessage + ", isActionRequired=" + isActionRequired + "]";
	}

}
