package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class UVA10305OrderingTasks 
{
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static ArrayList<Integer> AdjList [] = new ArrayList[105];
	static boolean Visited [] = new boolean [105];
	static Stack<Integer> st = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		String line ;
		for(int i=0;i<AdjList.length;i++)
		{
		AdjList [i]= new ArrayList<Integer>();  
		}
		while ((line = br.readLine())!=null &&! line.equals("0 0"))
		{	String Sline[] = line.split(" ");
			int n =Integer.parseInt(Sline[0]);
			int m =Integer.parseInt(Sline[1]);
			for(int i=1;i<n+1;i++)
			{
				AdjList[i].clear();
			}
			Arrays.fill(Visited, false);
			for(int i=0;i<m;i++)
			{
				Sline = br.readLine().split(" " );
				int u =Integer.parseInt(Sline[0]);
				int v =Integer.parseInt(Sline[1]);
				AdjList[u].add(v);
				
			}
			for(int i=1;i<n+1;i++)
			{ if(!Visited[i])
				Trajan(i);
			}
			StringBuilder sb = new StringBuilder();
			while(!st.isEmpty())
			{
				sb.append(st.pop()+" ");
			}
			pw.println(sb.toString().trim());
		}
		pw.flush();pw.close();	
	}
	static void Trajan(int u )
	{
		Visited[u]= true;
		for(int i=0;i<AdjList[u].size();i++)
		{	int v =AdjList[u].get(i);
			if(!Visited[v])
			{
				Trajan(v);
			}
		}
		st.push(u);
	}
}
