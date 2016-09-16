import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CriticalLinks {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=737
	 */
	
	static int n;
	static ArrayList<Integer>[] list;
	static int[] low;
	static int[] num;
	static int dfsCounter;
	static boolean[] art;
	static ArrayList<Point> bri;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		String s;
		while ((s = br.readLine()) != null) {
			n = Integer.parseInt(s.trim());
			if (n == 0) {
				System.out.println("0 critical links");

			} else if (n == 1) {
				s = br.readLine();
				System.out.println("0 critical links");
			} else {
				for (int i = 0; i < n; i++) {
					list[i] = new ArrayList<Integer>();
				}
				int i = 0;
				while (i < n) {
					s = br.readLine();
					s = s.replace("(", "");
					s = s.replace(")", "");
					String[] in = s.split(" ");
					int f = Integer.parseInt(in[0]);
					for (int j = 2; j < in.length; j++) {
						int to = Integer.parseInt(in[j]);
						list[f].add(to);
						list[to].add(f);

					}
					i++;
				}
				fun();
				System.out.println(bri.size() + " critical links");
				Collections.sort(bri, new PointCompare());
				for (int j = 0; j < bri.size(); j++) {
					System.out.println(bri.get(j).x + " - " + bri.get(j).y);
				}

			}
			System.out.println();
		}

	}

	
	static void fun() {
		bri = new ArrayList<Point>();
		low = new int[n];
		num = new int[n];
		Arrays.fill(num, -1);
		for (int i = 0; i < n; i++) {
			if (num[i] == -1) {
				dfs(i, -1);
			}
		}

	}

	static void dfs(int u, int p) {
		low[u] = num[u] = dfsCounter++;
		for (int i = 0; i < list[u].size(); i++) {
			int v = list[u].get(i);
			if (num[v] == -1) {
				dfs(v, u);
				if (low[v] > num[u])
					bri.add(new Point(u, v));
				low[u] = Math.min(low[u], low[v]);
			} else if (v != p) {
				low[u] = Math.min(low[u], num[v]);
			}
		}
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
class PointCompare implements Comparator<Point> {

	public int compare(final Point a, final Point b) {
		if (a.x < b.x) {
			return -1;
		} else if (a.x > b.x) {
			return 1;
		} else {
			return 0;
		}
	}
}

