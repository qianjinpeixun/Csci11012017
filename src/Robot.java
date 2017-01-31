

public class Robot {

	private String name = "";
	private int x = 1;
	private int y = 1;
	private int direction=1;
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getCollectedPoints() {
		return collectedPoints;
	}

	public void setCollectedPoints(int collectedPoints) {
		this.collectedPoints = collectedPoints;
	}

	private int collectedPoints;

	public Robot(String name, String direction) {
		this.name = name;
		if(direction.equals("Up")) this.direction=1;
		else 		if(direction.equals("Right")) this.direction=2;
		else 		if(direction.equals("Diagonal")) this.direction=3;

		this.x = 1;
		this.y = 1;
		this.collectedPoints = 0;
		
	}
	
	public int getNextX(int steps, int direction){
		int newX=x;
		if(direction==1){
			newX= x;
		}else if(direction ==2){
			newX=x+steps;
		}else{
			newX=x+steps;
		}
		return newX;
	}
	
	
	public int getNextY(int steps, int direction){
		int newY=y;
		if(direction==1){
			newY= y+steps;
		}else if(direction ==2){
			newY=y;
		}else{
			newY=y+steps;
		}
		return newY;
	}

	
	

	public void move(int steps,int direction) {
		if(direction==1){
			y=y+steps;
		}else if(direction ==2){
			x=x+steps;
		}else{
			y=y+steps;
			x=x+steps;
		}
		if(x>8) x=8;
		if(y>8) y=8;
		this.collectedPoints =collectedPoints+x+y;
	}

	public String getName() {
		return name;
	}

	public static void main(String[] args) {

	}

	public boolean AmIAhead(Robot anotherRobot) {
		boolean ret = false;
		int myDistance = this.x + this.y;
		int anohterDistance = anotherRobot.x + anotherRobot.y;
		if (myDistance > anohterDistance)
			ret = true;
		else
			ret = false;
		return ret;
	}

	@Override
	public String toString() {
		String nameStr=String.format("%-10s", name);
		String directionStr="";
		if(direction==1) directionStr="Up";
		else if(direction==2) directionStr="Right";
		else directionStr="Diagonal";
		
		directionStr=String.format("%-8s", directionStr);
		
		
		return nameStr+" ("+x+","+y+") "+directionStr+"    "+collectedPoints+" points";
	}
	
	
	public String getMoveFailMessage() {
		String nameStr=String.format("%-10s", name);
		String directionStr=String.format("%-8s", direction);
		
		
		return nameStr+" ("+x+","+y+") move fails   "+collectedPoints+" points";
	}

}
