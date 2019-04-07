package table;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.conn;
import entities.Room;

@WebServlet("/getroom")
public class room extends HttpServlet {
	private Connection connection;

	private ResultSet rs;
	private String rList = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("hotel_id"));
		int hotel_id = Integer.valueOf((String) session.getAttribute("hotel_id"));
		int cap = Integer.valueOf(request.getParameter("room_cap"));
		String view = request.getParameter("view");
		String amenities = request.getParameter("amenities");
		
		conn db = new conn();
		db.openConnection();
		ArrayList<Room> r_list=db.getRoom(hotel_id, cap, view, amenities);
		
		if(r_list.size()>0) {
			request.setAttribute("roomList", r_list);
			request.getRequestDispatcher("BookingRoomDate.jsp").forward(request, response);
		}else {
			request.setAttribute("no_that_room", true);
			response.sendRedirect("BookingRoom.jsp");
		}
		db.closeConnection();
	}




	
}