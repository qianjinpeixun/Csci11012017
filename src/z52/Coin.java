package z52;

public class Coin
{
   private String name; 
   private int value;
   public Coin(String n, int v)
   {
      name = n;
      value  = v;
   }
   public String getName()
   {
      return name;
   }
   public int getValue()
   {
      return value;
   }
   public String toString()
   {
      return "name is " + this.name + " and the value is " + this.value;
   }
}       
