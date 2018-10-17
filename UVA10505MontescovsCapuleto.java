package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;



public class UVA10505MontescovsCapuleto 
{	static PrintWriter pw = new PrintWriter( new BufferedWriter( new OutputStreamWriter(System.out)));
	static ArrayList<Integer> AdjList []= new ArrayList[205];
	static int visited [] = new int [205];
	static int E1 ;
	static int E2 ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int i =0;i<AdjList.length;i++)
		{
			AdjList[i]= new ArrayList<Integer>();
		}
		while(TC-->0)
		{	for(int i=0;i<AdjList.length;i++)
			AdjList[i].clear();
			br.readLine();
			int N = Integer.parseInt(br.readLine());
			Arrays.fill(visited, -1);
			for(int i=1;i<=N;i++)
			{
				String Line [] = br.readLine().split(" ");
				for(int j=1;j<Line.length;j++)
				{	int v =Integer.parseInt(Line[j]);
					AdjList[i].add(v);
					AdjList[v].add(i);
				}
			}
			int r =0;
			for(int i =1;i<N;i++)
			{
				if(visited[i]==-1)
				{
					E1=1;
					E2=0;
					visited[i]=0;
					bio(i);
					r+= Math.max(E1, E2);
				}
			}
			pw.println(r);
		
		}
		pw.flush();
		pw.close();
	}
	private static void bio(int u)
	{
		
		
		for(int i=0;i<AdjList[u].size();i++ )
		{ int v =AdjList[u].get(i);
			if(visited[v]==visited[u])
				{E1=0;
				E2=0;
				return ;}
			if(visited[v]==-1)
			{
				visited[v]=1-visited[u];
				if(visited[v]==1)
				{
					E2++;
					
				}
				else
				{
					E1++;
				}
				bio(v);
			}
				
		}
	}
}
