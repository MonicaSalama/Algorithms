import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RaucousRockers {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=414
	 */
	
	static int n;
	static int m;
	static int t;
	static int[] time;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int test = Integer.parseInt(br.readLine().trim());
		while (test > 0) {
			br.readLine();
			String[]in = br.readLine().split(" ");
			n = Integer.parseInt(in[0]);
			t = Integer.parseInt(in[1]);
			m = Integer.parseInt(in[2]);
			int i = 0;
			time = new int[n];
			String s = br.readLine();
			s = s.replaceAll(",", "");
			in = s.split(" ");
			while (i < n) {
				time[i] = Integer.parseInt(in[i]);
				i++;
			}
			dp = new int[n][m + 1][t + 1];
			for (int[][] ar : dp)
				for (int[] a : ar)
					Arrays.fill(a, -1);
			out.println(maxSongs(0, m, t));
			test--;
			if (test != 0)
				out.println();
		}
		out.close();

	}

	static int maxSongs(int i, int d, int min) {
		if (i == n)
			return 0;
		int max = 0;
		if (dp[i][d][min] != -1)
			return dp[i][d][min];
		if (time[i] <= min) {
			max = Math.max(1 + maxSongs(i + 1, d, min - time[i]),
					maxSongs(i + 1, d, min));
		} else if (d > 1) {
			max = Math.max(1 + maxSongs(i + 1, d - 1, t - time[i]),
					maxSongs(i + 1, d, min));
		} else {
			max = maxSongs(i + 1, d, min);
		}
		return (dp[i][d][min] = max);
	}

	static BufferedReader br;
	static StringTokenizer sc;
	static PrintWriter out;

	

}
