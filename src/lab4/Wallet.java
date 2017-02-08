package lab4;

import java.util.Arrays;

public class Wallet {

	private Coin[] coins;
	private int capacity;
	private int num;
	private int totalValue;

	public Wallet(int capacity) {
		this.totalValue = 0;
		this.num = 0;
		this.capacity = capacity;
		coins = new Coin[capacity];
	}

	public void addCoin(Coin coin) {
		if (num < capacity) {
			coins[num] = coin;
			num++;
			totalValue = totalValue + coin.getValue();
		}
	}

	public Coin removeCoin() {
		if (num >= 1) {
			Coin coin = coins[num - 1];
			coins[num-1]=null;
			num--;
			totalValue = totalValue - coin.getValue();
			return coin;
		}else 
			return null;

	}
	
	@Override
	public String toString() {
		return "Wallet [coins=" + Arrays.toString(coins) + ", capacity=" + capacity + ", num=" + num + ", totalValue="
				+ totalValue + "]";
	}

	public static void main(String[] args){
		
		Wallet wallet=new Wallet(10);
		Coin Toonie=new Coin("Toonie",200);
		Coin Loonie=new Coin("Loonie",100);
		Coin Quarter=new Coin("Quarter",25);
		Coin Dime=new Coin("Dime",10);
		
		wallet.addCoin(Toonie);
		System.out.println(wallet);
		wallet.addCoin(Loonie);
		System.out.println(wallet);
		wallet.addCoin(Dime);
		System.out.println(wallet);
		Coin removedCoin=wallet.removeCoin();
		System.out.println(removedCoin);
		System.out.println(wallet);
		
		
	}

}
