import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class LCMCardinality {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1833
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while (true) {
			int n = nxtInt();
			if (n == 0)
				break;
			out.println(n + " " + (count(n)));
		}
		out.close();

	}

	static long count(int n) {
		long c = 0;
		ArrayList<Integer> l = divi(n);
		int num1, num2, temp;
		for (int i = 0; i < l.size(); i++) {
			for (int j = i; j < l.size(); j++) {
				num1 = l.get(i);
				num2 = l.get(j);
				temp = GCD(num1, num2);
				if (((num1 / temp) * num2) == n) {
					// System.out.println(num1+" "+num2);
					c++;
				}
			}
		}
		return c;
	}

	static ArrayList<Integer> divi(int num) {
		ArrayList<Integer> l = new ArrayList<Integer>();
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				l.add(i);
				if (i * i != num)
					l.add(num / i);
			}

		}
		return l;
	}

	static int GCD(int x, int y) {
		int num1 = Math.min(x, y);
		int num2 = Math.max(x, y);
		if (num1 == 0)
			return num2;
		return GCD(num2 % num1, num1);
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
