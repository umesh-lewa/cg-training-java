package actions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LoginService;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		//LoginService ls = new LoginService();
		LoginService ls = LoginService.getLoginService();
		String status = ls.login(request, response);
		
		if(status.equals("1")) {
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}else if(status.equals("2")) {
			
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<h1>" + "Credentials are Incorrect....!!!" + "</h1>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
		}else if(status.equals("3")) {
			
			RequestDispatcher rd=request.getRequestDispatcher("register.html");
			try {
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return null;
	}

}
