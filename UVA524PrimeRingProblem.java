package UVA;

import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;

public class UVA524PrimeRingProblem {
	static int [][]Pairs1;static StringBuffer MyOutput;static PrintWriter pw = new PrintWriter(System.out);
	static int c =250;
	public static void main(String[] args) throws IOException {
		int [][]Pairs={{},{1,2,4,6,10,12,16},{1,3,5,9,11,15},{2,4,8,10,14,16},
				{1,3,7,9,13,15},{2,6,8,12,14},{1,5,7,11,13},{4,6,10,12,16},
				{3,5,9,11,15},{2,4,8,10,14},{1,3,7,9,13},{2,6,8,12},
				{1,5,7,11},{4,6,10,16},{3,5,9,15},{2,4,8,14,16},{1,3,7,13,15}};// this Array[i][j]+i = prime  
		Pairs1=Pairs;
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		String line ="";int caseNumber =0;
		boolean f =true;
		while((line =br.readLine())!=null&&!line.isEmpty())
			
		{	
			if(f)
			{
				f=false;
				
			}
			else
			{
				pw.println();	c--;
			}
			pw.println("Case "+(++caseNumber)+":");c--;
			int n = Integer.parseInt(line);// input n;
			Search(1,n,"",0,n);
		
			if(c>=0)
			{
				pw.flush();
			}
		}
		pw.flush();pw.close();
	}
	
	private static void Search(int x, int n,String output,int bitmask,int max) {
		
		if(n==0&&x==1)
		{	pw.println(output.trim());c--;
			return ;// if the sequnce ended and i can reach 1 from this sequnce
			
		}
		if(n==0&&x!=1)
		{	
			return ; // i can't reach one from this sequence
			
		}
		if((1<<x & bitmask)!=0)
		{
			return ; // have duplicates in my sequence
		}
		if(x>max)
		{
			return ; // if the number is bigger than n
		}
		else
		{
			bitmask = bitmask|(1<<x); // mark that i will use this number
			
			
			String currentString =output+x+" ";
			for(int i=0;i<Pairs1[x].length;i++)
			{
				Search(Pairs1[x][i],n-1,currentString,bitmask,max);
				
			}
		}
		
		
	}
}
