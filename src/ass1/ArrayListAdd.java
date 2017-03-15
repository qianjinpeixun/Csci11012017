package ass1;
import java.util.*;
public class ArrayListAdd {

	public static void main(String[] args) {

		Scanner kb =new Scanner(System.in);
		ArrayList<String> growinglist=new ArrayList<String>();
		String a="";
		while(!a.equals("-1")){
			a=""+kb.next();
			System.out.println(growinglist);
			if(growinglist.isEmpty())
				growinglist.add(a);
			else{
				int i=0;
				while(i<growinglist.size()){
					if(a.compareTo(growinglist.get(i))<0){
						System.out.println(a+",i="+i);
						growinglist.add(i,a);
					}
					i++;
				}
			}
		}
		
	}

}
