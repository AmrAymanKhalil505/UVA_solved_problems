package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.text.NumberFormat;
import java.util.ArrayList;

public class UVA725Division {
	static ArrayList<Long> Nums = new ArrayList<Long>() ;
	int [] oneToTen= new int [10];
	static PrintWriter pw = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		 BufferedReader br =new BufferedReader (new InputStreamReader(System.in));
		 String line ="";
		 boolean f = true;
		 
		  GenNums(0);
		 while((line=br.readLine())!=null&&!line.equals("0"))
		 {	if(f)
		 {
			 f=false;
			 
		 }
		 else
		 {
			 pw.println(); 
		 }
			 int N = Integer.parseInt(line);
		/* boolean f= false;
			 for(int i=0;i<Nums.size();i++)
			 { 	
				long m = Nums.get(i);
				long x=m/100000;
				long y=m%100000;
				String l1= x+"";
				String l2= y+"";
				System.out.println(l1+" "+l2);
				if(l2.length()!=5)
				{
					l2=0+l2;
				}
				if(N*y==x)
				{	f=true;
					pw.println(l1+"/"+l2);
				}
			 }
			 if(f)
			 {
				 pw.println();
			 }
			 else
			 {
				 pw.println("There are no solutions for "+N);
			 }*/
		 
		 	Find(N);
		 	
		 }pw.flush();pw.close();
		 
	}
	private static long BinarySearch(int thisNum) {
		int high=Nums.size()-1;
		int low = 0;
		int mid;
		long ans=-1; //  declaring the normal things needed for binarySearch
		while(low<=high)
		{	
			mid = low+((high-low)>>1); // get the mid each time
	
			if(Nums.get(mid)<thisNum)// if the number in the index smaller than the given number 
			{	
				
				low = mid +1;// i made this cuz it goes into infinite loop if do it without Math.max
			}
			else if(Nums.get(mid)>thisNum)
			{
				high =mid-1;// not smaller than the given number
			}
			else 
			{
				ans =Nums.get(mid);
				break;
			}
			
		}
		
		return ans;
		
	}
	private static void Find(int N )
	{	boolean f= false;
		int l =98765/N;
		for(int i=1234;i<=l;i++)
		{
			int mul = i*N;
			
			int bitmask=0;
			if(i<10000)
			{
				bitmask =1<<0;
			}
			while(mul!=0)
			{
				int z =mul%10;
				mul =mul/10;
				bitmask=bitmask|1<<z;
				
			}
			 mul = i;
			 while(mul!=0)
			 {
				 int z =mul%10;
					mul =mul/10;
					bitmask=bitmask|1<<z;
					 
			 }
			 String s = i+"";
			 String ss =N*i+"";
			 
			 if(bitmask==((1<<10)-1))
			 {while(s.length()<5)
			 {
				 s=0+s;
			 }
			 while(ss.length()<5)
			 {
				 ss=0+ss;
			 }
				 f =true;
				 pw.println((ss)+" / "+s+" = "+N );
			 }
			 
			 
		}
		if(!f)
		 {
			 pw.println("There are no solutions for "+N+".");
		 }
	}
	private static void GenNums(int index) {
		/*int Array []= new int [10];
		for(int i=0;i<10;i++)
		{	Array [0]=i;
			for(int j=0;j<10;j++)
			{ Array [1]=j;
				for(int k=0;k<10;k++)
				{Array [2]=k;
					for(int q=0;q<10;q++)
					{Array [3]=q;
						for(int z=0;z<10;z++)
						{Array [4]=z;
							for(int ii=0;ii<10;ii++)
							{Array [5]=ii;
								for(int jj=0;jj<10;jj++)
								{Array [6]=jj;
									for(int kk=0;kk<10;kk++)
									{Array [7]=kk;
										for(int qq=0;qq<10;qq++)
										{Array [8]=qq;
											for(int zz=0;zz<10;zz++)
											{Array [9]=zz;
											boolean f= true;
												for(int x=0;x<10;x++)
												{
													for(int y =x+1;y<10;y++)
													{
														if(Array[x]==Array[y])
														{
															f=false;
														}
													}
												}
												if(f)
												{ long adfadf=0;
													for(int x=0;x<10;x++)
													{
														adfadf+=Math.pow(10, 10-x)*Array[x];
													}
													Nums.add(adfadf);
												}
									}
								}
							}
						}
					}
						}
					}
				}
			}
		}*/
	
	/*	boolean bo [] = new boolean [10];
		StringBuffer s =new StringBuffer("0123456789");
		for(int i=0;i<10;i++)
		{	 
			
			for(int j=0;j<10;j++)
			{	
				char x =s.charAt(i);
				char z =s.charAt(j);
				s.replace(i, i+1, z+"");
				s.replace(j, j+1, x+"");
				Nums.add(Long.parseLong(s.toString()));
				s.replace(i, i+1, x+"");
				s.replace(j, j+1, z+"");
			}
		}*/
		
		
	}
}
