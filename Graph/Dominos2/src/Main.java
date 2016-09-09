import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * 11518 - Dominos 2
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2513
 */

public class Main {
    static boolean[]visited;
    static ArrayList<Integer>[] vertices;
    static int counter;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(x);
        String s = rd.readLine();
        String[]input = s.split(" ");
        int testCases = Integer.parseInt(input[0]);
        int j = 0;
        while (j<testCases) {
			s = rd.readLine();
			input = s.split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int l = Integer.parseInt(input[2]);
			visited = new boolean[n + 1];
			vertices = new ArrayList[n+1];
			counter = 0;
			int i = 0;
			for (int k = 0; k < n+1; k++) {
				vertices[k] = new ArrayList<Integer>();
			}
			while (i < m) {
				s = rd.readLine();
				input = s.split(" ");
				int node = Integer.parseInt(input[0]);
				vertices[node].add(Integer.parseInt(input[1]));
				i++;
			}
			i = 0;
			while (i < l) {
				s = rd.readLine();
				input = s.split(" ");
				int temp = Integer.parseInt(input[0]);
				dfs(temp);
				i++;
			}
			System.out.println(counter);
			j++;
		}
        
	}
	static void dfs(int temp){
		if(visited[temp]){
			return;
		}
		counter++;
		visited[temp]= true;
		ArrayList<Integer> ar = vertices[temp];
		for (int i = 0; i < ar.size(); i++) {
			dfs(ar.get(i));
		}
	}

}
