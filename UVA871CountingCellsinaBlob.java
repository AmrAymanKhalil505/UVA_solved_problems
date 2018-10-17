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
import java.util.PriorityQueue;

public class UVA871CountingCellsinaBlob 
{	static int XA []= { 1, 1, 0,-1,-1,-1, 0, 1};
	static int YA []= { 0, 1, 1, 1, 0,-1,-1,-1};
	static ArrayList<String>Grid = new ArrayList<String>();
	static boolean Visited [][] ;
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		br.readLine();
		String line;
		boolean f =true;
		while(TC-->0)
		{ 	if(f)
			{
			 f=false;
			}
		else
			{
			pw.println();
			}
			
			Grid.clear();
				while((line=br.readLine())!=null && !line.isEmpty())
				{
					Grid.add(line);	
				}
				Visited = new boolean [Grid.size()][Grid.get(0).length()];
				int max =0;
				for(int i=0;i<Grid.size();i++)
				{
					for(int j=0;j<Grid.get(0).length();j++)
					{if(!Visited[i][j])
						max = Math.max(BFS(i,j), max);
					}
				}
				pw.println(max);
				
		}
		pw.flush();pw.close();
	}
	private static int  BFS(int y, int x) 
	{ //System.out.println(y+" "+x+" "+Visited[y][x]);
		Visited[y][x]=true;
		if(Grid.get(y).charAt(x)=='0')
		{
			return 0;
		}
		int sum =1;
		
		for(int i=0;i<XA.length;i++)
		{
			int xx =x+XA[i];
			int yy =y+YA[i];
			if(xx<0||xx>=Visited[0].length)
				continue;
			if(yy<0||yy>=Visited.length)
				continue;
			if(Visited[yy][xx])
			{
				continue;
			}
				sum+=BFS(yy,xx);
			
		}
		
		return sum;
		
	}
	}
