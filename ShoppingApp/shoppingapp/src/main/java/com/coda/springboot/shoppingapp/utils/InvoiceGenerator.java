package com.coda.springboot.shoppingapp.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aspose.cells.PdfCompliance;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;
import com.coda.springboot.shoppingapp.model.Invoice;
import com.coda.springboot.shoppingapp.repository.InvoiceRepository;
import com.coda.springboot.shoppingapp.utils.DBUtility;

@Component
public class InvoiceGenerator {
	
	private final InvoiceRepository invoiceRepository;
	
	HttpServletRequest request;
	
    public InvoiceGenerator(InvoiceRepository invoiceRepository,HttpServletRequest request) {
        this.invoiceRepository = invoiceRepository;
        //System.out.println(invoiceRepository.findAll());
        this.request = request;
    }
    
	//@Autowired
	//private InvoiceRepository invoiceRepository;
	
	@Autowired
	private LobHelper lobCreator;
	
	private ServletContext ctx;
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle("application");
	
	public void setServCtx(ServletContext ctx) {
		this.ctx = ctx;
	}
	
	private Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>();
	
	public void setInvoiceItems(Set<InvoiceItem> invoiceItems){
		this.invoiceItems=invoiceItems;
	}
	
	public void generateInvoice(String useremail,String userphone){
		
		InvoiceDetails ivd = new InvoiceDetails.InvoiceDetailsBuilder("","","")
				.setBILL_TO_CLIENT_COMPANY_NAME("")
				.setSHIP_TO_CLIENT_COMPANY_NAME("")
				.build();
		
		XSSFWorkbook workbook = new XSSFWorkbook();		  
        XSSFSheet sheet = workbook.createSheet("Invoice");
		
		Set<InvoiceItem> invoiceItems = this.invoiceItems;
	
		int rownum = 0;		
		int invoiceTotal = 0 ;
		
        for(InvoiceItem invoiceItem : invoiceItems){
        	
        	   System.out.println(invoiceItem);
        	   
        	   Row row = sheet.createRow(rownum++);

               Cell cell0 = row.createCell(0); 
               cell0.setCellValue((String)invoiceItem.DESCRIPTION);               
               Cell cell1 = row.createCell(1); 
               cell1.setCellValue((String)invoiceItem.QUATITY);            
               Cell cell2 = row.createCell(2); 
               cell2.setCellValue((String)invoiceItem.UNIT_PRICE);               
               Cell cell3 = row.createCell(3); 
               cell3.setCellValue((String)invoiceItem.TOTAL);
               
               double d = Double.parseDouble(invoiceItem.TOTAL.toString());
			   int temp = (int) d;
			   System.out.println("converted int temp : "+temp);
				
			   System.out.println(" invoiceItem : "+invoiceItem.toString());
               invoiceTotal+= temp;             
        }
        
        LocalDateTime date = LocalDateTime.now();
        
        int min = 1000;  
		int max = 10000;  		
		System.out.println("Random value of type int between "+min+" to "+max+ ":");  
		int invid = (int)(Math.random()*(max-min+1)+min);  		
		System.out.println("invid : "+invid);
		
        Row row1 = sheet.createRow(rownum++);

        Cell cell01 = row1.createCell(0); 
        Cell cell11 = row1.createCell(1);      
        Cell cell21 = row1.createCell(2); 
        cell21.setCellValue("Invoice Date");               
        Cell cell31 = row1.createCell(3); 
        cell31.setCellValue(date.toString());
        	
        Row row2 = sheet.createRow(rownum++);

        Cell cell02 = row2.createCell(0); 
        Cell cell12 = row2.createCell(1);      
        Cell cell22 = row2.createCell(2); 
        cell22.setCellValue("Invoice ID");               
        Cell cell32 = row2.createCell(3); 
        cell32.setCellValue(String.valueOf(invid));
        
        Row row3 = sheet.createRow(rownum++);

        Cell cell03 = row3.createCell(0); 
        Cell cell13 = row3.createCell(1);      
        Cell cell23 = row3.createCell(2); 
        cell23.setCellValue("Invoice Total");               
        Cell cell33 = row3.createCell(3); 
        cell33.setCellValue(String.valueOf(invoiceTotal));
        
        try {

            FileOutputStream out = new FileOutputStream(new File("Invoice.xlsx"));
            workbook.write(out);
            out.close();
            
            Workbook workbook1 = new Workbook("Invoice.xlsx");
	         
	        workbook1.save("Invoice.pdf");
	       	
					
          	SMSUtility sms = new SMSUtility();
          	
            System.out.println("Current Date and Time: "+date);
            
            long serialized_id = serializeJavaObjectToDB(invid, date.toString(), new File("Invoice.pdf"));            
            System.out.println("serialized_id : "+serialized_id);
            
            System.out.println("Setting invoice values in session....!!!");
            HttpSession session=request.getSession();
			System.out.println("Setting => Invoice ID , value : "+String.valueOf(invid));
			session.setAttribute("Invoice ID", invid);
			System.out.println("Setting => invoiceTotal , value : "+String.valueOf(invoiceTotal));
			session.setAttribute("Invoice Total", invoiceTotal);
			System.out.println("Setting => Invoice date , value : "+date.toString());
			session.setAttribute("Invoice Date", date.toString());
			
			
          	//String sid = sms.sendSMS("+91"+userphone, "Invoice ID + "+invid+"Invoice Total : "+invoiceTotal+"Invoice Date : "+date.toString(), this.ctx);
          	//String sid = sms.sendSMS("+91"+userphone, "Invoice ID + "+invid+"Invoice Total : "+invoiceTotal+"Invoice Date : "+date.toString());
          	//System.out.println("SMS sid : "+sid);
          	
          	String emailacc="";
          	String emailpass="";
          	
          	try {
    			emailacc=bundle.getString("email.emailid");
    			emailpass=bundle.getString("email.password");
    			//System.out.println("email.emailid : "+emailacc);
    			//System.out.println("email.password : "+emailpass);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
          	
          	EmailUtility email = new EmailUtility();
          	email.generateAndSendEmail("smtp.gmail.com", "587", emailacc, emailpass, "Invoice Generated", "Invoice ID + "+invid+"Invoice Total : "+invoiceTotal+"Invoice Date : "+date.toString(),useremail);
          	
          	//File objFromDatabase = (File) deSerializeJavaObjectFromDB(this.ctx, invid);
          	//System.out.println("Deserialized obj from DB : "+objFromDatabase.getName());
          	         	
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
        	try {
        		if(workbook!=null) {
        			workbook.close();
        		}
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        
	}
	
	//public static long serializeJavaObjectToDB(int invid,String invdate, Object objectToSerialize) throws SQLException {
		
	public long serializeJavaObjectToDB(int invid,String invdate, File fileToSerialize) throws SQLException {

		final String SQL_SERIALIZE_OBJECT = "INSERT INTO invoicemaster(invid, invdate, customerid, invoiceobject) VALUES (?, ?, ?, ?)";
		/*
		System.out.println("Checking again if ctx is null....!!!");
        if(ctx==null) {
        	System.out.println("Its null....!!!");
        }else {
        	System.out.println("Its not null....!!!");
        }
        */
		
		/*
		Connection connection = DBUtility.getConnection(ctx);
		PreparedStatement pstmt = connection.prepareStatement(SQL_SERIALIZE_OBJECT,Statement.RETURN_GENERATED_KEYS);

		// just setting the class name
		pstmt.setInt(1, invid);
		pstmt.setString(2, invdate);
		pstmt.setInt(3, 999);
		pstmt.setObject(4, objectToSerialize);
		System.out.println("Executing pstmt....!!!");
		pstmt.executeUpdate();
		connection.commit();
		System.out.println("Done Executing pstmt....!!!");
		ResultSet rs = pstmt.getGeneratedKeys();
		int serialized_id = -1;
		if (rs.next()) {
			serialized_id = rs.getInt(1);
		}
		rs.close();
		pstmt.close();
		*/
	        
		Invoice invoice = new Invoice();
		invoice.setInvid(invid);
		invoice.setInvdate(invdate);
		invoice.setCustomerid(999);
		
		byte[] contents;
	    Blob blob = null;
	    try {
	        contents = Files.readAllBytes(fileToSerialize.toPath());
	        blob = new SerialBlob(contents);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    
		invoice.setInvoiceobject(blob);
		System.out.println("invid : "+invid);
		System.out.println("invdate : "+invdate);
		System.out.println("blob : "+blob);
		
		if(invoice!=null) {
			System.out.println("invoice : "+invoice.toString());
		}else {
			System.out.println("invoice object is null....!!!");
		}
		
		if(invoiceRepository!=null) {
			System.out.println("invoiceRepository is not null");
		}else{
			System.out.println("invoiceRepository is null....!!!");
		}
		
		invoiceRepository.save(invoice);
		
		System.out.println("Java File object serialized to database. Object: "+ fileToSerialize);
		
		return Long.parseLong("999");
		
		//return serialized_id;
	}
	
	public static Object deSerializeJavaObjectFromDB(ServletContext ctx,int invid) throws SQLException, IOException,ClassNotFoundException {
		
		final String SQL_DESERIALIZE_OBJECT = "SELECT invoiceobject FROM invoicemaster WHERE invid = ?";
		/*
		Connection connection = DBUtility.getConnection(ctx);
		PreparedStatement pstmt = connection.prepareStatement(SQL_DESERIALIZE_OBJECT);
		
		pstmt.setInt(1, invid);
		ResultSet rs = pstmt.executeQuery();
		rs.next();

		// Object object = rs.getObject(1);

		byte[] buf = rs.getBytes(1);
		ObjectInputStream objectIn = null;
		if (buf != null)
			objectIn = new ObjectInputStream(new ByteArrayInputStream(buf));

		Object deSerializedObject = objectIn.readObject();

		rs.close();
		pstmt.close();

		System.out.println("Java object de-serialized from database. Object: "+ deSerializedObject + " Classname: "+ deSerializedObject.getClass().getName());
		
		return deSerializedObject;
		*/
		return new Object();
	}
	
	public static void main(String args[]) {
		/*
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		
		InvoiceDetails ivd = new InvoiceDetails.InvoiceDetailsBuilder("","","")
				.setBILL_TO_CLIENT_COMPANY_NAME("")
				.setSHIP_TO_CLIENT_COMPANY_NAME("")
				.build();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		  
        XSSFSheet sheet = workbook.createSheet("Invoice");
		
		Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>();
		invoiceItems.add(new InvoiceItem("Table","4","250","1000"));
		invoiceItems.add(new InvoiceItem("Chair","3","100","300"));
		invoiceItems.add(new InvoiceItem("Lamp","6","50","300"));
		
		invoiceGenerator.setInvoiceItems(invoiceItems);
		
		invoiceGenerator.generateInvoice();
		*/
	}

}

class InvoiceDetails{
	
	String COMPANY_NAME;
	String STREET;
	String CITY;
	String STATE;
	String ZIPCODE;
	String PHONE;
	String EMAIL;
	
	String DATE;
	String INVOICE_NO;
	
	String BILL_TO_CONTACT_NAME;
	String BILL_TO_CLIENT_COMPANY_NAME;
	String BILL_TO_ADDRESS;
	String BILL_TO_PHONE;
	String BILL_TO_EMAIL;
	
	String SHIP_TO_NAME;
	String SHIP_TO_CLIENT_COMPANY_NAME;
	String SHIP_TO_ADDRESS;
	String SHIP_TO_PHONE;
	
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}

	public String getSTREET() {
		return STREET;
	}

	public void setSTREET(String sTREET) {
		STREET = sTREET;
	}

	public String getCITY() {
		return CITY;
	}

	public void setCITY(String cITY) {
		CITY = cITY;
	}

	public String getSTATE() {
		return STATE;
	}

	public void setSTATE(String sTATE) {
		STATE = sTATE;
	}

	public String getZIPCODE() {
		return ZIPCODE;
	}

	public void setZIPCODE(String zIPCODE) {
		ZIPCODE = zIPCODE;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getDATE() {
		return DATE;
	}

	public void setDATE(String dATE) {
		DATE = dATE;
	}

	public String getINVOICE_NO() {
		return INVOICE_NO;
	}

	public void setINVOICE_NO(String iNVOICE_NO) {
		INVOICE_NO = iNVOICE_NO;
	}

	public String getBILL_TO_CONTACT_NAME() {
		return BILL_TO_CONTACT_NAME;
	}

	public void setBILL_TO_CONTACT_NAME(String bILL_TO_CONTACT_NAME) {
		BILL_TO_CONTACT_NAME = bILL_TO_CONTACT_NAME;
	}

	public String getBILL_TO_CLIENT_COMPANY_NAME() {
		return BILL_TO_CLIENT_COMPANY_NAME;
	}

	public void setBILL_TO_CLIENT_COMPANY_NAME(String bILL_TO_CLIENT_COMPANY_NAME) {
		BILL_TO_CLIENT_COMPANY_NAME = bILL_TO_CLIENT_COMPANY_NAME;
	}

	public String getBILL_TO_ADDRESS() {
		return BILL_TO_ADDRESS;
	}

	public void setBILL_TO_ADDRESS(String bILL_TO_ADDRESS) {
		BILL_TO_ADDRESS = bILL_TO_ADDRESS;
	}

	public String getBILL_TO_PHONE() {
		return BILL_TO_PHONE;
	}

	public void setBILL_TO_PHONE(String bILL_TO_PHONE) {
		BILL_TO_PHONE = bILL_TO_PHONE;
	}

	public String getBILL_TO_EMAIL() {
		return BILL_TO_EMAIL;
	}

	public void setBILL_TO_EMAIL(String bILL_TO_EMAIL) {
		BILL_TO_EMAIL = bILL_TO_EMAIL;
	}

	public String getSHIP_TO_NAME() {
		return SHIP_TO_NAME;
	}

	public void setSHIP_TO_NAME(String sHIP_TO_NAME) {
		SHIP_TO_NAME = sHIP_TO_NAME;
	}

	public String getSHIP_TO_CLIENT_COMPANY_NAME() {
		return SHIP_TO_CLIENT_COMPANY_NAME;
	}

	public void setSHIP_TO_CLIENT_COMPANY_NAME(String sHIP_TO_CLIENT_COMPANY_NAME) {
		SHIP_TO_CLIENT_COMPANY_NAME = sHIP_TO_CLIENT_COMPANY_NAME;
	}

	public String getSHIP_TO_ADDRESS() {
		return SHIP_TO_ADDRESS;
	}

	public void setSHIP_TO_ADDRESS(String sHIP_TO_ADDRESS) {
		SHIP_TO_ADDRESS = sHIP_TO_ADDRESS;
	}

	public String getSHIP_TO_PHONE() {
		return SHIP_TO_PHONE;
	}

	public void setSHIP_TO_PHONE(String sHIP_TO_PHONE) {
		SHIP_TO_PHONE = sHIP_TO_PHONE;
	}

	public InvoiceDetails(InvoiceDetailsBuilder builder) {

	}
	
	public static class InvoiceDetailsBuilder{
		
		String COMPANY_NAME;
		String STREET;
		String CITY;
		String STATE;
		String ZIPCODE;
		String PHONE;
		String EMAIL;
		
		String DATE;
		String INVOICE_NO;
		
		String BILL_TO_CONTACT_NAME;
		String BILL_TO_CLIENT_COMPANY_NAME;
		String BILL_TO_ADDRESS;
		String BILL_TO_PHONE;
		String BILL_TO_EMAIL;
		
		String SHIP_TO_NAME;
		String SHIP_TO_CLIENT_COMPANY_NAME;
		String SHIP_TO_ADDRESS;
		String SHIP_TO_PHONE;
		
		
		public InvoiceDetailsBuilder(String COMPANY_NAME,String PHONE,String EMAIL) {
			this.COMPANY_NAME=COMPANY_NAME;
			this.PHONE=PHONE;
			this.EMAIL=EMAIL;
		}
		
		public String getSTREET() {
			return STREET;
		}

		public InvoiceDetailsBuilder setSTREET(String sTREET) {
			STREET = sTREET;
			return this;
		}

		public String getCITY() {
			return CITY;
		}

		public InvoiceDetailsBuilder setCITY(String cITY) {
			CITY = cITY;
			return this;
		}

		public String getSTATE() {
			return STATE;
		}

		public InvoiceDetailsBuilder setSTATE(String sTATE) {
			STATE = sTATE;
			return this;
		}

		public String getZIPCODE() {
			return ZIPCODE;
		}

		public InvoiceDetailsBuilder setZIPCODE(String zIPCODE) {
			ZIPCODE = zIPCODE;
			return this;
		}

		public String getDATE() {
			return DATE;
		}

		public InvoiceDetailsBuilder setDATE(String dATE) {
			DATE = dATE;
			return this;
		}

		public String getINVOICE_NO() {
			return INVOICE_NO;
		}

		public InvoiceDetailsBuilder setINVOICE_NO(String iNVOICE_NO) {
			INVOICE_NO = iNVOICE_NO;
			return this;
		}

		public String getBILL_TO_CONTACT_NAME() {
			return BILL_TO_CONTACT_NAME;
		}

		public InvoiceDetailsBuilder setBILL_TO_CONTACT_NAME(String bILL_TO_CONTACT_NAME) {
			BILL_TO_CONTACT_NAME = bILL_TO_CONTACT_NAME;
			return this;
		}

		public String getBILL_TO_CLIENT_COMPANY_NAME() {
			return BILL_TO_CLIENT_COMPANY_NAME;
		}

		public InvoiceDetailsBuilder setBILL_TO_CLIENT_COMPANY_NAME(String bILL_TO_CLIENT_COMPANY_NAME) {
			BILL_TO_CLIENT_COMPANY_NAME = bILL_TO_CLIENT_COMPANY_NAME;
			return this;
		}

		public String getBILL_TO_ADDRESS() {
			return BILL_TO_ADDRESS;
		}

		public InvoiceDetailsBuilder setBILL_TO_ADDRESS(String bILL_TO_ADDRESS) {
			BILL_TO_ADDRESS = bILL_TO_ADDRESS;
			return this;
		}

		public String getBILL_TO_PHONE() {
			return BILL_TO_PHONE;
		}

		public InvoiceDetailsBuilder setBILL_TO_PHONE(String bILL_TO_PHONE) {
			BILL_TO_PHONE = bILL_TO_PHONE;
			return this;
		}

		public String getBILL_TO_EMAIL() {
			return BILL_TO_EMAIL;
		}

		public InvoiceDetailsBuilder setBILL_TO_EMAIL(String bILL_TO_EMAIL) {
			BILL_TO_EMAIL = bILL_TO_EMAIL;
			return this;
		}

		public String getSHIP_TO_NAME() {
			return SHIP_TO_NAME;
		}

		public InvoiceDetailsBuilder setSHIP_TO_NAME(String sHIP_TO_NAME) {
			SHIP_TO_NAME = sHIP_TO_NAME;
			return this;
		}

		public String getSHIP_TO_CLIENT_COMPANY_NAME() {
			return SHIP_TO_CLIENT_COMPANY_NAME;
		}

		public InvoiceDetailsBuilder setSHIP_TO_CLIENT_COMPANY_NAME(String sHIP_TO_CLIENT_COMPANY_NAME) {
			SHIP_TO_CLIENT_COMPANY_NAME = sHIP_TO_CLIENT_COMPANY_NAME;
			return this;
		}

		public String getSHIP_TO_ADDRESS() {
			return SHIP_TO_ADDRESS;
		}

		public InvoiceDetailsBuilder setSHIP_TO_ADDRESS(String sHIP_TO_ADDRESS) {
			SHIP_TO_ADDRESS = sHIP_TO_ADDRESS;
			return this;
		}

		public String getSHIP_TO_PHONE() {
			return SHIP_TO_PHONE;
		}

		public InvoiceDetailsBuilder setSHIP_TO_PHONE(String sHIP_TO_PHONE) {
			SHIP_TO_PHONE = sHIP_TO_PHONE;
			return this;
		}
		
		public InvoiceDetails build() {
			return new InvoiceDetails(this);
		}
	}
	
}
