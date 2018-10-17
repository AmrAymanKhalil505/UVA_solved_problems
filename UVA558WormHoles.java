package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class UVA558WormHoles 
{	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static ArrayList<Edge> AdjList[]= new ArrayList[1005];
	static  long dist [] =new long[1005]; 
	static final long oo = 1<<62;
	static  int n;
	public static void main(String[] args) throws NumberFormatException, IOException 
	{	for(int i=0;i<AdjList.length;i++)
		{	
		 AdjList[i]= new ArrayList<Edge>();
		}
		 BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		 int TC = Integer.parseInt(br.readLine());// read Test Cases
		 while(TC-->0)
		 {		
			 String line []= br.readLine().split(" ");//split the first line
			 n = Integer.parseInt(line[0]); //get the number of nodes
			 int m = Integer.parseInt(line[1]); // get number of worm holes
			 for(int i=0;i<n;i++)
			 {
				 AdjList[i].clear();
			 }
			 while(m-->0)
			 	{
				 line = br.readLine().split(" ");
				 int u = Integer.parseInt(line[0]);
				 int v = Integer.parseInt(line[1]);
				 int w = Integer.parseInt(line[2]);
				 AdjList[u].add(new Edge(v, w));
			 	}
			boolean f= Bellmen();
		//	System.out.println(Arrays.toString(dist));
			if(f)
			{
				pw.println("possible");
			}
			else
			{
				pw.println("not possible");
			}
			
		 }
		 pw.flush();
		 pw.close();
	}
	private static boolean Bellmen()
	{Arrays.fill(dist, oo);	
	dist[0]=0;
		for(int i=0;i<n-1;i++)
		{
			for(int u=0;u<n;u++)
			{
				for(int z =0;z<AdjList[u].size();z++)
				{
					Edge v =AdjList[u].get(z);
					dist[v.v]= Math.min(dist[v.v],dist[u]+v.w);
					
				}
			}
		}
			for(int u =0;u<n;u++)
			{
				for(int j =0;j<AdjList[u].size();j++)
				{
					Edge v =AdjList[u].get(j);
					
					if(dist[v.v]>dist[u]+v.w)
					return true;
				}
			}
		return false;
	}
	static class Edge
	{ 	int v;
		int w;
		public Edge(int v,int w ) 
		{
			this.v=v;
			this.w=w;
		}
	}
}
