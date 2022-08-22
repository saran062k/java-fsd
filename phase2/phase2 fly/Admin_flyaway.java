package Phase2_servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Phase2_servlet.programs.DatabaseConnection;

/**
 * Servlet implementation class Admin_flyaway
 */
@WebServlet("/Admin_flyaway")
public class Admin_flyaway extends HttpServlet {
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
    public Admin_flyaway() {
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
		String user1=request.getParameter("username");
		String pass1=request.getParameter("password");
		PrintWriter out=response.getWriter();
		
		if(user1==null||user1.equals("")||pass1==null||pass1.equals(""))
		{
			System.out.println("\nPlease fill the crendials");
			response.sendRedirect("Admin_flyaway.jsp");
		}
		else{
			try {
				
		        String user_name=null;
		        String pass_word=null;
	            Connection con = DatabaseConnection.initializeDatabase();
	  
	            
	            PreparedStatement st = con
	                   .prepareStatement("select * from Admin where username=? and password=?");
	 
	            st.setString(1, user1);
	            st.setString(2, pass1);
	           
	            
	            rs=st.executeQuery();
	            //System.out.println("\nRetrieving Flights for the route from "+src_city+" "+des_city+" "+"data from the Flight_deatails table");
	            System.out.println();
	            while(rs.next())
	            {
	            	
	            	user_name=rs.getString("username");
	            	pass_word=rs.getString("password");
	            
	            }
	            if(user_name.equals(user1)&&pass_word.equals(pass1))
	            {
	            	System.out.println("\n**************************");
	            	System.out.println("\nAdmin Login sucess");
	            	System.out.println("\n**************************");
	            	out.println("\n<html><body><center>"
	            			+ "<Body  style='background-color:black;'>"
	            			+ "<h1><font color='white'>Admin Operations</h1></font><br>"
	            			+ "<table border='2px'bgcolor='powderblue' width='230px' height=250px'>"
	            			+ "<tr><td>"
	            			+ "<form action='Newuser_flyaway.jsp' method='post'>"
	            			+ "<center><input type='submit' value='Add New User'></center>"
	            			+ "</form>"
	            			+ "<form action='updatepassword_flyaway.jsp' method='post'>"
	            			+ "<center><input type='submit' value='Update user password'></center>"
	            			+ "</form>"
	            			+ "<form action='Bookinghistory_flyaway' method='post'>"
	            			+ "<center><input type='submit' value='View Booking History'></center>"
	            			+ "</form>"
	            			+ "</td></tr></table></center></body>"
	            			+ "</html>");
	            	
	            }
	            else{
	            	out.println("\nLogin credentials are wrong");
	            	out.println("\nLogin again");
	            	response.sendRedirect("Admin_flyaway.jsp");
	            }
			}
	        catch (Exception e) {
	            e.printStackTrace();
	        }
			}
	}

}
