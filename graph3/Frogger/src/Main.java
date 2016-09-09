import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 534 - Frogger
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=475
 */

public class Main {
	static ArrayList<edge> list;
	static int n;
	static int[] x;
	static int[] y;
	static ArrayList<edge>[] c;
	static boolean[]visited;
	static int[]parent;
	static double[]w;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader s = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(s);
		String S;
		list = new ArrayList<edge>();
		int i = 0;
		while (true) {
			flag = false;
			if(i != 0){
				rd.readLine();
				System.out.println();
			}
			n = Integer.parseInt(rd.readLine().trim());
			if(n == 0)
				break;
			x = new int[n];
			y = new int[n];
			c = new ArrayList[n];
			int j = 0;
			while( j < n){
				String[]in = rd.readLine().split(" ");
				x[j] = Integer.parseInt(in[0]);
				y[j] = Integer.parseInt(in[1]);
				c[j] = new ArrayList<edge>();
				j++;
			}
			graph();
			kruskal();
            System.out.println("Scenario #"+(i+1));
			System.out.println(String.format( "Frog Distance = %.3f", dist()));
			i++;
		}

	}

	static void graph() {
		list.clear();
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				double c = calc(x[i], y[i], x[j], y[j]);
				list.add(new edge(i, j, c));
			}
		}
	}

	static double calc(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

	}

	static void kruskal() {
		disj s = new disj();
		s.init(n);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			edge e = list.get(i);
			if (s.union(e.n1, e.n2)){
				c[e.n1].add(new edge(e.n1, e.n2, e.c));
			    c[e.n2].add(new edge(e.n2, e.n1, e.c));
			}
		}
	}

	static double dist() {
		flag = false;
		double max = 0;
		visited = new boolean[n];
		parent = new int[n];
		w = new double[n];
		dfs(0);
		int z = 1;
		while(z != 0){
			if(w[z] > max)
				max = w[z];
			z = parent[z];
		}
		return max;
	}
	static void dfs(int i){
		if(flag)
			return;
		if(i == 1){
			flag = true;
			return;
		}
		visited[i] = true;
		for (int j = 0; j < c[i].size(); j++) {
		     edge e = c[i].get(j);
		     if(!visited[e.n2]){
		    	 parent[e.n2] = i;
		    	 w[e.n2] = e.c;
		    	 dfs(e.n2);
		    	 if(flag)
		    		 return;
		    	
		     }
		}
		
	}

}

class edge implements Comparable<edge>{
	int n1;
	int n2;
	double c;

	edge(int n1, int n2, double c) {
		this.n1 = n1;
		this.n2 = n2;
		this.c = c;
	}

	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		if (c - o.c < 0) {
			return -1;
		}
		return 1;
	}
}

class disj {
	int[] parent;

	void init(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	int find(int i) {
		if (parent[i] == i)
			return i;
		return (parent[i] = find(parent[i]));
	}

	boolean union(int i, int j) {
		int pi = find(i);
		int pj = find(j);
		if (pi == pj)
			return false;
		parent[pi] = pj;
		return true;
	}
}