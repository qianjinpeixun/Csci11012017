package xu.lab3;
/*20170201 Jiawen Xu B00742689 Lab3 E3
   This object has many methods for theDemo to use
   isEven, isOdd,isPrime,character/string into int */
   
   public class MyInteger{
      private int value;
      
      //constructor 
      public MyInteger(int v){value=v;}
      
      //get method
      public int getValue(){return value;}
      
      //Static isEven 2,4,6,
      public static boolean isEven(int va){
         if(va%2==0){return true;}
         else{return false;}
      }
      
      //Static isOdd 1,3,5
      public static boolean isOdd(int va){
         if(va%2!=0){return true;}
         else{return false;}
      }
      
      //Static isPrime num/1 and itself
      public static boolean isPrime(int va){
         for(int i=2;i<va;i++){
            if(va%i==0){return false;}//not frime   
         }
         return true;
      }
      
      //isEven
      public boolean isEven(){
         if(value%2==0){return true;}
         else{return false;}
      }
      
      //isOdd
      public boolean isOdd(){
         if(value%2!=0){return true;}
         else{return false;}
      }
      
      //isPrime
      public boolean isPrime(){
         for(int i=2;i<value;i++){
            if(value%i==0){return false;}//not frime   
         }
         return true;
      }      
     
      //Static isEven MyInteger
      public static boolean isEven(MyInteger m){
         if(m.getValue()%2==0){return true;}
         else{return false;}
      }
      
      //Static idOdd 
      public static boolean isOdd(MyInteger m){
         if(m.getValue()%2!=0){return true;}
         else{return false;}
      }
      
      //Static isPrime
      public static boolean isPrime(MyInteger m){
         for(int i=2;i<m.getValue();i++){
            if(m.getValue()%i==0){return false;}//not frime   
         }
         return true;
      }
      
      //equals(int)
      public boolean equals(int a){
         if(a==value){return true;}
         else{return false;}
      }
      
      //equals(MY)
      public boolean equals(MyInteger m){
         if(m.getValue()==value){return true;}
         else{return false;}
      }
      
      //parseInt(char[])
      public static int parseInt(char[] c){
         int a=0;
         for(int i=0;i<c.length;i++){
            int b=((int)c[i]-48)*(int)Math.pow(10,c.length-1-i);
            a=a+b;
         }
         return a;
      }
      
      //parseInt(String)
      public static int parseInt(String s){
         int b=0;
         for(int i=0;i<s.length();i++){
            int a=((int)s.charAt(i)-48)*(int)Math.pow(10,s.length()-1-i);
            b=b+a;
         }
         return b;
      }
   }
            
         
      
      
      
      
      
