package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class UVA10901FerryLoadingIII {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());PrintWriter out =new PrintWriter(System.out);
		while(TC-->0)
		{String line []=br.readLine().split( " " );
			int n=Integer.parseInt(line[0]);
			int t=Integer.parseInt(line[1]);
			int m=Integer.parseInt(line[2]);
			Queue<Pair10901> Left =new LinkedList<Pair10901>();
			Queue<Pair10901> Right =new LinkedList<Pair10901>();
			ArrayList<Pair10901> Cars =new ArrayList<Pair10901>();
			int i=1;
			while(m-->0)
			{
				line=br.readLine().split(" ");
				if(line[1].charAt(0)=='L')
					Left.add(new Pair10901(Integer.parseInt(line[0]), i));
				else
					Right.add(new Pair10901(Integer.parseInt(line[0]), i));	
				i++;
			}
			boolean fL=true;int time=0;
			int gn=n;
			
			while(!Left.isEmpty()||!Right.isEmpty())
			
				if((!Left.isEmpty()&&Left.peek().t<=time)||((!Right.isEmpty())&&Right.peek().t<=time))
				if(fL)
				{
					while(!Left.isEmpty()&&Left.peek().t<=time&&n>0)
					{ Pair10901 temp =Left.poll();
					temp.t+=t;
						Cars.add(temp);
						n--;
					}
				}
				else {
					while(!Right.isEmpty()&&Right.peek().t<=time&&n>0)
					{ Pair10901 temp =Right.poll();
					temp.t+=t;
						Cars.add(temp);
						n--;
					}
				}
				n=gn;
				time+=t;
				fL = (!fL);
			
			Collections.sort(Cars);	
			for(int ii=0;ii<Cars.size();ii++)
			{
				out.append(""+Cars.get(ii).t+"\n");
			}
			if(TC!=0)
			out.append("\n");
		}
		
		out.flush();out.close();
	}
}

class Pair10901 implements Comparable {
	int t;
	int i;

	public Pair10901(int t, int i) {
		this.t = t;
		this.i = i;
	}

	@Override
	public int compareTo(Object arg0) {
		
		return this.i-((Pair10901)arg0).i;
	}

}