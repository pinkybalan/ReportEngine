/**
 * 
 */
package utils;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import model.ReportInput;

/**
 * @author Priya Balan
 *
 */
public class SettlementDateCalculatorTest {

	SettlementDateCalculator calculator;

	@Before
	public void setUp() {
		calculator = new SettlementDateCalculator();
	}

	@Test
	public void calculateDate_ArabWorkingDay() throws Exception {
		// date is SUNDAY
		final LocalDate actualDate = LocalDate.of(2017, 12, 17);
		final ReportInput inputSet = new ReportInput("Foo", "B", BigDecimal.valueOf(0.50), "AED",
				LocalDate.of(2016, 1, 1), LocalDate.of(2017, 12, 17), 200, BigDecimal.valueOf(100.25));

		// calculate the settlement date
		calculator.calculateDate(inputSet);

		// should be the same date, since given date SUNDAY is a working day
		assertEquals(actualDate, inputSet.getSettlementDate());

	}

	@Test
	public void calculateDate_ArabNonWorkingDay() throws Exception {
		// date is FRIDAY
		final LocalDate actualDate = LocalDate.of(2017, 12, 17);
		final ReportInput inputSet = new ReportInput("Foo", "B", BigDecimal.valueOf(0.50), "AED",
				LocalDate.of(2016, 1, 1), LocalDate.of(2017, 12, 15), 200, BigDecimal.valueOf(100.25));

		// calculate the settlement date
		calculator.calculateDate(inputSet);

		// should be the next working date, since given date FRIDAY is not a working day
		assertEquals(actualDate, inputSet.getSettlementDate());

	}

	@Test
	public void calculateDate_OtherWorkingDay() throws Exception {
		// date is MONDAY
		final LocalDate actualDate = LocalDate.of(2017, 12, 18);
		final ReportInput inputSet = new ReportInput("Foo", "B", BigDecimal.valueOf(0.50), "SGP",
				LocalDate.of(2016, 1, 1), LocalDate.of(2017, 12, 18), 200, BigDecimal.valueOf(100.25));

		// calculate the settlement date
		calculator.calculateDate(inputSet);

		// should be the same date, since given date MONDAY is a working day
		assertEquals(actualDate, inputSet.getSettlementDate());

	}

	@Test
	public void calculateDate_OtherNonWorkingDay() throws Exception {
		// date is MONDAY
		final LocalDate actualDate = LocalDate.of(2017, 12, 18);
		final ReportInput inputSet = new ReportInput("Foo", "B", BigDecimal.valueOf(0.50), "SGP",
				LocalDate.of(2016, 1, 1), LocalDate.of(2017, 12, 17), 200, BigDecimal.valueOf(100.25));

		// calculate the settlement date
		calculator.calculateDate(inputSet);

		// should be the next working date, since given date SUNDAY is not a working day
		assertEquals(actualDate, inputSet.getSettlementDate());

	}
}
