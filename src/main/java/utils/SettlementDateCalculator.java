package utils;

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
	
	/*
	 * calculate the settlement dates for the given set of inputs 
	 */
	public void calculateDates(Set<ReportInput> reportInputs) {
		reportInputs.forEach(data->calculateDate(data));
	}

	public void calculateDate(ReportInput inputData) {
    	IWorkingDays workingDaysInstance = WorkingDaysFactory.getWorkingDaysInstance(inputData.getCurrency());
		LocalDate settlementDate = workingDaysInstance.findSettlementWorkingDate(inputData.getSettlementDate());
		inputData.setSettlementDate(settlementDate);
	}
}
