package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;



public class UVA10446TheMarriageInterview 
{	static BigInteger DP[][]=new BigInteger[61][62];
	static BigInteger def =new BigInteger("-1");
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException 
	{	String line [];int c =1;
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		for(int i=0;i<DP.length;i++)
		{
			for(int j=0;j<DP[i].length;j++)
			{
				DP[i][j]=def;				// i tried doesn't = null and it didn't work
			}
		}
		for(int i=0;i<61;i++)
			for(int j=0;j<62;j++)
			{
				trib(i,j);				// no stack overflow
			}
		while (true)// read the input
		{
			line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int back =Integer.parseInt(line[1]);
			if(n>60)
				break;
			pw.println("Case "+c+": "+ trib(n,back));// all outputs should come in O(1)
			c++;
		}
		pw.flush();
		pw.close();
	}
	static BigInteger trib (int n ,int back)
	
	{		if(n<=0)
		{	
			return new BigInteger("1"); // only used this method one
		}
		if(n==1)
		{
			return new BigInteger("1");//same
		}
		if(!DP[n][back].equals(def))
		{	
			return DP[n][back];
		}
		BigInteger sum =new BigInteger("0") ; // my sum =0
		
		for(int i=1;i<=back;i++) 
			sum=sum.add(trib(n-i,back)); //start adding 
		DP[n][back]=sum.add(new BigInteger("1"));//add one couse this method should be counted
		
		return DP[n][back]; 
	}
}
