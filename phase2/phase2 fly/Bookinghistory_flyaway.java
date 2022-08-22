package Phase2_servlet.programs;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Phase2_servlet.programs.DatabaseConnection;

/**
 * Servlet implementation class Bookinghistory_flyaway
 */
@WebServlet("/Bookinghistory_flyaway")
public class Bookinghistory_flyaway extends HttpServlet {
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
    public Bookinghistory_flyaway() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      con = DriverManager.getConnection(url, user, password);
		      
		      stmt=con.createStatement();
		      
		      String query="select * from booking_details";
		      rs=stmt.executeQuery(query);
		      
		      System.out.println("\nTable Displayed Successfully");
		      while(rs.next())
		      {
		    	  
		    	   String user_name = rs.getString(1); 
		    	   String booking_id = rs.getString(2);
		    	   String flightnumber = rs.getString(3);
		    	   //System.out.printf("prodid : %d, prodname: %s, price : %d, modelyear: %s %n", prodid, prodname, price, modelyear);
		    	   out.println("<html><body><Body  style='background-color:black;'><font color='white'>"
	            			+"<center><h3>Review Selected Flight</h3></center></font><div align='center'><table border='2px' bgcolor='powderblue' width='1100px' height='200px'><tr> "
	     	          		+ "<th>Username</th> "
	     	          		+ "<th>Booking_id</th>"
	     	          		+ "<th>Flight Number</th> "
	     	          		+ "</tr>"
	     	          		+ "<tr>"
	     	          		+ "<td style='text-align:center'>"+user_name+"</td>"
	     	          		+ "<td style='text-align:center'>"+booking_id+"</td>"
	     	          		+ "<td style='text-align:center'>"+flightnumber+"</td>"
	     	          		+ "</tr>"
	     	          		+ "</table>"
	     	          		+ "</div></body></html>");
		    	   out.println("<html><body><br><br></body></html>");
		    	   
		      }
		      out.println("<html><body><br><br></body></html>");
		      out.println("<html><body><form action='Login_flyaway.jsp' method='post'>"
		      		+ "<center><input type='submit' value='go to Login'></center>"
		      		+ "</body></html>");
		   }
		      
		      catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            stmt.close();
			      }catch(SQLException se2){
			      }// nothing we can do
			      try{
			         if(con!=null)
			            con.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
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
