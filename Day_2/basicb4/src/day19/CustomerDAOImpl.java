package day19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public List<CustomerDTO> findAll() {
		
		List<CustomerDTO> listOfCustomerDTO = new ArrayList<CustomerDTO>();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from customer");
			
			while(rs.next()) {
				
				CustomerDTO customerDTO = new CustomerDTO();
				
				int customerid  = rs.getInt("customerid");
		        String customername = rs.getString("customername");
		        String customeraddress = rs.getString("customeraddress");
		        String customercellphone = rs.getString("customercellphone");
		        String customeraccountdetails = rs.getString("customeraccountdetails");
		        String customergstnumber = rs.getString("customergstnumber");

		        customerDTO.setCustomerid(customerid);
		        customerDTO.setCustomername(customername);
		        customerDTO.setCustomeradress(customeraddress);
		        customerDTO.setCustomercellphone(customercellphone);
		        customerDTO.setCustomeraccountdetails(customeraccountdetails);
		        customerDTO.setCustomergstnumber(customergstnumber);
		        
		        listOfCustomerDTO.add(customerDTO);
		        
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return listOfCustomerDTO;
	}

	@Override
	public CustomerDTO findByID(Integer customerid) {
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from customer where customerid = "+customerid);
						
			while(rs.next()) {
				
				int cusid  = rs.getInt("customerid");
		        String customername = rs.getString("customername");
		        String customeraddress = rs.getString("customeraddress");
		        String customercellphone = rs.getString("customercellphone");
		        String customeraccountdetails = rs.getString("customeraccountdetails");
		        String customergstnumber = rs.getString("customergstnumber");

		        customerDTO.setCustomerid(cusid);
		        customerDTO.setCustomername(customername);
		        customerDTO.setCustomeradress(customeraddress);
		        customerDTO.setCustomercellphone(customercellphone);
		        customerDTO.setCustomeraccountdetails(customeraccountdetails);
		        customerDTO.setCustomergstnumber(customergstnumber);
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return customerDTO;
	}

	@Override
	public int insertItem(CustomerDTO customerDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "INSERT INTO customer " + "VALUES ("+customerDTO.getCustomerid()+", '"+customerDTO.getCustomername()+"', '"+customerDTO.getCustomeradress()+"', "+customerDTO.getCustomercellphone()+"', "+customerDTO.getCustomeraccountdetails()+"', "+customerDTO.getCustomergstnumber()+")";
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int updateItem(CustomerDTO customerDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "UPDATE user " + "SET customername = "+customerDTO.getCustomername()+", customeraddress = "+customerDTO.getCustomername()+", customercellphone = "+customerDTO.getCustomercellphone()+", customeraccountdetails = "+customerDTO.getCustomeraccountdetails()+", customergstnumber = "+customerDTO.getCustomergstnumber()+" WHERE customerid = "+customerDTO.getCustomerid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteItemByID(Integer customerid) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM customer " + "WHERE customerid = "+customerid;
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		return 0;
	}

	@Override
	public int deleteItemByDTO(CustomerDTO cutomerDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM customer " + "WHERE customerid = "+cutomerDTO.getCustomerid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

}
