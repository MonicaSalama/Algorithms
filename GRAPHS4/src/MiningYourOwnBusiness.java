import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class MiningYourOwnBusiness {
    static int[]low;
    static int[]num;
    static int dfsCounter;
    static boolean[]art;
    static boolean[]visited;
    static ArrayList<Integer>[]al;
    static ArrayList<Point>t;
    static int n;
    static  int test = 1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		sc = new StringTokenizer("");
		t = new ArrayList<Point>();
		int max = 0;
		while(true){
			n = nxtInt();
			if(n == 0)
				break;
			t.clear();
			while(n > 0){
				int f = nxtInt();
				int to = nxtInt();
				max = Math.max(max, Math.max(f, to));
				t.add(new Point(f-1, to-1));
				n--;
			}
			al = new ArrayList[max];
			low = new int[max];
			num = new int[max];
			visited = new boolean[max];
			art = new boolean[max];
			for (int i = 0; i < max; i++) {
				al[i] = new ArrayList<Integer>();
				num[i] = -1;
			}
			for (int i = 0; i < t.size(); i++) {
				Point p = t.get(i);
				al[p.x].add(p.y);
				al[p.y].add(p.x);
			}
			check();
			test++;
		}

	}
	static void check(){
		dfsCounter = 0;
		int min = 0;
		long ways = 1;
		for (int i = 0; i < num.length; i++) {
			if(num[i] == -1)
				dfs(i, -1);
		}
		for (int i = 0; i < visited.length; i++) {
			if(!visited[i] && !art[i]){
				min++;
				ways = ways * dfs2(i);
			}
		}
		System.out.println("Case "+test+": "+min+" "+ways);
		
	}
	static void dfs(int u, int p) {
        low[u] = num[u] = dfsCounter++;
        int child = 0;
        for (int i = 0; i < al[u].size(); i++) {
            int v = al[u].get(i);
            if (num[v] == -1) {
                dfs(v, u);
                if (low[v] >= num[u] && p != -1)
                    art[u] = true;
                child++;
                low[u] = Math.min(low[u], low[v]);
            } else if (v != p) {
                low[u] = Math.min(low[u], num[v]);
            }
        }
        if (p == -1 && child > 1)
            art[u] = true;
    }
	static long dfs2(int from){
		visited[from] = true;
		long c = 1;
		for (int i = 0; i < al[from].size(); i++) {
			int v = al[from].get(i);
			if(!visited[v] && !art[v]){
				c += (dfs2(v));
			}
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
