package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.GuestDAO;
import model.Guest;
import utility.HashingPassword;
import utility.Validator;

/**
 * Servlet implementation class GuestServlet
 */
@WebServlet("/register")
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GuestDAO guestDao = new GuestDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/registeration-forum.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		//validate input fields
		PrintWriter pw = null;
		response.setContentType("text/html");
	    
	    pw = response.getWriter();
	    
	   //check for name
	    if(first_name == null || first_name.length()==0 || first_name.equals(" ") || last_name == null || last_name.length()==0 || last_name.equals(" ")) {   
	    	   pw.println("<h4 style='color:red'>Guest name is required.</h4>");
	    	   return; 
	    	} else if(first_name.length() < 3 || last_name.length() < 3){
	    	   pw.println("<h4 style='color:red'>"+
	    	              "Guest name must have minimum 3 Characters.</h4>");
	    	   return; 
	    	}
		//check for email
	    if(!Validator.isValidEmail(email)) {
	    	pw.println("<h4 style='color:red'>"+
  	              "Email must be written with the right pattern,Enter a correct Email.</h4>");
	    		return;
	    	}
	    //check for password
	    if(!Validator.isValidPassword(password)) {
	    	pw.println("<h4 style='color:red'>"+
  	              "Password must be 9 characters. and must contain capital and small letter , numbers and special character !!</h4>");
	    		return;
	    	}
	    //hashing password db must be varchar(255) to handle large string size generated from hashing
	    String hashedPassword = HashingPassword.hashing(password);
	    
	    //store guest obj 
		Guest guest = new Guest();
		guest.setFirst_name(first_name);
		guest.setLast_name(last_name);
		guest.setEmail(email);
		guest.setPassword(hashedPassword);
		
		try {
			guestDao.insertGuest(guest);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp");
		dispatcher.forward(request,response);
		
	}

}
