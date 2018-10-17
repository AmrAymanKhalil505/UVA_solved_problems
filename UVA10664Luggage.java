package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA10664Luggage {
	static boolean dp[][];
	static ArrayList<Integer>nums=new ArrayList<Integer>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		 nums= new ArrayList<Integer>();
		PrintWriter pw = new  PrintWriter(System.out);
	
		while(TC-->0)
		{
			nums.clear();
			int sum1=0;int sum2=0;
			String line []= br.readLine().split(" ");
			for(int i=0;i<line.length;i++)
			{	int x=Integer.parseInt(line[i]);
				sum1+=x;
				nums.add(x);
			}
			
			boolean f = true;
			
			
			/*if(sum1==sum2)
			{
				f=false;
			}*/
			int maxSum1=sum1;
			sum1/=2;
			int c=0;
			f=!trying(sum1,0);
			if(!f&&maxSum1%2==0)
			{
				pw.println("YES");
			}
			else
			{
				pw.println("NO");
			}
			
		}
		pw.flush();pw.close();
	}

	private static boolean trying(int sum1,int index) {
		// TODO Auto-generated method stub
		if(index==nums.size())
		{
			return false;
		}
		if(sum1==0)
		{
			return true ;
		}
		if(sum1<0)
			return false;
		return trying (sum1-nums.get(index),index+1)|trying(sum1,index+1);
	}

	private static boolean prem(int i, int sum1,int sum2, int bitmask) {
		if((bitmask&1<<i)!=0)
		{
			return false;
		}
		sum1-=nums.get(i);
		sum2+=nums.get(i);
	 
		if(sum1==sum2)
		{
		return true;
		}
		if(sum1<sum2)
		{
			return false;
		}
		bitmask = bitmask^ 1<<i;
		Boolean f =false;
		for(int j=0;j<nums.size();j++)
		{if((bitmask&1<<j)==0)
			f=f|prem(j, sum1,sum2,bitmask);
		}
		return f;
	
	}
	private static boolean prem2(int i, int sum1, int bitmask) {
		if((bitmask&1<<i)!=0)
		{
			return false;
		}
		sum1-=nums.get(i);
		
	 
		if(sum1==0)
		{
		return true;
		}
		if(sum1<0)
		{
			return false;
		}
		bitmask = bitmask^ 1<<i;
		Boolean f =false;
		for(int j=0;j<nums.size();j++)
		{if((bitmask&1<<j)==0)
			f=f|prem2(j, sum1,bitmask);
		}
		return f;
	
	}
}
/* 
for(int j=1;j<nums.size()&&f;j++)
for(int k=0;k<nums.size()&&f;k++)
{ sum1=maxSum1;sum2=0;
for(int i=0;i<j&&f;i++)
{	
	sum1-=nums.get(k);
	sum2+=nums.get(k);
	
	if(sum1==sum2)
	{
		f=false;
	}
}
}*/
/*
for(int i=0;i<nums.size();i++)
{		sum1-=nums.get(i);
	sum2+=nums.get(i);

	if(sum1==sum2)
	{
	f=false;
	}
	for(int j=i+1;j<nums.size();j++)
	{
		sum1-=nums.get(j);
		sum2+=nums.get(j);
	
		if(sum1==sum2)
		{
		f=false;
		}
		else{
			sum1+=nums.get(j);
			sum2-=nums.get(j);
		}
	}
}*/
