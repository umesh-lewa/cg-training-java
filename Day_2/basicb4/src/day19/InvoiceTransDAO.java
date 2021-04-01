package day19;

import java.util.List;

public interface InvoiceTransDAO {
	
	public List<InvoiceTransDTO> findAll();
	public InvoiceTransDTO findByID(Integer invid);	
	public int insertItem(InvoiceTransDTO invoiceTransDTO);
	public int updateItem(InvoiceTransDTO invoiceTransDTO);
	public int deleteItemByID(Integer invid);
	public int deleteItemByDTO(InvoiceTransDTO invoiceTransDTO);
	
}
