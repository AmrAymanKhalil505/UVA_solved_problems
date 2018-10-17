package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class UVA10815AndysFirstDictionary 
{	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException 
	{String line ;ArrayList<String> Arr = new ArrayList<String>();
	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	 while((line=br.readLine())!=null)
	 {	
		 String SegLine [] = line.split(" ");
		 int s  = 'a';
		 int e  = 'z';
		 
		 for(int i=0;i<SegLine.length;i++)
		 {	String l ="";
		 	String ll = SegLine[i].toLowerCase();
		 	for(int j = 0;j<SegLine[i].length();j++)
		 	{
		 		if(ll.charAt(j)<=e&&ll.charAt(j)>=s)
		 		{
		 			l+=ll.charAt(j);
		 		}
		 		else
		 		{if(!l.isEmpty())
				 	Arr.add(l);	
		 		l="";
		 		}
		 	}
		 
		 	if(!l.isEmpty())
		 	Arr.add(l);			 
		 } 
	 }
	 Collections.sort(Arr);
	 String last = Arr.get(0);
	 pw.println(last);
	 for(int i=1;i<Arr.size();i++)
	 { String now = Arr.get(i);
	 	if(!last.equals(now))
		 pw.println(Arr.get(i));
	 	last =now;
	 }
	 pw.flush();pw.close();
	}
	
}
