package UVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class UVA11057ExactSum 
{	static final int INF = 1<<28;  
	static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	public static void main(String[] args) throws IOException 
	{
		boolean Books []= new boolean [10000005] ; // like a visited Array
		 BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		 String line ;
		 while((line=br.readLine())!=null&&!line.isEmpty())
		 {
			 int N = Integer.parseInt(line); // number of books no need to keep it 
			 Arrays.fill(Books, false); // fill the visited  array with False
			 String Segline []= br.readLine().split(" ");//Split the Line
			 int n = Integer.parseInt(br.readLine());// know the budget 
			 int min=INF;// make  the the minimum difference between two numbers = infinite 
			 int cur = 0;//the book price i should buy 
			 for(int i=0;i<Segline.length;i++)
			 { int x =Integer.parseInt(Segline[i]);// read a number 
			 if(x<=n&&x>=0)// check if the number is bigger than the budget 
				 if(Books[n-x])// if it the other book which is the pair to my book is visited
				 {
					 if(min>Math.abs(n-x-x)) // if the difference between the the two books is smaller than the min
					 {
						 min =Math.abs(n-x-x);//set the new min
						 cur =x; // set the book
					 }
					
				 }
				 else
				 {
					 Books[x]=true; // else make this book visited
				 }
			 }
			 if(n-cur<cur)
				 pw.printf("Peter should buy books whose prices are %d and %d.\n\n",n-cur,cur);//print
			 else 
				 pw.printf("Peter should buy books whose prices are %d and %d.\n\n",cur,n-cur);//print
			 if(br.ready())
			 {
				 br.readLine();
			 }
		 }
		 pw.flush();
		 pw.close();
	}
}