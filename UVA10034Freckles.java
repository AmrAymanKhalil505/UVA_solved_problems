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

public class UVA10034Freckles 
{	static double xA[] ;
	static double yA[] ;
	static int  rep [];
	static int rank [];
	static int setSize[];
	static int numSets;
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

	static ArrayList<Triple> EdgeList =new ArrayList<Triple>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		 	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		 	boolean f =true;
		 	int TC =Integer.parseInt(br.readLine());
		 	while(TC-->0)
		 	{	
		 		if(f)
		 		{
		 			f=false;
		 			
		 		}
		 		else
		 		{
		 			pw.println();
		 		}
		 		EdgeList.clear();
		 		br.readLine();
		 		int N =Integer.parseInt(br.readLine());
		 		xA=new double[N];
		 		yA=new double[N];
		 		String line [];
		 		for(int i=0;i<N;i++)
		 		{
		 			line = br.readLine().split(" ");
		 			xA[i]=Double.parseDouble(line[0]);
		 			yA[i]=Double.parseDouble(line[1]);
		 		}
		 		for(int i=0;i<N;i++)
		 		{
		 			for(int j=i+1;j<N;j++)
		 			{	double wx = xA[i]-xA[j];
		 				double wy = yA[i]-yA[j];
		 				EdgeList.add(new Triple(i,j ,wx*wx+wy*wy ));
		 			}
		 		}
		 		Collections.sort(EdgeList);
		 		rep = new int[N];
				rank = new int[N];
				setSize = new int[N];
				for (int i = 0; i <N; i++) {
					rep[i] = i;
					rank[i] = 1;
					setSize[i] = 1;
				}
				numSets = N;
				double mst_cost = 0;
				for(int i=0;i<EdgeList.size();i++)
				{
					Triple x =EdgeList.get(i);
					if(!isSameSet(x.from, x.to))
					{
						mst_cost+=Math.sqrt(x.w);
						Union(x.from, x.to);
					}
				}
				
				pw.printf("%.2f\n",mst_cost);
		 	}
		 	pw.flush();
		 	pw.close();
	}
static class Triple implements Comparable<Triple>
{	int from ;
	int to ;
	double w ;
	Triple(int from , int  to ,double w)
	{
		this.from=from;
		this.to=to;
		this.w=w;
	}
	@Override
	public int compareTo(Triple o) {
		return (int) Math.ceil(this.w-o.w);
	}
}

public static int findSet(int x) {
	if (rep[x] == x)
		return x;
	return rep[x] = findSet(rep[x]);
}
public static boolean isSameSet(int x, int y) {
	return findSet(x) == findSet(y);
}

public static void Union(int x, int y) {
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

}
