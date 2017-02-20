package ass1;

public class Point {
	/**
	 * 
	 */
	private double px;
	public double getPx() {
		return px;
	}

	public void setPx(double px) {
		this.px = px;
	}

	public double getPy() {
		return py;
	}

	public void setPy(double py) {
		this.py = py;
	}

	private double py;
	
	public Point(double px,double y){
		this.px=px;
		py=y;
	}
	
	
}
