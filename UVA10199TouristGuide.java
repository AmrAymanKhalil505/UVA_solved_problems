package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class UVA10199TouristGuide
{	static PrintWriter pw = new PrintWriter(new BufferedWriter( new OutputStreamWriter( System.out)));
	static int N ;
//static 	ArrayList<String> Names = new ArrayList<String >();
static ArrayList<Integer> adjlist []= new ArrayList[105];
static int dfs_num [] = new int [105];
static int dfs_low [] = new int [105];
static boolean art []= new boolean [105];
static int children ;
static int root ;
static int p[]= new int [105];
static int c;
	public static void main(String[] args) throws IOException {
		 BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
		String line; int Case =1; 
		for(int i=0;i<adjlist.length;i++)
		{
			adjlist[i]= new ArrayList<Integer>();
		}
		boolean f= true;
		 while(!((line=br.readLine()).equals("0")))
		{	if(f)
			{
				f=false;
			}
			else
			{
			pw.println();
			}
			 Arrays.fill(dfs_low, -1);
			Arrays.fill(dfs_num, -1);
			Arrays.fill(art, false);
			c=0;
			
		 N=Integer.parseInt(line);
		 String  names []= new String [N];
		 for(int i=0;i<N;i++)
		 { names[i]=br.readLine();adjlist[i].clear();
		 }
			Arrays.sort(names);
		 int E = Integer.parseInt(br.readLine());
		 for(int i=0;i<E;i++)
		 {
			 String Sline[] = br.readLine().split(" ");
			 int u = Arrays.binarySearch(names,Sline[0]);
			 int v = Arrays.binarySearch(names,Sline[1]);
			 adjlist[u].add(v);
			 adjlist[v].add(u);
			 
		 }
		 for(int i=0;i<N;i++)
		 {	if(dfs_num[i]==-1)
		 	{	root=i;c=0;children=0;
			 ArticulationBridge(i);
			 art[root]= children>1;
		 	}
		 }int r =0;StringBuilder output= new StringBuilder("");
		 for(int i=0;i<N;i++)
		 {
			 if(art[i])
			 {	output.append(names[i]+"\n");
				 r++;
			 }
		 }
		 pw.printf("City map #%d: %d camera(s) found\n",Case,r);
		 pw.print(output);
		 Case++;
		 c=0;
		 
		}
		 pw.flush();
		 pw.close();
	}
	static void ArticulationBridge(int u) {
		dfs_num[u] = dfs_low[u] = ++c;
		for (int v : adjlist[u]) {
			if (dfs_num[v] == -1) {
				if (root == u)
					children++;
				p[v] = u;
				ArticulationBridge(v);
				if (dfs_low[v] >= dfs_num[u]) 
				{
					art[u] = true;
				}
				dfs_low[u]= Math.min(dfs_low[u],dfs_low[v]);
			} else {
				if (p[u] != v)
					dfs_low[u] = Math.min(dfs_low[u], dfs_num[v]);
			}
		}
	}
}
