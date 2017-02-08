package z3;

public class CoinDemo {
	public static void main(String[] args) {
		Coin c1 = new Coin("Toonie", 200);
		Coin c2 = new Coin("Loonie", 100);
		Coin c3 = new Coin("Quarter", 25);
		Coin c4 = new Coin("Dime", 10);
		Coin c5 = new Coin("Nickel", 5);
		Wallet w = new Wallet(5);
		w.addCoin(c1);
		w.addCoin(c2);
		w.addCoin(c3);
		w.addCoin(c4);
		w.addCoin(c5);
	}
}
