package xu.lab3;
/*20170131 Jiawen Xu B00742689 Lab3 E2
   This object will create methods for 
   pizza stands, number of pizza sold, cost/pizza,
   total number of sold pizza and total money*/
   
   public class Pizza{
      private int idNum; //ID number of stand
      private int sold; //how many pizza sold in that stand in that day
      private static int totalsold; //total sold from all stand
      private static double costper; //$cost per pizza
      
      //constructor to set origal value
      public Pizza(int id,int s){
         idNum=id;
         sold=0;
      }
      
      //justSold that increments the number of pizzas sold by that stand by 1
      public void justSold(){
         totalsold=totalsold+1;
         sold=sold+1;
      }
      
      //and return the num of that stand
      public int justSold2(){return sold;}  
      
      //setCost
      public static void setCost(double cost){costper=cost;}
      
      //return totalsold
      public static int totalSold(){return totalsold;}
      
      //return totalSale
      public static double totalSale(){return totalsold*costper;}
      
   }
  
      