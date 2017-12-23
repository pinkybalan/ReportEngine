package model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Priya Balan
 *
 */
public class ReportInput {
	
	private String entity;
	
	private String tradeAction;

	private BigDecimal agreedFx;
	
	private String currency;	
	
	private LocalDate instructionDate;
	
	private LocalDate settlementDate;
	
	private int units;
	
	private BigDecimal pricePerUnit;


	/**
	 * @param entity
	 * @param tradeAction
	 * @param agreedFx
	 * @param currency
	 * @param instructionDate
	 * @param settlementDate
	 * @param units
	 * @param pricePerUnit
	 */
	public ReportInput(String entity, String tradeAction, BigDecimal agreedFx, String currency, LocalDate instructionDate,
			LocalDate settlementDate, int units, BigDecimal pricePerUnit) {
		this.entity = entity;
		this.tradeAction = tradeAction;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.pricePerUnit = pricePerUnit;		
	}

	
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}

	
	
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * @return the instructionDate
	 */
	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	
	/**
	 * @return the settlementDate
	 */
	public LocalDate getSettlementDate() {
		return settlementDate;
	}

	/**
	 * @param settlementDate the settlementDate to set
	 */
	public void setSettlementDate(LocalDate settlementDate) {
		this.settlementDate = settlementDate;
	}
	
	/**
	 * @return the tradeAction
	 */
	public String getTradeAction() {
		return tradeAction;
	}

	
	
	/**
	 * @return the agreedFx
	 */
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}


	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}


	/**
	 * @return the pricePerUnit
	 */
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}


	/**
	 * @return the tradeAmount
	 * TradeAmount = Price per unit * units * agreedFx
	 */
	public BigDecimal getTradeAmount() {
		return pricePerUnit
				.multiply(BigDecimal.valueOf(units))
				.multiply(agreedFx);
	}

		
	
}
