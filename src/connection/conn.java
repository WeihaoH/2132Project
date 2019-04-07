package connection;

import java.awt.FlowLayout;
import java.sql.*;
import java.util.ArrayList;

import entities.Room;
import entities.area_info;

public class conn {

	private Connection connection;
	private Statement st;
	private ResultSet rs;

	public conn() {
	}

	public Connection getConnection() {
		return connection;
	}

	public void openConnection() {
		try {
			// Password password = new Password();
			
			Class.forName("org.postgresql.Driver");
			
			
			String url="jdbc:postgresql://web0.site.uottawa.ca:15432/whuan028";
			String username="whuan028";
			String password="324059HWh";
			connection = DriverManager.getConnection(url,
					username, password); 
			
			System.out.println("Connection Established");
		} catch (Exception e) {
			System.out.println("No connection established: " + e.toString());
		}
	}
	
	
	public ArrayList<String> gethotelchainList() {
		System.out.println("Get Chain");
		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery("SELECT  name FROM project.hotel_chain;");
		} catch (Exception e) {
			System.out.println("Cant read table");
		}
		ArrayList<String> result = new ArrayList<String>();;
		try {
			while (rs.next()) {			
				String name = rs.getString("name");
				System.out.println(name);
				result.add(name);
				
				
			}
		} catch (Exception e) {
			System.out.println("Error creating list " + e);
		}
		return result;
	}
	
	public ArrayList<area_info> getArea() {
		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery("SELECT  area, sum(availableroom) as sum_avai,sum(total_rooms) as sum_tot FROM project.hotel group by area;");
		} catch (Exception e) {
			System.out.println("Cant read table");
		}
		ArrayList<area_info> result = new ArrayList<area_info>();;
		try {
			while (rs.next()) {			
				String name = rs.getString("area");
				int availableroom = rs.getInt("sum_avai");
				int total_rooms = rs.getInt("sum_tot");
				area_info area_i = new area_info(name,availableroom,total_rooms);
				result.add(area_i);			
				
			}
		} catch (Exception e) {
			System.out.println("Error creating list " + e);
		}
		return result;
	}
	
	public ArrayList<String> getHotel(String area, String chain_name) {
		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery("SELECT chain_to_hotel.hotel_id FROM project.chain_to_hotel LEFT JOIN project.hotel as l ON l.hotel_id = chain_to_hotel.hotel_id Right Join project.hotel_chain as r ON r.chain_id = chain_to_hotel.chain_id where(area = '"+area+"' and r.name='"+chain_name+"');");
		} catch (Exception e) {
			System.out.println("Cant read table");
		}
		ArrayList<String> result = new ArrayList<String>();;
		try {
			while (rs.next()) {			
				String id = rs.getString("hotel_id");
				result.add(id);			
				
			}
		} catch (Exception e) {
			System.out.println("Error creating list " + e);
		}
		return result;
	}
	public ArrayList<String> getHotel(String chain_name) {
		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery("SELECT chain_to_hotel.hotel_id FROM project.chain_to_hotel LEFT JOIN project.hotel as l ON l.hotel_id = chain_to_hotel.hotel_id Right Join project.hotel_chain as r ON r.chain_id = chain_to_hotel.chain_id where(r.name='"+chain_name+"');");
		} catch (Exception e) {
			System.out.println("Cant read table");
		}
		ArrayList<String> result = new ArrayList<String>();;
		try {
			while (rs.next()) {			
				String id = rs.getString("hotel_id");
				result.add(id);			
				
			}
		} catch (Exception e) {
			System.out.println("Error creating list " + e);
		}
		return result;
	}
	
	public String gethotelinfo(String id) {
		String hname;
		String address;
		int categorized;
		int total_room;
		int available_room;
		
		String result = "";

		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery(
					"select hotel_name,categorized, address,total_rooms,availableroom from project.hotel where hotel_id="
							+ id);
		} catch (Exception e) {
			System.out.println("Cant get rating");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				hname = rs.getString("hotel_name");			
				address = rs.getString("address");
				categorized = rs.getInt("categorized");
				total_room = rs.getInt("total_rooms");
				available_room = rs.getInt("availableroom");


				result = id+"---"+hname+"---addrees: "+address+"---star "+categorized+"---"+total_room+"/"+available_room;
				System.out.println(result);
			}
		} catch (Exception e) {
			System.out.println("Error creating table " + e);
			e.printStackTrace();
		}
		return result;

	}
	
	public ArrayList<Room> getRoom(int id,int cap,String view,String amenities) {
		
		
		ArrayList<Room> result = new ArrayList<Room>();
		
		int room_id;
		float price;
		boolean used;
		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery(
					"select room_id, price, used from project.room where hotel_id="
							+ id+"and roomsize="+cap+" and view = \'"+view+"\' and amenities =\'"
									+ amenities+"\';");
		} catch (Exception e) {
			System.out.println("Cant get rating");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				room_id = rs.getInt("room_id");			
				price = rs.getFloat("price");
				used = rs.getBoolean("used");
				Room room = new Room(room_id,price,used);
				result.add(room);
			}
		} catch (Exception e) {
			System.out.println("Error creating table " + e);
			e.printStackTrace();
		}
		return result;

	}
	public void insertbooking(int hotel, int room,String ssn, Date checkin,Date checkout) {
		
		try {
			Statement st = connection.createStatement();
			long time = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(time);
			
			String sql = "Insert into project.booking (booking_id,hotel_id,room_num,user_email,bookingdate,expectcheckindate,expectcheckoutdate) values ("
					+getBookingID() + ","+hotel+","+room+",\'"+ssn+"\',\'"+date+"\',\'"+checkin+"\',\'"+checkout+"\');";
			System.out.println(sql);
			rs = st.executeQuery("Insert into project.booking (booking_id,hotel_id,room_num,user_email,bookingdate,expectcheckindate,expectcheckoutdate) values ("
					+getBookingID() + ","+hotel+","+room+",\'"+ssn+"\',\'"+date+"\',\'"+checkin+"\',\'"+checkout+"\');");
		} catch (Exception e) {
			System.out.println("Cant read table");
		}
		
	}
	
public String bookingView(String ssn) {
		String result="";
		try {
			Statement st = connection.createStatement();

			
			String sql = "select booking_id, bookingdate,expectcheckindate,room_num from project.booking where user_ssn = '"+ssn+"';";
			System.out.println(sql);
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Cant read table");
		}
		try {
			while (rs.next()) {
				
				int id = rs.getInt("booking_id");			
				Date bd = rs.getDate("bookingdate");
				Date ed = rs.getDate("expectcheckindate");
				int room = rs.getInt("room_num");


				result += "<tr><td>"+id+"</td><td>" + bd + "</td><td>" + ed + "</td>"
						+ "<td>" + room+"</td></tr>";

			}
		} catch (Exception e) {
			System.out.println("Error creating table " + e);
			e.printStackTrace();
		}
		return result;
		
	}
	
	
public void insertRenting(int hotel, int room,String ssn) {
		
		try {
			Statement st = connection.createStatement();
			long time = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(time);
			
			String sql = "Insert into project.renting (renting_id,hotel_id,room_num,customerssn,checkindate) values ("
					+getBookingID() + ","+hotel+","+room+",\'"+ssn+"\',\'"+date+"\');";
			System.out.println(sql);
			rs = st.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("Cant read table");
		}
		
	}

public void checkout(int hotel, int room) {
	
	try {
		Statement st = connection.createStatement();

		String sql = "update project.renting set isleft = true where hotel_id ="+hotel+"and room_num="+room+";";
		System.out.println(sql);
		rs = st.executeQuery(sql);
	} catch (Exception e) {
		System.out.println("Cant read table");
	}
	
}
	
	
	public boolean siguiente() {
		try {
			return (rs.next());
		} catch (Exception e) {
			System.out.println("Error moving to the next one");
			return false;
		}
	}

	public String getField(String name) {
		try {
			return (rs.getString(name));
		} catch (Exception e) {
			System.out.println("Error getting the field");
			return "";
		}
	}

	public void closeConsult() {
		try {
			rs.close();
			st.close();
		} catch (Exception e) {
		}
	}

	public void closeConnection() {
		try {
			connection.close();
		} catch (Exception e) {
		}
	}
	
	public int getBookingID() {
		int id = 0;
		Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select booking_id from project.booking order by booking_id desc limit 1");
		} catch (Exception e) {
			System.out.println("Cant get last record");
		}
		try {
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt("booking_id");
				}
			}

		} catch (Exception e) {
			System.out.println("Error creating table " + e);
		}
		id++;
		return id;
	}
	
	public int getRentingID() {
		int id = 0;
		Statement st;
		try {
			st = connection.createStatement();
			rs = st.executeQuery("select renting_id from project.renting order by renting_id desc limit 1");
		} catch (Exception e) {
			System.out.println("Cant get last record");
		}
		try {
			if (rs != null) {
				while (rs.next()) {
					id = rs.getInt("booking_id");
				}
			}

		} catch (Exception e) {
			System.out.println("Error creating table " + e);
		}
		id++;
		return id;
	}
	
	public String gethotelinfo() {
		String hname;
		String address;
		int categorized;
		int total_room;
		int available_room;
		
		String result = "";

		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery(
					"select hotel_name,categorized, address,total_rooms,availableroom from project.hotel;");
		} catch (Exception e) {
			System.out.println("Cant get rating");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				hname = rs.getString("hotel_name");			
				address = rs.getString("address");
				categorized = rs.getInt("categorized");
				total_room = rs.getInt("total_rooms");
				available_room = rs.getInt("availableroom");


				result += "<tr><td>"+hname+"</td><td>" + address + "</td><td>" + categorized + "</td>"
						+ "<td>" + available_room+"/"+ total_room+"</td>"
								+ "<td></td></tr>";

			}
		} catch (Exception e) {
			System.out.println("Error creating table " + e);
			e.printStackTrace();
		}
		return result;

	}
	
	public ArrayList<String> getliveinfo() {
		int hname;
		int rnum;
		
		ArrayList<String> result = new ArrayList<String>();

		try {
			Statement st = connection.createStatement();
			rs = st.executeQuery(
					"select hotel_id,room_num from project.renting where isleft = false");
		} catch (Exception e) {
			System.out.println("Cant get rating");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				hname = rs.getInt("hotel_id");			
				rnum = rs.getInt("room_num");
				
				String option = hname+"---"+rnum;
				result.add(option);

			}
		} catch (Exception e) {
			System.out.println("Error creating table " + e);
			e.printStackTrace();
		}
		return result;

	}

}
