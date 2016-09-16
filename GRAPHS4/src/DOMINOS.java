import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class DOMINOS {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2499
	 */
	
	static int p;
    static int t;
    static ArrayList<Integer>[]gr;
    static ArrayList<Integer>[]tr;
    static int[]vis;
	static boolean[]visited;
    static int num;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		int test = nxtInt();
		while( test > 0){
			p = nxtInt();
			t = nxtInt();
			for (int i = 0; i < p; i++) {
				gr[i] = new ArrayList<Integer>();
				tr[i] = new ArrayList<Integer>();
			}
			while( t > 0){
				int f = nxtInt()-1;
				int to = nxtInt()-1;
				gr[f].add(to);
				tr[to].add(f);
				t--;
			}
			System.out.println(check());
			test--;
		}

	}
	static int check(){
		num = 0;
		visited = new boolean[p];
		vis = new int [p];
		int c = 0;
		for (int i = 0; i < p; i++) {
			if(!visited[i])
				dfs(i);
		}
		Arrays.fill(visited, false);
		for (int i = p-1; i >= 0; i--) {
			if(!visited[vis[i]]){
				dfs2(vis[i]);
				c++;
			}
		}
		return c;
	}
	static void dfs(int from ){
		visited[from] = true;
		for (int i = 0; i < gr[from].size(); i++) {
			if(!visited[gr[from].get(i)] ){
				dfs(gr[from].get(i));
			}
		}
		vis[num] = from;
		num++;
	}
	static void dfs2(int from ){
		visited[from] = true;
		for (int i = 0; i < gr[from].size(); i++) {
			if(!visited[gr[from].get(i)] ){
				dfs2(gr[from].get(i));
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
