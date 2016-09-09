import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 11747 - Heavy Cycle Edges
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2847
 */

public class Main {
	static int n;
	static edge[] list;
	static int m;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader s = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(s);
		while (true) {
			String[] in = rd.readLine().split(" ");
			n = Integer.parseInt(in[0]);
			if (n == 0)
				break;
			m = Integer.parseInt(in[1]);
			list = new edge[m];
			int i = 0;
			while (i < m) {
				in = rd.readLine().split(" ");
				int n1 = Integer.parseInt(in[0]);
				int n2 = Integer.parseInt(in[1]);
				int c = Integer.parseInt(in[2]);
				list[i] = new edge(n1, n2, c);
				i++;
			}
			print(kruskal());

		}

	}

	static void print(ArrayList<Integer> l) {
		if (l.size() == 0) {
			System.out.println("forest");
			return;
		}

		for (int i = 0; i < l.size() - 1; i++) {
			System.out.print(l.get(i) + " ");
		}
		System.out.println(l.get(l.size() - 1));
	}

	static ArrayList<Integer> kruskal() {
		ArrayList<Integer> c = new ArrayList<Integer>();
		disj s = new disj();
		s.init(n);
		Arrays.sort(list);
		for (int i = 0; i < m; i++) {
			edge e = list[i];
			if (!s.union(e.n1, e.n2))
				c.add(e.c);
		}
		Collections.sort(c);
		return c;
	}

}

class edge implements Comparable<edge> {
	int n1;
	int n2;
	int c;

	edge(int n1, int n2, int c) {
		this.n1 = n1;
		this.n2 = n2;
		this.c = c;
	}

	@Override
	public int compareTo(edge o) {
		// TODO Auto-generated method stub
		return c - o.c;
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
