package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;



public class UVA10651PebbleSolitaire {
	static int DP[][]= new int [12][1<<13];
	static final int INF = (int)1e9;static int c =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		
		while(TC-->0)
		{
			int Bitmask = GenBitmask(br.readLine());
		//	System.out.println(Integer.toBinaryString(Bitmask));
			for(int i=0;i<DP.length;i++)
			{
				Arrays.fill(DP[i], -1);
			}
			pw.println(finish(0,Bitmask));
			
			
		}
		pw.flush();
		pw.close();
	}

/*	private static void print(int index, int bitmask) {
		// TODO Auto-generated method stub
		if(bitmask==0)
		{
			return ;
		}
		if(index==-1)
		{
			return  ;
			
		}
		if(index==12)
		{
			return ;
		}
		
		int moveright = INF;
		int moveleft =INF;
		int leave = INF;
		//use this point to move right
		int bitmaskRight=INF ;
		int bitmaskLeft =INF;
		if((bitmask & (1<<(index)))!=0)
		{
			
			if((bitmask & (1<<(index+1)))!=0)
			{ 
				if((bitmask & (1<<(index+2)))==0)
				{
				 bitmaskRight= bitmask;
			 bitmaskRight = bitmaskRight^1<<(index);
			 bitmaskRight =bitmaskRight ^ (1<<(index+1));
			 bitmaskRight =bitmaskRight ^ (1<<(index+2));
				moveright = finish(index+2, bitmaskRight);
				
				}
				
			
		}
		}
		// use this point to move left
			if((bitmask & (1<<(index)))!=0)
			{
				
					if((bitmask & (1<<(index-1)))!=0)
					{ 
					
				
				{if((bitmask & (1<<(index-2)))==0)
				{
					 bitmaskLeft  = bitmask;
				 bitmaskLeft = bitmaskLeft^1<<(index);
				 bitmaskLeft =bitmaskLeft ^ (1<<(index-1));
				 bitmaskLeft =bitmaskLeft ^ (1<<(index-2));
					moveleft = finish(index-2, bitmaskLeft);
					
				}
				}
					
			}
			}
		// don't use the point 
		  leave =finish(index+1, bitmask);
		  
		  int op =DP[index][bitmask];
		  if(op==moveright)
		  {c++;
			  print(index+2, bitmaskRight);
		  }else
		  if(op==moveleft)
		  {c++;
			  print(index-2, bitmaskLeft);
		  }
		  else
			print (index+1,bitmask);  
		  	}
*/
	private static int finish(int index, int bitmask) {
		if(bitmask==0)
		{
			return 0;
		}
		if(index==-1)
		{//System.out.println( Integer.toBinaryString(bitmask)+" "+Integer.toBinaryString(bitmask).length());
			return  Integer.bitCount(bitmask);
			
		}
		if(index==12)
		{//System.out.println( Integer.toBinaryString(bitmask)+" "+Integer.toBinaryString(bitmask).length() );
			return Integer.bitCount(bitmask);
		}
		if(DP[index][bitmask]!=-1)
		{
			return DP[index][bitmask];
		}
		int moveright = INF;
		int moveleft =INF;
		int leave = INF;
		
		//use this point to move right
		
		if((bitmask & (1<<(index)))!=0)
		{
			
			if((bitmask & (1<<(index+1)))!=0&&index+1!=12)
			{ 
				if((bitmask & (1<<(index+2)))==0&&index+2!=12)
				{
				int bitmaskRight  = bitmask;
			 bitmaskRight = bitmaskRight^1<<(index);
			 bitmaskRight =bitmaskRight ^ (1<<(index+1));
			 bitmaskRight =bitmaskRight ^ (1<<(index+2));
				moveright = finish(0, bitmaskRight);
				
				}
				
			
		}
		}
		// use this point to move left
			if((bitmask & (1<<(index)))!=0)
			{
				
					if((bitmask & (1<<(index-1)))!=0&&index-1!=-1)
					{ 
					
				
				{if((bitmask & (1<<(index-2)))==0&&index-2!=-1)
				{
					int bitmaskLeft  = bitmask;
				 bitmaskLeft = bitmaskLeft^1<<(index);
				 bitmaskLeft =bitmaskLeft ^ (1<<(index-1));
				 bitmaskLeft =bitmaskLeft ^ (1<<(index-2));
					moveleft = finish(0, bitmaskLeft);
					
				}
				}
					
			}
			}
		// don't use the point 
		  leave =finish(index+1, bitmask);
		  
		  DP[index][bitmask]= Math.min(leave, Math.min(moveleft, moveright));
		  
		  return DP[index][bitmask];
	}

	private static int GenBitmask(String Line) {
		int b = 0 ;// bitmask	
		for(int i=0;i<Line.length();i++)
			{
				if(Line.charAt(i)=='o')
				{
					
					b = b^(1<<i);
					//System.out.println(Line.charAt(i)+Integer.toBinaryString(b));
				}
			}
		return b;
	}
}
