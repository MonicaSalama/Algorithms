import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Network {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=251
	 */
	
	static int n;
	static ArrayList<Integer>[] list;
    static boolean []visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		while (true) {
			n = Integer.parseInt(br.readLine().trim());
			if (n == 0)
				break;
			for (int i = 0; i < n; i++) {
				list[i] = new ArrayList<Integer>();
			}
			while (true) {
				String[] s = br.readLine().split(" ");
				int f = Integer.parseInt(s[0]);
				if(f == 0)
					break;
				for (int i = 1; i < s.length; i++) {
					int to  = Integer.parseInt(s[i])-1; 
					list[f-1].add(to);
					list[to].add(f-1);
				}
			}
			System.out.println(fun());
		}

	}
	static void dfs(int from , int off){
		visited[from] = true;
		for (int i = 0; i < list[from].size(); i++) {
			if(!visited[list[from].get(i)] && list[from].get(i) != off  ){
				dfs(list[from].get(i), off);
			}
		}
	}
	static int count(int off ){
		for (int i = 0; i < n; i++) {
			if(!visited[i] && i != off)
				return 1;
		}
		return 0;
	}
	static int  fun(){
		visited = new boolean[n];
		int c = 0;
		Arrays.fill(visited, false);
		dfs(1, 0);
		c += count(0);
		for (int i = 1; i < n; i++) {
			Arrays.fill(visited, false);
			dfs(0, i);
			c += count(i);
		}
		return c;
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
