package entities;

public class area_info {
	private String area_name;
	private int availableroom;
	private int total_rooms;
	
	public area_info() {
		
	}
	public area_info(String area_name, int availableroom,int total_rooms) {
		this.area_name = area_name;
		this.availableroom = availableroom;
		this.total_rooms = total_rooms;
	}
	

	public String getArea_name() {
		return area_name;
	}

	public int getAvailableroom() {
		return availableroom;
	}

	public int getTotal_rooms() {
		return total_rooms;
	}
}
