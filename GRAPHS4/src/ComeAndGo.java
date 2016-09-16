import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class ComeAndGo {
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2938
	 */
	static int n;
	static int m;
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
		while(true){
			n = nxtInt();
			if(n == 0)
				break;
			m = nxtInt();
			vis = new int[n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				gr[i] = new ArrayList<Integer>();
				tr[i] = new ArrayList<Integer>();
				visited[i] = false;
			}
			int i = 0;
			while(i < m){
				int f = nxtInt()-1;
				int to = nxtInt()-1;
				int p = nxtInt();
				gr[f].add(to);
				tr[to].add(f);
				if(p == 2){
					gr[to].add(f);
					tr[f].add(to);
				}
				
				i++;
			}
			if(check()){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}

	}
	static boolean check(){
		num = 0;
		for (int i = 0; i < n; i++) {
			if(!visited[i])
				dfs(i);
		}
		Arrays.fill(visited, false);
		dfs2(vis[n-1]);
		return count();
	}
	static void dfs(int from ){
		visited[from] = true;
		for (int i = 0; i < tr[from].size(); i++) {
			if(!visited[tr[from].get(i)] ){
				dfs(tr[from].get(i));
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
	static boolean count(){
		for (int i = 0; i < n; i++) {
			if(!visited[i])
				return false;
		}
		return true;
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
