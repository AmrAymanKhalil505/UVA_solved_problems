package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA11059MaximumProduct {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);	
		
		String line1;int c =1;
		while((line1= br.readLine())!=null&&!line1.isEmpty())
		{int n = Integer.parseInt(line1);
		String line []= br.readLine().split(" ");
		int Nums[]= new int [n];
		if(br.ready())
		{
			br.readLine();
		}
		for(int i=0;i<n;i++)
		{
			Nums[i]=Integer.parseInt(line[i]);
		}
	 long max=	Solve(Nums);
	 
	 pw.println("Case #"+c+": The maximum product is "+max+".\n");
	 c++;
		}
		pw.flush();pw.close();
	
	}

	private static long  Solve(int[] nums) {
		long max=0;long pro;
		for(int i=0;i<nums.length;i++)
		{pro =nums[i];
		max =Math.max(pro, max);
			for(int j=i+1;j<nums.length;j++)
			{
				pro *=nums[j];
				max =Math.max(pro, max);
			}
		}
		return max;
	}
}
