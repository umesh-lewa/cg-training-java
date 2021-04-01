package day19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO{

	@Override
	public List<InvoiceMasterDTO> findAll() {
		
		List<InvoiceMasterDTO> listOfInvoiceMasterDTO = new ArrayList<InvoiceMasterDTO>();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from invoicemaster");
			
			while(rs.next()) {
				
				InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
				
				int ivid  = rs.getInt("invid");
		        String invdate = rs.getString("invdate");		        
		        int customerid = rs.getInt("customerid");

		        invoiceMasterDTO.setInvid(ivid);
		        invoiceMasterDTO.setInvdate(invdate);
		        invoiceMasterDTO.setCustomerid(customerid);
		        
		        listOfInvoiceMasterDTO.add(invoiceMasterDTO);
		        
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return listOfInvoiceMasterDTO;

	}

	@Override
	public InvoiceMasterDTO findByID(Integer invid) {
		
		InvoiceMasterDTO invoiceMasterDTO = new InvoiceMasterDTO();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from invoicemaster where invid = "+invid);
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int colCount=rsmd.getColumnCount();
			
			for(int i=1;i<=colCount;i++) {
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
						
			while(rs.next()) {
				
				int ivid  = rs.getInt("invid");
		        String invdate = rs.getString("invdate");		        
		        int customerid = rs.getInt("customerid");

		        invoiceMasterDTO.setInvid(ivid);
		        invoiceMasterDTO.setInvdate(invdate);
		        invoiceMasterDTO.setCustomerid(customerid);
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return invoiceMasterDTO;
		
	}

	@Override
	public int insertItem(InvoiceMasterDTO invoiceMasterDto) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "INSERT INTO invoicemaster " + "VALUES ("+invoiceMasterDto.getInvid()+", '"+invoiceMasterDto.getInvdate()+"', '"+invoiceMasterDto.getCustomerid()+")";
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int updateItem(InvoiceMasterDTO invoiceMasterDto) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "UPDATE invoicemaster " + "SET customerid = "+invoiceMasterDto.getCustomerid()+" WHERE invid = "+invoiceMasterDto.getInvid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteItemByID(Integer invid) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM invoicemaster " + "WHERE invid = "+invid;
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteItemByDTO(InvoiceMasterDTO invoiceMasterDto) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM invoicemaster " + "WHERE invid = "+invoiceMasterDto.getInvid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	
}
