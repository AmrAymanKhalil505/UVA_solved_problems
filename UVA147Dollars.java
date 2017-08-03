package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class UVA147Dollars {
	static int Coins [] = {5,10,20,50,100,200,500,1000,2000,5000,10000};
	static long dp [][]=new long [11][30000+5];
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		 String line ;
		 for(int i=0;i<dp.length;i++)
		 {
			 Arrays.fill(dp[i],-1);
		 }
		
		 while((line = br.readLine())!=null&&!line.equals("0.00"))
		 {
			 float f = Float.parseFloat(line);
			 int  change = (int)(f*100);
			 while(change%5!=0)
			 {
				 change++;
			 }
			// System.out.println(change);
			
			 UseDP(0, 5000);
			 UseDP(0,10000);
			 UseDP(0, 15000);
			 UseDP(0, 20000);
			 UseDP(0, 25000);
			 UseDP(0, 30000);
			 
			 long output= UseDP(0,change);
			
			 int z = (int)f;
			 String s =new DecimalFormat("000.00").format(f);
			 if(s.charAt(0)=='0')
				{s=s.replaceFirst("0", " ");
			 		if(s.charAt(1)=='0')
			 		{
			 			s=s.replaceFirst("0", " ");
			 		}
				}
			 
			pw.print(s);
			 pw.printf("%17d\n",output);
			 
		 }
		 pw.flush();
		 pw.close();
		 
	}
	
	private static long  UseDP(int index, int change) {
	
		if(change<0)
		{
			return 0;
		}
		
		if(change==0)
		{
			return 1;
		}
		if(index==Coins.length)
		{
			return 0;
		}
		if(dp[index][change]!=-1)
		{
			return dp[index][change];
		}
		long take = UseDP(index, change-Coins[index]);
		long leave = UseDP(index+1, change);
		
		dp[index][change]=take+leave;
		//System.out.println(take+" "+leave +" "+dp[index][change]+" "+index +" "+change);
		return dp[index][change];
		
}
}
