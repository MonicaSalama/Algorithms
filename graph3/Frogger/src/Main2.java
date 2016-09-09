//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.PriorityQueue;
//
//public class Main2 {
//	static ArrayList<edge>[] list;
//	static int n;
//	static int[] x;
//	static int[] y;
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		// TODO Auto-generated method stub
//		InputStreamReader s = new InputStreamReader(System.in);
//		BufferedReader rd = new BufferedReader(s);
//		String S;
//		int i = 0;
//		while (true) {
//			if(i != 0){
//				rd.readLine();
//				System.out.println();
//			}
//			n = Integer.parseInt(rd.readLine().trim());
//			list = new ArrayList[n];
//			if(n == 0)
//				break;
//			x = new int[n];
//			y = new int[n];
//			int j = 0;
//			while( j < n){
//				String[]in = rd.readLine().split(" ");
//				x[j] = Integer.parseInt(in[0]);
//				y[j] = Integer.parseInt(in[1]);
//				j++;
//			}
//			graph();
//            System.out.println("Scenario #"+(i+1));
//			System.out.println(String.format( "Frog Distance = %.3f", 5));
//			i++;
//		}
//
//	}
//
//	static void graph() {
//		for (int i = 0; i < n; i++) {
//			list[i] = new ArrayList<edge>();
//		}
//		for (int i = 0; i < n - 1; i++) {
//			for (int j = i + 1; j < n; j++) {
//				double c = calc(x[i], y[i], x[j], y[j]);
//				list[i].add(new edge(j, c));
//				list[j].add(new edge(i, c));
//
//			}
//		}
//	}
//	static double solv(){
//		double max = 0;
//		boolean[]visited = new boolean[n];
//		double[] w = new double[n];
//		Arrays.fill(w, Double.MAX_VALUE/2);
//		w[0] = 0;
//		PriorityQueue<edge> pq = new PriorityQueue<>();
//		pq.add(new edge(0, 0));
//		while(!pq.isEmpty() && !visited[1]){
//			edge e = pq.poll();
//			if(!visited[e.n1]){
//				visited[e.n1] = true;
//				for (int i = 0; i < list[e.n1].size(); i++) {
//					edge ed = list[e.n1].get(i);
//					if(w[ed.n1] > ed.c && !visited[ed.n1]){
//						pq.add(new edge(ed.n1,w[ed.n1]));
//					}
//				}
//			}
//		}
//	}
//
//	static double calc(double x1, double y1, double x2, double y2) {
//		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
//
//	}
//
//	
//	
//
//}
//
//class edge implements Comparable<edge>{
//	int n1;
//	double c;
//
//	edge(int n1, double c) {
//		this.n1 = n1;
//		this.c = c;
//	}
//
//	@Override
//	public int compareTo(edge o) {
//		// TODO Auto-generated method stub
//		if (c - o.c < 0) {
//			return -1;
//		}
//		return 1;
//	}
//}
//
//class disj {
//	int[] parent;
//
//	void init(int n) {
//		parent = new int[n];
//		for (int i = 0; i < n; i++) {
//			parent[i] = i;
//		}
//	}
//
//	int find(int i) {
//		if (parent[i] == i)
//			return i;
//		return (parent[i] = find(parent[i]));
//	}
//
//	boolean union(int i, int j) {
//		int pi = find(i);
//		int pj = find(j);
//		if (pi == pj)
//			return false;
//		parent[pi] = pj;
//		return true;
//	}
//}