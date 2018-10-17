package UVA;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA10158War {
	static int Fri [];
	static ArrayList<Integer> Ene [];

	public static void main(String[] args) throws NumberFormatException, IOException {
		

		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		Fri = new int[TC+1] ;
		Ene = new ArrayList [TC+1];
		
		for(int i= 0 ;i<Fri.length;i++)
		{
			Fri[i]=i;
			
		}
		String line [];
		while(TC-->0)
		{
			line =br.readLine().split(" " );
			switch (line[0].charAt(0))
			{
			case '1' : setFri(Integer.parseInt(line[1]),Integer.parseInt(line[2]));break;
			case '2' : setEne(Integer.parseInt(line[1]),Integer.parseInt(line[2]));break;
			case '3': areFri(Integer.parseInt(line[1]),Integer.parseInt(line[2]));break;
			case '4' : areEne(Integer.parseInt(line[1]),Integer.parseInt(line[2]));break;
			}
			
		}
	}

	private static boolean areEne(int s1, int s2) {
		// TODO Auto-generated method stub
		if(s1==s2)
			return false;
		for(int i=0;i<Ene[s1].size();i++)
		{
			if(Ene[s1].get(i)==s2)
			{
				return true;
			}
		}
	
		return false;
	}

	private static boolean areFri(int s1, int s2) {
		// TODO Auto-generated method stub
		if(s1==s2)
			return true;
		
			if(Fri[s1]==Fri[s2])
			{
				return true;
			}
		
		return false;
	}

	private static boolean setEne(int s1, int s2) {
		// TODO Auto-generated method stub
		if(areFri(s1,s2))
		{
			return  false;
		}
		else {
			Ene[s1].add(s2);
			Ene[s2].add(s1);
		}
	}

	private static boolean setFri(int s1, int s2) {
		// TODO Auto-generated method stub
		if(areEne(s1,s2))
		{
			return  false;
		}
		else {
				for(int i=0;i<Fri.length;i++)
				{
					if(Fri[i]==Fri[s1]||Fri[i]==Fri[s2])
					{
						Fri[i]=Fri[s1];
						AddEni(i,s1,s2);
					}
				}
			
		}
		return true;
	}

	private static void AddEni(int i, int s1, int s2) {
		// TODO Auto-generated method stub
		
	}
}
