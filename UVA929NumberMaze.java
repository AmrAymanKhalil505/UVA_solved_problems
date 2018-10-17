package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.util.PriorityQueue;

public class UVA929NumberMaze
{ static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
  static int  grid [][];
  static boolean visited[][] ;
  static final boolean vis =true;
  static final boolean unVis=false;
  static int dist [][];
  static int xa []= {1,0,-1,0};
  static int ya []= {0,-1,0,1};
  static int R ;
  static int C ;
  static final int oo = 1<<28; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br= new BufferedReader( new InputStreamReader(System.in));
		 int TC =Integer.parseInt(br.readLine());
		 while(TC-->0)
		 {
			 R =Integer.parseInt(br.readLine());
			 C =Integer.parseInt(br.readLine());
			grid = new int [C][R];
			dist = new int [C][R];
			visited = new boolean [C][R];
			for(int i=0;i<R;i++)
			{ String Sline []= br.readLine().split(" ");
				for(int j =0;j<C;j++)
				{
					grid [j][i]= Integer.parseInt(Sline[j]);
					dist[j][i] =oo;
				}
				
			}Dij();
			int output=	dist[C-1][R-1];
			/*for(int i=0;i<C;i++)
			{
				System.out.println(Arrays.toString(dist[i]));
			}*/
			pw.println(output);
		 }
		 pw.flush();
		 pw.close();
	}
	private static void Dij() {
		PriorityQueue<Edge> PQ = new PriorityQueue<Edge>();
	
		PQ.add(new Edge(0, 0, grid[0][0]) );
		
		dist[0][0]=grid[0][0];
		while(!PQ.isEmpty())
		{
			Edge v = PQ.poll();
			if (v.w > dist[v.x][v.y])
				continue;
			for(int i=0;i<4;i++)
			{	int xx =v.x+xa[i];
				int yy =v.y+ya[i];
				if(xx<0||xx>=C)
					 continue;
				if(yy<0||yy>=R)
					 continue;
				
				if(dist[xx][yy]>dist[v.x][v.y]+grid[xx][yy])
				{
					dist[xx][yy]=dist[v.x][v.y]+grid[xx][yy];
					PQ.add(new Edge(xx,yy, dist[xx][yy]));
					
				}
			}
		}
		
	}
	static class Edge implements Comparable<Edge>
	{
		int x ;
		int y ;
		int w ; 
		public Edge (int X,int Y, int W)
		{
			x=X;
			y=Y;
			w=W;
		}
		@Override
		public int compareTo(Edge o) {
			return this.w-o.w;
		}
	}
}
