package z62.lab2;

/*CSCI 1101-Lab 2-E3
The class Stock gives the calculation to StockDemo.
<Wenyi Zhang><B00732630><2017.Jan.24>*/  
public class Stock{
   private String symbol;
   private double price = 0;
   private int shares = 0;
   //constructor method
   public Stock(String symbol, double price, int shares) {
      this.symbol = symbol;
      this.price = price;
      this.shares = shares;
   }
   //get and set methods
   public String getSymbol() {
      return this.symbol;
   }
   public double getPrice() {
      return this.price;
   }
   public int getShares() {
      return this.shares;
   }
   public void setSymbol(String symbol) {
      this.symbol = symbol;
   }
   public void setPrice(double price) {
      this.price = price;
   }
   public void setShares(int shares) {
      this.shares = shares;
   }
   //toString method
   public String toString() {
      return "Stock: " + this.symbol + "\nPrice: " + String.valueOf(this.price) + "\nShares: " + String.valueOf(this.shares) + "\n";
   }
   //calculation
   public double calcValue() {
      return this.price * this.shares;
   }
   //compareTo method
   public int compareTo(Stock s) {
      if (calcValue() < s.calcValue()) 
         return -1;
      else if (calcValue() > s.calcValue()) 
         return 1;
      else 
         return 0;
   }
}//end
