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
@WebServlet("/checkout")
public class left extends HttpServlet{
	

	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	ArrayList<String> rlist;
	ArrayList<area_info> arealist;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	
		String[] live = request.getParameter("live").split("---");

		int hotel_id =Integer.valueOf(live[0]);
		int room_id =Integer.valueOf(live[1]);
		
		System.out.println(hotel_id);
		System.out.println(room_id);
		
		conn db = new conn();
		db.openConnection();

		db.checkout(hotel_id,room_id);
		
		String table=db.gethotelinfo();
		request.setAttribute("hoteltable", table);
		request.getRequestDispatcher("Status.jsp").forward(request, response);
		db.closeConnection();
	}
}
