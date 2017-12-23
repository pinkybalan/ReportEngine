package services;

/**
 * @author Priya Balan
 *
 */
public class WorkingDaysFactory {

	/*
	 * Get the instance of working days implementation class based on the currency
	 */
	public static IWorkingDays getWorkingDaysInstance(String currency) {
		// checks for Arab country currencies(AED or SAR)
		if (currency.equalsIgnoreCase("AED") || currency.equalsIgnoreCase("SAR"))
			return new ArabWorkingDays();
		else
			return new OtherCountryWorkingDays();
	}
}
