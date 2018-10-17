package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UVA10131IsBiggerSmarter {
			static int  DP[][];static int  n;
			static final int NINF=(int )-1e9;
			static PrintWriter pw = new PrintWriter(System.out);
			static ArrayList<triple>  Elep;
			static final int INF = (int)1e9;
	public static void main(String[] args) throws IOException
	{
			BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
			String line ;
			String SegLine[];Elep= new ArrayList<triple>();
			int c=0;
		
			while((line=br.readLine())!=null&&!line.isEmpty())
			{
				SegLine= line.split(" ");
				Elep.add(new triple(Integer.parseInt(SegLine[0]),Integer.parseInt(SegLine[1]), c));
				c++;
			}
			
			Collections.sort(Elep);
			Elep.add(0, new triple(NINF, INF, Elep.size()));
			DP = new int [Elep.size()][Elep.size()];
			n = Elep.size();
			for(int i=0;i<DP.length;i++)
			{
				Arrays.fill(DP[i], NINF);
			}
			int op = LIS (1,0);
					pw.println(op);
					print(1,0,op);
		/*	for(int i=0;i<DP.length;i++)
			
			{
				for(int j=0;j<DP.length;j++)
				{
					System.out.print(DP[i][j]+" ");
				}
				System.out.println();
			}*/
					pw.flush();
					pw.close();
	}
	private static void print(int index,int prev,int op) {
		if(index==n)
		{
			return ;
		}
		
		if(Elep.get(prev).w<Elep.get(index).w&&Elep.get(index).iq<Elep.get(prev).iq)
		{
			//take 
			int take =LIS(index+1,index);
			int leave = LIS(index+1,prev);
			if(leave ==op)
			{	
				print(index+1, prev, op);
			}
			else
				
			{	
				
				pw.println(Elep.get(index).index+1);
				print(index+1, index, op-1);
			}
			
		}
		else
		{	
			print(index+1, prev, op);
			
		}
		
	}
	private static int LIS(int index, int prev) {
		if(index==n)
		{
			return 0;
		}
		if(DP[index][prev]!=NINF)
		{
			return DP[index][prev];
		}
		
		if(Elep.get(prev).w<Elep.get(index).w&&Elep.get(index).iq<Elep.get(prev).iq)
		{
			//take 
			int take =1+LIS(index+1,index);
			int leave = LIS(index+1,prev);
			DP[index][prev]=Math.max(take, leave);
			return DP[index][prev];
		}
		else
		{
			DP[index][prev]=LIS(index+1,prev);
			return DP[index][prev];
		}
	
		
			
		
		
		
		
		
	}
}

class triple implements Comparable
{	int w ;
	int iq;
	int index;
	triple(int W , int IQ,int Index)
	{w=W;
	iq=IQ;
	index=Index;
	
	}
	@Override
	public int compareTo(Object o) {
		 triple oo = (triple)o;
		 if(this.w-oo.w!=0)
		 {
			 return this.w-oo.w;
		 }
		 else 
		 {
			 return this.iq-this.iq;
		 }
		
	}
}