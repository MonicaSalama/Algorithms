import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CollectingBeepers {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1437
	 */
	
	static int start_x;
	static int start_y;
	static int[] x;
	static int[] y;
	static int n;
	static long[][]dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double t = Math.pow(2, 64);
		System.out.println(t-Math.pow(2, 64));
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int test = nxtInt();
		while(test > 0){
			nxtInt();
			nxtInt();
			start_x = nxtInt()-1;
			start_y = nxtInt()-1;
			n = nxtInt();
			x = new int[n+1];
			y = new int[n+1];
			int i = 0;
			while(i < n){
				x[i] = nxtInt()-1;
				y[i] = nxtInt()-1;
				i++;
			}
			x[n] = start_x;
			y[n]= start_y;
			dp = new long[n+1][(1<<n)];
			for(long[]ar:dp)
				Arrays.fill(ar, -1);
			out.println("The shortest path has length "+minPath(n, 0));
			test--;
		}
		out.close();

	}

	static long minPath(int index, int mask) {
		if (mask == (1 << n) - 1) {
			return cost(start_x, x[index], start_y, y[index]);
		}
		if(dp[index][mask]!=-1)
			return dp[index][mask];
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if ((mask & (1 << i)) == 0) {
				min = Math.min(
						min,
						cost(x[index], x[i], y[index], y[i])
								+ minPath(i, (mask | (1 << i))));
			}
		}
		return dp[index][mask] = min;
	}

	static int cost(int x1, int x2, int y1, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);

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
