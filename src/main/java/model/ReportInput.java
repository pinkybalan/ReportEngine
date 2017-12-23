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
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}

	/**
	 * @return the agreedFx
	 */
	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	/**
	 * @param agreedFx the agreedFx to set
	 */
	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the instructionDate
	 */
	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	/**
	 * @param instructionDate the instructionDate to set
	 */
	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
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
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}

	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}

	/**
	 * @return the pricePerUnit
	 */
	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	/**
	 * @param pricePerUnit the pricePerUnit to set
	 */
	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	/**
	 * @return the tradeAction
	 */
	public String getTradeAction() {
		return tradeAction;
	}

	/**
	 * @param tradeAction the tradeAction to set
	 */
	public void setTradeAction(String tradeAction) {
		this.tradeAction = tradeAction;
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
