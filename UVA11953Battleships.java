package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA11953Battleships 
{	static ArrayList<String > Grid = new ArrayList<String>();
	static int  visited [][];
	static int id =0;
	static int N;
	static int xA []= {1,0,-1,0};
	static int yA []= {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(new BufferedWriter( new OutputStreamWriter( System.out)));
		int c =1;
		while(TC-->0)
		{Grid.clear();id =0;
		 N = Integer.parseInt(br.readLine());
		visited = new int  [N][N];
			for(int i=0;i<N;i++)
			{
				Grid.add(br.readLine());
			}
			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++)
				{
					if(visited[i][j]==0&&Grid.get(i).charAt(j)== 'x')
					{
						Mark(i,j,true);
					}
				}
			pw.printf("Case %d: %d\n",c,id);
			id =0;++c;
			
		}
		pw.flush();
		pw.close();
	}
	private static void Mark(int x, int y,boolean start) 
	{
		if(start)
		{
			id++;
		}
		visited[x][y]=id;
		for(int i=0;i<4;i++)
		{int xx =x+xA[i];
		 int yy =y+yA[i];
		 if(xx<0||xx>=N)
			 continue;
		 if(yy<0||yy>=N)
			 continue;
		 if(visited[xx][yy]==0&&(Grid.get(xx).charAt(yy)=='x'||Grid.get(xx).charAt(yy)=='@'))
		 {
			 Mark(xx,yy,false);
		 }
		}
	}
}
