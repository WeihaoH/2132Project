package table;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.conn;
import entities.Room;
import entities.area_info;

@WebServlet("/getdate")
public class booked extends HttpServlet {
	private Connection connection;

	private ResultSet rs;
	private String rList = "";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		conn db = new conn();
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("hotel_id"));
		int hotel_id = Integer.valueOf((String) session.getAttribute("hotel_id"));
		String ssn = (String) session.getAttribute("custSSN");
		
		int room = Integer.valueOf(request.getParameter("room"));
		
		String checkin = request.getParameter("check_in");
		String checkout = request.getParameter("check_out");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		java.util.Date checkinDate;
		try {
			checkinDate = sdf.parse(checkin);
			java.util.Date checkoutDate = sdf.parse(checkout);
			java.sql.Date sqlDate_checkin = new java.sql.Date(checkinDate.getTime());
		    java.sql.Date sqlDate_checkout = new java.sql.Date(checkoutDate.getTime());
			db.openConnection();
			db.insertbooking(hotel_id,room,ssn,sqlDate_checkin,sqlDate_checkin);
			db.closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String table_list=db.bookingView(ssn);
		request.setAttribute("bookinginfo", table_list);
		request.getRequestDispatcher("BookingView.jsp").forward(request, response);
		db.closeConnection();
		/*
		ArrayList<String> rlist = db.gethotelchainList();
		ArrayList<area_info> arealist = db.getArea();
		request.setAttribute("allchains", rlist);
		request.setAttribute("allareas", arealist);
		request.getRequestDispatcher("index.html").forward(request, response);
		db.closeConnection();
		*/
	}




	
}