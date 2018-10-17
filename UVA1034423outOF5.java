package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class UVA1034423outOF5 {
	
 public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
	String line ;String segLine [];
   int nums [][]=new int[5][3126];
   
		PrintWriter pw = new PrintWriter(System.out);
	while((line=br.readLine())!=null&&!line.trim().equals("0 0 0 0 0"))
	{	boolean f = false;
		segLine=line.split(" ");
		for(int i=0;i<segLine.length;i++)
		{
			nums[i][0]=Integer.parseInt(segLine[i]);
		}
		nums=getSequence(nums);
		int Arth []=new int [4];
		for(int xx=0;xx<120;xx++)
		{
			
		
		for(int i=0;i<3;i++)//0=+ 1=- 2=* 
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					for(int q=0;q<3;q++)
					{int n=nums[0][xx];
						Arth[0]=i;
						Arth[1]=j;
						Arth[2]=k;
						Arth[3]=q;
						for(int x=0;x<4;x++)
						{
							if(Arth[x]==0)
							{
								n+=nums[x+1][xx];
							}
							else if(Arth[x]==1)
							{
								n-=nums[x+1][xx];
							}
							else if(Arth[x]==2)
							{
								n*=nums[x+1][xx];
							}
						}
		
						if(n==23)
						{
							f=true;
						}
							
					}
				}
			}
		}
		
	}
		if(f)
		{
			pw.println("Possible");
		}
		else
		{
			pw.println("Impossible");
		}
		
	}
pw.flush();pw.close();}

 public static int[][] getSequence(int array[][]) {
     
     int c=0;
     for(int i=0;i<5;i++)
     {
         for(int j=0;j<5;j++)
         {
             for(int k=0;k<5;k++)
             {
                 for(int q=0;q<5;q++)
                 {
                     for(int l=0;l<5;l++)
                     {
                         
                             if((i!=j&&i!=k&&i!=q&&i!=l)&&(j!=k&&j!=q&&j!=l)&&(k!=q&&k!=l)&&q!=l)
                             {   
                            	 array[0][c]=array[i][0];
                            	 array[1][c]=array[j][0];
                            	 array[2][c]=array[k][0];
                            	 array[3][c]=array[q][0];
                            	 array[4][c]=array[l][0];
                                // System.out.println(array[0][c]+" "+array[1][c]+" "+array[2][c]+" " +array[3][c]+" "+array[4][c]);
                                 c++;
                                 
                                 
                             }
                     }
                 }
             }
         }
     }
   
 return array;  }
 
}

