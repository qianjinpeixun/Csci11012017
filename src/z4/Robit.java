package z4;

//robit class
//拼写错误
public class Robit {

	// arrtibutes
	private String name;
	private int Xpos = 1;
	private int Ypos = 1;
	public String direction = "";
	private int point;

	// constructor
	public Robit(String n, String dir) {
		name = n;
		direction = dir;
		Xpos = 1;
		Ypos = 1;
		point = 0;
	}

	public void setName(String n) {
		name = n;
	}

	public void setXpos(int x) {
		Xpos = x;
	}

	public void setYpos(int y) {
		Ypos = y;
	}

	public String getName() {
		return name;
	}

	public int getXpos() {
		return Xpos;
	}

	public int getYpos() {
		return Ypos;
	}

	// Move method's function:
	// 1:update Xpos and Ypos each when robit is moving, value passed in this
	// method is random between 1 to 3
	// 2:if direction is diagonal then if steps is odd,move (steps-1)/2 along
	// its direction
	// ortherwise, only move steps/2 along its direction
	
	//函数名字要有意义
	//移动的部数，就是简单的加1即可
	public void Move(int m, int e) {

		//Up的话，Y轴变化
		//怎么算分数？
		if (e == 1) {

			Xpos += m;
			point += Xpos;
			point += Ypos;

			direction = "Up";
		} else if (e == 2) {

			Ypos += m;
			point += Xpos;
			point += Ypos;
			direction = "Right";
		} else {
			if (m % 2 == 0) {

				Xpos += (m / 2);
				Ypos += (m / 2);
				point += Xpos;
				point += Ypos;
				direction = "Diagonal";
			} else {

				Xpos += (m - 1) / 2;
				Ypos += (m - 1) / 2;
				point += Xpos;
				point += Ypos;
				direction = "Diagonal";
			}
		}
	}

	// point method to count pointcollected
	//方法一般是动词
	public int point() {
		return point;
	}

	// to determine which robit is ahead by comparing the sum of
	// (Xpos+Ypos),bigger one is ahead
	public boolean amIAhead(Robit r) {
		//一般要加括号，即使操作符优先级正确
		if (this.Xpos + this.Ypos > r.getXpos() + r.getYpos())
			return true;
		else
			return false;
	}

	// to string to return its position and direction
	public String toString() {
		//为什么没有分数？
		return this.name + " (" + this.Xpos + "," + this.Ypos + ") " + this.direction;
	}
}
