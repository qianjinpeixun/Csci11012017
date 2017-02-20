package z4;

//问题比较多，哪些是成员变量，哪些是静态变量

public class Pizza { 
	
	
	public int age=9;
	
	public static int yyy;
	
	public void play(){
		yyy=18;
	}

	
	public static void play2(){
		yyy=9;
	}
	
	
	
	
 private int IDnum; 

 private static  int NumP;//number of pizza 

 private static double Cost; 

 private  int TotalNum; 

 private static double TotalSale; 

 //constructor 

  public Pizza(int ID,int num){ 

   IDnum = ID; 

   NumP = num; 

  } 

  public int justSold(){ 

   return NumP; 

  } 

  public int justSold(int n){ 

   return NumP+=n; 

  } 

  public static void setCost(double c){ 

   Cost = c; 

  } 
  //keep update totalNum
  public static int totalNum(){ 

   return NumP; 

  } 
  //calculate total money
  public static double totalSale(){ 

   return Cost*NumP; 

  } 

} 
