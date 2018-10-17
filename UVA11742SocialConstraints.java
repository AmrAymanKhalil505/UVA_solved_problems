package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA11742SocialConstraints {
	static int Con[][];
	static int Places [];
	static int c ;
	static int cona[];
	static int conb[];
	static int conw[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		 String line ;PrintWriter pw = new PrintWriter(System.out);
		 while((line = br.readLine())!=null&& !line.equals("0 0"))
		 {
			 	String Spline []=line.split(" ");
			 	int n =Integer.parseInt(Spline[0]);
			 	int m =Integer.parseInt(Spline[1]);
			 	c=0;
			 	
			 	Places= new int [n];
			 	/* 
			 while(m-->0)
			 {
				 Spline = br.readLine().split(" ");
				 int a = Integer.parseInt(Spline[0]);
				 int b = Integer.parseInt(Spline[1]);
				 int w =Integer.parseInt(Spline[2]);
				 Con [a][b] =w;
				 Con [b][a] =w;
				 Perm(0);
			 }*/
			 	cona= new int [m];
			 	conb=new int [m];
			 	conw =new int [m];
			 for(int i=0;i<m;i++)
			 {
				 Spline = br.readLine().split(" ");
				 int a = Integer.parseInt(Spline[0]);
				 int b = Integer.parseInt(Spline[1]);
				 int w =Integer.parseInt(Spline[2]);
				 cona[i]=a;
				 conb[i]=b;
				 conw[i]=w;
			 }
			 Perm(0);
			 pw.println(c);
		 }
		 pw.flush();pw.close();
	}
	private static void Perm(int index)
	{
		if(index==Places.length)
		{
			check();
			return ;
		}
		for(int i=0;i<Places.length;i++)
		{
			if(place(i,index))
			{
				Places[index]=i;
				Perm(index+1);
				
			}
		}
		
	}
	private static boolean place(int ii, int index) 
	{
		for(int i=0;i<index;i++ )
		{
			if(ii==Places[i])
			{
				return false;
			}
		}
		return true;
	}
	private static void check() 
	{
		for(int i=0;i<cona.length;i++)
		{
			if(conw[i]>0)
			{
				if(!(Math.abs(Places[cona[i]]-Places[conb[i]])<=conw[i]))
				{
					return;
				}
			}
			else
			{
				if(!(Math.abs(Places[cona[i]]-Places[conb[i]])>=-conw[i]))
				{
					return;
				}
			}
		}
		c++;
	}
}
