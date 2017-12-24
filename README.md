[![Build Status](https://travis-ci.org/pinkybalan/ReportEngine.svg?branch=master)](https://travis-ci.org/pinkybalan/ReportEngine)

[![Coverage Status](https://coveralls.io/repos/github/pinkybalan/ReportEngine/badge.svg?branch=master&v=1.0)](https://coveralls.io/github/pinkybalan/ReportEngine?branch=master)

[![BCH compliance](https://bettercodehub.com/edge/badge/pinkybalan/ReportEngine?branch=master)](https://bettercodehub.com/)

# ReportEngine
Generates trade amount and ranking reports for the given instructions.

# Requirement:

Need to generate report that shows
1.	Trade amount settled outgoing everyday.
2.	Trade amount settled incoming everyday.
3.	Ranking of entities based on incoming.
4.	Ranking of entities based on outgoing.

# Instruction:
1.	Entity – A financial entity whose shares are bought or sold
2.	Trade Action (Buy/Sell) 
  	B – Buy – Outgoing
    S – Sell – Incoming
3.	Instruction Date – Date on which the instruction was sent
4.	Settlement Date – Date on which the instruction was settled
5.	Agreed Fx – Foreign exchange rate that was agreed
6.	Units – No of units to be bought or sold 
7.	Currency –  Currency of the trade (ex: AED, SAR, SGP)
8.	Price per unit – Price per unit for each entity
9.	Trade amount in USD = Price/Unit * units * Agreed Fx

# Design:

## Settlement Date Calculation:
1.	Based on the currency the working days need to be considered.               
* **Arabian Country Working days:**
Sunday, Monday, Tuesday, Wednesday, Thursday
* **Other Country Working days:**
Monday, Tuesday, Wednesday, Thursday, Friday
2.	Instruction settlement date must be verified whether it is a working day or not. If it is a working day can retain the same date and if not a working day then need to find the next working date for settlement date.
3.	For this had a separate implementation class for different country working days, which gives us the list of working days. Used a Factory class to get the instance for particular implementation class. This pattern will be useful if in future there need to be add a new set of working days for another country. 
4.	**SettlementDateCalculator** is the class which handles these operations and finds the correct settlement date.
5.	Once settlement date is calculated we can proceed to calculate the details required for generating reports.

## Report Calculation:
1.	Calculate daily trade amount based on incoming and outgoing instructions.
With the given set of inputs first need to filter for incoming(S) and    outgoing (B) and then group by settlement date and sum all the trade amounts. This will give us a mapping of Settlement date and trade amount for both incoming and outgoing separately.
2.	Calculate entity ranking based on incoming and outgoing instructions.
With the given set of inputs first need to filter for incoming(S) and outgoing (B) and then group by settlement date and map to entity, trade amount. Then for each date sort the trade amount and assign ranking to entities. The entity with highest trade amount will be ranked 1 and continued. The entity with same amount will be given same ranking.  
3.	**ReportCalculator** is the class which handles these operations.
4.	Data’s are ready for generating daily trade amount report and ranking report.

## Generate Reports:
For displaying the calculated data in the report format, **GenerateReportImpl** class generates the report from the calculated details.

## Output:
In order to show the output generated some dummy inputs are provided in **ReportInputGenerator** class.
