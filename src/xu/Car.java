package xu;

/* 20170117 Jiawen Xu B00742689 E5
   This is the object for models the amount of gas required by the car to drive a certain distance  */
   
   public class Car{
      private double tc;//tank capacity
      private double agt;//amount of gas in tank
      private double fcr;//fuel consumption rate 
      
      //construtor
      public Car(double c,double f){
         tc=c;
         fcr=f;
         agt=0;
      }
      
      //get 
      public double getTankCapacity(){
         return tc;
      }
      public double getAmountofGas(){
         return agt;
      }
      public double getFuelConsumpRate(){
         return fcr;
      } 
      
      //set
      public void setTankCapacity(double c){
         tc=c;
      }
      public void setAmountofGas(double a){
         agt=a;
      }
      public void setFuelConsumpRate(double f){
         fcr=f;
      }
      
      //methods
      public void fill(double g){
         double total=agt+g;
         if(total<tc){
            agt=agt+g;
         }
         else{//total>tc
            System.out.println("Cannot fill.Exceeds capacity.");
         }
      }
      
      public void drive(double d){
         double requireGas=d*fcr;
         if(requireGas<=agt){
            agt=agt-requireGas;
            System.out.print("\nGas remaining in tank: "+agt);
         }
         else{
            System.out.println("Cannot drive. Not enough gas.");
            System.out.print("\nGas remaining in tank: "+agt);
         }
      }
   }
      
          