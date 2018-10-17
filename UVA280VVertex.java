package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class UVA280VVertex 
{	static int visited []=new int [105];static ArrayList<Integer> AdjList [] = new ArrayList[105];// visited Array and AdjList
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException {
		BufferedReader  br= new BufferedReader(new InputStreamReader(System.in));
		String line ;String[] Segline;
		for(int i=0;i<AdjList.length;i++)
		{
			AdjList[i]= new ArrayList<Integer>();
		}	// initializing  all the ArrayLists
		while((line =br.readLine())!=null&&!line.equals("0"))
		{
			int M = Integer.parseInt(line); // number of nodes
		
			
			for(int i=0;i<M+1;i++)
			{
				AdjList[i].clear(); // clear all Array lists needed for this part
			}
			while((line =br.readLine())!=null&&!line.equals("0"))
			{
				Segline=line.split(" "); // split the line 
				int u =Integer.parseInt(Segline[0]); // first node that will connect to other
				for(int i=1;i<Segline.length-1;i++)
				{
					AdjList[u].add(Integer.parseInt(Segline[i]));// making and edge from U to V
				}
				
				
			}
			Segline =br.readLine().split(" ");// reading the line telling me which i should test
			for(int i=1;i<Segline.length;i++)
			{ Arrays.fill(visited, 0); // fill the visited array with zeros
				int u = Integer.parseInt(Segline[i]);
				dfs(u,u);// i need to visit the start node twice so i put it in the method as j
				StringBuilder outString=new StringBuilder();int c=0;// string builder for the output
				String oo; // output 
				for(int j=1;j<M+1;j++)
				{	if(j==u) // this node should be visited twice
					{
					 if(visited[j]!=2)
					 {
						 	c++;
							outString.append(j+" ");
					 }
					}
					if(visited[j]==0&&j!=u)// this node should be visited once 
					{c++;
					outString.append(j+" ");
					}
					
				}
				
				
			oo=(c+" "+outString.toString()).trim(); // i always have space i need to trim it
				pw.println(oo);
			}
			
		}
		pw.flush();
		pw.close();
	}
	private static void dfs(int u,int j)
	{	// j the node i need to visit it twice
		visited[u]++;// mark visited
		for(int i=0;i<AdjList[u].size();i++)
		{ int v =AdjList[u].get(i);  // get my child
			if(v==j) // if it equals the starting node i have to visit it twice
			{	if(visited[v]<2)
				
				dfs(v,j);
			}
			// else visit other once 
			else if(visited[v]<1)
			{
				dfs(v, j); 
			}
			
		}
		
	}
}
