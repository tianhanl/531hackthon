package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.User;
import mysql.SQLDriver;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginServlet() {
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("in loginServlet");
    	HttpSession session = request.getSession(true);
    	
    	
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	if(SQLDriver.checkPassword(username, password)){
    		// login successfully
    		User loggedInUser = SQLDriver.findUser(username);
    		session.setAttribute("loggedInUser", loggedInUser); 
    	}else{
    		// login fail
    		session.setAttribute("error", "incorrect username or password");
    	}
    }

}
