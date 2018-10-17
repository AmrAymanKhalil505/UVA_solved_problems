package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class UVA11572UniqueSnowflakes {
	
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		while(TC-->0)
		{pq.clear();
			int n = Integer.parseInt(br.readLine().trim());
			while(n-->0)
			{
				pq.add(Integer.parseInt(br.readLine().trim()));
				
			}
			int last =-1;
			int c =0;
			while(!pq.isEmpty())
			{ 
				if(last==pq.peek())
				{
					pq.poll();
				}
				else
				{
					last =pq.poll();
					c++;
				}
			}
			pw.println(c);
			
		}
		pw.flush();pw.close();
	}
}
