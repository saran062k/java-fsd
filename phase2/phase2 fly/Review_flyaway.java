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
 * Servlet implementation class Review_flyaway
 */
@WebServlet("/Review_flyaway")
public class Review_flyaway extends HttpServlet {
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
    public Review_flyaway() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		int person=(int)session.getAttribute("no_of_person");
		String flightnumber=request.getParameter("flight_num");
		int flight=Integer.parseInt(flightnumber);
		session.setAttribute("flight_num", flight);
		out.println("<center><strong>Displaying Flight Details u have choosed</strong></center>");
	
		try {
			
	          
	            Connection con = DatabaseConnection.initializeDatabase();
	  
	            
	            PreparedStatement st = con
	                   .prepareStatement("select * from Flight_details where flight_no=?");
	  
	       
	           
	            st.setInt(1, flight);
	           
	            
	            rs=st.executeQuery();
	            //System.out.println("\nRetrieving Flights for the route from "+src_city+" "+des_city+" "+"data from the Flight_deatails table");
	            System.out.println();
	            while(rs.next())
	            {
	            	
	            	String airline_name=rs.getString("airline_name");
	            	int price=rs.getInt("price");
	            	int flight_no1=rs.getInt("flight_no");
	            	String source_city=rs.getString("source_city");
	            	String destination_city=rs.getString("destination_city");
	            	String departure_time=rs.getString("departure_time");
	            	String arrival_time=rs.getString("arrival_time");
	            	String clas=rs.getString("class");
	            	int totalprice=price*person;
	            	//out.println("<html><body>Retrieving Flight</body></html>");
	            	 out.println("<html><body><Body  style='background-color:black;'><font color='white'>"
	            			+"<center><h3>Review Selected Flight</h3></center></font><div align='center'><table border='2px' bgcolor='powderblue' width='430px' height='200px'><tr> "
	     	          		+ "<th>Airline_name</th> "
	     	          		+ "<th>Price</th> "
	     	          		+ "<th>Flight_no</th> "
	     	          		+ "<th>Source_city</th>"
	     	          		+ "<th>Destination_city</th>"
	     	          		+ "<th>Arrival Time</th>"
	     	          		+ "<th>Departure Time</th>"
	     	          		+ "<th>Class</th>"
	     	          		+ "<th>No Of Persons</th>"
	     	          		+ "<th>Total Price</th>"
	     	          		+ "</tr>"
	     	          		+ "<tr>"
	     	          		+ "<td style='text-align:center'>"+airline_name+"</td>"
	     	          		+ "<td style='text-align:center'>"+price+"</td>"
	     	          		+ "<td style='text-align:center'>"+flight_no1+"</td>"
	     	          		+ "<td style='text-align:center'>"+source_city+"</td>"
	     	          		+ "<td style='text-align:center'>"+destination_city+"</td>"
	     	          		+ "<td style='text-align:center'>"+arrival_time+"</td>"
	     	          		+ "<td style='text-align:center'>"+departure_time+"</td>"
	     	          		+ "<td style='text-align:center'>"+clas+"</td>"
	     	          		+ "<td style='text-align:center'>"+person+"</td>"
	     	          		+ "<td style='text-align:center'>"+totalprice+"</td>"
	     	          		+ "</tr>"
	     	          		+ "</table>"
	     	          		+ "</div></body></html>");
	            	out.println();
	            	out.println();
	            	out.print("<html><body><div align='center'><form action='Payment_flyaway.jsp' method='post'><br>");  
	     		    out.print("<input type='submit' value='Go To Payment'>");  
	     		    out.print("</form></div></body></html>"); 
	            	 
	            	
	            	//System.out.println("airline_name: "+airline_name + "  "+"Price: " +price+"  "+"Flight no: "+flight_no+"  "+" Source City: "+source_city+"  "+" Destination City: "+destination_city+"  "+" Arrival Time: "+arrival_time+"  "+" Departure Time: "+departure_time+"  "+" Class: "+clas);
	            }
	         
	            
	        
		 }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

}
