package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;

public class UVA441Lotto  {/*
	static BufferedReader br;
	
	static ArrayList<Integer> nums;
	static int Count [] = new int [49];
	public static void main(String[] args)throws IOException {
		br =new BufferedReader(new InputStreamReader(System.in));
		String lineNotSegmented;
		PrintWriter pw = new PrintWriter(System.out);
		lineNotSegmented=br.readLine();
		
		if(!lineNotSegmented.equals(0)){
		Read(lineNotSegmented);
		Perm();}
		while((lineNotSegmented=br.readLine())!=null&& !lineNotSegmented.isEmpty()&&!lineNotSegmented.equals("0"))
		{ 	pw.println();
			Read(lineNotSegmented);
			Perm();
			
		}
	}
	private static void Perm() {
		StringBuffer SB =new StringBuffer("");
		
	}
	public static void Read (String lineNotSegmented) throws IOException
	{
	String 	line[] = lineNotSegmented.split(" ");
	nums.clear();
	for(int i=1;i<line.length;i++)
	{
	 nums.add(Integer.parseInt(line [i]));
	 
	}
	Collections.sort(nums);
	Arrays.fill(Count, 1);
	
	}*/
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String Segline[];
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		boolean f = true;
		while((line = br.readLine())!=null&&!line.equals("0"))
			
		{	if(f)
			{
				f=false;
					
			}
		else{
			pw.println();
		}
			nums.clear();
			Segline=line.split(" ");
			for (int i=1;i<Segline.length;i++)
			{
				nums.add(Integer.parseInt(Segline[i]));
			}
			long bimask =0;
			Collections.sort(nums);
			
			//Prem(nums,i,6,"",bimask,-1);
			Gen(nums);
			
		}
		pw.flush();
		pw.close();
		
	}

private static void Gen(ArrayList<Integer> nums) {
		// TODO Auto-generated method stub
	 for(int i=0;i<nums.size();i++)
	 {
		 for(int j=i+1;j<nums.size();j++)
		 {
			 for(int k=j+1;k<nums.size();k++)
			 {
				 for(int x=k+1;x<nums.size();x++)
				 {
					 for(int y=x+1;y<nums.size();y++)
					 {
						 for(int z=y+1;z<nums.size();z++)
						 {
							 pw.println(nums.get(i)+" "+nums.get(j)+" "+nums.get(k)+" "+nums.get(x)+" "+nums.get(y)+" "+nums.get(z));
						 }
					 }
				 }
			 }
		 }
	 }
	}

private static void Prem(ArrayList<Integer> segline, int index, int n, String output,long bitmask,int last) {
				if(n==0)
				{
					pw.print(output+"\n");
					return;
				}
				if(index==segline.size())
				{
					return ;
				}
				
				if((1<<index & bitmask)!=0)// i use this to check if bit number x is 1
				{
					  return;
				}
				if(segline.get(index)<last)
				{
					
					return;
				}
				
				bitmask = bitmask^(1<<index); // to toggel  bit number x
				output+=segline.get(index)+" ";
				for(int i=index+1;i<segline.size();i++)
				{
					Prem(segline,i,n-1,output,bitmask,segline.get(index));
					
				}
				
				
				
	}

private static void Prem(String[] segline, int i) {
	// TODO Auto-generated method stub
	
}
}
