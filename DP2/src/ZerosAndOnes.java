import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ZerosAndOnes {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3215
	 */
	
    static int k;
    static int n;
    static long[][][]dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int test = nxtInt();
		int i = 0;
		while(i < test){
			n = nxtInt();
			k = nxtInt();
			i++;
			if(n % 2 == 0 && k != 0){
				dp = new long[n/2+1][n/2+1][k];
				for(long[][]arr:dp)
					for(long[]ar:arr)
						Arrays.fill(ar, -1);
				out.println("Case "+i+": "+count(0, 0, 0 ));
			}else{
				out.println("Case "+i+": "+0);
			}
			
		}
		out.close();
	}
	static long count(int z , int o , int sum){
		sum = sum%k;
		if(z > n/2 || o > n/2)
			return 0;
		if(z+o == n-1){
			if(z-1 == o){
				sum = (int) ((sum%k+ (Math.pow(2, n-1)%k))%k);
				if(sum == 0){
					return 1;
				}
			}
			return 0;
		}
		if(dp[z][o][sum] != -1)
			return dp[z][o][sum];
		return  dp[z][o][sum] = count(z+1, o, sum)+count(z, o+1, (int)((sum%k+(Math.pow(2,z+o)%k))%k));
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
