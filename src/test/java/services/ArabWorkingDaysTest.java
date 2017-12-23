/**
 * 
 */
package services;

import static org.junit.Assert.assertEquals;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Priya Balan
 *
 */
public class ArabWorkingDaysTest {

	Set<DayOfWeek> workingDaysSet;
	ArabWorkingDays workingDaysInstance;

	/**
	 * Method to initialise working days and to get the testing class instance
	 * 
	 * @throws Exception
	 */
	@Before
	public void setWorkingDays() throws Exception {
		workingDaysSet = new HashSet<>(Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
				DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY));
		workingDaysInstance = new ArabWorkingDays();
	}

	@Test
	public void findSettlementWorkingDate_SUNDAY() throws Exception {
		LocalDate dateSunday = LocalDate.of(2017, 12, 17);

		// should return the same date, since the given date SUNDAY is a working day
		assertEquals(dateSunday, workingDaysInstance.findSettlementWorkingDate(dateSunday));
	}

	@Test
	public void findSettlementWorkingDate_WEDNESDAY() throws Exception {
		LocalDate dateWednesday = LocalDate.of(2017, 12, 13);

		// should return the same date, since the given date Wednesday is a working day
		assertEquals(dateWednesday, workingDaysInstance.findSettlementWorkingDate(dateWednesday));
	}

	@Test
	public void findSettlementWorkingDate_FRIDAY() throws Exception {
		// FRIDAY is not a working day
		LocalDate dateFriday = LocalDate.of(2017, 12, 15);
		// SUNDAY is the next working day
		LocalDate dateSunday = LocalDate.of(2017, 12, 17);

		/* should return the next working date, since the given date FRIDAY is not a
		 working day*/
		assertEquals(dateSunday, workingDaysInstance.findSettlementWorkingDate(dateFriday));
	}

	@Test
	public void findSettlementWorkingDate_SATURDAY() throws Exception {
		// SATURDAY is not a working day
		LocalDate dateSaturday = LocalDate.of(2017, 12, 16);
		// SUNDAY is the next working day
		LocalDate dateSunday = LocalDate.of(2017, 12, 17);

		/* should return the next working date, since the given date SATURDAY is not a
		 working day*/
		assertEquals(dateSunday, workingDaysInstance.findSettlementWorkingDate(dateSaturday));
	}
}
