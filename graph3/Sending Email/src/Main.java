import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
 * 10986 - Sending email
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1927
 */

public class Main {
    static ArrayList[] edges;
    static int vertex;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader st = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(st);
		int testCases;
		String s = rd.readLine();
		testCases = Integer.parseInt(s);
		int i = 0;
		while(i < testCases){
			s = rd.readLine();
			String[]input = s.split(" ");
			vertex = Integer.parseInt(input[0]);
			int Edges = Integer.parseInt(input[1]);
			int source = Integer.parseInt(input[2]);
			int T = Integer.parseInt(input[3]);
			if(Edges == 0){
				System.out.println("Case #"+(i+1)+": unreachable");
			}else{
				edges = new ArrayList[vertex] ;
				arr();
				int j = 0;
				while(j < Edges){
					s = rd.readLine();
					input = s.split(" ");
					int temp1 = Integer.parseInt(input[0]);
					int temp2 = Integer.parseInt(input[1]);
					int w = Integer.parseInt(input[2]);
					edges[temp1].add(new Point(temp2, w));
					edges[temp2].add(new Point(temp1,w));
					j++;
				}
				int t = dik(source, T);
				if(t == (Integer.MAX_VALUE/2)){
					System.out.println("Case #"+(i+1)+": unreachable");
				}else{
					System.out.println("Case #"+(i+1)+": "+t);
				}
			}
			i++;
		}

	}
	static void arr(){
		for (int i = 0; i < edges.length; i++) {
			edges[i]= new ArrayList<Point>();
		}
	}
	static int dik(int source , int T){
		int[]dist = new int[vertex];
		fill(dist);
		PriorityQueue<point> q = new PriorityQueue<>();
		dist[source] = 0;
		q.add(new point(source, 0));
		while(!q.isEmpty()){
			point p = q.poll();
			int node = p.k;
			int w = p.dis;
			if(dist[node] == w){
				for (int i = 0; i < edges[node].size(); i++) {
					Point temp = (Point) edges[node].get(i);
					if(dist[node] + temp.y < dist[temp.x]){
						dist[temp.x] = dist[node] + temp.y;
						q.add(new point(temp.x , dist[temp.x]));
					}
				}
			}
		}
		return dist[T];
		
	}
	static void fill(int[]dist){
		for (int i = 0; i < dist.length; i++) {
			dist[i] = (Integer.MAX_VALUE/2);
		}
	}

}

class point implements Comparable<point> {
	int u, k, dis;

	point(int k, int dist) {
		this.k = k;
		this.dis = dist;
	}

	@Override
	public int compareTo(point o) {
		return dis - o.dis;
	}
}
