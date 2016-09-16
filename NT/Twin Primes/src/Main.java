import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1335
	 */
	
    static int max = 20000000;
    static boolean[]prime = new boolean[max+1];
    static Point[]pairs = new Point[100000];
    static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		primes();
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		String s;
		int temp;
		while((s = br.readLine())!= null){
			 temp = Integer.parseInt(s);
			 out.println("("+pairs[temp-1].x +", "+pairs[temp-1].y+")");
		}
		out.close();

	}
	static void primes(){
		Arrays.fill(prime, true);
		prime[0]= false;
		prime[1]= false;
		for (int i = 2; i*i <= max; i++) {
			if(prime[i]){
				for (int j = i*i; j <= max; j=j+i) {
					prime[j]= false;
				}
			}
			
		}
		int index = 0;
		for (int i = 2; i < max-2 && index < 100000  ; i++) {
		   	if(prime[i] && prime[i+2]){
		   		pairs[index] =  new Point(i , i+2);
		   		index++;
		   		
		   	}
		}
	}
	

}
