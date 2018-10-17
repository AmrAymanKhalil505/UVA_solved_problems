package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UVA567Risk 
{static PrintWriter pw = new  PrintWriter( new BufferedWriter( new OutputStreamWriter( System.out)));
	static ArrayList<Integer> adjlist [] = new ArrayList[21];
	static boolean visited []=new boolean [21]; 
	public static void main(String[] args) throws IOException {
		 BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		 for(int i=0;i<21;i++)
		 {
			 adjlist[i]= new ArrayList<Integer>();
			 
		 }
		 String line;
		 int c =1;
		 while((line= br.readLine())!=null&&!line.isEmpty())
		 {	
			 for(int i=0;i<21;i++)
			 {
				 adjlist[i].clear();
				 
			 }
		
			 pw.println("Test Set #"+c);
			 c++;
			 String Sline[] =line.split(" ");
		 for(int j=1;j<Sline.length;j++)
		 {	 int u=	Integer.parseInt(Sline[j]);
			 adjlist[1].add(u);
			 adjlist[u].add(1);
		 }
			 for(int i=2;i<20;i++)
			 {
				 Sline =br.readLine().split(" ");
				 for(int j=1;j<Sline.length;j++)
				 {
					 int u=	Integer.parseInt(Sline[j]);
					 adjlist[i].add(u);
					 adjlist[u].add(i);
				 }
			 }
			 int TC = Integer.parseInt(br.readLine());
			 while(TC-->0)
			 {
				 Sline =br.readLine().split(" ");
				 int s =Integer.parseInt(Sline[0]);
				 int z =Integer.parseInt(Sline[1]);
				 int output = bfs(s,z);
				 pw.printf("%2d to %2d:%2d\n",s,z,output);
			 }
			 pw.println();
		 }
		 pw.flush();pw.close();
	}

	private static int bfs(int s, int z) {
		Queue<Integer> Q = new LinkedList<Integer>();
		Queue<Integer> costQ = new LinkedList<Integer>();
		Arrays.fill(visited, false);
		visited[s]=true;
		Q.add(s);
		costQ.add(0);
		while(!Q.isEmpty())
		{	
			int u =Q.poll();
			int co = costQ.poll();
			//System.out.println(u+" "+co);
			if(u==z)
			{
				return co;
			}
			for(int i=0;i<adjlist[u].size();i++)
			{int v =adjlist[u].get(i);
				if(!visited[v])
				{	visited [v]= true;
					Q.add(v);
					costQ.add(co+1);
				}
			}
		}
		
		
		return 0;
	}
}
