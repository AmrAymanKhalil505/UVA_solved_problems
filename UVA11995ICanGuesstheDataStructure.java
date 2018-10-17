package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class UVA11995ICanGuesstheDataStructure
{
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line ;
		PriorityQueue<Integer> pq =new PriorityQueue<Integer>(Collections.reverseOrder());
		Stack<Integer> st = new Stack<Integer>();
		Queue<Integer> q= new LinkedList<Integer>();
		String L[];
		while((line =br.readLine())!=null&&!line.isEmpty())
		{	boolean PQ= true;
			boolean ST= true;
			boolean Q = true;
			pq.clear();
			st.clear();
			q.clear();
			int N = Integer.parseInt(line);
			while(N-->0)// damno
			{
				 L=br.readLine().split(" "); 
				int Oper =Integer.parseInt(L[0]);
				int Valu = Integer.parseInt(L[1]);
				if(Oper==1)
				{
					pq.add(Valu);
					st.add(Valu);
					q.add(Valu);
				}
				if(Oper==2)
				{
					int pqv=-1;
				if(!pq.isEmpty())	
				 pqv = pq.poll();
				if(pqv!=Valu)
				{
					PQ = false;
				}
				int stv=-1;
					
				if(!st.isEmpty())		
				stv =st.pop();
				if(stv!=Valu)
				{
					ST = false;
				}
				int qv=-1;
				if(!q.isEmpty())
				 qv = q.poll();
				if(qv!=Valu)
				{
					Q=false;
				}
				}
			}
			if(Q&&ST||Q&&PQ||PQ&&ST)
				 pw.println("not sure");
			else if(Q)
				pw.println("queue");
			else if(PQ)
				pw.println("priority queue");
			else if (ST)
				pw.println("stack");
			else 
				pw.println("impossible");
			
		
				
		}
		pw.flush();
		pw.close();
	}
}
