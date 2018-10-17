package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;


public class UVA11961DNA {
	static char Seq[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Seq=GenAllSEQ();
		PrintWriter pw = new PrintWriter("D://programing//Packs//ACM//src//HackerCup//Output.txt");
		for(int i=0;i<1048576;i++)
		{
			for(int j=0;j<10;j++)
			{
				pw.print(Seq[i][j]);
			}
			pw.println();
		}
		pw.flush();
		pw.close();
		int TC = Integer.parseInt(br.readLine());
		String line [];
		while(TC-->0)
		{
			line=br.readLine().split(  " ");
			int N = Integer.parseInt(line[0]);
			int K=Integer.parseInt(line[1]);
			String Maline =br.readLine();
			String NewSeq ="";
			replace (Maline,K);
		}
	}

	private static char [][]GenAllSEQ() {
		int c =0;
		char ss[] = {'A','C','G','T'};
		char[][] See = new char[1048577][10];
		int j =0;
	for(int d=0;d<10;d++)
	{ int rep =d;
		for(int i=0;i<1048576;i++)
		{
			
				See [i][d]=ss[j];
				rep--;
				if(rep==0)
				{rep =d;
				j++;
				if(j>3)
				{
					j=0;
				}
				}
		}
	}
	return See;
	}

	private static void replace(String maline, int k) {
		// TODO Auto-generated method stub
		String output ="";
		for(int i=0;maline.length();i++)
		{
			
			
		}
	}
}
