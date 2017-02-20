package xu;
/* 20170117 Jiawen Xu B00742689 E4
   This is the object for BMI system to person  */
   
   public class Person{
      private String name;
      private int age;
      private double weight;//in pounds
      private double height;//in inches
      
      
      //constructor
      public Person(String n,int a,double w,double h){
         name=n;
         age=a;
         weight=w;
         height=h;
      }
      
      //get name,age,weight,height
      public String getName(){
         return name;
      }
      public int getAge(){
         return age;
      }
      public double getWeight(){
         return weight;
      }
      public double getHeight(){
         return height;
      }
      
      //set name,age,weight,height
      public void setName(String n){
         name=n;
      }
      public void setAge(int a){
         age=a;
      }
      public void setWeight(double w){
         weight=w;
      }
      public void setHeight(double h){
         height=h;
      }
          
      //BMI
      public double calcBMI(double weight,double height){
         return 703*weight/ ((height)*(height));
      }
   }
   
         
      