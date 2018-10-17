package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA11003Boxes 
{	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
 	static int  DP [][];
 	static  final int oo =1<<28; 
 	static int TC;static int boxesW [];static int boxesMax [];
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
		String sline ;
		while(!((sline = br.readLine()).equals("0"))){
		TC = Integer.parseInt(sline);
		 boxesW = new int [TC]; 
		 boxesMax = new int [TC];
		for(int i=0;i<TC;i++)
		{
			String line []=br.readLine().split(" ");
			boxesW[i]=Integer.parseInt(line[0]);
			boxesMax[i]=Integer.parseInt(line[1]);
			
		}
		DP = new int [TC][3005];
		for(int i=0;i<TC;i++)
			Arrays.fill(DP[i],-1);
		useDP(0,oo);
		pw.println(useDP(0,oo));
		}
		pw.flush();pw.close();
	}
	private static int  useDP(int ind, int W) 
	{	
		
		if(ind>=TC)
		{
			return 0;
		}
		if(W!=oo&&DP[ind][W]!=-1)
		{
			return DP[ind][W];
		}
		int take =-1;
		if(boxesW[ind]<=W)
		{
			take =1+useDP(ind+1,Math.min(boxesMax[ind], W-boxesW[ind]));
		}
		int leave = useDP(ind+1, W);
		if(W!=oo){
		DP[ind][W]=Math.max(take, leave);
		return DP[ind][W];
		}
		return Math.max(take, leave);
	}
}
