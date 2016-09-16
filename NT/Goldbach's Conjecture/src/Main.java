import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=484
	 */
	
    static int n;
    static int max = 1000000;
    static PrintWriter out = new PrintWriter(System.out);
    static boolean[] prime = new boolean[max+1];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		primes();
		while(true){
			n = Integer.parseInt(br.readLine());
			if(n == 0){
				break;
			}
			solution();
		}
		out.close();

	}
	static void primes(){
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1]= false;
		for (int i = 2; i*i <= max; i++) {
			if(prime[i]){
				for (int j = i*i; j <= max; j=j+i) {
					prime[j] = false;
				}
			}
		}
		
	}
	static void solution(){
		for (int i = 3; i <= n; i = i+2) {
			if(prime[i] && ((n-i)%2 != 0) && prime[n-i]){
				out.println(n+" = "+i+" + "+(n-i));
				return;
			}
		}
		out.println("Goldbach's conjecture is wrong.");
	}

}
