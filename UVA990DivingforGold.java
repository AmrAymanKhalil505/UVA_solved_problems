package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA990DivingforGold {
	static int DP [][];static int itemsD[];static int itemsV[]; static int n ;
	static PrintWriter pw = new  PrintWriter(System.out); static int w;
	static final int NINF =-(int)1e9;static StringBuffer output;static int c=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String line ;
		String Spline[]; boolean f = true;
		while((line =br.readLine())!=null&&!line.isEmpty())
		{	if(f )
			{
				f= false;
			}
		else
		{
			pw.println();
		}
			Spline =line.split(" ");
			int t = Integer.parseInt(Spline[0]);
			 w = Integer.parseInt(Spline[1]);
			n = Integer.parseInt(br.readLine());
			DP = new int [n][1000+5];
			itemsD= new int [n];
			itemsV=new int [n];
			for(int i=0;i<n;i++)
			{	Spline= br.readLine().split(" ");
				itemsD[i]=Integer.parseInt(Spline[0]);
				itemsV[i]=Integer.parseInt(Spline[1]);
			}
			for(int i=0;i<DP.length;i++)
			{
				Arrays.fill(DP[i],-1);
			}
			pw.println(Dive(0,t));output= new StringBuffer();c=0;
			print (0,t);
			pw.println(c);
			pw.print(output);
			
			if(br.ready())
			{
				br.readLine();
			}
		}
		pw.flush();pw.close();
	}
	private static void print(int index, int time) 
	{	if(time<0)
	{
		return ;
	}
	if(n==index)
	{
		return ;
	}
		int op =DP[index][time];
		int take = itemsV[index]+Dive(index+1, time-(itemsD[index]*w+itemsD[index]*2*w));
		int leave=Dive(index+1,time);
		if(take == op)
		{c++;
		output.append(itemsD[index]+" "+itemsV[index]+"\n");
		print (index+1,time-(itemsD[index]*w+itemsD[index]*2*w));
		}
		else
		{
			print (index+1,time);
		}
	}
	private static int  Dive(int index, int time) 
	{
		if(time<0)
		{
			return NINF;
		}
		if(n==index)
		{
			return 0;
		}
		
		
		if(DP[index][time]!=-1)
		{
			return DP[index][time];
		}
		int take = itemsV[index]+Dive(index+1, time-(itemsD[index]*w+itemsD[index]*2*w));
		int leave =Dive(index+1,time);
		DP[index][time]=Math.max(take, leave);
		return DP[index][time];
	}
}
