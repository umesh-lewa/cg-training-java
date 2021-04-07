package actions;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("Executing logout....!!!");
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
