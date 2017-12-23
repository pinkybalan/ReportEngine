package utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import model.ReportInput;

/**
 * @author Priya Balan
 *
 */
public class ReportInputGenerator {

	public Set<ReportInput> generateInputs(){
		Set<ReportInput> inputSet = new HashSet<ReportInput>();
		inputSet.add(new ReportInput("Foo", "B", BigDecimal.valueOf(0.50), "SGP", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 18), 200, BigDecimal.valueOf(100.25)));
		inputSet.add(new ReportInput("Bar", "S", BigDecimal.valueOf(0.22), "AED", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 17), 100, BigDecimal.valueOf(100.0)));
		inputSet.add(new ReportInput("Foo1", "B", BigDecimal.valueOf(0.50), "AED", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 19), 300, BigDecimal.valueOf(85.25)));
		inputSet.add(new ReportInput("Bar1", "B", BigDecimal.valueOf(0.50), "SAR", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 19), 300, BigDecimal.valueOf(85.25)));
		inputSet.add(new ReportInput("Bar2", "S", BigDecimal.valueOf(0.22), "SAR", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 17), 200, BigDecimal.valueOf(100.0)));
		inputSet.add(new ReportInput("Foo2", "S", BigDecimal.valueOf(0.50), "SGP", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 18), 100, BigDecimal.valueOf(200.0)));
		inputSet.add(new ReportInput("Foo3", "S", BigDecimal.valueOf(0.50), "AED", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 21), 100, BigDecimal.valueOf(50.0)));
		inputSet.add(new ReportInput("Bar3", "B", BigDecimal.valueOf(0.50), "SAR", LocalDate.of(2017, 12, 12),
				LocalDate.of(2017, 12, 19), 200, BigDecimal.valueOf(85.25)));
		return inputSet;
		
	}
	
}
