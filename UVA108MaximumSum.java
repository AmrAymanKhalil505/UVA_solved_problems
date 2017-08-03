package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class UVA108MaximumSum
{	static int arr [][] ;
	static int DP_arr [][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new  BufferedReader( new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr=new int [N][N];
		DP_arr=new int [N][N];
		int seqN =N*N;
		String line []=null;
		for(int i=0;i<seqN;i+=line.length)
		{	line=br.readLine().split(" ");
			for(int j=i;(j-i)<line.length;j++)
			{
				int y = ((j-i)+i)/N;
				int x = ((j-i)+i)%N;
				arr[y][x]=Integer.parseInt(line[j-i]);
			}
		}
		int sum =0;
		for(int i=0;i<N;i++)
		{
			sum+=arr[0][i];
			DP_arr[0][i]=sum;
		}
		sum=0;
		for(int i=0;i<N;i++)
		{
			sum+=arr[i][0];
			DP_arr[i][0]=sum;
		}
		for(int i=1;i<N;i++)
		{
			for(int j=1;j<N;j++)
			{
				DP_arr[i][j]=arr[i][j]+DP_arr[i][j-1]+DP_arr[i-1][j]-DP_arr[i-1][j-1];
			}
		}
		int max =DP_arr[0][0];
//		for(int i=0;i<N;i++)
//		{
//			System.out.println(Arrays.toString(DP_arr[i]));
//			
//		}
//		System.out.println();
//		for(int i=0;i<N;i++)
//		{
//			System.out.println(Arrays.toString(arr[i]));
//		}
		for(int i=0;i<N;i++)
		for(int j=0;j<N;j++)
		for(int y=0;y<=i;y++)
		{
			
			for(int x=0;x<=j;x++)
			{	int t1=0;if((y-1)>-1) t1=DP_arr[y-1][j];
				
				
				int t2=0;if((x-1)>-1) t2=DP_arr[i][x-1];
				
				int t3=0;if((y-1)>-1&&(x-1)>-1)t3 =DP_arr[y-1][x-1];
//				if(i==3&&j==1&&y==0&&x==1)
//					{System.out.println(DP_arr[i][j]-t1-t2+t3);
//					System.out.println(t1);
//					System.out.println((x-1)>-1);
//					System.out.println(DP_arr[i][j]);
//					System.out.println(DP_arr[0][1]);
//					System.out.println(t2);
//					System.out.println(t3);}
				max = Math.max(max, (DP_arr[i][j]-t1-t2+t3));
			}
		}
		
		System.out.println(max);
	}
}
