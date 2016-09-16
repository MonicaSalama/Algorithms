import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Main {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=627
	 */
	
    static int n;
    static int max = 32768;
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
		int num = 0;
		for (int i = 2; i <= (n/2);i++) {
			if(prime[i]  && prime[n-i]){
				num++;	
			}
		}
		System.out.println(num);
	}

}
