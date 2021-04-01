package day19;

import java.util.List;

public interface InvoiceMasterDAO {
	
	public List<InvoiceMasterDTO> findAll();
	public InvoiceMasterDTO findByID(Integer invid);	
	public int insertItem(InvoiceMasterDTO invoiceMasterDto);
	public int updateItem(InvoiceMasterDTO invoiceMasterDto);
	public int deleteItemByID(Integer invid);
	public int deleteItemByDTO(InvoiceMasterDTO invoiceMasterDto);
	
}
