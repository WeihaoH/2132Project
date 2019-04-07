package table;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.conn;
import entities.area_info;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/employeelogin")
public class employeelogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	private String cpswd;
	private Connection connection;
	ArrayList<String> rlist;
	ArrayList<area_info> arealist;
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userSSN = request.getParameter("userSSN");
		String password = request.getParameter("password");
		
		System.out.println("log");

		conn db = new conn();
		db.openConnection();
		if (checkLogin(userSSN, userSSN, db) == true) {
			HttpSession session = request.getSession();
			session.setAttribute("employeeSSN", userSSN);
			request.getRequestDispatcher("EmployeeAdmin.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("Employee.html");
		}
		db.closeConnection();
	}

	public boolean checkLogin(String custSSN, String pswd, conn conn) {
		Statement st;

		Connection connection = conn.getConnection();
		String sql = "Select employeessn, pswd from project.employeelogin where employeessn='" + custSSN + "';";
		try {
			st = connection.createStatement();
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Cant check login info");
		}
		try {
			if (rs != null) {
				while (rs.next()) {
					cpswd = rs.getString("pswd");
				}
			}

		} catch (Exception e) {
			System.out.println("Error creating table " + e);
		}

		if (pswd.equals(cpswd)) {
			return true;
		} else {
			return false;
		}

	}
	


	
}
