package xu.lab3;
/*20170131 Jiawen Xu B00742689 Lab3 E2
   This program will show num of pizza sold by each stand 
   and totalsold and total sale */
      import java.util.Scanner;
      public class PizzaDemo{
         public static void main(String[] args) {
         Scanner kb = new Scanner(System.in);
         
            //set cost/pizza 
            System.out.print("The price per pizza: ");
            Pizza.setCost(kb.nextDouble());
            
            //create pizza stands 
            System.out.print("How many pizza stands?");
            int s=kb.nextInt();//number of stand
            
            
            int id=0;//stand id number
            int ss=0;//sale from each stand
            Pizza piz=new Pizza(id,ss);
            for(int i=1;i<=s;i++){
               System.out.print("Stand "+i+" sales: ");
               ss=kb.nextInt();
               
               int w=0;
               while(w<ss){
                  piz.justSold();
                  w++;
               }
            }
            
            
               
          
            
            
            System.out.println("\nTotal pizzas sold: "+Pizza.totalSold());
            System.out.println("Total sales: $"+Pizza.totalSale());
            System.out.print("\n");
            System.out.print("Process completed.");
 
         }
      }
      
            