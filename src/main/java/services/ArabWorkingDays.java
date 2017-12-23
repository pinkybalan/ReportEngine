package services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Priya Balan
 *
 */
public class ArabWorkingDays implements IWorkingDays {

	//List of ArabCountries working days
	Set<DayOfWeek> workingDaysSet = new HashSet<>(Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
			DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY));

	/*
	 * finds if the given date is a working day and returns if true else returns the
	 * next working date
	 */
	@Override
	public LocalDate findSettlementWorkingDate(LocalDate settlementDate) {
		// checks if the given date is working day
		if (workingDaysSet.contains(settlementDate.getDayOfWeek())) {
			return settlementDate;
		} else {
			// checks for the next working day recursively
			return findSettlementWorkingDate(settlementDate.plusDays(1));
		}
	}

}
