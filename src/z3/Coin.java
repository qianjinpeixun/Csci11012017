package z3;

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
   public double getValue()
   {
      return value;
   }
   public String toString()
   {
      return this.name + " " + this.value;
   }
}       
