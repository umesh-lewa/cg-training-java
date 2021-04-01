package day19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemMasterDAOImpl implements ItemMasterDAO{

	@Override
	public ItemDTO findByID(Integer itemid) {
		
		ItemDTO itemDTO = new ItemDTO();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from itemmaster where itmeid = "+itemid);
						
			while(rs.next()) {
				
				int iteid  = rs.getInt("itemid");
		        String itemdesc = rs.getString("itemdesc");
		        int price = rs.getInt("price");

		        itemDTO.setItemid(iteid);
		        itemDTO.setItemdesc(itemdesc);
		        itemDTO.setPrice(price);
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return itemDTO;
	}

	@Override
	public List<ItemDTO> findAll() {
		
		List<ItemDTO> listOfItemDTO = new ArrayList<ItemDTO>();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from itemmaster");
			
			while(rs.next()) {
				
				ItemDTO itemDTO = new ItemDTO();
				
				int itemid  = rs.getInt("itemid");
		        String itemdesc = rs.getString("itemdesc");
		        int price = rs.getInt("price");

		        itemDTO.setItemid(itemid);
		        itemDTO.setItemdesc(itemdesc);
		        itemDTO.setPrice(price);
		        
		        listOfItemDTO.add(itemDTO);
		        
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return listOfItemDTO;

	}

	@Override
	public int insertItem(ItemDTO itemDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "INSERT INTO itemmaster " + "VALUES ("+itemDTO.getItemid()+", '"+itemDTO.getiItemdesc()+"', '"+itemDTO.getPrice()+")";
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int updateItem(ItemDTO itemDTO) {
		
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "UPDATE itemmaster " + "SET itemdesc = "+itemDTO.getiItemdesc()+" WHERE itemid = "+itemDTO.getItemid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteItemByID(Integer itemid) {
			
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM itemmaster " + "WHERE itemid = "+itemid;
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteItemByDTO(ItemDTO itemDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM itemmaster " + "WHERE itemid = "+itemDTO.getItemid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

}
