package day19;

import java.util.List;

public interface CustomerDAO {
	
	public List<CustomerDAO> findAll();
	public CustomerDAO findByID(Integer customerid);	
	public int insertItem(CustomerDAO customerDAO);
	public int updateItem(CustomerDAO customerDAO);
	public int deleteItemByID(Integer customerid);
	public int deleteItemByDTO(CustomerDAO cutomerDAO);
	
}
