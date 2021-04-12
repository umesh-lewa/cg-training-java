package control;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import servicepack.LoginServiceImpl;

/**
 * Application Lifecycle Listener implementation class MySessionListener
 *
 */
public class MySessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MySessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("session created...");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	
    	System.out.println("session destroyed...");
    	HttpSession session=se.getSession();
    	Object name=session.getAttribute("uname");
    	if(name!=null) {
    		String uname=name.toString();
    		LoginServiceImpl login=LoginServiceImpl.getLoginService();
    		login.updateFlag(uname, 0);
    	}
    }
	
}
