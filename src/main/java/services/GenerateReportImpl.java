package services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import model.ReportInput;
import utils.ReportCalculator;
import utils.SettlementDateCalculator;

/**
 * @author Priya Balan
 *
 */
public class GenerateReportImpl implements IGenerateReport {

	ReportCalculator reportCalc = new ReportCalculator();
	
	/*
	 * method generates outgoing and incoming amount report,
	 * outgoing and incoming ranking report
	 */
	public void generateReports(Set<ReportInput> reportInputs) {
		//calculate settlement date
		SettlementDateCalculator dateCalculator = new SettlementDateCalculator();
		dateCalculator.calculateDates(reportInputs);
		
		generateOutgoingAmountReport(reportInputs);
		generateIncomingAmountReport(reportInputs);
		generateOutgoingRankingReport(reportInputs);
		generateIncomingRankingReport(reportInputs);
		
	}

	/*
	 * generates daily outgoing(Buy) amount report 
	 * report shows Date vs Amount
	 */
	private void generateOutgoingAmountReport(Set<ReportInput> reportInputs) {
		
		//calculate daily outgoing amount
		Map<LocalDate,BigDecimal> outgoingAmtMap = new TreeMap<>(reportCalc.calculateDailyAmount(reportInputs,"B"));	
		System.out.println("\n===============================\n   Outgoing Amount Report \n===============================\n");
		System.out.println("SettlementDate\tOutgoingAmount\n-------------------------------");
		for(Map.Entry<LocalDate, BigDecimal> entry : outgoingAmtMap.entrySet()) {
			
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		System.out.println("-------------------------------");
		
	}

	/*
	 * generates daily incoming(Sell) amount report 
	 * report shows Date vs Amount
	 */
	private void generateIncomingAmountReport(Set<ReportInput> reportInputs) {
		
		//calculate daily incoming amount
		Map<LocalDate,BigDecimal> incomingAmtMap = new TreeMap<>(reportCalc.calculateDailyAmount(reportInputs,"S"));	
		System.out.println("\n\n===============================\n   Incoming Amount Report \n===============================\n");
		System.out.println("SettlementDate\tIncomingAmount\n-------------------------------");
		for(Map.Entry<LocalDate, BigDecimal> entry : incomingAmtMap.entrySet()) {
			
			System.out.println(entry.getKey()+"\t"+entry.getValue());
		}
		System.out.println("-------------------------------");
	}
	
	/*
	 * generates daily outgoing(Buy) ranking report 
	 * report shows Date vs Entity vs Ranking
	 */
	private void generateOutgoingRankingReport(Set<ReportInput> reportInputs) {
		//calculate incoming amount
		Map<LocalDate,Map<String,Integer>> outgoingRankingMap = new TreeMap<>(reportCalc.calculateRanking(reportInputs,"B"));	
		System.out.println("\n\n===============================\n   Outgoing Ranking Report \n===============================\n");
		System.out.println("SettlementDate\tEntity\tRanking\n-------------------------------");
		
		printRankingReport(outgoingRankingMap);
		System.out.println("-------------------------------");
		
	}
	
	/*
	 * generates daily incoming(Sell) ranking report 
	 * report shows Date vs Entity vs Ranking
	 */
	private void generateIncomingRankingReport(Set<ReportInput> reportInputs) {
		//calculate incoming amount
		Map<LocalDate,Map<String,Integer>> incomingRankingMap = new TreeMap<>(reportCalc.calculateRanking(reportInputs,"S"));	
		System.out.println("\n\n===============================\n   Incoming Ranking Report \n===============================\n");
		System.out.println("SettlementDate\tEntity\tRanking\n-------------------------------");
		
		printRankingReport(incomingRankingMap);
		System.out.println("-------------------------------");
	}

	/**
	 * @param rankingMap
	 */
	private void printRankingReport(Map<LocalDate, Map<String, Integer>> rankingMap) {
		rankingMap.entrySet().stream()
									 .forEach(e -> {
										     e.getValue().entrySet().stream()
										     .forEach(r-> {
												 System.out.println(e.getKey()+"\t"+r.getKey()+"\t"+r.getValue());
											 });
									 });
	}
}