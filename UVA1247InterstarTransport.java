package UVA;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


public class UVA1247InterstarTransport 
{	static ArrayList<Edge> AdjList[] = new ArrayList[28];
	static int  p [] = new int [28];
	static int d [] = new int [28];
	static final int oo = 1<<28;
	static PrintWriter pw = new PrintWriter(System.out);
	static StringBuilder sb = new StringBuilder(" ");
	
	public static void main(String[] args) throws IOException 
	{
		for(int i=0;i<AdjList.length;i++)
		{
			AdjList[i]= new ArrayList<Edge>();
		}
		
	BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
	String ST []=br.readLine().split(" ");
	int N = Integer.parseInt(ST[0]);
	int P = Integer.parseInt(ST[1]);
		while(P-->0)
		{	
			ST = br.readLine().split(" ");
			char u = ST[0].charAt(0);
			char v = ST[1].charAt(0);
			int w = Integer.parseInt(ST[2]);
			AdjList[u-'A'].add(new Edge(v-'A', w));	
			AdjList[v-'A'].add(new Edge(u-'A', w));
		}
		P =Integer.parseInt(br.readLine());
		while(P-->0)
		{	ST= br.readLine().split(" ");
			int s =ST[0].charAt(0)-'A';
			int z =ST[1].charAt(0)-'A';
			Dij(s,z);//System.out.println(Arrays.toString(p));
			print(s,z);
			pw.println(sb.toString().trim());sb=new StringBuilder("");
		}
		pw.flush();pw.close();
	}
	static void print (int s , int z)
	{
		if(z!=s)
			print(s, p[z]);
		char x=(char) (z+'A');
		sb.append(x+" ");
			
	}
	private static void Dij(int s, int z) 
	{
	 Arrays.fill(d, oo);
	 PriorityQueue<Edge> PQ = new PriorityQueue<Edge>();
	 PQ.add(new Edge(s, 0));d[s]=0;
	 while(!PQ.isEmpty())
	 {
		 Edge u =PQ.poll();
		 if(u.w>d[u.v])
			{
				continue;
			}
		 for(int i=0;i<AdjList[u.v].size();i++)
		 {
			Edge v =AdjList[u.v].get(i);
			if(d[v.v]>d[u.v]+v.w)
			{
				d[v.v]=d[u.v]+v.w;
				PQ.add(new Edge(v.v, d[v.v]));
				p[v.v]=u.v;
			}
			
			
		 }
		 
	 }
		
	}
	static class Edge implements Comparable<Edge>
	{
		int v ;
		int w ;
		public Edge(int v , int w) 
		{
			this.v= v;
			this.w =w;
		}
		@Override
		public int compareTo(Edge arg0) {
		if(this.w>arg0.w)
		{
			return 1;
		}
		if(this.w==arg0.w)
		{
			return 0;
		}
		return -1;
		}
	}
	static class Pair implements Comparable<Pair>
	{
		int s;
		int z;
		public Pair(int s, int z) {
		this.s =s;
		this.z =z;
		}
		@Override
		public int compareTo(Pair arg0) {
			
			return this.s-arg0.s;
		}
		
	}
}