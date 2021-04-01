package day19;

import java.io.Serializable;

public class CustomerDTO implements Serializable,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2801075592057981464L;
	
	private int customerid;
	private String customername;
	private String customeradress;
	private String customercellphone;
	private String customeraccountdetails;
	private String customergstnumber;
	
	private static CustomerDTO customerDTO;
	
	synchronized public static CustomerDTO getCustomerDTO() {
		
		if(customerDTO==null) {
			customerDTO=new CustomerDTO();
		}
		
		return customerDTO.getCloneCustomerDTO();
	}
	
	private CustomerDTO getCloneCustomerDTO() {
		
		try {
			return (CustomerDTO)super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [customerid=" + customerid + ", customername=" + customername + ", customeradress=" + customeradress + ", customercellphone="
				+ customercellphone + ", customeraccountdetails=" + customeraccountdetails + ", customergstnumber=" + customergstnumber+"]";
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeradress() {
		return customeradress;
	}

	public void setCustomeradress(String customeradress) {
		this.customeradress = customeradress;
	}

	public String getCustomercellphone() {
		return customercellphone;
	}

	public void setCustomercellphone(String customercellphone) {
		this.customercellphone = customercellphone;
	}

	public String getCustomeraccountdetails() {
		return customeraccountdetails;
	}

	public void setCustomeraccountdetails(String customeraccountdetails) {
		this.customeraccountdetails = customeraccountdetails;
	}

	public String getCustomergstnumber() {
		return customergstnumber;
	}

	public void setCustomergstnumber(String customergstnumber) {
		this.customergstnumber = customergstnumber;
	}

}
