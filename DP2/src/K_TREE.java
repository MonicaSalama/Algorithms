import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class K_TREE {
	
	/*
	 * http://codeforces.com/problemset/problem/431/C
	 */
	
    static int n, k, d;
    static long[][] dp;
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        sc = new StringTokenizer("");
        n = nxtInt();
        k = nxtInt();
        d = nxtInt();
        dp = new long[2][n + 1];
        for (long[] ar : dp)
            Arrays.fill(ar, -1);
        System.out.println(fun(0, false)% mod);

    }
    static long fun(int sum, boolean flag) {
        if (sum > n)
            return 0;
        if (sum == n) {
            return flag == true ? 1L : 0L;
        }
        int index = 0;
        if (flag)
            index = 1;
        if (dp[index][sum] != -1)
            return dp[index][sum];
        long ways = 0;
        for (int i = 1; i < d; i++) {
            ways = (ways %mod + fun(sum + i, flag)% mod)%mod;
        }
        for (int i = d; i <= k; i++) {
            ways = (ways % mod + fun(sum + i, true)% mod)%mod;
        }

        return dp[index][sum] = (ways% mod);

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