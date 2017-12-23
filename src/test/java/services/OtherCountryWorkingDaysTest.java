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
public class OtherCountryWorkingDaysTest {
	Set<DayOfWeek> workingDaysSet;
	OtherCountryWorkingDays workingDaysInstance;

	/**
	 * Method to initialise working days and to get the testing class instance
	 * 
	 * @throws Exception
	 */
	@Before
	public void setWorkingDays() throws Exception {
		workingDaysSet = new HashSet<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
				DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));

		workingDaysInstance = new OtherCountryWorkingDays();
	}

	@Test
	public void findSettlementWorkingDate_MONDAY() throws Exception {
		LocalDate dateMonday = LocalDate.of(2017, 12, 11);

		// should return the same date, since the given date Monday is a working day
		assertEquals(dateMonday, workingDaysInstance.findSettlementWorkingDate(dateMonday));
	}

	@Test
	public void findSettlementWorkingDate_WEDNESDAY() throws Exception {
		LocalDate dateWednesday = LocalDate.of(2017, 12, 13);

		// should return the same date, since the given date Wednesday is a working day
		assertEquals(dateWednesday, workingDaysInstance.findSettlementWorkingDate(dateWednesday));
	}

	@Test
	public void findSettlementWorkingDate_SUNDAY() throws Exception {
		// SUNDAY is not a working day
		LocalDate dateSunday = LocalDate.of(2017, 12, 10);
		// MONDAY is the next working day
		LocalDate dateMonday = LocalDate.of(2017, 12, 11);

		/*
		 * should return the next working date, since the given date SUNDAY is not a
		 * working day
		 */
		assertEquals(dateMonday, workingDaysInstance.findSettlementWorkingDate(dateSunday));
	}

	@Test
	public void findSettlementWorkingDate_SATURDAY() throws Exception {
		// SATURDAY is not a working day
		LocalDate dateSaturday = LocalDate.of(2017, 12, 9);
		// MONDAY is the next working day
		LocalDate dateMonday = LocalDate.of(2017, 12, 11);

		/*
		 * should return the next working date, since the given date SATURDAY is not a
		 * working day
		 */
		assertEquals(dateMonday, workingDaysInstance.findSettlementWorkingDate(dateSaturday));
	}

}
