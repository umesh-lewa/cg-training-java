package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import actions.LoginAction;
import actions.LogoutAction;
import actions.RegisterAction;

public class RequestProcessor {

	public String processRequest(HttpServletRequest request, HttpServletResponse response) {
		
		LoginAction loginAction = new LoginAction();
		LogoutAction logoutAction = new LogoutAction();
		RegisterAction registerAction = new RegisterAction();
		
		String typeOfAction = request.getParameter("formid");
		
		if(typeOfAction.equals("login")) {
			try {
				loginAction.execute(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(typeOfAction.equals("logout")) {
			logoutAction.execute(request, response);
			System.out.println("porcessing logout action....!!!");
		}else if(typeOfAction.equals("register")) {
			registerAction.execute(request, response);
		}
		
		return null;
	}
}
