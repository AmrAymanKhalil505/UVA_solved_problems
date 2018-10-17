package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UVA10507WakingUpBrain {
	static ArrayList<Integer> Adj [] ;
	static int c;
	static int  wake[] ;
	static boolean visited[];
	 static int bar =-500;
	public static void main(String[] args) throws IOException {
	BufferedReader br = new  BufferedReader( new InputStreamReader( System.in));
	String line ;
	StringBuilder wokeup=new StringBuilder();
	while ((line=br.readLine())!=null)
	{
		int n =Integer.parseInt(line);
		Adj=new ArrayList [n+1];
		
		wake=new int[n];
		for(int i =0 ;i<n+1;i++)
		{
			Adj[i]=new ArrayList<Integer>();
			
		}
		int m =Integer.parseInt(br.readLine());
		 wokeup.append(br.readLine());
		char alp [] =new char[n];c=0;
		visited= new boolean [n];
		for(int i=0;i<m;i++)
		{int indx;int indy;
			line=br.readLine();
			indx =contains(alp,line.charAt(0));
			
			indy=contains(alp,line.charAt(1));
			Adj[indx].add(indy);
			Adj[indy].add(indx);
			
		}
		for(int i=0;i<3;i++)
		{
			int id= contains(alp,wokeup.charAt(i));
			wake[id]=3;
		}
	
		
		System.out.println(bfs());
	}
	
}

	private static String bfs() {
		Queue<Integer> q =new LinkedList<Integer>();int years=0;
		int all=0;
		for(int i=0;i<wake.length;i++)
		{if(wake[i]==3)
			q.add(i);
		}
		q.add(bar);
		while(!q.isEmpty())
		{	
			int ind =q.poll();
			if(ind == bar)
			{
				years++;
				q.add(bar);
			}
			else{
				all++;
			 visited[ind]=true;
			for(int i=0;i<Adj[ind].size()-1;i++)
			{
				if(wake[Adj[ind].get(i)]!=3)
				{
					wake[i]++;
				}
				if(wake[Adj[ind].get(i)]==3&&!visited[Adj[ind].get(i)])
				{
					q.add(Adj[ind].get(i));
				}
				
			}
		}
	
	}	for(int i=0;i<wake.length;i++)
	{
		if(wake[i]==3)
		{
			all++;
		}
		
	}
	if(all==wake.length)
	{
		return "WAKE UP IN, "+years+", YEARS";
	}
	else
	{
		return "THIS BRAIN NEVER WAKES UP";
	}
	}
	private static int contains(char[] alp,char x) {
		for(int i=0;i<=c;i++)
		{
			if(i==c)
			{
				alp[i]=x;c++;
				return c;
				
			}
			else if(alp[i]==x)
				
			{
				return i;
			}
		}
		return -1;
	}
}
