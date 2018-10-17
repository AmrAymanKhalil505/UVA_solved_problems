package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class UVA10440FerryLoadingII {
	static int n=0;static int t=0;static int m=0;static ArrayList<Integer> Cars;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());// test cases
		 Cars =new ArrayList<Integer>();
		PrintWriter pw = new PrintWriter(System.out);
		while(TC-->0)
		{	Cars.clear();
			String line []=br.readLine().split(" ");
				n = Integer.parseInt(line[0]);
				t = Integer.parseInt(line[1]);
				m = Integer.parseInt(line[2]);
				int mm=m;
				while(mm-->0)
				{
					Cars.add(Integer.parseInt(br.readLine()));
				}
				pairUVA10440FerryLoadingII t1 =trip(0,0,0,0);
			pw.println((t1.t-10)+" "+t1.step);//zero not taken Cars
						//I am at index zero
						// start time zero
				
		}
		pw.flush();pw.close();
	}
	private static pairUVA10440FerryLoadingII trip(int NotTaken, int Index, int CurTime,int Steps) {
			if(Index==m)
			{	
				
				return new pairUVA10440FerryLoadingII(CurTime, Steps); // no cars remaining
			}
			else if (NotTaken==n)
			{
				return trip(0,Index,CurTime+2*t,Steps+1);//waiting cars are what the farry can take
			}
			/*else if(NotTaken>0)
			{   	if(Index+1!=m){
				pairUVA10440FerryLoadingII t1 =trip(NotTaken+1,Index+1,Cars.get(Index+1),Steps);
					pairUVA10440FerryLoadingII t2= trip(0,Index+1,CurTime+2*t,Steps+1);
					if(t1.t>t2.t)
						return t2;
					if(t1.t<t2.t)
						return t1;
					if(t1.step<=t2.step)
						return t1;
					return t2;}
			else	{
				return  trip(0,Index+1,2*t,Steps+1);
			}
					//the Waiting cars are bigger than 0
			}			// either go with what is waiting or wait for another car*/
			else if(Cars.get(Index)>CurTime)
				return trip(NotTaken,Index,Cars.get(Index),Steps);
								 // no cars waiting wait for the next car
				 else 
				 {	if(Index+1!=m){
					 pairUVA10440FerryLoadingII t1 =trip(NotTaken+1,Index+1,Cars.get(Index+1),Steps);
					pairUVA10440FerryLoadingII t2= trip(0,Index+1,CurTime+2*t,Steps+1);
					if(t1.t>t2.t)
						return t2;
					if(t1.t<t2.t)
						return t1;
					if(t1.step<=t2.step)
						return t1;
					return t2;
				 }
					else	{
						return   trip(0,Index+1,CurTime+2*t,Steps+1);
					}
				 }// else there is cars waiting either take them or leave them
			
			 
			//TLE;
			
	
}
}
class pairUVA10440FerryLoadingII implements Comparable
{
	int t;
	int step;
		public pairUVA10440FerryLoadingII(int time,int Steps)
		{
			t = time;
			step = Steps;
		}
		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			pairUVA10440FerryLoadingII oo = (pairUVA10440FerryLoadingII)o;
			return this.t-oo.t;
		}
		
}