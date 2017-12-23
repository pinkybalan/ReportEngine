package services;

import java.time.LocalDate;

/**
 * @author Priya Balan
 *
 */
public interface IWorkingDays {
	LocalDate findSettlementWorkingDate(LocalDate settlementDate);
}
