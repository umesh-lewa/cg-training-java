package servicepack;

import javax.servlet.ServletContext;

import daopack.UserDAO;
import daopack.UserDTO;

public class LoginServiceImpl implements LoginService,Cloneable{
	
	private LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	private static LoginServiceImpl loginService;
	synchronized public static LoginServiceImpl getLoginService() {
		if(loginService==null) {
			loginService=new LoginServiceImpl();
		}
		return loginService.getClone();
	}
	public final UserDAO getUserDAO() {
		return userDAO;
	}
	public final void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public LoginServiceImpl getClone() {
		try {
			return (LoginServiceImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private UserDAO userDAO;
	
	public LoginServiceImpl(UserDAO userDAO) {
		this.userDAO=userDAO;
	}
	
	private ServletContext ctx;
	
	public void setServCtx(ServletContext ctx) {
		this.ctx = ctx;
		this.userDAO.setServCtx(ctx);
	}

	@Override
	public boolean checkUser(String uname, String upass) {
		// TODO Auto-generated method stub
		UserDTO userDTO=userDAO.findByName(uname);
		if(userDTO!=null) {
			if(userDTO.getUpass().equals(upass)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkFlag(String uname) {
		UserDTO userDTO=userDAO.findByName(uname);
		if(userDTO!=null) {
			if(userDTO.getFlag()==0) {
				return true;
				//this.userDAO=userDTO;
			}
		}
		return false;
	}

	@Override
	public int updateFlag(String uname, int flag) {
		int n=0;
		UserDTO userDTO=userDAO.findByName(uname);
		if(userDTO!=null) {
			userDTO.setFlag(flag);
			n=userDAO.updateUser(userDTO);
		}
		
		return n;
	}

	@Override
	public int registerUser(int uid, String uname, String upass, int flag) {
		// TODO Auto-generated method stub
		UserDTO userDTO=new UserDTO(uid,uname,upass,flag);
		int n=userDAO.insertUser(userDTO);
		return n;
	}
	
}
