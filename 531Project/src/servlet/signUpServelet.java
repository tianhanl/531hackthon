package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mysql.SQLDriver;

/**
 * Servlet implementation class signUpServelet
 */
@WebServlet("/signUpServelet")
public class signUpServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signUpServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("in signUpServlet");
    	HttpSession session = request.getSession(true);
    	
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	String nickname = request.getParameter("nickname");
    	if(SQLDriver.findUser(username) == null){
    		//username is available
    		SQLDriver.addUser(username, password, nickname);
    		session.setAttribute("error", "");
    	}
    	else{
    		//username is occupied
    		session.setAttribute("error", "username is occupied");
    	}
	}
	

}
