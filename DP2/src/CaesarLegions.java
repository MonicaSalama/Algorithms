import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CaesarLegions {
	
	/*
	 * http://codeforces.com/problemset/problem/118/D
	 */
	
	static int n1, n2, k1, k2;
	static int mod = 100000000;
	static int[][][][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		n1 = nxtInt();
		n2 = nxtInt();
		k1 = nxtInt();
		k2 = nxtInt();
		dp = new int[2][Math.max(k1, k2) + 1][n1 + 1][n2 + 1];
		for (int[][][] ar : dp)
			for (int[][] arr : ar)
				for (int[] a : arr)
					Arrays.fill(a, -1);
		System.out.println(ways(n1, n2, true, 0));

	}

	static int ways(int r1, int r2, boolean f, int c) {
		if (r1 < 0 || r2 < 0)
			return 0;
		if (f && c > k1)
			return 0;
		if (!f && c > k2)
			return 0;
		if (r1 == 0 && r2 == 0)
			return 1;
		int ways = 0;
		if (f) {
			if (dp[1][c][r1][r2] != -1)
				return dp[1][c][r1][r2];
			ways = (ways(r1 - 1, r2, f, c + 1) % mod);
			ways = (ways + ((ways(r1, r2 - 1, !f, 1)) % mod)) % mod;
			return dp[1][c][r1][r2] = ways;
		}
		if (dp[0][c][r1][r2] != -1)
			return dp[0][c][r1][r2];
		ways = (ways(r1, r2 - 1, f, c + 1) % mod);
		ways = (ways + ((ways(r1 - 1, r2, !f, 1)) % mod)) % mod;
		return dp[0][c][r1][r2] = ways;
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
