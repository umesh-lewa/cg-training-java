package day19;

import java.io.Serializable;

public class InvoiceMasterDTO implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5862830728212664563L;
	
	private InvoiceMasterDTO invoiceMasterDTO;
	
	private int invid;
	private String invdate;
	private int customerid;
	
	public InvoiceMasterDTO getInvoiceMasterDTO() {
		
		if(invoiceMasterDTO==null) {
			invoiceMasterDTO=new InvoiceMasterDTO();
		}
		
		return invoiceMasterDTO.getCloneInvoiceMasterDTO();
	}
	
	private InvoiceMasterDTO getCloneInvoiceMasterDTO() {
		
		try {
			return (InvoiceMasterDTO)super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "InvoiceMasterDTO [invid=" + invid + ", invdate=" + invdate + ", customerid=" + customerid + "]";
	}
	
	public int getInvid() {
		return invid;
	}
	public void setInvid(int invid) {
		this.invid = invid;
	}
	public String getInvdate() {
		return invdate;
	}
	public void setInvdate(String invdate) {
		this.invdate = invdate;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	
	

}
