package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class UVA01234Racing
{	static PrintWriter pw =new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int N;
	static UnionFind UF ;
	static PriorityQueue<Edge> PQ = new PriorityQueue<Edge>(Collections.reverseOrder());
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		while (TC-->0)
		{
			String Sline [] = br.readLine().split(" ");
			N = Integer.parseInt(Sline[0]);
			
			int M = Integer.parseInt(Sline[1]);
			long R = 0;
			for(int i=0;i<M;i++)
			{ Sline  = br.readLine().split(" ");
			  int u = Integer.parseInt(Sline[0]);
			  int v = Integer.parseInt(Sline[1]);
			  int w = Integer.parseInt(Sline[2]);
			  R+=w;
			  PQ.add(new Edge(u-1, v-1, w));
			}
			R= kuskal(R);
			pw.println(R);
			
		}
		br.readLine();
		pw.flush();
		pw.close();
		
	}
	private static long kuskal(long r) 
	{
		UF = new UnionFind(N);
		while(!PQ.isEmpty())
		{	Edge E = PQ.poll();
			if(!UF.isSameSet(E.u,E.v) )
			{
				r-=E.w;
				UF.Union(E.u,E.v );
			}
			
		}
		return r;
	}
	static class Edge implements Comparable<Edge>
	{
		int u ;
		int v ;
		int w ;
		
		public Edge(int u , int v ,int w)
		{
			this.u = u;
			this.v = v;
			this.w = w;
		}@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.w-o.w;	
		}
		
	}
	static class UnionFind 
	{
		int []rep , rank , setSize;
		int numSets;

		public UnionFind(int n) {
			rep = new int[n];
			rank = new int[n];
			setSize = new int[n];
			for (int i = 0; i < n; i++) {
				rep[i] = i;
				rank[i] = 1;
				setSize[i] = 1;
			}
			numSets = n;
		}
		public int findSet(int x) {
			if (rep[x] == x)
				return x;
			return rep[x] = findSet(rep[x]);
		}
		public void Union(int x, int y) {
			int x1 = findSet(x), y1 = findSet(y);
			if (x1 == y1)
				return;
			if (rank[x1] > rank[y1]) {
				rep[y1] = x1;
				setSize[x1] += setSize[y1];
			} else {
				rep[x1] = y1;
				setSize[y1] += setSize[x1];
				if (rank[y1] == rank[x1])
					rank[y1]++;
			}
			numSets--;
		}

		public boolean isSameSet(int x, int y) {
			return findSet(x) == findSet(y);
		}
	}
	}

