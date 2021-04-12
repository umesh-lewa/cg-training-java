package utils;

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
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletContext;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aspose.cells.PdfCompliance;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;

import daopack.DBUtility;

public class InvoiceGenerator {
	
	private ServletContext ctx;
	
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
				
               invoiceTotal+= temp;             
        }
        
        try {

            FileOutputStream out = new FileOutputStream(new File("Invoice.xlsx"));
            workbook.write(out);
            out.close();
            
            Workbook workbook1 = new Workbook("Invoice.xlsx");

	        //PdfSaveOptions options = new PdfSaveOptions();
	        //options.setCompliance(PdfCompliance.PDF_A_1_A);
	         
	        workbook1.save("Invoice.pdf");
	        
	        /*
	        InvoiceStorageObject iso = new InvoiceStorageObject();
	        iso.setWorkbook1(workbook1);
	        
	        ByteArrayOutputStream baos;
	        ObjectOutputStream out1;
	        baos = new ByteArrayOutputStream();
	        
	        try {
		        out1 = new ObjectOutputStream(baos);
		        out1.writeObject(iso);
		        out1.close();
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        
	        byte[] byteObject = baos.toByteArray();
	        
	        //to deserialize the object :
	        ByteArrayInputStream bais;
	        ObjectInputStream in;
	        try {
		        bais = new ByteArrayInputStream(byteObject);
		        in = new ObjectInputStream(bais);
		        iso = (InvoiceStorageObject) in.readObject();
		        in.close();
	        } catch (Exception ex) {
	        	ex.printStackTrace();
	        }
	        */
	        int min = 1000;  
			int max = 10000;  		
			System.out.println("Random value of type int between "+min+" to "+max+ ":");  
			int invid = (int)(Math.random()*(max-min+1)+min);  		
			System.out.println("invid : "+invid);
			
	       	        
          	SMSUtil sms = new SMSUtil();
          	LocalDateTime date = LocalDateTime.now();
            System.out.println("Current Date and Time: "+date);
            
            System.out.println("Checking if ctx is null....!!!");
            if(this.ctx==null) {
            	System.out.println("Its null....!!!");
            }else {
            	System.out.println("Its not null....!!!");
            }
            
            long serialized_id = serializeJavaObjectToDB(this.ctx, invid, date.toString(), new File("Invoice.pdf"));            
            System.out.println("serialized_id : "+serialized_id);
            
          	//String sid = sms.sendSMS("+91"+userphone, "Invoice ID + "+invid+"Invoice Total : "+invoiceTotal+"Invoice Date : "+date.toString(), this.ctx);
          	//System.out.println("SMS sid : "+sid);
          	
          	String emailacc="";
          	String emailpass="";
          	
          	try {
    			Properties prop=new Properties();
    			prop.load(new FileInputStream(this.ctx.getAttribute("dbconfigpath").toString()));
    			emailacc=prop.getProperty("emailacc");
    			emailpass=prop.getProperty("emailpass");
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
          	
          	EmailUtil email = new EmailUtil();
          	//email.generateAndSendEmail("smtp.gmail.com", "587", emailacc, emailpass, "Invoice Generated", "Invoice ID + "+invid+"Invoice Total : "+invoiceTotal+"Invoice Date : "+date.toString(),useremail);
          	
          	File objFromDatabase = (File) deSerializeJavaObjectFromDB(this.ctx, invid);
          	System.out.println("Deserialized obj from DB : "+objFromDatabase.getName());
          	
          	try {
          		/*
          		PDDocument document = PDDocument.load(new File("Invoice.pdf"));
          		if (!document.isEncrypted()) {
          		    PDFTextStripper stripper = new PDFTextStripper();
          		    String text = stripper.getText(document);
          		    System.out.println("Text:" + text);
          		}
          		document.close();
          		 */
          	}catch(Exception e) {
          		e.printStackTrace();
          	}
          	
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
	
	public static long serializeJavaObjectToDB(ServletContext ctx,int invid,String invdate, Object objectToSerialize) throws SQLException {

		final String SQL_SERIALIZE_OBJECT = "INSERT INTO invoicemaster(invid, invdate, customerid, invoiceobject) VALUES (?, ?, ?, ?)";
		
		System.out.println("Checking again if ctx is null....!!!");
        if(ctx==null) {
        	System.out.println("Its null....!!!");
        }else {
        	System.out.println("Its not null....!!!");
        }
        
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
		System.out.println("Java object serialized to database. Object: "+ objectToSerialize);
		
		return serialized_id;
	}
	
	public static Object deSerializeJavaObjectFromDB(ServletContext ctx,int invid) throws SQLException, IOException,ClassNotFoundException {
		
		final String SQL_DESERIALIZE_OBJECT = "SELECT invoiceobject FROM invoicemaster WHERE invid = ?";
		
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