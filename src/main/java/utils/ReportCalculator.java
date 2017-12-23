package utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import model.ReportInput;

/**
 * @author Priya Balan
 *
 */
public class ReportCalculator {

	/*
	 * Method to calculate daily trade amount based on outgoing and incoming instructions 
	 */
    public Map<LocalDate,BigDecimal> calculateDailyAmount(Set<ReportInput> reportInputs,String action) {	
		
		return reportInputs.stream().filter(input -> input.getTradeAction().equals(action))
				             .collect(Collectors.groupingBy(ReportInput::getSettlementDate,
				            		 Collectors.mapping(ReportInput::getTradeAmount,
				            				 Collectors.reducing(BigDecimal.ZERO,BigDecimal::add))));
		
	}
    
    /*
     * Method to calculate ranking of entities based on trade amount
     */
    public Map<LocalDate,Map<String,Integer>> calculateRanking(Set<ReportInput> reportInputs,String action) {	
		
    	Map<LocalDate,Map<String,Integer>> dailyRankingMap = new TreeMap<>();
    	
    	reportInputs.stream()
    	                    .filter(input -> input.getTradeAction().equals(action))
        		            .collect(Collectors.groupingBy(ReportInput::getSettlementDate, Collectors.toMap(ReportInput::getEntity, ReportInput::getTradeAmount)))
        		            .forEach((date,instructionMap) -> {
        		            	 final AtomicInteger rank = new AtomicInteger(0);
        		            	 Map<String,Integer> entityRankingMap = new LinkedHashMap<>();
        		            	 Set<BigDecimal> instructionMapValues = new HashSet<>();
        		            	 
							     instructionMap.entrySet().stream()
								 .sorted(Map.Entry.<String,BigDecimal>comparingByValue().reversed())
								 .forEach(r-> {
									 //checks if the entity has same trade amount, if so ranking should be the same
									 if(instructionMapValues.contains(r.getValue()))
										 entityRankingMap.put(r.getKey(),rank.get());
									 else
										 entityRankingMap.put(r.getKey(),rank.incrementAndGet());
									 
									 instructionMapValues.add(r.getValue());
								 });
							     
							     dailyRankingMap.put(date,entityRankingMap);
        		            });
        		            
    	 return dailyRankingMap;	     
	}   
}