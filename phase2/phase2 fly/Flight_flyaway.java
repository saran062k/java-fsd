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
 * Servlet implementation class Flight_flyaway
 */
@WebServlet("/Flight_flyaway")
public class Flight_flyaway extends HttpServlet {
	
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
    public Flight_flyaway() {
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
		HttpSession session=request.getSession();
		try {
			 PrintWriter out = response.getWriter();
	            // Initialize the database
	            Connection con = DatabaseConnection.initializeDatabase();
	  
	            // Create a SQL query to insert data into demo table
	            // demo table consists of two columns, so two '?' is used
	            PreparedStatement st = con
	                   .prepareStatement("select * from Flight_details where source_city=? and destination_city=?");
	  
	            // For the first parameter,
	            // get the data using request object
	            // sets the data to st pointer
	            String date=request.getParameter("date_of_travel");
	    		String src_city=request.getParameter("source_city");
	    		String des_city=request.getParameter("destination_city");
	    		String no_persons=request.getParameter("no_of_person");
	    		int no_per=Integer.parseInt(no_persons);
	           
	            st.setString(1, src_city);
	            st.setString(2, des_city);
	 
	  
	 
	            // to display the successful result
	            
	            rs=st.executeQuery();
	            //System.out.println("\nRetrieving Flights for the route from "+src_city+" "+des_city+" "+"data from the Flight_deatails table");
	            System.out.println();
	            int i=0;
	            while(rs.next())
	            {
	            	i++;
	            	String airline_name=rs.getString("airline_name");
	            	int price=rs.getInt("price");
	            	int flight_no=rs.getInt("flight_no");
	            	String source_city=rs.getString("source_city");
	            	String destination_city=rs.getString("destination_city");
	            	String departure_time=rs.getString("departure_time");
	            	String arrival_time=rs.getString("arrival_time");
	            	String clas=rs.getString("class");
	            	//session.setAttribute("flight_num", flight_no);
	            	session.setAttribute("no_of_person", no_per);
	            	out.println("<html><body><center>Retrieving Flight "+i+"</center></body></html>");
	            	 out.println("<html><body><div align='center'><table border='2px' bgcolor='powderblue' width='1100px' height='200px'><tr> "
	     	          		+ "<th>Airline_name</th> "
	     	          		+ "<th>Price</th> "
	     	          		+ "<th>Flight_no</th> "
	     	          		+ "<th>Source_city</th>"
	     	          		+ "<th>Destination_city</th>"
	     	          		+ "<th>Arrival Time</th>"
	     	          		+ "<th>Departure Time</th>"
	     	          		+ "<th>Class</th>"
	     	          		+"<th>Book</th>"
	     	          		+ "</tr>"
	     	          		+ "<tr>"
	     	          		+ "<td style='text-align:center'>"+airline_name+"</td>"
	     	          		+ "<td style='text-align:center'>"+price+"</td>"
	     	          		+ "<td style='text-align:center'>"+flight_no+"</td>"
	     	          		+ "<td style='text-align:center'>"+source_city+"</td>"
	     	          		+ "<td style='text-align:center'>"+destination_city+"</td>"
	     	          		+ "<td style='text-align:center'>"+arrival_time+"</td>"
	     	          		+ "<td style='text-align:center'>"+departure_time+"</td>"
	     	          		+ "<td style='text-align:center'>"+clas+"</td>"
	     	          		+ "<td style='text-align:center'><a href='Review_flyaway?flight_num="+flight_no+"'>book</a></td>"
	     	          		+ "</tr>"
	     	          		+ "</table>"
	     	          		+ "</div></body></html>");
	            	
	            	//System.out.println("airline_name: "+airline_name + "  "+"Price: " +price+"  "+"Flight no: "+flight_no+"  "+" Source City: "+source_city+"  "+" Destination City: "+destination_city+"  "+" Arrival Time: "+arrival_time+"  "+" Departure Time: "+departure_time+"  "+" Class: "+clas);
	            }
	         
	            
	        
		 }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	    
		PrintWriter out=response.getWriter();
		
		
		
	}

}
