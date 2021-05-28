package com.coda.springboot.shoppingapp.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	@Id
	@Column(name="invid")
	private int invid;
	
	@Column(name="invdate")
	private String invdate;
	
	@Column(name="customerid")
	private int customerid;
	
	@Lob
	@Column(name="invoiceobject")
	private Blob invoiceobject;

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

	public Blob getInvoiceobject() {
		return invoiceobject;
	}

	public void setInvoiceobject(Blob invoiceobject) {
		this.invoiceobject = invoiceobject;
	}
		
}
