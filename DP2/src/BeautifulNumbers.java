import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BeautifulNumbers {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2467
	 */
	
	static int n;
	static int m;
    static long[][][]dp;
    static long mod = 1000000007;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int test = nxtInt();
		while(test > 0){
			n = nxtInt();
			m = nxtInt();
			if (m != 0) {
				dp = new long[n][m][1 << n];
				for (long[][] arr : dp)
					for (long[] ar : arr)
						Arrays.fill(ar, -1);
				long c = 0;
				for (int i = 1; i < n; i++) {
					c = (c% mod + (count(1, i, (1 << i))%mod))%mod;
				}
				out.println(c);
			}else{
				out.println(0);
			}
			test--;
		}
		out.close();

	}

	static long count(int i, int previous, int mask) {
		if (previous < 0 || previous > n - 1)
			return 0;
		if (i == m) {
			if ((mask == ((1 << n) - 1)))
				return 1;
			return 0;
		}
		if(dp[previous][i][mask]!= -1)
			return dp[previous][i][mask];
		if ((mask == ((1 << n) - 1))) {
			return dp[previous][i][mask] = (1 + count(i + 1, previous - 1, mask)%mod
					+ count(i + 1, previous + 1, mask)%mod)%mod;
		}
		long count = 0;
		if (previous != 0)
			count = count(i + 1, previous - 1, mask | (1 << (previous - 1)))%mod;
		count = (count %mod + (count(i + 1, previous + 1, mask | (1 << (previous + 1))))%mod)%mod;
		return dp[previous][i][mask] = count;
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
