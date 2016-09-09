import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/*
 * 1235 - Anti Brute Force Lock
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3676
 */

public class Main {
    static int[]key;
    static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader s = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(s);
		int test = Integer.parseInt(rd.readLine());
		while(test > 0){
			String[]in = rd.readLine().split(" ");
			n = Integer.parseInt(in[0])+1;
			key = new int[n];
			key[0] = 0;
			for (int i = 1; i < n; i++) {
				key[i] = Integer.parseInt(in[i]);
			}
			System.out.println(fun());
			test--;
		}
		

	}
	static long fun(){
		disj s = new disj();
		s.init(n);
		long c = 0;
		ArrayList<edge>list = new ArrayList<edge>();
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 1; i < n; i++) {
			int co = weight(key[0], key[i]);
			if(co < min){
				min = co;
				index = i;
			}
		}
		c += min;
		s.union(0, index);
		for (int i = 0; i < n; i++) {
			for (int j = i-1; j > 0; j--) {
				int num1 = key[i];
				int num2 = key[j];
				list.add(new edge(i, j, weight(num1, num2)));
			}
		}
		Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
			edge e = list.get(i);
			if(s.union(e.n1 , e.n2))
				c += e.c;
		}
		return c;
	}
	
	static int weight(int num1 , int num2){
		int w = 0;
		for (int i = 0; i < 4; i++) {
			w += cost(num1%10 , num2%10 );
			num1 /= 10;
			num2 /= 10;
		}
		return w;
	}
	static int cost(int from , int to){
		int w;
		if(to >= from){
			w = to - from;
			if(w > 5){
				w = from + 1 + 9 - to; 
			}
		}else{
			w = from - to;
			if(w > 5){
				w = 9 - from + 1 + to;
			}
		}
		return w;
		
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

