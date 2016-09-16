import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FactorialFactors {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=825
	 */
	
	static boolean[] prime;
	static int max = 1000001;
    static long[]dp;
    static BufferedReader br;
	static StringTokenizer sc;
	static PrintWriter out;
	static ArrayList<Integer>l;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		l = new ArrayList<Integer>();
		primes();
		dp = new long[max];
		dp[0] = 0;
		dp[1] = 0;
		String s;
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		while((s=br.readLine())!= null){
			System.out.println(fact(Integer.parseInt(s.trim())));
		}
		out.close();
	}

	static void primes() {
		prime = new boolean[max];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i * i < max; i++) {
			if (prime[i]) {
				for (int j = i * i; j < max; j += i) {
					prime[j] = false;
				}
			}
		}
		for (int i = 2; i < max; i++) {
			if(prime[i])
				l.add(i);
		}
	}
    static long fact(int num){
    	if(dp[num] != 0)
    		return dp[num];
    	for (int i = 2; i <= num; i++) {
    		if(dp[i] == 0){
    			dp[i] = dp[i-1]+max(i);
    		}
		}
    	return dp[num];
    }
	static long max(int num) {
		long c = 0;
		int t = num;
		int index = 0;
		int p = l.get(index);
		while (p*p <= t) {
			while (t % p == 0) {
				t /= p;
				c++;
			}
			index++;
			p = l.get(index);
		}
		if(t != 1)
			return c+1;
		return c;
	}

	
}
