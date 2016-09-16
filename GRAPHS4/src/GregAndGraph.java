import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GregAndGraph {
	
	/*
	 * http://codeforces.com/problemset/problem/295/B
	 */
	
	static long[][] d;
	static int n;
    static int[]del;
    static boolean[]visited;
    static long[]sum;
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		n = nxtInt();
		d = new long[n][n];
		del = new int[n];
		visited = new boolean[n];
		sum = new long[n];
		int i = 0;
		while(i < n){
			d[i] = nxtLngArr(n);
			i++;
		}
		del = nxtIntArr(n);
		fun();
		for (int j = 0; j < n; j++) {
			System.out.print(sum[j]+" ");
		}
		

	}

	static void fun() {
		for (int k = n-1; k >= 0; k--) {
			int k1 = del[k]-1;
			visited[k1] = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					d[i][j] = Math.min(d[i][j], d[i][k1] + d[k1][j]);
				}
			}
			count(k);
		}
	}
	static void count(int k){
		long c = 0;
		for (int i = 0; i < n; i++) {
			if (visited[i]) {
				for (int j = 0; j < n; j++) {
                     if(visited[j]){
                    	 c += d[i][j];
                     }
				}
			}
		}
		sum[k] = c;
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


