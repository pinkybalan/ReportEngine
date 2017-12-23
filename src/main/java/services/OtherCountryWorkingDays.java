package services;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Priya Balan
 *
 */
public class OtherCountryWorkingDays implements IWorkingDays {

	@Override
	public Set<DayOfWeek> getWorkingDays() {
		// List of OtherCountry working days
		return new HashSet<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
				DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY));
	}

}
