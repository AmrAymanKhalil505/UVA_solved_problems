package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UVA10911FormingQuizTeams
{	
static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
static int n ;
static int XA[];
static int YA[];
static int DP [][]= new int [16][1<<17];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line ;
		String Sline[];int c =1;
		while((line = br.readLine())!=null&&!line.equals("0"))
		{	
			n=Integer.parseInt(line);
			int m =2*n;
			XA=new int[m];
			YA=new int[m];
			
			for(int i=0;i<m;i++)
			{	Sline= br.readLine().split(" ");
				XA[i]=Integer.parseInt(Sline[1]);
				YA[i]=Integer.parseInt(Sline[2]);
			}
			
		}
	}
}
