package entities;

public class Room {
	private int room_num;
	private float price;
	private boolean used;
	
	public Room() {
		
	}
	public Room(int room_num, float price,boolean used) {
		this.room_num = room_num;
		this.price = price;
		this.used = used;
	}
	

	public int getroom_num() {
		return room_num;
	}

	public float getprice() {
		return price;
	}

	public boolean isused() {
		return used;
	}
}
