import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chestOfDrawers {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2415
	 */
	static int n;
	static int s;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while (true) {
			n = nxtInt();
			if (n < 0)
				break;
			s = nxtInt();
			dp = new int[2][n][s + 1];
			for (int[][] ar : dp)
				for (int[] a : ar)
					Arrays.fill(a, -1);
			System.out.println(count(0, 0, true));
		}

	}

	static int count(int i, int sec, boolean locked){
		if (sec == s && i == n)
			return 1;
		if (i == n || sec > s)
			return 0;
		int index = 0;
		if (locked)
			index = 1;
		if (dp[index][i][sec] != -1)
			return dp[index][i][sec];

		dp[index][i][sec] = count(i + 1, sec + index, true)+ count(i + 1, sec, false);
		return dp[index][i][sec];
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