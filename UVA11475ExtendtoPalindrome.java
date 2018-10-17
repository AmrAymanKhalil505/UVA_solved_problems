package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UVA11475ExtendtoPalindrome
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		String line ;
		PrintWriter pw = new PrintWriter( new BufferedWriter( new OutputStreamWriter(System.out)));
		while((line = br.readLine())!=null && !line.isEmpty())
		{StringBuilder sb = new StringBuilder("");
		/*for(int i=line.length()-1;i>=0;i--)
		{
			sb.append(line.charAt(i));
		}
		for(int i=0;i<line.length();i++)
		{
			sb.append(line.charAt(i));
		}*/
			StringBuilder output  = new StringBuilder("");
		
			int arr []= PrefixFunc(sb);
			int x = arr[arr.length-1];
			if(x ==arr.length-1)
			{
				for(int i=0;i<arr.length-2;i++)
				{
					output.append(line.charAt(i));
				}
			}
			else
				{
				
				}
			
			pw.println(output.toString());
		}
		pw.flush();
		pw.close();
	}
	
	static int [] PrefixFunc(StringBuilder p){
        int m=p.length();
        int [] b=new int [m];
        for (int i=1,k=0;i<m;i++){
            while (k>0 && p.charAt(k)!=p.charAt(i))k=b[k-1];
            if (p.charAt(k)==p.charAt(i))b[i]=++k;
            else b[i]=k;
        }
        return b;
    }
}
