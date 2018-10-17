package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA11565SimpleEquations {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		String line [];
		PrintWriter pw = new PrintWriter(System.out);
		while(TC-->0)
		{
			line = br.readLine().split(" ");
			int A =Integer.parseInt(line[0]);
			int B= Integer.parseInt(line[1]);
			int C=Integer.parseInt(line[2]);
			boolean f =true;
			for(int x=-100;x<100&&f;x++)
			{
				for(int y =-100;y<100&&f;y++)
				{
					for(int z=-100;z<100&&f;z++)
					{
						int sum = x+y+z;
						int mul = x*y*z;
						int sumS= x*x+y*y+z*z;
						if(A==sum&&mul==B&&sumS==C&&x!=y&&x!=z&&y!=z)
						{
							pw.println(x+" "+y+" "+z);
							f=false;
							
						}
					}
				}
			}
			if(f)
			{
				pw.println("No solution.");
			}
		}pw.flush();pw.close();
	}
	
}
