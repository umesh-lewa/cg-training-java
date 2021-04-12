package utils;

public class InvoiceItem {

	String DESCRIPTION;
	String QUATITY;
	String UNIT_PRICE;
	String TOTAL;
	
	public InvoiceItem(String DESCRIPTION,String QUATITY,String UNIT_PRICE,String TOTAL){
		this.DESCRIPTION = DESCRIPTION;
		this.QUATITY = QUATITY;
		this.UNIT_PRICE = UNIT_PRICE;
		this.TOTAL = TOTAL;
	}

}