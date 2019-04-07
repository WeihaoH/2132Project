package table;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.conn;
import entities.area_info;
@WebServlet("/live_list")
public class checkout extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	ArrayList<String> rlist;
	ArrayList<area_info> arealist;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		
		conn db = new conn();
		db.openConnection();

		
		
		
		ArrayList<String> table=db.getliveinfo();
		request.setAttribute("livelist", table);
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
		db.closeConnection();
	}
}
