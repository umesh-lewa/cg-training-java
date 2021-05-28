package com.coda.springboot.shoppingapp.utils;

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
	
	@Override
	public String toString() {
		return "InvoicceItem [DESCRIPTION="+DESCRIPTION+", QUATITY="+QUATITY+", UNIT_PRICE="+UNIT_PRICE+", TOTAL="+TOTAL+"]";
	}

}
