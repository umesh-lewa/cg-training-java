package day19;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
	
	public static void main(String args[]) {
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		//UserDTO idFind = userDAOImpl.findByID(145);
		
		//ystem.out.println("idFind : "+idFind.toString());	
		
		List<UserDTO> allFind = userDAOImpl.findAll();
		System.out.println("allFind.size() : "+allFind.size());
		for(UserDTO userDTO:allFind) {
			System.out.println("allFind : "+userDTO.toString());
		}
		/*
		UserDTO userDTO= new UserDTO();
		userDTO.setUserid(145);
		userDTO.setUsername("somu");
		userDTO.setPassword("123");
		userDTO.setFlag(3);
		
		userDAOImpl.insertItem(userDTO);
		
		userDTO.setUsername("somu");
		
		userDAOImpl.updateItem(userDTO);
		
		userDAOImpl.deleteItemByID(145);
			
		userDAOImpl.deleteItemByDTO(userDTO);
		*/
	}
	
	@Override
	public UserDTO findByID(Integer userid) {
		
		UserDTO userDTO = new UserDTO();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from user where userid = "+userid);
			
			while(rs.next()) {
				
				int uid  = rs.getInt("userid");
		        String username = rs.getString("username");
		        String password = rs.getString("password");
		        int flag = rs.getInt("flag");

		        userDTO.setUserid(uid);
		        userDTO.setUsername(username);
		        userDTO.setPassword(password);
		        userDTO.setFlag(flag);
			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return userDTO;
	}

	@Override
	public List<UserDTO> findAll() {
			
		List<UserDTO> listOfUserDTO = new ArrayList<UserDTO>();
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from user;");
			
			ResultSetMetaData rsmd=rs.getMetaData();
			
			int rsrowcount = 0 ;
			
			while(rs.next()) {
				
				rsrowcount++;
				System.out.println("rsrowcount : "+rsrowcount);
				
				UserDTO userDTO = new UserDTO();
				
				int uid  = rs.getInt("userid");
		        String username = rs.getString("username");
		        String password = rs.getString("password");
		        int flag = rs.getInt("flag");

		        userDTO.setUserid(uid);
		        userDTO.setUsername(username);
		        userDTO.setPassword(password);
		        userDTO.setFlag(flag);
		        
		        listOfUserDTO.add(userDTO);
		        
			}
			
			System.out.println("listOfUserDTO : "+listOfUserDTO);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			e.printStackTrace();
			DBUtil.closeConnection(e, null);
		}
		
		return listOfUserDTO;
	}

	@Override
	public int insertItem(UserDTO userDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "INSERT INTO user " + "VALUES ("+userDTO.getUserid()+", '"+userDTO.getUsername()+"', '"+userDTO.getPassword()+"', "+userDTO.getFlag()+")";
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int updateItem(UserDTO userDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "UPDATE user " + "SET username = "+userDTO.getUsername()+" WHERE userid = "+userDTO.getUserid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteItemByID(Integer userid) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM user " + "WHERE id = "+userid;
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
   
		return 0;
	}

	@Override
	public int deleteItemByDTO(UserDTO userDTO) {
		
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			String sql = "DELETE FROM user " + "WHERE id = "+userDTO.getUserid();
			
			st.executeUpdate(sql);
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
		}
		
		return 0;
	}

}
