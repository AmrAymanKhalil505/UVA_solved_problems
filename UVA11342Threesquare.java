package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA11342Threesquare 
{
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(br.readLine());
		while(TC-->0)
		{
			int n = Integer.parseInt(br.readLine());
			int l = (int) (Math.sqrt(n)+1);
			boolean f =true;
			for(int i=0;i<l&&f;i++)
			{
				for(int j=i;j<l;j++)
				{ int s = n-(j*j+i*i);
					if(isSq(s))
					{
						f= false;
						pw.printf("%d %d %d\n",i,j,(int)Math.sqrt(s));
						break;
					}
				}
			}
			if(f)
			{
				pw.println(-1);
			}
		}
		pw.flush();
		pw.close();
	}
	private static boolean isSq(int i)
	{
		int l = (int) Math.sqrt(i);
		if(l*l==i)
		return true;
		return false;
	}
	
}
