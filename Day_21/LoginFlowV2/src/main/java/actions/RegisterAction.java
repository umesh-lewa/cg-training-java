package actions;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;

public class RegisterAction extends Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//LoginService ls = new LoginService();
		LoginService ls = LoginService.getLoginService();
		String status = ls.register(request, response);
		
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		try {
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
