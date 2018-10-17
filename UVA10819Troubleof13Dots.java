package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class UVA10819Troubleof13Dots 
{	static int DP[][];static int m;static int n;static ArrayList<pairUVA10819Troubleof13Dots> items;
	static PrintWriter pw = new  PrintWriter(System.out);static final int NINF =-(int)1e9;
	public static void main(String[] args) throws IOException 	
	{
		 BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		 String line ;
		 String Spline[];
		  items= new ArrayList<pairUVA10819Troubleof13Dots>();
		 while((line=br.readLine())!=null&&!line.isEmpty())
		 {items.clear();
			 Spline=line.split(" ");
			  m = Integer.parseInt(Spline[0]);
			
			 n =Integer.parseInt(Spline[1]);
			 DP = new int [n][15000];
			 for(int i=0;i<n;i++)
			 { Spline=br.readLine().split(" ");
				 items.add(new pairUVA10819Troubleof13Dots(Integer.parseInt(Spline[0]), Integer.parseInt(Spline[1])));
			 }
			for(int i=0;i<n;i++)
				 Arrays.fill(DP[i], -1);
			 
			 int output =BuyWith(0,0);
			
			 pw.println(output);
		 }
		 pw.flush();pw.close();
	}
	private static int BuyWith(int index, int PaidSoFar) {
		
		
		if(PaidSoFar>m&&m<1800)
		{
			return NINF;
		}
		if(PaidSoFar>m+200)
		{
			return NINF;
		}
		if(index==n)
		{
			if(PaidSoFar>m&&PaidSoFar<=2000)
			{
				return NINF;
			}
			return 0;
		}
		if(DP[index][PaidSoFar]!=-1)
		{	//System.out.println(index);
			return DP[index][PaidSoFar];
		}
		int take =0;
		
		take = items.get(index).f+BuyWith(index+1, PaidSoFar+items.get(index).p);
		
		int leave = BuyWith(index+1, PaidSoFar);
		DP[index][PaidSoFar]= Math.max(take, leave);
		return DP[index][PaidSoFar];
	}
}
class pairUVA10819Troubleof13Dots
{	int p; // price 
	int f; // favor
	public pairUVA10819Troubleof13Dots(int p , int f)
	{
		this.p=p;
		this.f=f;
	}
}