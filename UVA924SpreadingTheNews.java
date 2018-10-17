package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;



public class UVA924SpreadingTheNews 
{static ArrayList<Integer> AdjList [] ;
	static boolean visited []= new boolean [2505];
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
		 int E =Integer.parseInt(br.readLine());
		 
		 AdjList= new ArrayList[E];
		 for(int i=0;i<E;i++)
		 {
			 AdjList[i]=new ArrayList<Integer>();
		 }
		 for(int j = 0;j<E;j++){
			 String line [] = br.readLine().split(" ");
			 for(int i=1;i<line.length;i++)
			 {
				 AdjList[j].add(Integer.parseInt(line[i]));
			 }
		 }
		 int T =Integer.parseInt(br.readLine());
		 for(int i=0;i<T;i++)
		 {
			 bfs(Integer.parseInt(br.readLine()));
			
		 }
		 pw.flush();pw.close();
	}
	private static void bfs(int t)
	{	Arrays.fill(visited, false);
		visited[t]=true;
		int d =0;
		int c =-1;
		int B =0; int D=-0;//max
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		pq.add(new Edge(t, 0));
		while(!pq.isEmpty())
		{
			Edge E = pq.poll();
		//	System.out.println(E.v+" "+E.d+" "+d);
			if(d==E.d)
			{
				c++;
			}
			else
			{	
				if(B<c)
				{
					D=d;
					B=c;
					
				}
				d=E.d;
				c=1;
			}
			for(int i=0;i<AdjList[E.v].size();i++)
			{
				if(!visited[AdjList[E.v].get(i)])
				{visited[AdjList[E.v].get(i)]=true;
					pq.add(new Edge(AdjList[E.v].get(i), E.d+1));
				}
			}
		}
		if(B<c)
		{
			D=d;
			B=c;
			
		}
	//System.out.println();
		if(D==0)
		{
			pw.println(0);
		}
		else
		{
			pw.println(B+" "+(D));
		}
	}
	static class Edge implements Comparable<Edge>
	{
		int v ;
		int d ;
		public Edge(int v , int d) 
		{
			this.v= v;
			this.d =d;
		}
		@Override
		public int compareTo(Edge arg0) {
		if(this.d>arg0.d)
		{
			return 1;
		}
		if(this.d==arg0.d)
		{
			return 0;
		}
		return -1;
		}


}}