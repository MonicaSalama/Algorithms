import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LetMeCountTheWays {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=293
	 */
	
	static int[] chan = { 50, 25, 10, 5, 1 };
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
        String s ;
        dp = new long[5][30001];
		for (long[] ar : dp)
			Arrays.fill(ar, -1);
		while ((s= br.readLine())!= null) {
			int c = Integer.parseInt(s);
			long l = ways(0, c);
			if (l == 1)
				System.out.println("There is only 1 way to produce " + c
						+ " cents change.");
			else
				System.out.println("There are " + l + " ways to produce " + c
						+ " cents change.");

		}
		out.close();

	}

	static long ways(int i, int c) {
		if (c < 0)
			return 0;
		if (c == 0)
			return 1;
		if(i == 5)
			return 0;
		if (dp[i][c] != -1)
			return dp[i][c];
		long ways = 0;
		ways = ways(i ,c - chan[i])+ways(i+1,c);

		return dp[i][c] = ways;
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
