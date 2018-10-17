package UVA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;



public class UVA11396ClawDecomposition {
	static ArrayList<Integer> AdjList [];//
	static int color[];

	 public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int n =Integer.parseInt(br.readLine());

	while((n!=0))
	{String  line [] = br.readLine().split(" " );
	AdjList= new ArrayList[n+1];
	color=new int [n+1];
	Arrays.fill(color, -1);
	for(int i=0;i<n+1;i++)
	{
		AdjList[i]=new ArrayList<Integer>();//
	}
	do{	
		int from = Integer.parseInt(line[0]);
		int to = Integer.parseInt(line[1]);
		AdjList[from].add(to);
		AdjList[to].add(from);
		line = br.readLine().split(" " );
	}while(line.length!=1);
	if(isber())
	{
		out.append("YES\n");
	}
	else{
		out.append("NO\n");
	}


		n = Integer.parseInt(line[0]);
	}

	out.flush();out.close();

	}

	private static boolean isber() {
			
			for(int i=1;i<color.length;i++)
			if(color[i]==-1)
				if(!fill(i))
			return false;
		
		return true;
	}

	/*private static boolean fill(int node) {
		for(int i=1;i<AdjList.length;i++)
		{
			if(color[node]==0)
			{
				
			}
		}

		return false;
	}*/

	private static boolean fill(int j) {
		if(color[j]==-1)
		{ color [j]=0;
		}
		for(int i=0;i<AdjList[j].size();i++)
		{
			if(color[AdjList[j].get(i)]==-1)
			{
				color[AdjList[j].get(i)]=1-color[j];
				if(!fill(AdjList[j].get(i)))
						{
					return false;
						}
			}
			else if(color[AdjList[j].get(i)]==color[j])
			{
			return false;
			}
		}
		return true;
		
	}
}
