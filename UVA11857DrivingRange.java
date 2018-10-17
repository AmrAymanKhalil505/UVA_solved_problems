package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;



public class UVA11857DrivingRange
{	static PrintWriter pw = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)));
	static int V ;
	static int E ;
	static Triple edgeList []; 
	static UnionFind uf;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
		String line ;
		while(!((line=br.readLine()).equals("0 0")))
		{
			String Sline []= line.split(" ");
			 V = Integer.parseInt(Sline[0]);
			 E =Integer.parseInt(Sline[1]);
			 edgeList = new Triple[E];
			 for(int i=0;i<E;i++)
			 {
				 Sline=br.readLine().split(" ");
				 edgeList[i]= new Triple(Integer.parseInt(Sline[0]),Integer.parseInt(Sline[1]), Integer.parseInt(Sline[2]));
			 }
			int output= Kruskal();
			 if(uf.numSets==1)
			 {
				 pw.println(output);
			 }
			 else
			 {
				 pw.println("IMPOSSIBLE");
			 }
		}
		pw.flush();
		pw.close();
	}
		
	static int Kruskal() {
		Arrays.sort(edgeList);
		 uf = new UnionFind(V);
		int mst = 0;
		for (Triple t : edgeList) {
			if (!uf.isSameSet(t.u, t.v)) {
				mst =Math.max(  t.w,mst);
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
	static class Triple implements Comparable<Triple> 
	{	int u; // from vertex u
		int v; // to vertex v
		int w; // with weight w
		public  Triple(int from , int to , int weight)
		
		{
		u =from;
		v=to;
		w=weight;
		}
		@Override
		public int compareTo(Triple o) {
			return this.w-o.w;
		}
	}
}
