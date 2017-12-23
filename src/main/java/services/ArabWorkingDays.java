package services;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Priya Balan
 *
 */
public class ArabWorkingDays implements IWorkingDays {

		
	@Override
	public Set<DayOfWeek> getWorkingDays() {
		//List of ArabCountries working days
		return new HashSet<>(Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.MONDAY, DayOfWeek.TUESDAY,
				DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY));
	}

}
