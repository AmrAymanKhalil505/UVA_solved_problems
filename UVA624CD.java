package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class UVA624CD {
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static final  int NINF =(int )-1e9 ;static int tracks [];static int N;
	static int NL ;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String line ;
		String Segline[];
		
		while((line =br.readLine())!=null&&!line.isEmpty())
		{
			Segline = line.split(" ");
			N = Integer.parseInt(Segline[0]);
			tracks = new int [Segline.length-2];
			for(int i=2;i<Segline.length;i++)
			{
				tracks[i-2]=Integer.parseInt(Segline[i]);
			}
			int l = 1<<tracks.length;
			NL= tracks.length;
			int max =0;
			int records=0;
			int thissum;
			for(int i=0;i<l;i++)
			{
				if(max<(thissum=Record(i)))
				{
					max =thissum;
					records=i;
				}
			}
			for(int i=0;i<NL;i++)
			{
				if((records&1<<i)!=0)
				{
					pw.print(tracks[i]+" ");
				}
			}
			pw.println("sum:"+max);
		}
		pw.flush();pw.close();
		
	}
	private static int Record(int num) {
		int sum =0;
		for(int i=0;i<NL;i++)
		{
			if((num&1<<i)!=0)
			{
				sum+=tracks[i];
			}
		}
		if(sum<=N)
		{
			return sum;
		}
		return NINF;
	}
}
