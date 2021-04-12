package utils;

import java.io.Serializable;

import com.aspose.cells.Workbook;

public class InvoiceStorageObject implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7263525361310906301L;
	
	private Workbook workbook1 = new Workbook();

	public Workbook getWorkbook1() {
		return workbook1;
	}

	public void setWorkbook1(Workbook workbook1) {
		this.workbook1 = workbook1;
	}
	
}
