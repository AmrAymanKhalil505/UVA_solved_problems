package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;



public class UVA357LetMeCountTheWays {
	static int Coins [] = {1,5,10,25,50};
	static long dp [][]=new long [5][30000+5];
	public static void main(String[] args) throws IOException {
	 BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	 PrintWriter pw = new PrintWriter(System.out);
	 String line ;
	 for(int i=0;i<dp.length;i++)
	 {
		 Arrays.fill(dp[i],-1);
	 }
	 while((line=br.readLine())!=null&&!line.isEmpty())
	 {
		 int change = Integer.parseInt(line);
		 UseDP(0, 5000);
		 UseDP(0,10000);
		 UseDP(0, 15000);
		 UseDP(0, 20000);
		 UseDP(0, 25000);
		 UseDP(0, 30000);
		 long output= UseDP(0,change);
		 
		 if(output!=1)
		 pw.printf("There are %d ways to produce %d cents change.\n",output,change);
		 else
		 {
			 pw.printf("There is only 1 way to produce %d cents change.\n", change);
		 }
	 }
	 pw.flush();
	 pw.close();
	}
	private static long  UseDP(int index, int change) {
			
			if(change<0||index==5)
			{
				return 0;
			}
			
			if(change==0)
			{
				return 1;
			}
			if(dp[index][change]!=-1)
			{
				return dp[index][change];
			}
			long take = UseDP(index, change-Coins[index]);
			long leave = UseDP(index+1, change);
			dp[index][change]=take+leave;
			return dp[index][change];
			
	}
}
