package UVA;

//import graphsCamp.tarjanSCC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
//import java.nio.channels.ServerSocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
//import java.util.TreeSet;

public class UVA11709Trustgroups 
{	static int  rep [];
	static int rank [];
	static int setSize[];
	static int numSets;
	static boolean[] SCC= new boolean [1005];
	static ArrayList<Integer> AdjList [] =new ArrayList[1005];
	static int dfs_num[] = new int [1005];
	static int dfs_low[] = new int [1005];
	static int ID =1;
static Stack<Integer> ST = new Stack<Integer>();
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		String line ;
		String People [];
//		int Sets[];
		for(int i=0;i<1001;i++)
		{
			AdjList[i]=new ArrayList<Integer>();
		}
		while((line =br.readLine())!=null&&!line.equals("0 0"))
		{String lineS []=line.split(" ");
			
			int p =Integer.parseInt(lineS[0]);
			int t =Integer.parseInt(lineS[1]);
			People=new String [p];
			for(int i=0;i<p;i++)
			{
				AdjList[i].clear();
			}
			numSets = 0;
			ST.clear();
			/*rep = new int[p];
			rank = new int[p];
			setSize = new int[p];
			for (int i = 0; i < p; i++) {
				rep[i] = i;
				rank[i] = 1;
				setSize[i] = 1;
			}
			numSets = p;
			*/
			Arrays.fill(dfs_low, 0);
			Arrays.fill(dfs_num, 0);
			Arrays.fill(SCC, false);
			for(int i=0;i<p;i++)
			{
				People[i]=br.readLine();
				
			}
			Arrays.sort(People);
			for(int i=0;i<t;i++)
			{
				String p1String= br.readLine();
				String p2String=	br.readLine();
				int p1=Arrays.binarySearch(People, p1String);
				int p2=Arrays.binarySearch(People, p2String);
//				Union(p1,p2);
				
				AdjList[p1].add(p2);
			}
			ID=1;
			for(int i=0;i<p;i++)
			{
				if(dfs_num[i]==0)
				{
					TarjanSSC(i);
				}
			}//System.out.println(Arrays.toString(dfs_num));
			//System.out.println(Arrays.toString(dfs_low));
			pw.println(numSets);
		}
		pw.flush();pw.close();
		
	}
	
	private static void TarjanSSC(int u) 
	{
		dfs_low[u]=dfs_num[u]=ID++;
			
	ST.add(u);
//		SCC[u] =true;
		
		for(int i=0;i<AdjList[u].size();i++)
		{
			int v =AdjList[u].get(i);
			if(dfs_num[v]==0)
			{
				TarjanSSC(v);
			}
			if(!SCC[v])
			{
				dfs_low[u]= Math.min(dfs_low[u],dfs_low[v]);
				
			}	
		}
		if(dfs_low[u]==dfs_num[u])
		{
			numSets++;
			while(true)
			{
				int v =ST.pop(); 
				SCC[v]=true;
				if(u==v)
				{
					break;
				}
			}
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
