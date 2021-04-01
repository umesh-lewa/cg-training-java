package day19;

import java.util.List;

public interface InvoiceTransDAO {
	
	public List<InvoiceTransDAO> findAll();
	public InvoiceTransDAO findByID(Integer invid);	
	public int insertItem(InvoiceTransDAO invoiceTransDAO);
	public int updateItem(InvoiceTransDAO invoiceTransDAO);
	public int deleteItemByID(Integer invid);
	public int deleteItemByDTO(InvoiceTransDAO invoiceTransDAO);
	
}
