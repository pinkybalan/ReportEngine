package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;

import java.util.Set;

import model.ReportInput;
import services.IWorkingDays;
import services.WorkingDaysFactory;

/**
 * @author Priya Balan
 *
 */
public class SettlementDateCalculator {
	
	private Set<DayOfWeek> workingDaysSet;

	/*
	 * calculate the settlement dates for the given set of inputs 
	 */
	public void calculateDates(Set<ReportInput> reportInputs) {
		reportInputs.forEach(data->calculateDate(data));
	}

	public void calculateDate(ReportInput inputData) {
    	IWorkingDays workingDaysInstance = WorkingDaysFactory.getWorkingDaysInstance(inputData.getCurrency());
    	workingDaysSet = workingDaysInstance.getWorkingDays();
		LocalDate settlementDate = findSettlementWorkingDate(inputData.getSettlementDate());
		inputData.setSettlementDate(settlementDate);
	}
	
	/*
	 * finds if the given date is a working day and returns if true else returns the
	 * next working date
	 */
	private LocalDate findSettlementWorkingDate(LocalDate settlementDate) {
		// checks if the given date is working day
		if (workingDaysSet.contains(settlementDate.getDayOfWeek())) {
			return settlementDate;
		} else {
			// checks for the next working day recursively
			return findSettlementWorkingDate(settlementDate.plusDays(1));
		}
	}
}
