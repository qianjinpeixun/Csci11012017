package lab4;

public class RoomDimension {
	
	private double length;
	private double width;
	
	public RoomDimension(double l, double w){
		this.length=l;
		width=w;
	}
	
	public String toString(){
		String ret="";
		ret="Room with Length: "+length+" and Width: "+width;
		return ret;
	}
	

	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		this.length = length;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
