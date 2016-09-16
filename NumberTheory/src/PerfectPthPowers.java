import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class PerfectPthPowers {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1563
	 */

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while(true){
			long n = nxtLng();
			if(n == 0)
				break;
			out.println(max(n));
		}
		out.close();

	}
	static int max(long n){
		ArrayList<Long> l = divi(Math.abs(n));
		int max = 1;
		int p;
		long res , num;
		boolean negative = false;
		if(n < 0 ){
			negative = true;
			n = n*-1;
		}
		for (int i = 0; i < l.size(); i++) {
			p = 1;
			num = l.get(i);
			res = num;
			while(res*num <= n){
				res *= num;
				p++;
			}
			if(res == n){
				if(negative){
					if(p % 2 != 0)
						max = Math.max(max, p);
				}else{
					max = Math.max(max, p);
				}
			}	
		}
		return max;
	}
	static ArrayList<Long> divi(Long num) {
		ArrayList<Long> l = new ArrayList<Long>();
		for ( long i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				l.add(i);
				if (i * i != num)
					l.add(num / i);
			}

		}
		return l;
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
