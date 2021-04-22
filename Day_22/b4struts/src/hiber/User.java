package hiber;

import java.io.Serializable;

import daopack.UserDTO;

public class User implements Comparable<User>, Serializable,Cloneable{

	private int uid;
	private String uname,upass;
	private int flag;
	
	@Override
	public int compareTo(User o) {
		return this.uname.compareTo(o.uname);
	}
	
	public final int getUid() {
		return uid;
	}

	public final void setUid(int uid) {
		this.uid = uid;
	}

	public final String getUname() {
		return uname;
	}

	public final void setUname(String uname) {
		this.uname = uname;
	}

	public final String getUpass() {
		return upass;
	}

	public final void setUpass(String upass) {
		this.upass = upass;
	}

	public final int getFlag() {
		return flag;
	}

	public final void setFlag(int flag) {
		this.flag = flag;
	}

	public UserDTO getClone() {
		try {
			return (UserDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		return "UserDTO [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", flag=" + flag + "]";
	}
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String uname, String upass, int flag) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.flag = flag;
	}
	
}
