import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CountTheFactors {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1640
	 */
	
   static boolean[]prime;
   static int max = 1000001;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		primes();
		while(true){
			int num = nxtInt();
			if(num==0)
				break;
			out.println(num+" : "+counter(num));
		}
		out.close();

	}
	static void primes(){
		prime = new boolean[max];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1]= false;
		for (int i = 2; i*i < max; i++) {
			if(prime[i]){
				for (int j = i*i; j < max; j+=i) {
					prime[j]= false;
				}
			}
		}
	}
	static int counter(int num){
		int c = 0;
		for (int i = 2; i <= num; i++) {
			if(prime[i] && num%i == 0)
				c++;
			
		}
		return c;
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
