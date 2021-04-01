package day19;

import java.util.List;

public interface CustomerDAO {
	
	public List<CustomerDTO> findAll();
	public CustomerDTO findByID(Integer customerid);	
	public int insertItem(CustomerDTO customerDTO);
	public int updateItem(CustomerDTO customerDTO);
	public int deleteItemByID(Integer customerid);
	public int deleteItemByDTO(CustomerDTO cutomerDTO);
	
}
