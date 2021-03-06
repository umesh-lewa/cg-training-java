package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.UserDAOImpl;
import servicepack.LoginServiceImpl;

public class LogoutAction extends Action {
 @Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	 
	HttpSession session=request.getSession();
	String uname=session.getAttribute("uname").toString();
	
	LoginServiceImpl lservice=LoginServiceImpl.getLoginService();
	lservice.setUserDAO(UserDAOImpl.getUserDaoImpl());
	lservice.setServCtx(request.getServletContext());
	lservice.updateFlag(uname, 0);
	
	return "logout.success";
}
}
