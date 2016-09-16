import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Buns {
	
	/*
	 * http://codeforces.com/problemset/problem/106/C
	 */
	
	static int n, m, c0, d0;
	static int[] a;
	static int[] b;
	static int[] c;
	static int[] d;
    static long[][][]dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		n = nxtInt();
		m = nxtInt();
		c0 = nxtInt();
		d0 = nxtInt();
		a = new int[m];
		b = new int[m];
		c = new int[m];
		d = new int[m];
		dp = new long[m+2][101][n+1];
		for(long[][]ar:dp)
			for(long[]arr:ar)
				Arrays.fill(arr, -1);
		int i = 0;
		while(i < m){
			a[i]= nxtInt();
			b[i]= nxtInt();
			c[i]= nxtInt();
			d[i]= nxtInt();
			i++;
		}
		System.out.println(maxVal(0, n, a[0]));

	}

	static long maxVal(int i, int dough , int stLeft) {
		if (dough == 0 || i > m) {
			return 0;
		}
		long val = 0;
		if(dp[i][stLeft][dough] != -1)
			return dp[i][stLeft][dough];
		if (i == m) {
			if (dough >= c0)
				val = d0 + maxVal(i, dough - c0 , 10);
			else
				val = maxVal(i + 1, dough , 10);
			return dp[i][stLeft][dough] = val;

		}
		int aNew;
		if(i == m-1)
			aNew = 10;
		else
			aNew = a[i+1];
		if (dough - c[i] >= 0 && stLeft-b[i] >= 0) {
			val = d[i] + maxVal(i, dough - c[i],stLeft-b[i]);
			val = Math.max(val, d[i] + maxVal(i + 1, dough - c[i],aNew));
		}
		val = Math.max(val, maxVal(i + 1, dough,aNew));
		return dp[i][stLeft][dough] = val;
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
