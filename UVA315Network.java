package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;



public class UVA315Network 
{	static PrintWriter pw = new  PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static ArrayList<Integer> adjList [];
	static final int VISITED =1;
	static final int UNVISTIED=0;
	static final int EXPLORD=-1;
	static int [] dfs_num;
	static int [] dfs_low;
	static int  DFSN;
	static int Childeren;
	static int root;
	static int Visited[];
	static int Parent[];
	static boolean art[];
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		while((line=br.readLine())!=null&&!line.equals("0"))
		{	int c=0;
			int Nodes = Integer.parseInt(line);
			adjList = new ArrayList[Nodes+1];
			for(int i=0;i<adjList.length;i++)
			{
				adjList[i]= new ArrayList<Integer>();
			}
			
			// making my Arrays starting from 1 (1 indexed) 
			dfs_low= new int[Nodes+1];
			dfs_num= new int [Nodes+1];
			Visited= new int [Nodes+1];
			art =new boolean [Nodes+1];
			DFSN=1;
			Childeren=0;
			root=1;
			Parent = new int [Nodes+1];
		
			while((line=br.readLine())!=null&&!line.equals("0"))
			{
				String[] Segline = line.split(" ");
				int u = Integer.parseInt(Segline[0]);
				for(int i=1;i<Segline.length;i++)
				{	
					int v = Integer.parseInt(Segline[i]);
					adjList[u].add(v);
					adjList[v].add(u);
				}	
			}//all above is reading the input and constructing the graph 
			for(int i=1;i<adjList.length;i++)
			{
				if(dfs_num[i]==UNVISTIED)
				{root =i;Childeren=0;
					DFS(i);
					art[root]= Childeren>1; // not sure if this is handled right 
					
				}
			
			}
			for(int i=1;i<art.length;i++)
			{//System.out.print(i+" "+art[i]+" ");
				if(art[i])
				{	
					c++;
					
				}
			}//show amplification points
			//System.out.println();
			pw.println(c);
		}
		pw.flush();
		pw.close();
	}
	private static void DFS(int u) 
	{	
		dfs_low[u]=dfs_num[u]=DFSN++;
		
		for(int i=0;i<adjList[u].size();i++)
		{ int v =adjList[u].get(i);
			if(dfs_num[v]==UNVISTIED)
			{
				 Parent[v]=u;
				 if(u==root)
				 {
					 Childeren++;
				 }
				 DFS(v);
					if(dfs_low[v]>=dfs_num[u])
					{
						art[u]=true;
					}
					dfs_low[u]= Math.min(dfs_low[u],dfs_low[v]);
			}
			
			else if (v!=Parent[u])
			{
				dfs_low[u]= Math.min(dfs_low[u],dfs_num[v]);
			}
		}
		
		
	}
}
