package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class UVA10935ThrowingcardsawayI 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line ;
		Queue<Integer> Q = new LinkedList<Integer>();
		while((line= br.readLine())!=null&&!line.equals("0"))
		{
			int N =Integer.parseInt(line);
			
			Q.clear();
			if(N==1)
			{
				pw.print("Discarded cards:\n");
				pw.println("Remaining card: 1");
			}
			else{
			for(int i=1;i<=N;i++)
			{
				Q.add(i);
			}
			pw.print("Discarded cards: ");
			while(Q.size()>2)
			{
				pw.print(Q.poll()+", ");
				Q.add(Q.poll());
			}
			pw.println(Q.poll());
			pw.println("Remaining card: "+Q.poll());
			}
		}
		pw.flush();pw.close();
	}
}
