import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlternateTask {
	
	/*
	 * 
	 */
	
	static long[] div;
	static int max = 1001;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		div();
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int i = 1;
		while(true){
			int num = nxtInt();
			if(num == 0)
				break;
			out.println("Case "+i+": "+fun(num));
			i++;
		}
		out.close();

	}
	static int fun(int num){
		for (int i = max-1; i >= 0; i--) {
			if(div[i] == num)
				return i;
		}
		return -1;
	}

	static void div() {
		div = new long[max];
		for (int i = 1; i < max; i++) {
			for (int j = i ; j < max; j += i) {
				div[j] += i;
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
