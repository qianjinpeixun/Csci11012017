package xu;
/*E3*/

public class Stock{
   private String symbol;
   private double price;
   private int shares;
   
   
   public Stock(String s,double p,int sh){
      symbol=s;
      price=p;
      shares=sh;
   }
   
   public String getSymbol(){return symbol;}
   public double getPrice(){return price;}
   public int getShares(){return shares;}
   
   public void setSymbol(String s){symbol=s;}
   public void setPrice(double p){price=p;}
   public void setShares(int sh){shares=sh;}
   
   public String toString(){
      return "\nStock: "+symbol+"\nPrice: "+price+"\nShares: "+shares;
   }
   
   public int compareTo(Stock s){
      double v1=price*shares;
      double v2=(s.getPrice())*(s.getShares());
      
      if(v1<v2){return -1;}
      else if(v1>v2){return 1;}
      else{return 0;}
   }
   
}
        
   
   
   