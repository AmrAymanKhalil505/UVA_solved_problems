package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;



public class UVA10842TrafficFlow
{static PrintWriter pw = new PrintWriter( new BufferedWriter( new OutputStreamWriter( System.out)));
 static PriorityQueue<Edge> PQ = new PriorityQueue<Edge>(Collections.reverseOrder());
 static boolean visited [] =new boolean [125]; 
 static int V;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int c =1;c<=TC;c++)
		{	PQ.clear();
			String Sline[] = br.readLine().split(" ");
			V = Integer.parseInt(Sline[0]);
			int M = Integer.parseInt(Sline[1]);
			for(int cc=0;cc<M;cc++)
			{
				Sline= br.readLine().split(" ");
				int u = Integer.parseInt(Sline[0]);
				int v =Integer.parseInt(Sline [1]);
				int cap = Integer.parseInt(Sline[2]);
				PQ.add(new Edge(u, v, cap));
				
			}
			
			
				int cost =	kuskal ();
				pw.printf("Case #%d: %d\n", c,cost);
		}
		pw.flush();
		pw.close();
	}
	
	private static int  kuskal() 
	{
		UnionFind uf = new UnionFind(V);
		int mst = 1<<28;
	while(!PQ.isEmpty())
	{
		Edge t =PQ.poll();
			if (!uf.isSameSet(t.u, t.v)) {
				mst = Math.min(t.w, mst);
				uf.Union(t.u, t.v);
			}
		}
		return mst;
	}

	static class UnionFind {

		int[] rep, rank, setSize;
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
	static class Edge implements Comparable<Edge>
	{	int u ;
		int v ; // vertex
		int w ;	// weight 
		
		public Edge (int U ,int V, int W)
			
		{   u =U;
			v= V;
			w= W;
		}

		@Override
		public int compareTo(Edge o) {
			
			return this.w-o.w;
		}
	}
}
