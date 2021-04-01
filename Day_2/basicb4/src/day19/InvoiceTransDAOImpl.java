package day19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceTransDAOImpl implements InvoiceTransDAO{

	@Override
	public List<InvoiceTransDTO> findAll() {
		
		List<InvoiceTransDTO> listOfInvoiceTransDTO = new ArrayList<InvoiceTransDTO>();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from invoicetrans");
			
			while(rs.next()) {
				
				InvoiceTransDTO invoiceTransDTO = new InvoiceTransDTO();
				
				int invid  = rs.getInt("intid");
		        int itemid = rs.getInt("itemid");
		        int qty = rs.getInt("qty");

		        invoiceTransDTO.setInvid(invid);
		        invoiceTransDTO.setItemid(itemid);
		        invoiceTransDTO.setQty(qty);
		        
		        listOfInvoiceTransDTO.add(invoiceTransDTO);
		        
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return listOfInvoiceTransDTO;
	}

	@Override
	public InvoiceTransDTO findByID(Integer invid) {
		
		InvoiceTransDTO invoiceTransDTO = new InvoiceTransDTO();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from invoicetrans where invid = "+invid);
						
			while(rs.next()) {
				
				int inid  = rs.getInt("intid");
		        int itemid = rs.getInt("itemid");
		        int qty = rs.getInt("qty");

		        invoiceTransDTO.setInvid(invid);
		        invoiceTransDTO.setItemid(itemid);
		        invoiceTransDTO.setQty(qty);
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return invoiceTransDTO;

	}

	@Override
	public int insertItem(InvoiceTransDTO invoiceTransDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "INSERT INTO invoicetrans " + "VALUES ("+invoiceTransDTO.getInvid()+", '"+invoiceTransDTO.getItemid()+"', '"+invoiceTransDTO.getQty()+")";
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		return 0;
	}

	@Override
	public int updateItem(InvoiceTransDTO invoiceTransDTO) {
		
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "UPDATE invoicetrans " + "SET qty = "+invoiceTransDTO.getQty()+" WHERE invid = "+invoiceTransDTO.getInvid();
			
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
			
			String sql = "DELETE FROM invoicetrans " + "WHERE invid = "+invid;
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteItemByDTO(InvoiceTransDTO invoiceTransDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM invoicetrans " + "WHERE invid = "+invoiceTransDTO.getInvid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

}
