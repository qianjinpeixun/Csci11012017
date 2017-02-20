package z62.lab3;

/*CSCI 1101-Lab 3-E3
This class set the value and be used in MyIntegerDemo class.
<Wenyi Zhang><B00732630><2017.Feb.1st>*/
public class MyInteger {
   private int value;
   //constructor method
   public MyInteger(int v) {
      value=v;
   }
   //get method
   public int getValue() {
      return value;
   }
   //static methods isEven(int), isOdd(int) and isPrime(int)
   public static boolean isEven(int v) {
      return v%2==0;
   }
   public static boolean isOdd(int v) {
      return v%2!=0;
   }
   public static boolean isPrime(int v) {
      int total=0;
      for(int i=2;i<v;i++) {
         if(v%i==0)
            total=total+i;
      }
      return total==0;
   }
   //Methods isEven(), isOdd(), and isPrime()
   public boolean isEven() {
      return value%2==0;
   }
   public boolean isOdd() {
      return value%2!=0;
   }
   public boolean isPrime() {
      int total=0;
      for(int i=2;i<value;i++) {
         if(value%i==0)
            total=total+i;
      }
      return total==0;
   }
   //Static methods isEven(MyInteger), isOdd(MyInteger) and isPrime(MyInteger) 
   public static boolean isEven(MyInteger v) {
      return v.isEven();
   }
   public static boolean isOdd(MyInteger v) {
      return v.isOdd();
   }
   public static boolean isPrime(MyInteger v) {
      return v.isPrime();
   }
   //Method equals(int)
   public boolean equals(int n) {
      return n==getValue();
   }
   //Method equals(MyInteger)
   public boolean equals(MyInteger v) {
      return value==v.getValue();
   }
   //Static method parseInt(char[])
   public static int parseInt(char[]number) {
      return Integer.parseInt(new String(number));
   }
   //Static method parseInt(String)
   public static int parseInt(String string) {
      return Integer.parseInt(string);
   }
}//end

