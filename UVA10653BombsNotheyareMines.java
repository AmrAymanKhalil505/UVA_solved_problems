package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class UVA10653BombsNotheyareMines 
{static PrintWriter pw = new PrintWriter( new BufferedWriter( new OutputStreamWriter(System.out)));
 static int  [] [] grid ;
 static final int NoMines =0;
 static final int Mine =1;
 static final int Visited =2;
 static int xa []= {1,0,-1,0};
 static int ya []= {0,-1,0,1};
 static int R ;
 static int C ;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader( new InputStreamReader( System.in));
		String line ;
		while(!((line= br.readLine()).equals("0 0")))
		{	String Sline []=line.split(" ");
			 R =Integer.parseInt(Sline[0]);
			 C =Integer.parseInt(Sline[1]);
			grid= new int [R][C];
			int MinesN = Integer.parseInt(br.readLine());
			for(int i=0;i<MinesN;i++)
			{Sline = br.readLine().split(" ");
			int x = Integer.parseInt(Sline[0]);
				for(int j=2;j<Sline.length;j++)
//				{ System.out.println("loop");
				{
					int y =Integer.parseInt(Sline[j]);
					grid[x][y]= Mine;
				}
			}
			Sline = br.readLine().split(" ");
			int xs = Integer.parseInt(Sline[0]);
			int ys = Integer.parseInt(Sline[1]);
			Sline = br.readLine().split(" ");
			int xe = Integer.parseInt(Sline[0]);
			int ye = Integer.parseInt(Sline[1]);
			int output = bfs (xs,ys,xe,ye);
			pw.println(output);
		}
		pw.flush();pw.close();
	}

	private static int bfs(int xs, int ys, int xe, int ye)
	{	
		int minCost=1<<28;
		Queue<Integer> xQueue = new LinkedList<Integer>();
		Queue<Integer> yQueue = new LinkedList<Integer>();
		Queue<Integer> costQueue = new LinkedList<Integer>();
		xQueue.add(xs);
		yQueue.add(ys);
		costQueue.add(0);
		grid [xs][ys]=Visited;
		while(!xQueue.isEmpty())
		{	
			int x =xQueue.poll();
			int y =yQueue.poll();
			int cost= costQueue.poll();
//			System.out.println("loop");
			for(int i=0;i<4;i++)
			{
				int xx = x+xa[i];
				int yy = y+ya[i];
				if(xx<0||xx>=R)
				 continue;
				if(yy<0||yy>=C)
				 continue;
				
				if(xx==xe&&yy==ye)
				{
				 return cost +1;	
				}
				
				if(grid[xx][yy]==NoMines)
				{
					grid[xx][yy]=Visited;
					xQueue.add(xx);
					yQueue.add(yy);
					costQueue.add(cost+1);
				}
			}
			
		}
		
		return minCost;
	}
}
