package com.coda.springboot.shoppingapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	
	/*
	@Id
	private int itemid;
	
	private String itemdesc;
	
	private String itemname;
	
	private String itemunit;
	
	private float price;
	
	private String itemtype;
	*/
	
	@Id
	@Column(name="itemid")
	private int itemid;
	
	@Column(name="itemdesc")
	private String itemdesc;
	
	@Column(name="itemname")
	private String itemname;
	
	@Column(name="itemunit")
	private String itemunit;
	
	@Column(name="price")
	private float price;
	
	@Column(name="itemtype")
	private String itemtype;
	

	public int getItemid() {
		return itemid;
	}
	
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	
	public String getiItemdesc() {
		return itemdesc;
	}
	
	public void setItemdesc(String itemdesc) {
		this.itemdesc = itemdesc;
	}
	
	public String getItem_name() {
		return itemname;
	}
	
	public void setItem_name(String itemname) {
		this.itemname = itemname;
	}
	
	public String getItem_unit() {
		return itemunit;
	}
	
	public void setItem_unit(String itemunit) {
		this.itemunit = itemunit;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

}
