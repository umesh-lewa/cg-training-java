package service;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAOImpl;
import dao.UserDTO;

public class LoginService implements Cloneable{

	private LoginService() {
		
	}
	
	private static LoginService loginService;
	
	synchronized public static LoginService getLoginService() {
		
		if(loginService==null) {
			loginService=new LoginService();
		}
		
		return loginService.getCloneLoginService();
	}
	
	private LoginService getCloneLoginService() {
		
		try {
			return (LoginService)super.clone();
		} catch (CloneNotSupportedException e) {
			
			e.printStackTrace();
			return null;
		}
	}
	
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		String status = "";
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		UserDTO user = userDAOImpl.findByUsername(request.getParameter("uname"));
				
		boolean isUserPresent = false;
        boolean isCredsCorrect = false;
               
        if(user.getUsername()!=null&&user.getUsername().equals(request.getParameter("uname"))) {
        	isUserPresent = true;
        	System.out.println("User is present....!!!");
        	if(user.getPassword().equals(request.getParameter("psw"))) {
        		isCredsCorrect = true;
        		System.out.println("User is present....!!!and Creds are Correct....!!!");
        	}else {
        		System.out.println("User is present....!!!and Creds are not Correct....!!!");
        	}
        	
        }else {
        	System.out.println("User is not present....!!!");
        }
		
        
		if(isUserPresent&&isCredsCorrect) {
			//	response.sendRedirect("anotherpage.html");
			//RequestDispatcher rd=request.getRequestDispatcher("home.html");
			//rd.forward(request, response);
			status = "1";
			System.out.println("Setting login flag....!!!");
			setFlag(user);
		}else if(isUserPresent&&!isCredsCorrect) {
			response.setContentType("text/html");

			// Writing message to the web page
			//PrintWriter out = response.getWriter();
			//out.println("<h1>" + "Credentials are Incorrect....!!!" + "</h1>");
			status = "2";
		}else {
			//RequestDispatcher rd=request.getRequestDispatcher("register.html");
			//rd.forward(request, response);
			status = "3";
		}
		
		return status;
	}
	
	public static String setFlag(UserDTO user) {
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		UserDTO userDTO= new UserDTO();
		userDTO.setUserid(user.getUserid());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setFlag(1);
		
		userDAOImpl.updateItem(userDTO);
		
		return null;
	}
	
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}
	
	public String register(HttpServletRequest request, HttpServletResponse response) {
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		UserDTO userDTO= new UserDTO();
		userDTO.setUserid(999);
		userDTO.setUsername(request.getParameter("username"));
		userDTO.setPassword(request.getParameter("psw"));
		userDTO.setFlag(3);
		
		userDAOImpl.insertItem(userDTO);
		
		return null;
	}
}
