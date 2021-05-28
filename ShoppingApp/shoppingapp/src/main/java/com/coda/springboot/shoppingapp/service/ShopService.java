package com.coda.springboot.shoppingapp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.coda.springboot.shoppingapp.model.Invoice;
import com.coda.springboot.shoppingapp.model.Item;

public interface ShopService {

	public List<Item> findItemsByItemtype(String itemtype);
	
	public String doShop(HttpServletRequest request);
	
	public List<Invoice> findAllInvoice();
	
}
