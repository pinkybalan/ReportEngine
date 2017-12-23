package utils;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import model.ReportInput;

/**
 * @author Priya Balan
 *
 */
public class ReportCalculatorTest {

	Set<ReportInput> inputSet;
	ReportCalculator reportCalc;

	@Before
	public void setInputs() {
		reportCalc = new ReportCalculator();
		inputSet = new HashSet<ReportInput>();
		
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
	}

	@Test
	public void calculateIncomingDailyAmount() throws Exception {
		// calculate daily trade amount for incoming
		Map<LocalDate, BigDecimal> incomingDailyAmt = reportCalc.calculateDailyAmount(inputSet, "S");

		// checks if the result matches with expected
		assertEquals(3, incomingDailyAmt.size());
		assertEquals(BigDecimal.valueOf(6600.00).setScale(3), incomingDailyAmt.get(LocalDate.of(2017, 12, 17)));
		assertEquals(BigDecimal.valueOf(10000.00).setScale(2), incomingDailyAmt.get(LocalDate.of(2017, 12, 18)));
		assertEquals(BigDecimal.valueOf(2500.00).setScale(2), incomingDailyAmt.get(LocalDate.of(2017, 12, 21)));
	}

	@Test
	public void calculateOutgoingDailyAmount() throws Exception {
		// calculate daily trade amount for outgoing
		Map<LocalDate, BigDecimal> outgoingDailyAmt = reportCalc.calculateDailyAmount(inputSet, "B");
		
		// checks if the result matches with expected
		assertEquals(2, outgoingDailyAmt.size());
		assertEquals(BigDecimal.valueOf(10025.000).setScale(3), outgoingDailyAmt.get(LocalDate.of(2017, 12, 18)));
		assertEquals(BigDecimal.valueOf(34100.000).setScale(3), outgoingDailyAmt.get(LocalDate.of(2017, 12, 19)));

	}

	@Test
	public void calculateIncomingRanking() throws Exception {
		// calculate entity ranking for incoming
		Map<LocalDate, Map<String, Integer>> incomingDailyRank = reportCalc.calculateRanking(inputSet, "S");

		// checks if the result matches with expected
		assertEquals(3, incomingDailyRank.size());
		assertEquals(2, incomingDailyRank.get(LocalDate.of(2017, 12, 17)).size());
		assertEquals(1, incomingDailyRank.get(LocalDate.of(2017, 12, 18)).size());

		// checks if the expected ranking is achieved
		assertEquals(Integer.valueOf(1), incomingDailyRank.get(LocalDate.of(2017, 12, 17)).get("Bar2"));
		assertEquals(Integer.valueOf(2), incomingDailyRank.get(LocalDate.of(2017, 12, 17)).get("Bar"));
		assertEquals(Integer.valueOf(1), incomingDailyRank.get(LocalDate.of(2017, 12, 18)).get("Foo2"));
		assertEquals(Integer.valueOf(1), incomingDailyRank.get(LocalDate.of(2017, 12, 21)).get("Foo3"));

	}

	@Test
	public void calculateOutgoingRanking() throws Exception {
		// calculate entity ranking for incoming
		Map<LocalDate, Map<String, Integer>> outgoingDailyRank = reportCalc.calculateRanking(inputSet, "B");

		// checks if the result matches with expected
		assertEquals(2, outgoingDailyRank.size());
		assertEquals(1, outgoingDailyRank.get(LocalDate.of(2017, 12, 18)).size());
		assertEquals(3, outgoingDailyRank.get(LocalDate.of(2017, 12, 19)).size());

		// checks if the expected ranking is achieved
		assertEquals(Integer.valueOf(1), outgoingDailyRank.get(LocalDate.of(2017, 12, 18)).get("Foo"));
		assertEquals(Integer.valueOf(2), outgoingDailyRank.get(LocalDate.of(2017, 12, 19)).get("Bar3"));
		// these two tests when the entity has same trade amount which should produce
		// same ranking
		assertEquals(Integer.valueOf(1), outgoingDailyRank.get(LocalDate.of(2017, 12, 19)).get("Bar1"));
		assertEquals(Integer.valueOf(1), outgoingDailyRank.get(LocalDate.of(2017, 12, 19)).get("Foo1"));
	}

}
