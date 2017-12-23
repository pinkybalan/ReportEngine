/**
 * 
 */
package services;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Priya Balan
 *
 */
public class WorkingDaysFactoryTest {

	@Test
	public void getWorkingDaysInstance_ArabCurrency() throws Exception {
		String currency = "AED";

		// checks if the returned instance is the ArabWorkingDays instance
		assertTrue(WorkingDaysFactory.getWorkingDaysInstance(currency) instanceof ArabWorkingDays);
	}
	
	@Test
	public void getWorkingDaysInstance_SARCurrency() throws Exception {
		String currency = "SAR";

		// checks if the returned instance is the ArabWorkingDays instance
		assertTrue(WorkingDaysFactory.getWorkingDaysInstance(currency) instanceof ArabWorkingDays);
	}

	@Test
	public void getWorkingDaysInstance_OtherCurrency() throws Exception {
		String currency = "SGP";

		// checks if the returned instance is the OtherCountryWorkingDays instance
		assertTrue(WorkingDaysFactory.getWorkingDaysInstance(currency) instanceof OtherCountryWorkingDays);
	}
}
