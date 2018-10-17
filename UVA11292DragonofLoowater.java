package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream.GetField;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class UVA11292DragonofLoowater {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader ( new InputStreamReader(System.in));
		String line;PrintWriter pw = new PrintWriter(System.out);
		while((line=br.readLine())!=null&&!line.equals("0 0"))
		{
			String SegLine []= line.split(" ");
			int n = Integer.parseInt(SegLine[0]);
			int m = Integer.parseInt(SegLine[1]);
			ArrayList<Integer>Heads=new ArrayList<Integer>();
			ArrayList<Integer>Knights=new ArrayList<Integer>();
			int c=0;
			while(n-->0)
			{
				Heads.add(Integer.parseInt(br.readLine()));
				
			}
			while(m-->0)
			{
				Knights.add(Integer.parseInt(br.readLine()));
			}
			Collections.sort(Heads);
			Collections.sort(Knights);
			while(!Heads.isEmpty()&&!Knights.isEmpty())
			{	int x=Heads.get(0);
				int y=Knights.get(0);
				
				if(y>=x)
				{
					Heads.remove(0);
					c+=y;
				}
				Knights.remove(0);
				
			}
			if(Heads.isEmpty())
			
				pw.println(c);
			
			else
				pw.println("Loowater is doomed!");
		}pw.flush();pw.close();
	}
}
