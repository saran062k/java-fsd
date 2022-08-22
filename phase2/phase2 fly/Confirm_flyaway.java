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
import javax.servlet.http.HttpSession;

import Phase2_servlet.programs.DatabaseConnection;

/**
 * Servlet implementation class Confirm_flyaway
 */
@WebServlet("/Confirm_flyaway")
public class Confirm_flyaway extends HttpServlet {
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
    public Confirm_flyaway() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String user_name=request.getParameter("username");
		if(user_name!=null)
		{
			out.println("Username is "+user_name);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);
		PrintWriter out=response.getWriter();
		String username=(String)session.getAttribute("username");
		int flightnumber=(int)session.getAttribute("flight_num");
		
		
		out.println("<center><h2>Booking Details</h2></center>");
		
		String query = "insert into booking_details(username,booking_id,flight_no) values(?,?,?)";
		double random=Math.random();
	      try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, password);
	           
	            prSt = con.prepareStatement(query);
	            
	            prSt.setString(1, username);
	            prSt.setDouble(2,random);
	            prSt.setInt(3,flightnumber);
	            
	            int count = prSt.executeUpdate();
	            System.out.println("\nAll the records are inserted Successfully");
	         
	           
	            
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally{
	            try{
	                if(prSt != null) prSt.close();
	                if(con != null) con.close();
	            } catch(Exception ex){}
	        }
	      
	      try {
				 
		            Connection con = DatabaseConnection.initializeDatabase();
		  
		            PreparedStatement st = con
		                   .prepareStatement("select * from booking_details where booking_id=?");
		  
		            st.setDouble(1, random);
		          
		            rs=st.executeQuery();
		            //System.out.println("\nRetrieving Flights for the route from "+src_city+" "+des_city+" "+"data from the Flight_deatails table");
		            System.out.println();
		            while(rs.next())
		            {
		            	
		            	String user_name=rs.getString("username");
		            	String bookingid=rs.getString("booking_id");
		            	int flight_no=rs.getInt("flight_no");
		           
		            	 out.println("<html><body><div align='center'><table border='2px' bgcolor='powderblue' width='430px' height='200px'><tr> "
		     	          		+ "<th>Username</th> "
		     	          		+ "<th>Booking Id</th> "
		     	          		+ "<th>Flight Number</th>"
		     	          		+ "</tr>"
		     	          		+ "<tr>"
		     	          		+ "<td style='text-align:center'>"+user_name+"</td>"
		     	          		+ "<td style='text-align:center'>"+bookingid+"</td>"
		     	          		+ "<td style='text-align:center'>"+flight_no+"</td>"	
		     	          		+ "</tr>"
		     	          		+ "</table>"
		     	          		+ "</div></body></html>");
		            	
		            	//System.out.println("airline_name: "+airline_name + "  "+"Price: " +price+"  "+"Flight no: "+flight_no+"  "+" Source City: "+source_city+"  "+" Destination City: "+destination_city+"  "+" Arrival Time: "+arrival_time+"  "+" Departure Time: "+departure_time+"  "+" Class: "+clas);
		            }
		         
		            
		        
			 }
		        catch (Exception e) {
		            e.printStackTrace();
		        }
	      out.println("<html><body>"
					+ "<hr><center><img src='E:\\Downloads\\thank you2.jpg'></center>"
					+ "<hr></body></html>"
					);
	
	}

}
