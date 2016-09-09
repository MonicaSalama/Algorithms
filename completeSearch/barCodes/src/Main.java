import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1662
 */

public class Main {
    static int n; 
    static int k; 
    static int m;
    static long[][][][] SUM;
    static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String s;
		String[]input;
		while((s = br.readLine())!= null){
			input = s.split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			m = Integer.parseInt(input[2]);
			SUM = new long[n+1][m+1][k+1][2];
			for(long[][][] a : SUM){
				for(long[][] b : a){
					for(long[] c : b){
						Arrays.fill(c, -1);
					}	
				}	
			}
		   out.println(solutions(1,1,1,true));
		}
         out.close();
	}
	static long solutions(int total ,int num, int units , boolean ifOne){
		long sum = 0;
		if(num > m){
			return 0;
		}
		if(units > k){
			return 0;
		}
		if(total == n){
			if(units == k){
				return 1;
			}
			return 0;
		}
		
		if(ifOne){
			if (SUM[total][num][units][1] == -1) {
				sum = solutions(total + 1, 1, units + 1, false)+ solutions(total + 1, num + 1, units, true);
				SUM[total][num][units][1] = sum;
			}
			return SUM[total][num][units][1];
		}
   	    if (SUM[total][num][units][0] == -1) {
			sum = solutions(total + 1, num + 1, units, false)+ solutions(total + 1, 1, units + 1, true);
			SUM[total][num][units][0] = sum;
		}
		return SUM[total][num][units][0];
	}

}
