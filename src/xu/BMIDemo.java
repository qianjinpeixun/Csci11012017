package xu;
/* 20170117 Jiawen Xu B00742689 E4
   This program will calculate BMI of person */
   
   import java.util.Scanner;
   public class BMIDemo{
      public static void main(String[]args){
         Scanner input=new Scanner(System.in);
         
         String n;//name
         int a;//age
         double w;//weight
         double h;//height
         Person p1;
       
         System.out.print("Enter the name: ");
         n=input.nextLine();
         System.out.print("Enter the age: ");
         a=input.nextInt();
         System.out.print("Enter the weight in the pounds: ");
         w=input.nextDouble();
         System.out.print("Enter the height in the inches: ");
         h=input.nextDouble();
         p1=new Person(n,a,w,h);
         System.out.println("");
         
         if(a>=20){
            System.out.println("The BMI of "+n+" is "+p1.calcBMI(w,h));
            
            if(p1.calcBMI(w,h)<18.5){
               System.out.print("The BMI status is Underweight");
            }
            else if(p1.calcBMI(w,h)>=18.5&&p1.calcBMI(w,h)<25.0){
               System.out.print("The BMI status is Normal");
            }
            else if(p1.calcBMI(w,h)>=25.0&&p1.calcBMI(w,h)<30.0){
               System.out.print("The BMI status is Overweight");
            }
            else{//BMI>=30.0
               System.out.print("The BMI status is Obese");
            }
         }
         
         else{//a<20
            System.out.print("The minimum age should be 20 in order to calculate the BMI.");
         }
      }
   }
         
        
       
         
         