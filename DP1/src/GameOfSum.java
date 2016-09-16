import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GameOfSum {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1832
	 */
	
	static int[] num;
	static int n;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while (true) {
			n = nxtInt();
			if (n == 0)
				break;
			num = new int[n];
			int i = 0;
			while (i < n) {
				num[i] = nxtInt();
				i++;
			}
			dp = new long[2][n][n];
			for (long[][] ar : dp)
				for (long[] a : ar)
					Arrays.fill(a, -1);
			out.println(maxDiff(0, n - 1, true));
			
		}
		out.close();
	}

	static long maxDiff(int l, int r, boolean a) {
		if (l == r) {
			return num[l];
		}
		if (l > r || r < l)
			return 0;
		int index = (a == true ? 1 : 0);
		if (dp[index][l][r] != -1)
			return dp[index][l][r];
		long max = Long.MIN_VALUE;
		long s = 0;
		for (int i = l; i <= r; i++) {
			s += num[i];
			if (a) {
				max = Math.max(max, s - maxDiff(i + 1, r, false));
			} else {
				max = Math.max(max, s - maxDiff(i + 1, r, true));
			}
		}
		s = 0;
		for (int i = r; i >= l; i--) {
			s += num[i];
			if (a) {
				max = Math.max(max, s - maxDiff(l, i - 1, false));
			} else {
				max = Math.max(max, s - maxDiff(l, i - 1, true));
			}
		}
		return (dp[index][l][r] = max);
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
