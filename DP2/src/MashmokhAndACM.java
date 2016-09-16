import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MashmokhAndACM {
	
	/*
	 * http://codeforces.com/problemset/problem/414/B
	 */
	
	static int n, k;
	static int mod = 1000000007;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		n = nxtInt();
		k = nxtInt();
		dp = new int[n + 1][k + 1];
		for (int[] ar : dp)
			Arrays.fill(ar, -1);
		System.out.println(ways(k, 1));

	}

	static int ways(int c, int current) {
		if (c == 0)
			return 1;
		int ways = 0;
		if (dp[current][c] != -1)
			return dp[current][c];
		for (int i = current; i <= n; i += current) {
			ways = ((ways % mod) + ways(c - 1, i) % mod) % mod;
		}
		return dp[current][c] = ways;
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
