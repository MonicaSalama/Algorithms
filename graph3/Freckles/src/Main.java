import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 10034 - Freckles
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=975
 */

public class Main {
	static ArrayList<edge> list;
	static int n;
	static double[] x;
	static double[] y;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader s = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(s);
		String S;
		list = new ArrayList<edge>();
		int test = Integer.parseInt(rd.readLine().trim());
		int i = 0;
		while (i < test) {
			if (i != 0)
				System.out.println();
			rd.readLine();
			n = Integer.parseInt(rd.readLine().trim());
			x = new double[n];
			y = new double[n];
			int j = 0;
			while( j < n){
				String[]in = rd.readLine().split(" ");
				x[j] = Double.parseDouble(in[0]);
				y[j] = Double.parseDouble(in[1]);
				j++;
			}
			graph();
			System.out.println(String.format( "%.2f", kruskal() ));
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

	static double kruskal() {
		disj s = new disj();
		s.init(n);
		Collections.sort(list);
		double c = 0;
		for (int i = 0; i < list.size(); i++) {
			edge e = list.get(i);
			if (s.union(e.n1, e.n2))
				c += e.c;
		}
		return c;
	}

}

class edge implements Comparable<edge> {
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
