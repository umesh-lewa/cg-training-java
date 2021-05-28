package com.coda.springboot.shoppingapp.utils;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.servlet.tags.RequestContextAwareTag;

import com.coda.springboot.shoppingapp.model.Invoice;
import com.coda.springboot.shoppingapp.model.Item;
import com.coda.springboot.shoppingapp.repository.ItemRepository;
import com.coda.springboot.shoppingapp.service.ShopService;
import com.coda.springboot.shoppingapp.service.ShopServiceImpl;


public class DBTagInvoice extends RequestContextAwareTag{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9072053944921574043L;
	
	@Autowired
    ShopService shopService;

    @Override
    protected int doStartTagInternal() throws Exception {
        if (shopService == null) {
            System.out.println("Autowiring the shopService bean....!!!");
            WebApplicationContext wac = getRequestContext().getWebApplicationContext();
            AutowireCapableBeanFactory acbf = wac.getAutowireCapableBeanFactory();
            acbf.autowireBean(this);
        }
        
        return SKIP_BODY;
    }

	@Override
	public int doEndTag() throws JspException {
		
		System.out.println("Inside taglib class....!!!");
		
		JspWriter out=pageContext.getOut();
		 
		    try{   
		    	
		    	System.out.println("shopService : "+shopService);
		    	List<Invoice> invoices = shopService.findAllInvoice();		    
		    	
		    	for(Invoice invoice:invoices) {

		            out.write("<tr>"
						      +"<th scope='row'>"+invoice.getInvid()+"</th>"
						      +"<td>"+invoice.getInvdate()+"</td>"
						      +"<td>"+invoice.getCustomerid()+"</td>"
						      +"<td>"+invoice.getInvoiceobject().toString()+"</td>"
						      +"</tr>");

		    	}

		    }catch(Exception e){
		    	System.out.println(e);
		    	e.printStackTrace();
		    }  
		    //return SKIP_BODY;  
		    
		return super.doEndTag();
	}
	
}

