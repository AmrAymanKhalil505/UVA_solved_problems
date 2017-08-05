package UVA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
public class UVA10036Divisibility
{
    static int n,k;
    static int [] inp;
    static int [][] dp;
     
    static int mod(int x,int y)
    {
      return  Math.abs(x)%y;
    }
     
    static int solve(int i, int value){
        
    	if(i == inp.length){
            if(mod(value,k) == 0)
                return 0;
            return 1;
        }
        if(dp[i][mod(value,k)] != -1)
        { 
            return dp[i][mod(value,k)];
           
        }
        else{
            return dp[i][mod(value,k)] = Math.min(solve(i+1, value + inp[i]), solve(i + 1, value - inp[i]));
        }
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        String [] sp;
        for (int i = 0; i < t; i++) {
            sp = br.readLine().split("\\s+");
            n = Integer.parseInt(sp[0]);
            k = Integer.parseInt(sp[1]);
            dp = new int [n][105];
            sp = br.readLine().split("\\s+");
            inp = new int [sp.length];
            for (int j = 0; j < sp.length; j++){
                inp[j] = Integer.parseInt(sp[j]);
                for (int k = 0; k < 105; k++) {
                    dp[j][k] = -1;
                }
            }
          
            if(solve(0, 0) == 0)
                out.append("Divisible\n");
            else
                out.append("Not divisible\n");
         
        }
        System.out.print(out);
    }
     
}