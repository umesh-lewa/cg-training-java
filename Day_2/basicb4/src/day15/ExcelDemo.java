package day15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {
	
	public static void main(String args[]) throws IOException {
		
		/*
		XSSFWorkbook workbook = new XSSFWorkbook();
		  
        XSSFSheet sheet = workbook.createSheet("some people");
  
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
        
        try {

            FileOutputStream out = new FileOutputStream(new File("test.xlsx"));
            workbook.write(out);
            out.close();
          
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
        	if(workbook!=null) {
        		workbook.close();
        	}
        }
        */
        try {
        	
            FileInputStream file = new FileInputStream(new File("test.xlsx"));
  
            XSSFWorkbook workbook2 = new XSSFWorkbook(file);

            XSSFSheet sheet2 = workbook2.getSheetAt(0);
  
            Iterator<Row> rowIterator = sheet2.iterator();
            
            while (rowIterator.hasNext()) {
            	
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();
  
                while (cellIterator.hasNext()) {
                	
                    Cell cell = cellIterator.next();
 
                    //System.out.println(cell.getCellType().toString());
                    
                    switch (cell.getCellType().toString()) {
                    
                    case "NUMERIC":
                        System.out.print(cell.getNumericCellValue() + " ");
                        break;
                    case "STRING":
                        System.out.print(cell.getStringCellValue() + " ");
                        break;
                    }
                    
                }
                
                System.out.println("");
            }
            
            file.close();
            
        }catch (Exception e) {
            e.printStackTrace();
        }finally{

        }
        
    }

}
