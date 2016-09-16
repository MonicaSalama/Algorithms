import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Troubleof13Dots {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1760
	 */
	
	static int m;
	static int n;
	static int[] p;
	static int[] f;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			String[] in = s.split(" ");
			m = Integer.parseInt(in[0]);
			n = Integer.parseInt(in[1]);
			int i = 0;
			p = new int[n];
			f = new int[n];
			while (i < n) {
				in = br.readLine().split(" ");
				p[i] = Integer.parseInt(in[0]);
				f[i] = Integer.parseInt(in[1]);
				i++;
			}
			dp = new int[n][m + 201];
			for (int[] ar : dp)
				Arrays.fill(ar, -1);
			System.out.println(maxVal(0, 0));

		}

	}

	static int maxVal(int i, int sum) {
		if(sum > m+200)
			return Integer.MIN_VALUE;
		if (i == n) {
			if (sum > m && sum <= 2000)
				return Integer.MIN_VALUE;
			return 0;
		}
		int val = 0;
		if (dp[i][sum] != -1)
			return dp[i][sum];

		val = f[i] + maxVal(i + 1, sum + p[i]);
		int val2 = maxVal(i + 1, sum);
		return (dp[i][sum] = Math.max(val, val2));
	}

}
