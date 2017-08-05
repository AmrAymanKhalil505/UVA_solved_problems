package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA10026ShoemakersProblem {
	PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(br.readLine());
		ArrayList<Integer> outp = new ArrayList<Integer>();
		while(TC-->0)
		{
			br.readLine();
			int N= Integer.parseInt(br.readLine());
			while(N-->0)
			{
				outp.add(Integer.parseInt(br.readLine()));
			}
			co
		}
	}
	static class pair implements Comparable<pair> 
	{
		int t;
		int s;
		pair (int i,int j )
		{
			t= i;
			s=j;
		}
		@Override
		public int compareTo(pair o) {
			int d1 =this.s-this.t;
			int d2 =o.s-o.t;
			if(d1!=d2)
			return d2-d1;
			else
			return this.t - o.t;
		}
	}
}
