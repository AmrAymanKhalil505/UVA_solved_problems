package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA12455Bars { 
	static int DP [][];
	static int bars[];
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out);static int p;static int n;
	public static void main(String[] args) throws NumberFormatException, IOException
	{int TC = Integer.parseInt(br.readLine());
	
	String line []; 
	
	while(TC-->0)
	{ n=Integer.parseInt(br.readLine());
	  p=Integer.parseInt(br.readLine());
	 line= br.readLine().split(" ");
	 bars = new int [p];
	// DP= new int [n+1][1<<p];
	 for(int i=0;i<line.length;i++)
	 {
		 bars[i]=Integer.parseInt(line[i]);
	 }
	 boolean f= Bars(0,n,0);
	if(f)
		{
		pw.println("YES");
		}
	else
		{
		pw.println("NO");
		}
	}
	pw.flush();
	pw.close();
		
	}
	private static boolean  Bars(int index,int n,int bitmask ) {
		if (index==p)
		{	if(n==0)
			{
			return true ;
			}
			return false;
		}
		if((bitmask&1<<index)!=0)
		{
			return false;
			
		}
		if(n==0)
		{
			return true ;
		}
	//	System.out.println( index+" "+n+" "+ bitmask );
		int bitmasktake = bitmask^1<<index;
		boolean take  =Bars(index+1,n-bars[index],bitmasktake);
		boolean leave =Bars(index+1,n,bitmask);
		
		return take||leave;
	}
}
