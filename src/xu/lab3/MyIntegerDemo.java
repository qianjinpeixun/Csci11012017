package xu.lab3;
/*20170201 Jiawen Xu B00742689 Lab3 E3
   This program will check if the number is even,odd,prime
   and make string/array-character into int*/
   
   public class MyIntegerDemo {
      public static void main(String[] args) {
         
         //check for number n1
         MyInteger n1 = new MyInteger(66);
         System.out.println("n1 is " + n1.getValue()); 
         System.out.println("n1 is even? " + n1.isEven()); 
         System.out.println("n1 is odd? " + n1.isOdd()); 
         System.out.println("n1 is prime? " + n1.isPrime()); 
         
         //check the number is/not prime
         System.out.println("99 is prime? " + MyInteger.isPrime(99)); 
         
         //make character into int
         char[] chars = {'5','6','8','3'}; 
         System.out.println(MyInteger.parseInt(chars));
         
         //make string to int
         String s = "7890"; 
         System.out.println(MyInteger.parseInt(s));
         
         //check n2
         MyInteger n2 = new MyInteger(22);
         System.out.println("n2 is " + n2.getValue()); 
         System.out.println("n2 is odd? " + n2.isOdd()); 
         
         //check the number is/not odd
         System.out.println("44 is odd? " + MyInteger.isOdd(44));
         
         //check n1 equals n2 and another number
         System.out.println("n1 is equal to n2? " + n1.equals(n2)); 
         System.out.println("n1 is equal to 1? " + n1.equals(1));
} }