package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UVA10660CitizenAttentionOffices {
	static int CellsCor[][]= {{0,1,2,3,4},{5,6,7,8,9},{10,11,12,13,14},{15,16,17,18,19},{20,21,22,23,24}};
	static int CellsPop[][];
	static int cellsx []={0,1,2,3,4,0,1,2,3,4,0,1,2,3,4,0,1,2,3,4,0,1,2,3,4};
	static int cellsy []={0,0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4};
	static int Sequence [][]; static int C;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(System.out);
		int TC = Integer.parseInt(br.readLine());
		String line [];
		Sequence = getSequence(); // get 25 C 5 = 53130 different combinations 
		while(TC-->0) //each test case
		{   CellsPop= new int [5][5];
			int Areas=Integer.parseInt(br.readLine());
			while(Areas-->0) //each Area
			{
				line =br.readLine().split( " ");
				CellsPop[Integer.parseInt(line[1])][Integer.parseInt(line[0])]=Integer.parseInt(line[2]);
			}
			// read input done
			
			/*for(int i=0;i<5;i++)
			{
				for(int j=0;j<5;j++)
				{ int sum=0;
					for(int x=0;x<5;x++)
					{
						for (int y=0;y<5;y++)
						{
							sum +=CellsPop[x][y]*((Math.abs(x-i))+Math.abs(y-j));
						}
					}
					Cost.add(new TripleUVA10660(i, j, sum));
				}
			}*/int MinSum=(int)1e9; 
			int MinII=0;
			for(int ii=0;ii<C-1;ii++)
			{
				int sum = 0;//sum of the all  point's distance to their nearest offices 
						for(int x=0;x<5;x++)
						{
							for (int y=0;y<5;y++)
							{
									int D1=	CellsPop[x][y]*((Math.abs(x-cellsx[Sequence[0][ii]]))+Math.abs(y-cellsy[Sequence[0][ii]]));//Distance to office 1
									int D2= CellsPop[x][y]*((Math.abs(x-cellsx[Sequence[1][ii]]))+Math.abs(y-cellsy[Sequence[1][ii]]));//Distance to office 2
									int D3= CellsPop[x][y]*((Math.abs(x-cellsx[Sequence[2][ii]]))+Math.abs(y-cellsy[Sequence[2][ii]]));	//Distance to office3
									int D4= CellsPop[x][y]*((Math.abs(x-cellsx[Sequence[3][ii]]))+Math.abs(y-cellsy[Sequence[3][ii]]));//Distance to office 4
									int D5= CellsPop[x][y]*((Math.abs(x-cellsx[Sequence[4][ii]]))+Math.abs(y-cellsy[Sequence[4][ii]]));//Distance to office 5
									int d =Math.min(D1, Math.min(D2, Math.min(D3,Math.min(D4, D5)))); // this point distance to the nearest office
									sum+=d;
							}
						}
						
						if(sum==MinSum)// get the optimal answer with first lowest value and second lowest value ..etc
						{
							if(Sequence[0][ii]<Sequence[0][MinII])
							{
								MinII=ii;
							}
							else if(Sequence[1][ii]<Sequence[1][MinII]&&Sequence[0][ii]==Sequence[0][MinII])
							{
								MinII=ii;
							}
							else if(Sequence[2][ii]<Sequence[2][MinII]&&Sequence[1][ii]==Sequence[1][MinII]&&Sequence[0][ii]==Sequence[0][MinII])
							{
								MinII=ii;
							}
							else if(Sequence[3][ii]<Sequence[3][MinII]&&Sequence[2][ii]==Sequence[2][MinII]&&Sequence[1][ii]==Sequence[1][MinII]&&Sequence[0][ii]==Sequence[0][MinII])
							{
								MinII=ii;
							}
							else if(Sequence[4][ii]<Sequence[4][MinII]&&Sequence[3][ii]==Sequence[3][MinII]&&Sequence[2][ii]==Sequence[2][MinII]&&Sequence[1][ii]==Sequence[1][MinII]&&Sequence[0][ii]==Sequence[0][MinII])
							{
								MinII=ii;
							}
						}
						if(sum<MinSum)
						{
							MinII=ii;
							MinSum=sum;
						}
					
				
			}
		
			
		
			for(int i=0;i<4;i++)
			{
				pw.print(Sequence[i][MinII]+" ");
			}
			pw.print(Sequence[4][MinII]+"\n");
		
			
		}
	pw.flush();pw.close();}
	public static int[][] getSequence() {
		int S [][]=new int [5][60000];
		int c=0;
		for(int i=0;i<25;i++)
		{
			for(int j=i+1;j<25;j++)
			{
				for(int k=j+1;k<25;k++)
				{
					for(int q=k+1;q<25;q++)
					{
						for(int l=q+1;l<25;l++)
						{
							
								if((i!=j&&i!=k&&i!=q&&i!=l)&&(j!=k&&j!=q&&j!=l)&&(k!=q&&k!=l)&&q!=l)
								{	
									S[0][c]=i;
									S[1][c]=j;
									S[2][c]=k;
									S[3][c]=q;
									S[4][c]=l;
									//System.out.println(S[0][c]+" "+S[1][c]+" "+S[2][c]+" " +S[3][c]+" "+S[4][c]);
									c++;
									
									
								}
						}
					}
				}
			}
		}
C=c;
return S;	}
}
/*class TripleUVA10660 implements Comparable
{
	int x;
	int y;
	int cost;
	int ii;
	public TripleUVA10660(int x1,int y1,int z1)
	{
		x=x1;
		y=y1;
		cost=z1;
	}
	public TripleUVA10660(int y,int z1)
	{
		int ii =y;
		cost=z1;
	}
	@Override
	public int compareTo(Object o) {
		TripleUVA10660 oo =(TripleUVA10660)o;
		return this.cost-oo.cost;
	}
}*/
