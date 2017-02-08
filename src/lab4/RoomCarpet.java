package lab4;

public class RoomCarpet {

	private RoomDimension room;
	private double carpetCost;
	private double totalCost;

	public RoomCarpet(RoomDimension r, double cost) {
		this.room = r;
		this.carpetCost = cost;
		this.totalCost = carpetCost * room.getLength() * room.getWidth();
	}

	public double getTotalCost() {
		return totalCost;
	}

	public boolean costsMore(RoomCarpet other) {
		boolean ret = false;
		if (totalCost > other.totalCost)
			ret = true;
		else
			ret = false;
		return ret;
	}

	public String toString() {
		String ret = "";
		ret = room.toString()+" Carpet Cost ($per sq.ft): " + carpetCost + " Total cost ($):" + getTotalCost();
		return ret;
	}

}
