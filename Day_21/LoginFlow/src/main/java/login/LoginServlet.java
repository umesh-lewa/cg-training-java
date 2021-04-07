package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String uname = request.getParameter("uname");
        String psw = request.getParameter("psw");
        
        System.out.println("uname : "+uname);
        System.out.println("psw : "+psw);
        
        boolean isUserPresent = false;
        boolean isCredsCorrect = false;
        
		try {
			Connection con=DBUtil.getConnection();
			
			Statement st=con.createStatement();
			
			ResultSet rs= st.executeQuery("select * from user where username = '"+uname+"'");
			System.out.println(rs.toString());
			
			while(rs.next()) {
				
				int uid  = rs.getInt("userid");
		        String username = rs.getString("username");
		        String password = rs.getString("password");
		        int flag = rs.getInt("flag");
		        
		        System.out.println("unanme : "+uname);
		        System.out.println("username : "+username);
		        
		        if(uname.equals(username)) {
		        	isUserPresent = true;
		        	System.out.println("User is present....!!!");
		        	if(password.equals(psw)) {
		        		isCredsCorrect = true;
		        		System.out.println("User is present....!!!and Creds are Correct....!!!");
		        	}else {
		        		System.out.println("User is present....!!!and Creds are not Correct....!!!");
		        	}
		        	
		        }else {
		        	System.out.println("User is not present....!!!");
		        }

			}
			
			DBUtil.closeConnection(null, null);
		}catch(Exception e) {
			DBUtil.closeConnection(e, null);
			e.printStackTrace();
		}
		
		if(isUserPresent&&isCredsCorrect) {
		//	response.sendRedirect("anotherpage.html");
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request, response);
		}else if(isUserPresent&&!isCredsCorrect) {
			response.setContentType("text/html");

		      // Writing message to the web page
		      PrintWriter out = response.getWriter();
		      out.println("<h1>" + "Credentials are Incorrect....!!!" + "</h1>");
		}else {
			RequestDispatcher rd=request.getRequestDispatcher("register.html");
			rd.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
