package day15;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aspose.cells.PdfCompliance;
import com.aspose.cells.PdfSaveOptions;
import com.aspose.cells.Workbook;

public class InvoiceGenerator {
	
	private Set<InvoiceItem> invoiceItems = new HashSet<InvoiceItem>();
	
	public void setInvoiceItems(Set<InvoiceItem> invoiceItems){
		this.invoiceItems=invoiceItems;
	}
	
	public void generateInvoice(){
		
		InvoiceDetails ivd = new InvoiceDetails.InvoiceDetailsBuilder("","","")
				.setBILL_TO_CLIENT_COMPANY_NAME("")
				.setSHIP_TO_CLIENT_COMPANY_NAME("")
				.build();
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		  
        XSSFSheet sheet = workbook.createSheet("Invoice");
		
		Set<InvoiceItem> invoiceItems = this.invoiceItems;
	
		int rownum = 0;
		
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
               
        }
        
        try {

            FileOutputStream out = new FileOutputStream(new File("Invoice.xlsx"));
            workbook.write(out);
            out.close();
            
            Workbook workbook1 = new Workbook("Invoice.xlsx");

	        PdfSaveOptions options = new PdfSaveOptions();
	        //options.setCompliance(PdfCompliance.PDF_A_1_A);
	         
	        workbook1.save("Invoice.pdf", options);
          	
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
	
	public static void main(String args[]) {
		
		
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
		
		int rownum = 0;
		
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
               
        }
     
        /*
        Map<String, Object[]> data = new TreeMap<String, Object[]>();
        data.put("1", new Object[]{ "ID", "NAME", "LASTNAME" });
        data.put("2", new Object[]{ 1, "Umesh", "Moorthy" });
        data.put("3", new Object[]{ 2, "Surya", "Dev" });
        data.put("4", new Object[]{ 3, "Chandra Dev" });
        data.put("5", new Object[]{ 4, "Virat", "kohli" });
  
        Set<String> keyset = data.keySet();
        int rownum = 0;
        
        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            
            for (Object obj : objArr) {
                
                Cell cell = row.createCell(cellnum++);
                
                if (obj instanceof String) {
                    cell.setCellValue((String)obj);
                }else if (obj instanceof Integer) {
                    cell.setCellValue((Integer)obj);
                }
                
            }
            
        }
        */
        
        try {

            FileOutputStream out = new FileOutputStream(new File("Invoice.xlsx"));
            workbook.write(out);
            out.close();
            
            Workbook workbook1 = new Workbook("Invoice.xlsx");

	        PdfSaveOptions options = new PdfSaveOptions();
	        //options.setCompliance(PdfCompliance.PDF_A_1_A);
	         
	        workbook1.save("Invoice.pdf", options);
          	
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

class InvoiceItem {

	String DESCRIPTION;
	String QUATITY;
	String UNIT_PRICE;
	String TOTAL;
	
	InvoiceItem(String DESCRIPTION,String QUATITY,String UNIT_PRICE,String TOTAL){
		this.DESCRIPTION = DESCRIPTION;
		this.QUATITY = QUATITY;
		this.UNIT_PRICE = UNIT_PRICE;
		this.TOTAL = TOTAL;
	}
	
}