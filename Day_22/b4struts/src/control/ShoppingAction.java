package control;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.InvoiceGenerator;
import utils.InvoiceItem;

public class ShoppingAction extends Action{
	
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	
	System.out.println("Inside ShoppingAction....!!!");
	
	String shopid=request.getParameter("shopid");
	Enumeration<String> e=request.getParameterNames();
	HttpSession session=request.getSession();
	
	ServletContext ctx = request.getServletContext();
	
	
	while(e.hasMoreElements()) {
		System.out.println("Setting values in session....!!!");
		String name=e.nextElement();
		String value=request.getParameter(name);
		if(name.equals("formid")||name.equals("shopid")||name.equals("useremail")||name.equals("userphone")) {
			
		}else {
			if(name.equals("15")) {
				System.out.println("Encountered 15 ....!!!");
				System.out.println("Value of Encountered 15 : "+value);
			}
			if(value!=null) {
				System.out.println("name : "+name+" , value : "+value);
				session.setAttribute(name, value);
			}
		}
	}
	
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
			String value=request.getParameter(name);
			System.out.println("name : "+name+" , value : "+value);
			if(name.equals("formid")||name.equals("shopid")) {
				
			}else {
				//session.setAttribute(name, value);
				//System.out.println(name+":"+value);
				//String[] data=value.split(":");  
				//System.out.println("data : "+data[0]+"----->"+data[1]);
				//String d = data[1].toString();
				System.out.println("Session attribute names....!!!");
				System.out.println("name : "+name);
				
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
		
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		invoiceGenerator.setInvoiceItems(invoiceItems);
		invoiceGenerator.setServCtx(ctx);
		
		invoiceGenerator.generateInvoice(useremail,userphone);
	}
	
	return shopid;
}
}
