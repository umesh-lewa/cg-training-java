package dao;

import java.io.Serializable;

public class UserDTO implements Serializable,Cloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1421087857233541273L;
	private int userid;
	private String username;
	private String password;
	private int flag;
	
	private static UserDTO userDTO;
	
	synchronized public static UserDTO getUserDTO() {
		
		if(userDTO==null) {
			userDTO=new UserDTO();
		}
		
		return userDTO.getCloneUserDTO();
		
	}
	
	private UserDTO getCloneUserDTO() {
		
		try {
			return (UserDTO)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "ItemDTO [userid=" + userid + ", username=" + username + ", password=" + password + ", flag="
				+ flag + "]";
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}
}
