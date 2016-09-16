import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CountDePrimes {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2403
	 */
	
	static boolean[]prime;
	static int[]sum;
    static int max = 5000001;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		primes();
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while(true){
			int a = nxtInt();
			if(a == 0)
				break;
			int b = nxtInt();
			out.println(count(a, b));
		}
		out.close();
	
         
	}
	static int count(int a , int b){
		int c = 0;
		for (int i = a; i <= b; i++) {
			if(prime[sum[i]]){
				c++;
			}
		}
		return c;
	}
	static void primes(){
		prime = new boolean[max];
		sum = new int[max];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1]= false;
		for (int i = 2; i < max; i++) {
			if(prime[i]){
				sum[i]+=i;
				for (int j = i+i; j < max; j+=i) {
					prime[j]= false;
					sum[j] += i;
				}
			}
		}
	}
	static BufferedReader br;
	static StringTokenizer sc;
	static PrintWriter out;

	static String nxtTok() throws IOException {
		while (!sc.hasMoreTokens()) {
			String s = br.readLine();
			if (s == null)
				return null;
			sc = new StringTokenizer(s.trim());
		}
		return sc.nextToken();
	}

	static int nxtInt() throws IOException {
		return Integer.parseInt(nxtTok());
	}

	static long nxtLng() throws IOException {
		return Long.parseLong(nxtTok());
	}

	static double nxtDbl() throws IOException {
		return Double.parseDouble(nxtTok());
	}

	static int[] nxtIntArr(int n) throws IOException {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nxtInt();
		return a;
	}

	static long[] nxtLngArr(int n) throws IOException {
		long[] a = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = nxtLng();
		return a;
	}

	static char[] nxtCharArr() throws IOException {
		return nxtTok().toCharArray();
	}


}
