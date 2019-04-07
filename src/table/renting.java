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
@WebServlet("/rent")
public class renting extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	ArrayList<String> rlist;
	ArrayList<area_info> arealist;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int hotel_id = Integer.valueOf(request.getParameter("hotel_id"));
		int room_num = Integer.valueOf(request.getParameter("room_num"));		
		String custSSN = request.getParameter("custSSN");
		
		
		conn db = new conn();
		db.openConnection();

		db.insertRenting(hotel_id, room_num, custSSN);
		
		
		String table=db.gethotelinfo();
		request.setAttribute("hoteltable", table);
		request.getRequestDispatcher("Status.jsp").forward(request, response);
		db.closeConnection();
	}
}
