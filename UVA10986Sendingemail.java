package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class UVA10986Sendingemail
{	static ArrayList<Edge> AdjList [] =new ArrayList[20005];
	static long  Dist []= new long [20005];
	static final long oo = 1<<62;
	static int P[] = new int [20005]; 
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		String Segling[] ;
		int C =1;
		for(int i=0;i<AdjList.length;i++)
		{
			AdjList[i]= new ArrayList<Edge>();
		}
		
		while(TC-->0)
		{	
			Segling = br.readLine().split(" " );
			int n = Integer.parseInt(Segling[0]);
			int m = Integer.parseInt(Segling[1]);
			int s = Integer.parseInt(Segling[2]);
			int z = Integer.parseInt(Segling[3]);
			for(int i=0;i<=n;i++)
			{
				AdjList[i].clear();
			}
			for(int i=0;i<m;i++)
			{
				Segling= br.readLine().split(" " );
				int u = Integer.parseInt(Segling[0]);
				int v =	Integer.parseInt(Segling[1]);
				int w = Integer.parseInt(Segling[2]);
				AdjList[u].add(new Edge(v, w));
				AdjList[v].add(new Edge(u, w));
				
			}
				dijk(s,z);
				if(Dist[z]==oo)
				{
					pw.printf("Case #%d: unreachable\n",C++);
				}
				else
				{
					pw.printf("Case #%d: %d\n",C++,Dist[z]);
				}
		}
		pw.flush();
		pw.close();
	}
	static void dijk(int s , int z)
	{
		Arrays.fill(Dist, oo);
		PriorityQueue<Edge> PQ = new PriorityQueue<Edge>();
		Dist[s]=0;
		PQ.add(new Edge(s, 0));
		
		while(!PQ.isEmpty())
		{
			Edge u = PQ.poll();
			if(u.w > Dist[u.v])
			{
				continue;
			}
			for(Edge v : AdjList[u.v])
			{
				if (Dist[v.v]>Dist[u.v]+v.w)
				{
					Dist[v.v]=Dist[u.v]+v.w;
					PQ.add(new Edge(v.v, Dist[v.v]));
					P[v.v] = P[u.v];
				}
			}
		}
	}

	static class Edge implements Comparable<Edge> 
	
	{
		int v ;
		long w ;
		public Edge(int vertex , long weight)
		{
			v = vertex;
			w = weight;
		}
		@Override
		public int compareTo(Edge o) {
				if(this.w>o.w)
				{
					return 1;
				}
				if(this.w==o.w)
				{
					return 0;
				}
				return -1;
		}
		
	}
	
}
