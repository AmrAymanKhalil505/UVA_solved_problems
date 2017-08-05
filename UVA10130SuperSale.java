package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA10130SuperSale
{	static int []p;static int n;
	static int []w;static int INF=(int )-1e9;
	static int[][] memo;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
		int TC= Integer.parseInt(br.readLine());PrintWriter out = new PrintWriter(System.out);
		while(TC-->0)
		{
			 n=Integer.parseInt(br.readLine());
			p=new int [n];
			w=new int [n];
			memo=new int [n][31];
			
			for(int i=0;i<n;i++)
			{
				Arrays.fill(memo[i], -1);
			}
			
			for(int i=0;i<n;i++)
			{
				String Linearr[]= br.readLine().split(" ");
				 p[i]=Integer.parseInt(Linearr[0]);
				 w[i]=Integer.parseInt(Linearr[1]);
				 
			}
			int g =Integer.parseInt(br.readLine());
			
			long ans =0;
			for(int i=0;i<g;i++)
			{ 
				ans+=0L+dp(0,Integer.parseInt(br.readLine()));
			}
			out.append(ans+"\n");
		}
		out.flush();out.close();
	}
	private static int dp(int ind, int rw) {
		if(rw<0)
		{
			return INF;
		}
		if(ind ==n)
		{
			return 0;
		}
		if(memo[ind][rw]!=-1)
		{
			return memo[ind][rw];
		}
		// take 
		int take = p[ind]+dp(ind+1,rw-w[ind]);
		// leave 
		int leave = dp (ind+1,rw);
		memo[ind][rw]=Math.max(leave,take);
		return memo[ind][rw];
	}
}