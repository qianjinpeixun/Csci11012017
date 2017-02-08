package z4;

/*this program will compare value of two stocks and find total value*/
public class Stock {

	private String symbol;
	private double price;
	private int shares;

	// constructor
	public Stock(String syb, double p, int s) {
		symbol = syb;
		price = p;
		shares = s;
	}

	public void setSymbol(String syb) {
		symbol = syb;
	}

	public void setPrice(double p) {
		price = p;
	}

	public void setShares(int s) {
		shares = s;
	}

	public String getString() {
		return symbol;
	}

	public double getPrice() {
		return price;
	}

	public int getShares() {
		return shares;
	}

	// compare value of two stocks
	public int compareTo(Stock s) {
		if (s.getPrice() * s.getShares() < this.price * this.shares)
			return -1;
		else if (s.getPrice() * s.getShares() > this.price * this.shares)
			return 1;
		else
			return 0;
	}

	// toString method
	public String toString() {
		return "Stock: " + symbol + "\nPrice: " + price + "\nShares: " + shares;

	}// end method

}// end class