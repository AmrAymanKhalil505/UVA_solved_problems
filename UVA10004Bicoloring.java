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

public class UVA10004Bicoloring 
{static ArrayList<Integer> AdjList [];
static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		String Segline [];
		while((line = br.readLine())!=null&&!line.equals("0"))
		{
			int N = Integer.parseInt(line);
			int E =Integer.parseInt(br.readLine());
			color= new int [N];
			Arrays.fill(color, -1);
			AdjList=new ArrayList[N];
			for(int i=0;i<AdjList.length;i++)
			{
				AdjList[i]=new ArrayList<Integer>();
			}
			while(E-->0)
			{
				Segline= br.readLine().split(" ");
				int u = Integer.parseInt(Segline[0]);
				int w = Integer.parseInt(Segline[1]);
				AdjList[u].add(w);
				AdjList[w].add(u);
				
			}
			if(isBib())
			{
				pw.println("BICOLORABLE.");	
			}
			else
			{
				pw.println("NOT BICOLORABLE.");
			}
		}
		pw.flush();pw.close();
	}
	static int  color [];
	private static boolean isBib() 
	{	
		boolean f =true ;
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(0);color [0]=0;
		while(!Q.isEmpty()&f)
		{	int u = Q.poll();
			for(int i=0;i<AdjList[u].size();i++)
			{
				if(color[AdjList[u].get(i)]==-1)
				{
					color[AdjList[u].get(i)]=1-color[u];
					Q.add(AdjList[u].get(i));
				}
				else if(color[AdjList[u].get(i)]==color[u])
				{
					f=false;break;
				}
			}
		}
		return f;
	}
}
