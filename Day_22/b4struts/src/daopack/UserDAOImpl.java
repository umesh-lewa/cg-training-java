package daopack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

import javax.servlet.ServletContext;

public class UserDAOImpl implements UserDAO,Cloneable{

	private ServletContext ctx;
	
	public void setServCtx(ServletContext ctx) {
		this.ctx = ctx;
	}
	
	private UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	private static UserDAOImpl userDaoImpl;
	
	public static UserDAOImpl getUserDaoImpl() {
		if(userDaoImpl==null) {
			userDaoImpl=new UserDAOImpl();
		}
		return userDaoImpl.getClone();
	}
	
	public UserDAOImpl getClone() {
		try {
			return (UserDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public UserDTO findById(int uid) {
	
		UserDTO userDTO = new UserDTO();
		
		try {
			Connection con=DBUtility.getConnection(ctx);
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from user where userid = "+uid);
			
			while(rs.next()) {
				
				int userid  = rs.getInt("userid");
		        String username = rs.getString("username");
		        String password = rs.getString("password");
		        int flag = rs.getInt("flag");

		        userDTO.setUid(userid);
		        userDTO.setUname(username);
		        userDTO.setUpass(password);
		        userDTO.setFlag(flag);
			}
			
			DBUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
		return userDTO;
		
	}

	@Override
	public Set<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(UserDTO userDTO) {
		
		try {
			Connection con=DBUtility.getConnection(ctx);
			
			Statement st=con.createStatement();
			
			String sql = "INSERT INTO user " + "VALUES ("+userDTO.getUid()+", '"+userDTO.getUname()+"', '"+userDTO.getUpass()+"', "+userDTO.getFlag()+")";
			
			st.executeUpdate(sql);
			
			DBUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		
		try {
			Connection con=DBUtility.getConnection(ctx);
			
			Statement st=con.createStatement();
			
			String sql = "UPDATE user " + "SET username = "+userDTO.getUname()+","+"password = "+userDTO.getUpass()+","+"flag = "+userDTO.getFlag()+" WHERE userid = "+userDTO.getUid();
			
			st.executeUpdate(sql);
			
			DBUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
		}
		
		return 0;
	}

	@Override
	public UserDTO findByName(String uname) {
		
		UserDTO userDTO = new UserDTO();
	       
		try {
			Connection con=DBUtility.getConnection(ctx);
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from user where username = '"+uname+"'");
			System.out.println(rs.toString());
			
			while(rs.next()) {
				
				int userid  = rs.getInt("userid");
		        String username = rs.getString("username");
		        String password = rs.getString("password");
		        int flag = rs.getInt("flag");
		        
		        System.out.println("unanme : "+uname);
		        System.out.println("username : "+username);
		        
		        userDTO.setUid(userid);
		        userDTO.setUname(username);
		        userDTO.setUpass(password);
		        userDTO.setFlag(flag);
		        
			}
			
			DBUtility.closeConnection(null, null);
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
		
		return userDTO;
	}

}
