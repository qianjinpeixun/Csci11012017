package xu.lab3;
/*20170201 Jiawen Xu B00742689 Lab3 E4
   This program will check two circles touched externally or internally*/
   
   import java.util.Scanner; 
   public class CircleDemo {
      public static void main(String[] args) {
         Scanner keyboard = new Scanner(System.in); 
         
         //input values for two circle
         System.out.print("Enter the center coordinates (x,y) of first circle and its radius: ");
         Circle c1 = new Circle(keyboard.nextDouble(),keyboard.nextDouble(),keyboard.nextDouble());
         System.out.print("Enter the center coordinates (x,y) of second circle and its radius: ");
         Circle c2 = new Circle(keyboard.nextDouble(),keyboard.nextDouble(),keyboard.nextDouble());
         
         //check touch externally
         if(c1.touchExter(c2)){System.out.println(c1+" touches "+c2+" externally");}
         else{System.out.println(c1+" does not touches "+c2+" externally");} 
         
         //check touch internally
         if(c1.touchInter(c2)){System.out.println(c1+" touches "+c2+" internally");}
         else{System.out.println(c1+" does not touches "+c2+" internally");} 
         
                 
      }
   }
         