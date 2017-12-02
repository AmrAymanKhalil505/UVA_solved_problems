package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA331MappingtheSwaps {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pw = new PrintWriter(System.out);
	static int nums []; 
	static final int INF = (int )1e9;
	static  int NMinSwaps=1;
	static int MinSwaps=INF+1;
	static int Swaps []= {1,2,3,4};
	public static void main(String[] args) throws IOException {
		String line ;int c =1;
		String Segline [];
		while((line =br.readLine())!=null&&!line.equals("0"))
		{
			Segline =line.split(" ");
			int n =Integer.parseInt(Segline[0]);
			if(n==1)
			{
				pw.printf("There are %d swap maps for input data set %d.\n",0,c);
			}
			else
			{ nums = new int [n];int myNum=0;
				for ( int i=1;i<n+1;i++)
					{
					nums[i-1]=Integer.parseInt(Segline[i]);
					
					}
				if(isSorted())
				{
					pw.printf("There are %d swap maps for input data set %d.\n",0,c );
				}
				else{
				NMinSwaps=1;
				 MinSwaps=INF+1;
				bubbleSort(0);
				pw.printf("There are %d swap maps for input data set %d.\n",NMinSwaps,c );
				}
			}
			c++;
		}
		pw.flush();
		pw.close();
	}
	private static void bubbleSort(int swaps) {
		/*for(int z =0;z<nums.length ;z++)
			{
				System.out.print(nums[z]+" " );
				
			}*/
		//System.out.println( swaps );
		//int[] numsOr=new int [nums.length];
		if(swaps>11)
			return ;
		if(swaps>MinSwaps)
			return ;
		if(isSorted())
			
		{	
			if(swaps<MinSwaps)
			{
			 MinSwaps= swaps;
			 NMinSwaps=1;
			}
		else
			if(swaps==MinSwaps)
				NMinSwaps++;
		
		return;
			
		}
		
		
		for(int i=0;i<nums.length-1;i++)
		{	
			
				 int x=nums[i];
				 int y=nums[i+1];
				 nums[i]=y;
				 nums[i+1]=x;
				 bubbleSort(swaps+1);
				 nums[i]=x;
				 nums[i+1]=y;
				
		}
		
	}
	private static void bubbleSort( int swaps, int last ) {
		//System.out.println("i am in infinit loop");
		int[] numsOr=new int [nums.length];
		for(int i=0;i<numsOr.length;i++)
		{
			numsOr[i]=nums[i];
		}
		if(swaps>10)
			return ;
		if(isSorted())
			
		{	
			if(swaps<MinSwaps)
			{
			 MinSwaps=swaps ;
			 NMinSwaps=1;
			}
		else
			if(swaps==MinSwaps)
				NMinSwaps++;
		
		return;
			
		}
		
		if(last!=-1)
		{
		 int x=nums[last];
		 int y=nums[last+1];
		 nums[last]=y;
		 nums[last+1]=x;
		}
		//for(int z =0;z<nums.length ;z++)
		//{
			//System.out.print(nums[z]+" " );
			
		//}
	//	System.out.println( swaps +" "+last+" ");
		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		for(int i=0;i<nums.length-1;i++)
		{	if(i!=last)
			{
			bubbleSort( swaps+1,  i );
			for(int j=0;j<numsOr.length;j++)
			{
				nums[j]=numsOr[j];
			}
			}
		}
		
	
	
		
	}
	private static boolean isSorted() {
		
		for(int i=0;i<nums.length-1;i++)
			if(nums[i]>nums[i+1])
				return false;
		return true;
	}
}
 class ArrayOFNums{
	int nums[];
	public  ArrayOFNums(int nums [])
	{
		this.nums = new int [nums.length];
		for(int i=0;i<nums.length;i++)
		{
			this.nums[i]=nums[i];
		}
	}
}