import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class p10003 {
	
	/*
	 * Cutting Sticks
	 * https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=944
	 */
	
	static int[] arr;
	static long[][]dp;
	static int n;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while(true){
			int l = nxtInt();
			dp = new long[55][55];
			for(long[]ar : dp){
				Arrays.fill(ar, -1);
			}
			if(l == 0)
				break;
			n = nxtInt();
			arr = new int[n+2];
			arr[0]=0;
			for (int i = 1; i <= n; i++) {
				arr[i] = nxtInt();
			}
			arr[n+1]=l;
			System.out.println("The minimum cutting is "+minCost(0, n+1)+".");
		}

	}

	static long minCost(int first, int last ) {
		if (last-first==1){
			return 0 ;
		}
		if(dp[first][last] != -1)
			return dp[first][last];
		long cost = Long.MAX_VALUE/2;
		for (int i = first+1; i < last; i++) {
			
				cost = Math.min(cost, arr[last] - arr[first] + minCost(first, i ) + minCost(i, last));
			
		}
//		if(!c)
//			return dp[first][last]= 0;
		return dp[first][last] = cost;

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
