package z52;
public class Wallet
{
   private Coin[] c; 
   private int capacity;
   private int num;
   private int totalValue;
   public Wallet(int capacity)
   {
      this.capacity = capacity;
      num = 0;
      totalValue = 0;
      this.c = new Coin[capacity];
   }   
   public void addCoin(Coin a)
   {
      if(num >= capacity)
      {
         System.out.println("Cannot add anymore coins.");
      }
      else
      {
         c[num] = a;
         totalValue = totalValue + a.getValue();
         num++;
      }
   }
   public Coin removeCoin() 
   {
      if(num <= 0) 
      {
         System.out.println("Cannot remove anymore coins.");
         return null;
      }
      else
      {
         Coin c1 = c[num];
         totalValue = totalValue - c1.getValue();
         c[num-1] = null;
         num--;
         return c1;
      }
   }
   public String toString1()
   {
      return "remove" + removeCoin().getName() + "and that value is" + removeCoin().getValue();
   }
   public String toString2()
   {
      return "we have " + num + " coins now, and total value is " + totalValue;
   }      
}   
         
                  
            