import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 558 - Wormholes
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=499
 */


public class Main {
    static int vertex;
    static int edges;
    static Edge[]arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(in);
		int i = 0;
		String s = rd.readLine();
		s =s .trim();
		int testCases = Integer.parseInt(s);
		while(i < testCases){
			s = rd.readLine();
			String[]input = s.split(" ");
			vertex = Integer.parseInt(input[0]);
			edges = Integer.parseInt(input[1]);
			arr = new Edge[edges];
			int j = 0;
			while(j < vertex){
				s = rd.readLine();
				input = s.split(" ");
				arr[j] = new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
				j++;
			}
			if(negativeCycle()){
				System.out.println("possible");
			}else{
				System.out.println("not possible");
			}
			i++;
		}

	}
	static boolean negativeCycle(){
		int[]dist = new int[vertex];
		fill(dist);
		dist[0] = 0;
		boolean flag = true;
		int j = 0;
		while(flag && (j < vertex-1)) {
			flag = false;
			for (int i = 0; i < arr.length; i++) {
				if(dist[arr[i].to] > dist[arr[i].from] + arr[i].weight){
					dist[arr[i].to] = dist[arr[i].from] + arr[i].weight ;
					flag = true;
				}   
			}
			j++;
		}
		if(!flag){
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			if(dist[arr[i].to] > dist[arr[i].from] + arr[i].weight){
				return true;
			}  
		}
		return false;	
	}
	static void fill(int[]dist){
		for (int i = 0; i < dist.length; i++) {
			dist[i] = (Integer.MAX_VALUE/2);
		}
	}

}
class Edge {
	int from;
	int to;
	int weight;
	Edge(int f , int t , int w){
		this.from = f;
		this.to = t;
		this.weight = w;
	}
}
