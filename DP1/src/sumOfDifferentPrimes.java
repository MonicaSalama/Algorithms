import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sumOfDifferentPrimes {
	static int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
			47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
			113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181,
			191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257,
			263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337,
			347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419,
			421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491,
			499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587,
			593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659,
			661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751,
			757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839,
			853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937,
			941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019,
			1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091,
			1093, 1097, 1103, 1109, 1117 };
	static int n;
	static int k;
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		boolean flag = true;
		while (true) {
			n = nxtInt();
			k = nxtInt();
			if (n == 0 && k == 0)
				break;
			
			flag = false;
			dp = new int[k + 1][n + 1][primes.length];
			for (int[][] ar : dp)
				for (int[] a : ar)
					Arrays.fill(a, -1);
			out.println(count(0, 0, k));
		}
		out.close();
	}

	static int count(int i, int sum, int c) {
		if (c == 0) {
			if (sum == n)
				return 1;
			return 0;
		}
		if (i >= primes.length)
			return 0;
		if (dp[c][sum][i] != -1)
			return dp[c][sum][i];
		int cou = 0;
//		for (int j = i; j < primes.length; j++) {
//			if (sum + primes[j] <= n)
//				cou += count(j + 1, sum + primes[j], c - 1);
//			else
//				break;
//
//		}
		if (sum + primes[i] <= n){
			cou += count( i+ 1, sum + primes[i], c - 1);
			cou += count(i +1, sum , c);
		}
		return dp[c][sum][i] = cou;
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
