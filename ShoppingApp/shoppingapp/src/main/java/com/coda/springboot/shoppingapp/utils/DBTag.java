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

import com.coda.springboot.shoppingapp.model.Item;
import com.coda.springboot.shoppingapp.repository.ItemRepository;
import com.coda.springboot.shoppingapp.service.ShopService;
import com.coda.springboot.shoppingapp.service.ShopServiceImpl;


public class DBTag extends RequestContextAwareTag{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9072053944921574043L;
	
	private String itemtype;
	
	public final String getItemtype() {
		return itemtype;
	}
	public final void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}
	
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
		
		System.out.println("Item type is : "+itemtype);
		
		JspWriter out=pageContext.getOut();
		 
		    try{   
		    	//ShopServiceImpl shopService = new ShopServiceImpl();		    	
		    	
		    	//ApplicationContext aC = RequestContextUtils.getWebApplicationContext();
		    	//ShopService shopService = (ShopService) aC.getBean("ssc");
		    	
		    	System.out.println("shopService : "+shopService);
		    	List<Item> items = shopService.findItemsByItemtype(itemtype);		    
		    	
		    	for(Item item:items) {
		    		/*
		    		<div class="col-md-4">
		              <div class="card mb-4 box-shadow">
		                <img class="card-img-top" data-src="holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail" alt="Thumbnail [100%x225]" style="height: 225px; width: 100%; display: block;" src="data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22348%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20348%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_179a3792810%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A17pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_179a3792810%22%3E%3Crect%20width%3D%22348%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22116.7109375%22%20y%3D%22120.15%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E" data-holder-rendered="true">
		                <div class="card-body">
		                  <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
		                  <div class="d-flex justify-content-between align-items-center">
		                    <div class="btn-group">
		                      <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
		                      <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
		                    </div>
		                    <small class="text-muted">9 mins</small>
		                  </div>
		                </div>
		              </div>
		            </div>
		            */
		            out.write("<div class=\"col-md-4\">\n"
		            		+ "		              <div class=\"card mb-4 box-shadow\">\n"
		            		+ "		                <img class=\"card-img-top\" data-src=\"holder.js/100px225?theme=thumb&amp;bg=55595c&amp;fg=eceeef&amp;text=Thumbnail\" alt=\"Thumbnail [100%x225]\" style=\"height: 225px; width: 100%; display: block;\" src=\"data:image/svg+xml;charset=UTF-8,%3Csvg%20width%3D%22348%22%20height%3D%22225%22%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20viewBox%3D%220%200%20348%20225%22%20preserveAspectRatio%3D%22none%22%3E%3Cdefs%3E%3Cstyle%20type%3D%22text%2Fcss%22%3E%23holder_179a3792810%20text%20%7B%20fill%3A%23eceeef%3Bfont-weight%3Abold%3Bfont-family%3AArial%2C%20Helvetica%2C%20Open%20Sans%2C%20sans-serif%2C%20monospace%3Bfont-size%3A17pt%20%7D%20%3C%2Fstyle%3E%3C%2Fdefs%3E%3Cg%20id%3D%22holder_179a3792810%22%3E%3Crect%20width%3D%22348%22%20height%3D%22225%22%20fill%3D%22%2355595c%22%3E%3C%2Frect%3E%3Cg%3E%3Ctext%20x%3D%22116.7109375%22%20y%3D%22120.15%22%3EThumbnail%3C%2Ftext%3E%3C%2Fg%3E%3C%2Fg%3E%3C%2Fsvg%3E\" data-holder-rendered=\"true\">\n"
		            		+ "		                <div class=\"card-body\">\n"
		            		+ "		                  <p class=\"card-text\">"+item.getiItemdesc()+"</p>\n"
		            		+ "		                  <div class=\"d-flex justify-content-between align-items-center\">\n"
		            		+ "		                    <div class=\"btn-group\">\n"
//		            		+ "		                      <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">View</button>\n"
//		            		+ "		                      <button type=\"button\" class=\"btn btn-sm btn-outline-secondary\">Edit</button>\n"
		            		+ "		                    </div>");
		    		out.write(item.getItem_name()+" : "+"<input type='checkbox' name="+item.getItemid()+" value="+item.getItem_name()+","+item.getItem_unit()+","+item.getPrice()+" >");
		    		out.write("</div>\n"
		    				+ "		                </div>\n"
		    				+ "		              </div>\n"
		    				+ "		            </div>");
		    	}
		    	/*
		        Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection con=DriverManager.getConnection("jdbc:mysql://nztokwuj3eg8qmjx:te3avcbcll0amby9@bmlx3df4ma7r1yh4.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/jydol3b6ay8z4qa0","nztokwuj3eg8qmjx","te3avcbcll0amby9");  
		        PreparedStatement ps=con.prepareStatement("select * from item where itemtype=?");  
		        ps.setString(1,itemtype);  
		        ResultSet rs=ps.executeQuery();  
		        if(rs!=null){  
			        ResultSetMetaData rsmd=rs.getMetaData();  
			        int totalcols=rsmd.getColumnCount(); 
			        
			        System.out.println("Getting values from rs....!!!");
			        while(rs.next()){
			        	out.write(rs.getString("itemname")+" : "+"<input type='checkbox' name="+rs.getString("itemid")+" value="+rs.getString("itemname")+","+rs.getString("itemunit")+","+rs.getString("price")+" >");
			        	
			    		//%>
			    		//<%=resultSet.getString("itemname") %>:<input type="checkbox" name="<%=resultSet.getString("itemid") %>" value="<%=resultSet.getString("itemname") %>,<%=resultSet.getString("itemunit") %>,<%=resultSet.getString("price") %>">
			    		//<%
			    		
			    	}		        		          	    		          
		        }  
		        con.close();  
		        */
		    }catch(Exception e){
		    	System.out.println(e);
		    	e.printStackTrace();
		    }  
		    //return SKIP_BODY;  
		    
		return super.doEndTag();
	}
	
}
