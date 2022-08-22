package Phase2_servlet.programs;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Phase2_servlet.programs.DatabaseConnection;
/**
 * Servlet implementation class Updatepassword_flyaway
 */
@WebServlet("/Updatepassword_flyaway")
public class Updatepassword_flyaway extends HttpServlet {
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
    public Updatepassword_flyaway() {
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
		String username=request.getParameter("username");
		String oldpassword=request.getParameter("password");
		String newpassword=request.getParameter("newpassword");
		
		String query="Update Login set password=? where username=?";
		try {
            try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
            prSt = con.prepareStatement(query);
            
            // Take user input for insertion
            
            prSt.setString(1, newpassword);
            prSt.setString(2, username);
 
            int rowAffected = prSt.executeUpdate();
            System.out.println("*************************************************");
            System.out.println("\nRecords are updated");
            System.out.println("\nPassword updated for the username: "+username);
            System.out.println("*************************************************");
            response.sendRedirect("Login_flyaway.jsp");
 
            
 
		}
		catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }		
		
	}

}
