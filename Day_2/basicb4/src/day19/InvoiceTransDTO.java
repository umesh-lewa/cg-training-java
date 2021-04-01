package day19;

import java.io.Serializable;

public class InvoiceTransDTO implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1787836746848426240L;

	private static InvoiceTransDTO invoiceTransDTO;
	private int invid;
	private int itemid;
	private int qty;
	
	synchronized public static InvoiceTransDTO getInvoiceDTO() {
		
		if(invoiceTransDTO==null) {
			invoiceTransDTO=new InvoiceTransDTO();
		}
		
		return invoiceTransDTO.getCloneInvoiceDTO();
	}
	
	private InvoiceTransDTO getCloneInvoiceDTO() {
		
		try {
			return (InvoiceTransDTO)super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "ItemDTO [invid=" + invid + ", itemid=" + itemid + ", qty=" + qty + "]";
	}
	
	public int getInvid() {
		return invid;
	}
	public void setInvid(int invid) {
		this.invid = invid;
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itenid) {
		this.itemid = itenid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
}
