package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UVA10943Howdoyouadd {
	static long DP [][];
	
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DP= new long[101][101];
		for(int i=0;i<DP[1].length;i++)
		{
			DP[1][i]=1;
		}
		for(int i=1;i<DP.length;i++)
		{
			DP[i][0]=1;
		}
		
			for(int k=2;k<DP[1].length;k++)
			for(int num=1;num<DP.length;num++)
			for(int j=0;j<=num;j++)
			{
				DP[k][num]=(DP[k-1][j]%1000000+DP[k][num]%1000000)%1000000;
			}
	
		String line ;String Sline[];
		while((line =br.readLine())!=null&&!line.equals("0 0"))
		{
			Sline = line.split(" ");
			int i =Integer.parseInt(Sline[0]);
			int j =Integer.parseInt(Sline[1]);
			pw.println(DP[j][i]);
		}
		pw.flush();
		pw.close();
	}
	
}
