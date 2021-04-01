package day19;

import java.util.List;

public interface InvoiceMasterDAO {
	
	public List<InvoiceMasterDAO> findAll();
	public InvoiceMasterDAO findByID(Integer invid);	
	public int insertItem(InvoiceMasterDAO invoiceMasterDao);
	public int updateItem(InvoiceMasterDAO invoiceMasterDao);
	public int deleteItemByID(Integer invid);
	public int deleteItemByDTO(InvoiceMasterDAO invoiceMasterDao);
	
}
