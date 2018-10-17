package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;

public class UVA467SynchingSignals {
	static int gcd(int  a,int b)
	{a = Math.abs(a); b = Math.abs(b);
		return (b==0) ?	a:gcd(b,a%b);
	}
	static int lcm (int a,int b)
	{
		return a*b/gcd(a,b);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String line [] =br.readLine().split(" ");
		ArrayList<Integer> signals = new ArrayList<Integer>();
		for(int i=0;i<line.length;i++)
		{
			signals.add(Integer.parseInt(line[i]));
			
		}
		
		
	}
}
