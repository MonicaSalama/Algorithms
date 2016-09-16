import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class OptimalArrayMultiplicationSequence {
	static int[] r;
	static int[] c;
	static long[][] dp;
	static int[][] path;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int i = 0;
		while (true) {
			int n = nxtInt();
			if (n == 0)
				break;
			r = new int[n];
			c = new int[n];
			dp = new long[n][n];
			path = new int[n][n];
			before = new int[n];
			after = new int[n];
			for (long[] ar : dp)
				Arrays.fill(ar, -1);
			int j = 0;
			while (j < n) {
				r[j] = nxtInt();
				c[j] = nxtInt();
				j++;
			}
			i++;
			System.out.print("Case "+i+": ");
			mult(0, n - 1);
			p(0, n - 1);
			print(n);
		}

	}

	static int[] before;
	static int[] after;

	static void p(int start, int end) {
		if (start == end)
			return;
		int i = path[start][end];
		before[start]++;
		after[end]++;
		p(start, i);
		p(i + 1, end);
	}

	static void print(int n) {
		for (int i = 0; i < n; i++) {
			while (before[i] != 0) {
				System.out.print("(");
				before[i]--;
			}
			System.out.print("A" + (i + 1));
			while (after[i] != 0) {
				System.out.print(")");
				after[i]--;
			}
			if (i != n - 1) {
				System.out.print(" x ");
			}
		}
		System.out.println();
	}

	static long mult(int start, int end) {
		if (start == end)
			return 0;
		if (dp[start][end] != -1)
			return dp[start][end];
		long min = Long.MAX_VALUE;
		for (int i = start; i < end; i++) {
			long temp = r[start] * c[i] * c[end] + mult(start, i)
					+ mult(i + 1, end);
			if (temp < min) {
				min = temp;
				path[start][end] = i;
			}
		}

		return dp[start][end] = min;

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
