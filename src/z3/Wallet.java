package z3;

public class Wallet {
	private Coin[] c;
	private int capacity;
	private int num;
	private int totalValue;

	public Wallet(int capacity) {
		this.capacity = capacity;
		num = 0;
		totalValue = 0;
		this.c = new Coin[capacity];
	}

	public void addCoin(Coin a) {
		if (num == capacity) {
			System.out.println("Cannot add anymore coins.");
		} else {
			c[num] = a;
			//totalValue = totalValue + c[num].getValue();
			num++;
		}
	}

	public int RemoveCoin() 
   {
		
		
      if(num < 0) 
      {
         System.out.println("Cannot remove anymore coins.");
      }
      else
      {
        // totalValue = totalValue - c[num].getValue();
         //return "";
         //c[num] = ;
         //num--;
      }
   return 111;
   }
}
