package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class UVA111HistoryGrading {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter (System.out);
		int TC = Integer.parseInt(br.readLine());
		String Origin []=br.readLine().split(" ");
		int OriginInt[] =new int [Origin.length];
		for(int i=0;i<Origin.length;i++)
		{
			OriginInt[i]=Integer.parseInt(Origin[i]);
			
		}
		String line [];
		int CaseInt []=new int [TC];
		
		String x;
		while((x=br.readLine())!=null&&!x.isEmpty())
		{
			line=x.split(" ");
			for(int i=0;i<line.length;i++)
			{
				CaseInt[OriginInt[i]-1]=Integer.parseInt(line[i]);
				
			}
			int r =LIS(CaseInt);
			out.println(r);
		}
		out.flush();out.close();
	}

	private static int LIS(int[] caseInt) {
		 int  	Tail[] =new int [caseInt.length];
		Tail[0]=caseInt[0];
		int len =1;
		
		
		for (int i=1;i<caseInt.length;i++)
		{
			if(caseInt[i]<Tail[0])
			{
				Tail[0]=caseInt[i];
			}
			else if (Tail[len-1]<caseInt[i])
			{
				Tail[len++]=caseInt[i];
			}
			else
			{
				Tail[CeilIndex(Tail, -1, len-1, caseInt[i])]=caseInt[i];
			}
		}
		return len;
	}

	private static int CeilIndex(int[] tail2, int l, int r, int key) {
		while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (tail2[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
		
	}
}
 /*class PairUVA111
{	int Tail;
	int len;
	public PairUVA111 (int Tail , int len)
	{
		this.Tail=Tail;
		this.len=len;
	}
}*/