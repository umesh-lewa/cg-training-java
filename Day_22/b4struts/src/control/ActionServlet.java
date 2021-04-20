package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class ActionServlet
 */

@WebServlet(value = "*.do", initParams = {
		   @WebInitParam(name = "config", value = "/WEB-INF/config.properties"),
		   @WebInitParam(name = "dbconfig", value = "/WEB-INF/dbconfig.properties")
		},
			loadOnStartup = 1
		)
public class ActionServlet extends HttpServlet {
	
	private RequestProcessor rp;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
		rp=new RequestProcessor();
		
		ServletContext application=config.getServletContext();
		String configfile=config.getInitParameter("config");
		String dbconfigfile=config.getInitParameter("dbconfig");
		String configpath=application.getRealPath(configfile);
		String dbconfigpath=application.getRealPath(dbconfigfile);
		
		Properties configProp=new Properties();
		configProp.load(new FileInputStream(configpath));
		
		Properties dbConfigProp=new Properties();
		dbConfigProp.load(new FileInputStream(dbconfigpath));
		
		application.setAttribute("configProp", configProp);
		application.setAttribute("dbConfigProp", dbConfigProp);
		
		application.setAttribute("dbconfigpath", dbconfigpath);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rp.process(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
