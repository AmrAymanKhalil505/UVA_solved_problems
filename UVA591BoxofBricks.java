package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class UVA591BoxofBricks 
{static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException
	{String line;int c =1;
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		while(!(line=br.readLine()).equals("0"))
		{
			int N = Integer.parseInt(line);
			String[] Segline = br.readLine().split(" ");
			int Arr []= new int [N];int sum =0;
			for(int i=0;i<N;i++)
			{
				Arr[i]=Integer.parseInt(Segline[i]);
				sum+=Arr[i];
			}
			int H = sum/N; sum =0;
			for(int i=0;i<N;i++)
			{
				sum+= Math.abs(Arr[i]-H);
			}
			sum/=2;
			pw.println("Set #"+c);
			c++;
			pw.println("The minimum number of moves is "+sum+".");
			pw.println();
		}
		pw.flush();
		pw.close();
	}
}
