package Phase2_servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Phase2_servlet.programs.DatabaseConnection;

/**
 * Servlet implementation class Login_flyaway
 */
@WebServlet("/Login_flyaway")
public class Login_flyaway extends HttpServlet {
	private static final String url = "jdbc:mysql://localhost:3306/db_world";
    private static final String user = "root";
    private static final String password = "root";
    
    Connection con;
    PreparedStatement prSt;
    Statement stmt;
    ResultSet rs;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_flyaway() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password1=request.getParameter("password");
		if(username==null||username.equals("")||password1==null||password1.equals(""))
		{
			out.println("\nPlease enter your Login details");
			response.sendRedirect("Login_flyaway.jsp");
		}
		else{
		try {
			
	        String user_name=null;
	        String pass_word=null;
            Connection con = DatabaseConnection.initializeDatabase();
  
            
            PreparedStatement st = con
                   .prepareStatement("select * from Login where username=? and password=?");
 
            st.setString(1, username);
            st.setString(2, password1);
           
            
            rs=st.executeQuery();
            //System.out.println("\nRetrieving Flights for the route from "+src_city+" "+des_city+" "+"data from the Flight_deatails table");
            System.out.println();
            while(rs.next())
            {
            	
            	user_name=rs.getString("username");
            	pass_word=rs.getString("password");
            	
            
            }
            if(user_name.equals(username)&&pass_word.equals(password1))
            {
            	out.println("\nAlready a User");
            	HttpSession session=request.getSession();
        		session.setAttribute("username", user_name);
            	response.sendRedirect("search_flyaway.jsp");
            }
            else{
            	System.out.println("\nLogin Credentials are wrong");
            	System.out.println("\nTry to login with correct crendtials");
            	response.sendRedirect("Login_flyaway.jsp");
            }
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		}

	
		
		

		}
	}


