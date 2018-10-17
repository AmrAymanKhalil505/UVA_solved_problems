package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA674CoinChange {
	static long [][]DP =new long[5][7500];
	static int  []Coins =new int []{1,5,10,25,50};
	public static void main(String[] args) throws IOException {
		/*for(int i=0;i<5;i++)
		{
			DP[i][0]=1;
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		String line =null;int num;
		while((line =br.readLine())!=null&&!line.isEmpty())
		{
			num=Integer.parseInt(line);
			out.println(DP(num,5));
		}
	
		out.flush();out.close();
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		for(int i=0;i<5;i++)
		{
			Arrays.fill(DP[i], -1);
		}
	}
	private static long DP(int index , int sum)
	{	
		
		if(sum<0)
			return 0;
		if(sum==0)
			return 1;
		if(index==5)
			return 0;
			
		if(DP[index][sum]!=-1)
		{
			return DP[index][sum];
		}
		long result = DP(sum-Coins[index],index)+DP(sum,index);
		return DP[index][sum];
	
		
		
	}
}
