package model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

/**
 * @author Priya Balan
 *
 */
public class ReportInputTest {

	@Test
	public void testFields() {
		BigDecimal agreedFx = BigDecimal.valueOf(0.50);
		BigDecimal pricePerUnit = BigDecimal.valueOf(100.25);
		int units = 200;
		LocalDate instructionDate = LocalDate.of(2017, 12, 12);
		
		ReportInput reportInput = new ReportInput("Foo", "B", BigDecimal.valueOf(0.50), "SGP", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 18), 200, BigDecimal.valueOf(100.25));
		
		//test initialization
		assertEquals(agreedFx,reportInput.getAgreedFx());
		assertEquals(pricePerUnit,reportInput.getPricePerUnit());
		assertEquals(units,reportInput.getUnits());
		assertEquals(instructionDate,reportInput.getInstructionDate());
	}
}
