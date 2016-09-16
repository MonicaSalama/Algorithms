import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class PseudoprimeNumbers {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2262
	 */
	
    static long p;
    static long a;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while(true){
			p = nxtLng();
			if(p == 0)
				break;
			a = nxtLng();
			if (!primes(p)) {
				if ((pow(p) % p) == (a%p))
					out.println("yes");
				else
					out.println("no");
			}else{
				out.println("no");
			}
		}
		out.close();
	
	}
	static boolean primes(long p){
		if(p == 2)
			return true;
		if(p < 2 || p % 2 == 0 )
			return false;
		for (long i = 3; i*i < p; i+=2) {
			if(p%i==0)
				return false;
		}
		return true;
	}
	static long  pow(long power){
		if(power == 1)
			return a%p;
		long num = ((pow(power/2))%p);
		if(power %2 == 0){
			return ((num%p)*(num%p))%p;
		}
		return (((((num%p)*(num%p))%p)*(a%p))%p);		
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
