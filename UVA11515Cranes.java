package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UVA11515Cranes {
	static int N ;
	static int x [] ;
	static int y [] ;
	static int r [];
	static PrintWriter pw = new  PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader ( new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		while(TC-->0)
		{
			 N = Integer.parseInt(br.readLine());
			x = new int [N];
			y = new int [N];
			r  = new int [N];
			int l = 1<<N;
			int sumMax=0;
			String line [];
			for(int i = 0;i<N;i++)
			{
				line= br.readLine().split(" ");
				x[i]=Integer.parseInt(line[0]);
				y[i]=Integer.parseInt(line[1]);
				r[i]=Integer.parseInt(line[2]);
			}
			
			for(int i=1;i<l;i++)
			{ 
				if(NoConfilect (i))
				{
					sumMax= Math.max(Calc(i), sumMax);
				}
			}
			pw.println(sumMax);
			
		}
		pw.flush();
		pw.close();
	}
	private static int Calc(int num) {
		int sum =0;
		for(int i=0;i<N;i++)
		{
			if((num&(1<<i))!=0)
			{
				sum += r[i]*r[i];
			}
				
		}
		return sum;
	}
	private static boolean NoConfilect(int num) 
	{  //	System.out.print(Integer.toBinaryString(num));
		
		for(int i=0;i<N;i++)
		{if((num&1<<i)!=0)
			for(int j=i+1;j<N;j++)
			{if( (num&(1<<j))!=0)
				{int xx =x[i]-x[j];
					int yy=y[i]-y[j];
					int rr= r[i]+r[j];
				int c=	 (xx)*(xx)+yy*yy;
				if(c<=(rr)*(rr))
					{	//System.out.println("Coflect");
				return false;
					}
				}
			}
		}//System.out.println("No Conflect");
		return true;
	}
}
