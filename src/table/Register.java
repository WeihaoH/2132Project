package table;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.conn;;

@WebServlet("/cusRegister")
public class Register extends HttpServlet {

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ssn = request.getParameter("custSSN");
		String uname = request.getParameter("custName");
		String pswd = request.getParameter("custPwd");


		conn db = new conn();
		db.openConnection();


		createLogin(ssn, uname, pswd, db);

		response.sendRedirect("customer_login.html");
		db.closeConnection();
	}

	

	public void createLogin(String ssn, String uname, String pswd, conn conn) {
		Statement st;
		Connection connection = conn.getConnection();
		String sql ="Insert into project.login(user_ssn,name,pswd) values('" + ssn + "', '" + uname + "', '" + pswd + "');";

		try {
			st = connection.createStatement();
			st.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
        	conn.closeConnection();
        }

	}

	
}
