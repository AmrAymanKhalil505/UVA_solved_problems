package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA7508QueensChessProblem {
	 	static	int [] Board = new int [8];
	 	static	int x ;static int y ;static int c =1;
	 	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		int TC = Integer.parseInt(br.readLine());
		
		String line []; 
		
		while(TC-->0)
		{	if(br.ready())
			br.readLine();
			line=br.readLine().split(" " );
			x =Integer.parseInt(line[0]);x--;
			c=1;
			y =Integer.parseInt(line[1]);y--;
			pw.println("SOLN       COLUMN");
			pw.println(" #      1 2 3 4 5 6 7 8");
			pw.println();
			
			Queens(0);// pick start point 
			if(TC>0)
			{
				pw.println();
			}
		}
		pw.flush();
		pw.close();
	}

	private static void Queens(int index) {
		if(index==8&&Board[y]==x) // loop(!Done)
		{
			Display();
			return ;
		}
		if(index==8)
		{
			return;
		}
		for(int i=0;i<8;i++)
		{
			if(valid(index,i)) // check the validation of solution
			{
				Board[index]=i; 
				Queens(index+1);
				
			}
		}
	}

	private static boolean valid(int index, int col) {
		 for(int i=0;i<index;i++)
			 if(Board[i]==col||Math.abs(Board[i]-col)==Math.abs(index-i))
				 return false;
		 	return true;
	}

	private static void Display() {
		pw.printf("%2d      %d ",c,Board[0]+1);
		c++;
		for(int i=1;i<7;i++)
		{
		pw.print(Board[i]+1+" ");
		}
		pw.println(Board[7]+1);
		
		return ;
	}
}
