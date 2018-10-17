package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class UVA410StationBalance {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		 String line ;
		 PrintWriter pw = new PrintWriter(System.out);
		 ArrayList<Integer> nums=new ArrayList<Integer>();int c =0;
		 while((line=br.readLine())!=null&&!line.isEmpty())
		 {	c++;pw.println("Set #"+c);float sum=0;float IMB=0;
		 	nums.clear();
			 String Segline []=line.split(" ");
			 int C= Integer.parseInt(Segline[0]);
			 int S=	Integer.parseInt(Segline[1]);
			 Segline =br.readLine().split(" " );
			 for(int i=0;i<Segline.length;i++)
			 {int x=Integer.parseInt(Segline[i]);
				 nums.add(x);
			 	sum+=x;
			 }
			 sum/=C;
			 Collections.sort(nums);
			 int l =Segline.length/2;
			 
			 if(Segline.length%2==0)
			 {
				 for(int i=0;i<l;i++)
				 { int x = nums.get(i);int y =nums.get(Segline.length-i-1) ;
					pw.println(" "+i+": "+x+" "+y); 
					IMB+=Math.abs(x+y-sum);
				 }
			 }
			 
			 else
			 {	
				 for(int i=0;i<l;i++)
				 {int x = nums.get(i);int y =nums.get(nums.size()-i-2) ;
					pw.println(" "+i+": "+x+" "+y);
					IMB+=Math.abs(x+y-sum);
				 }
				pw.println(" "+l+": "+nums.get(nums.size()-1));
				IMB+=Math.abs(nums.get(nums.size()-1)-sum);
			 }
			 pw.printf("IMBALANCE = %.5f",IMB);
			 pw.println();
			 pw.println();
		 }
	pw.flush();pw.close();}
}
