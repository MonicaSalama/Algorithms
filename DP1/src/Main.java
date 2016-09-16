import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int x;
    static int[][]wind;
    static long[][]dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		sc = new StringTokenizer(br.readLine());
		int test = nxtInt();
		while (test > 0) {
			br.readLine();
			x = nxtInt();
			wind = new int[10][x/100];
			dp = new long[10][x/100];
			for (int i = 0; i < 10; i++) {
				Arrays.fill(dp[i], -1);
			}
			int j = 9;
			while(j >= 0){
				wind[j] = nxtIntArr(x/100);
				j--;
			}
			System.out.println(min(0, 0));
			System.out.println();
			test--;
		}

	}
	static long min(int position , int alt){
		long cost = Long.MAX_VALUE/2;
		if(position == x/100){
			if(alt == 0)
				return 0;
			return cost;
		}
		if(dp[alt][position] != -1)
			return dp[alt][position];
		if(alt > 0 ){
			cost = Math.min(cost,20-wind[alt][position]+min(position+1, alt-1));
		}
		if(alt < 9){
			cost = Math.min(cost, 60 - wind[alt][position]+min(position+1, alt+1));
		}
			cost = Math.min(cost, 30 - wind[alt][position]+min(position+1, alt));
		
		return dp[alt][position] = cost;
		
	}

	static BufferedReader br;
	static StringTokenizer sc;

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
