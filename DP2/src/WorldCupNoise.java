import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class WorldCupNoise {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1391
	 */
	
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int test = nxtInt();
		int i = 1;
		while (i <= test) {
			int t = nxtInt();
			dp = new long[2][t + 1];
			for (long[] ar : dp)
				Arrays.fill(ar, -1);
			System.out.println("Scenario #" + i + ":");
			System.out.println(ways(t, false) + "\n");
			i++;
		}
	}

	static long ways(int c, boolean one) {
		if (c == 0)
			return 1;
		long w = 0;
		if (one) {
			if (dp[1][c] != -1)
				return dp[1][c];
			w = ways(c - 1, false);
			return dp[1][c] = w;
		}
		if (dp[0][c] != -1)
			return dp[0][c];
		w = ways(c - 1, one); // zero
		w += ways(c - 1, true); // one
		return dp[0][c] = w;
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
