package network;

import java.text.DecimalFormat;

public class SingleDecimal {

	public static final SingleDecimal INSTANCE = new SingleDecimal("#0.00");
	
	private DecimalFormat dF;
	
	private SingleDecimal(String pattern){
		
		this.dF = new DecimalFormat(pattern);
		
	}
	
	public void setPattern(String pattern){
		
		this.dF.applyPattern(pattern);
		
	}
	
	public String format(double number){
		
		return this.dF.format(number);
		
	}
	
}
