package UVA;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class UVA482PermutationArrays
{	
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new  OutputStreamWriter(System.out)));
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		boolean f = true ;
		while(TC-->0)
		{
			if(f)
			{
				f=false;
			}
			else
			{
				pw.println();
			}
			br.readLine();
			String[] line = br.readLine().split(" ");
			int Arr []= new int [line.length];
			for(int i=0;i<line.length;i++)
			{
				Arr[i]=Integer.parseInt(line[i]);
				
			}
			line =br.readLine().split(" ");
			ArrayList<pair> p = new ArrayList<pair>();
			
			for(int i=0;i<Arr.length;i++)
			{
				p.add(new pair(Arr[i], line[i]));
			}
			Collections.sort(p);
			
			for(int i=0;i<Arr.length;i++)
			{
				pw.println(p.get(i).line);
			}
				
			
		}
		pw.flush();pw.close();
	}
	static class pair implements Comparable<pair>
	{
		int i ;
		String line ;
		pair(int ii,String  l)
		{
			i=ii;
			line =l;
		}
		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			
			
			return this.i-p.i;
		}
	}
}
