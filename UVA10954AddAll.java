package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;


public class UVA10954AddAll 
{
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		while((line=br.readLine())!=null&&!line.equals("0"))
		{	q.clear();
			int n =Integer.parseInt(line);
			String line1[]= br.readLine().split(" ");
			for(int i=0;i<line1.length;i++)
			{
				q.add(Long.parseLong(line1[i]));
			}
			
			long cost=0;
			while(q.size()>1)
			{
			long total = q.poll();
			total+=q.poll();
			cost+=total;
			q.add(total);
				
			}
			
			pw.println(cost);
		}
		pw.flush();
		pw.close();
		
	}
}
