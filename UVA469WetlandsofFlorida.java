package UVA;
//to be contained 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class UVA469WetlandsofFlorida {
	// 
	
	static boolean Visisted [][] ;

	static ArrayList<String> Grid = new ArrayList<String>();
	/*static ArrayList<Integer> x = new ArrayList<Integer>();
	static ArrayList<Integer> y = new ArrayList<Integer>();
	*/
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static int XA []= { 1, 1, 0,-1,-1,-1, 0, 1};
	static int YA []= { 0, 1, 1, 1, 0,-1,-1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		br.readLine();
		boolean f =true;
		while(TC-->0)
		{String line ;
		 	Grid.clear();
		 	if(f)
		 	{
		 		f=false;
		 	}
		 	else
		 	{
		 		pw.println();
		 	}
		 while((line=br.readLine())!=null&&!line.isEmpty()&&(line.startsWith("W")||line.startsWith("L")))
		 {
			 Grid.add(line);
		 }
		 
		 Visisted= new boolean [Grid.size()][Grid.get(0).length()];
	//	System.out.println(Grid.size()+" "+Grid.get(0).length());
		 String Spline []= line.split(" ");
		 int x =Integer.parseInt(Spline[1])-1;
		 int y= Integer.parseInt(Spline[0])-1;
		 pw.println(Bfs(x,y));
		 for(int i=0;i<Grid.size();i++)
		 {
			 Arrays.fill(Visisted[i], false);
		 }
		 while((line=br.readLine())!=null&&!line.isEmpty())
		 {	
			 Spline= line.split(" ");
			 x=Integer.parseInt(Spline[1])-1;
			 y=Integer.parseInt(Spline[0])-1;
			 pw.println(Bfs(x,y));
			 for(int i=0;i<Grid.size();i++)
			 {
				 Arrays.fill(Visisted[i], false);
			 }
		 }
		
		}
	/*	
		for(int i=0;i<Visisted.length;i++)
		{
			for(int j=0;j<Visisted[0].length;j++)
			{
				System.out.print(Visisted[i][j]+" ");
			}
			System.out.println();
		}*/
		pw.flush();
		pw.close();
	}
	private static int Bfs(int x, int y) 
	{ 
	//System.out.println(x +" "+y );
		Visisted[y][x]=true;
		if(Grid.get(y).charAt(x)!='W')
		{
			return 0;
		}
		int sum =1;
		
		for(int i=0;i<XA.length;i++)
		{
			int xx =x+XA[i];
			int yy =y+YA[i];
			if(xx<0||xx>=Visisted[0].length)
				continue;
			if(yy<0||yy>=Visisted.length)
				continue;
			if(Visisted[yy][xx])
			{
				continue;
			}
				sum+=Bfs(xx,yy);
			
		}
		
		return sum;
		
	}
}
