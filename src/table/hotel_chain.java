package table;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.conn;
import entities.area_info;

@WebServlet("/hotel_chain")
public class hotel_chain extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private ResultSet rs;
	ArrayList<String> rlist;
	ArrayList<area_info> arealist;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chain loading");
		conn db = new conn();
		db.openConnection();
		rlist=db.gethotelchainList();
		req.setAttribute("allchains", rlist);

		req.getRequestDispatcher("Customer.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String area_parts = request.getParameter("area");
		System.out.println(area_parts);
		String chain = request.getParameter("chain");
		
		String area = area_parts.split("---")[0];
		
		System.out.println(area);
		conn db = new conn();
		db.openConnection();
		rlist=db.getHotel(area,chain);
		
		ArrayList<String> table = new ArrayList<String>();
		for(String id:rlist) {
			table.add(db.gethotelinfo(id));
		}
		request.setAttribute("hotelinfo", table);
		request.getRequestDispatcher("HotelSelect.jsp").forward(request, response);
		db.closeConnection();
	}
	
	

}
