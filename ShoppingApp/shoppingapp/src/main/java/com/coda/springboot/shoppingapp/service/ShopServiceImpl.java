package com.coda.springboot.shoppingapp.service;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coda.springboot.shoppingapp.model.Invoice;
import com.coda.springboot.shoppingapp.model.Item;
import com.coda.springboot.shoppingapp.repository.InvoiceRepository;
import com.coda.springboot.shoppingapp.repository.ItemRepository;
import com.coda.springboot.shoppingapp.utils.InvoiceGenerator;
import com.coda.springboot.shoppingapp.utils.InvoiceItem;

@Service
@Component("ssc")
public class ShopServiceImpl implements ShopService{

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public List<Item> findItemsByItemtype(String itemtype) {
		
		System.out.println("itemRepository :"+itemRepository);
		return itemRepository.findByItemtype(itemtype);
	}
	
	@Override
	public List<Invoice> findAllInvoice() {
		
		System.out.println("invoiceRepository :"+invoiceRepository);
		return invoiceRepository.findAll();
	}

	@Override
	public String doShop(HttpServletRequest request) {
		
		String formid=request.getParameter("formid");
		
		if(formid.equals("goshop")) {
			return "shop1";
		}
		
		String shopid=request.getParameter("shopid");
		Enumeration<String> e=request.getParameterNames();
		HttpSession session=request.getSession();
		
		while(e.hasMoreElements()) {
			System.out.println("Setting values in session....!!!");
			String name=e.nextElement();
			String value=request.getParameter(name);
			if(name.equals("formid")||name.equals("shopid")||name.equals("useremail")||name.equals("userphone")) {
				
			}else {
				if(value!=null) {
					System.out.println("Setting => name : "+name+" , value : "+value);
					session.setAttribute(name, value);
				}
			}
		}
		
		String nextShop = "";
		/*
		if(shopid.equals("shop3")) {
			
			String useremail = request.getParameter("useremail");
			String userphone = request.getParameter("userphone");
			
			System.out.println("useremail : "+useremail);
			System.out.println("userphone : "+userphone);
			
			nextShop = "invoice";
		}
		*/
		
		int currentShopNum = Integer.parseInt(shopid.substring(shopid.length() - 1));
		System.out.println("currentShopNum : "+currentShopNum);
		int nextShopNum = currentShopNum+1;		
		//String nextShop = "shop"+nextShopNum;
		nextShop = "shop"+nextShopNum;
		
		if(shopid.equals("shop3")) {
			
			String useremail = request.getParameter("useremail");
			String userphone = request.getParameter("userphone");
			
			System.out.println("useremail : "+useremail);
			System.out.println("userphone : "+userphone);
			
			Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>();
			
			int total = 0;
			
			Enumeration<String> enu=session.getAttributeNames();
			System.out.println("Values from Session....!!!");
			
			while(enu.hasMoreElements()) {
				String name=enu.nextElement();
				
				
				if(name.equals("formid")||name.equals("shopid")||name.equals("SPRING_SECURITY_CONTEXT")) {
					
				}else {
					//session.setAttribute(name, value);
					//System.out.println(name+":"+value);
					//String[] data=value.split(":");  
					//System.out.println("data : "+data[0]+"----->"+data[1]);
					//String d = data[1].toString();
					System.out.println("Session attribute names....!!!");
					System.out.println("name : "+name);
					String value=(String)session.getAttribute(name);
					System.out.println("name : "+name+" , value : "+value);
					if(value!=null) {
						String[] val = value.split(",");
						System.out.println("val : "+val[0]+"----->"+val[1]+"----->"+val[2]);
		
						invoiceItems.add(new InvoiceItem(val[0],val[1],val[2],val[2]));
						//float f=Float.parseFloat(val[2]);
						
						double d = Double.parseDouble(val[2].toString());
						int temp = (int) d;
						System.out.println("converted int temp : "+temp);
						total+= temp;
					}
					
				}
			}
			
			System.out.println("invoice total : "+total);
			System.out.println("invoiceItems.size() : "+invoiceItems.size());
		
			InvoiceGenerator invoiceGenerator = new InvoiceGenerator(invoiceRepository,request);
			invoiceGenerator.setInvoiceItems(invoiceItems);		
			invoiceGenerator.generateInvoice(useremail,userphone);
			
			//return "invoicePage";
					
			if(shopid.equals("shop3")) {
				
				nextShop = "invoice";
			}
		}
			
		return nextShop;
	}
	
}
