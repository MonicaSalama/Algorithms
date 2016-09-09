package cycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * C. Cycle
 * http://codeforces.com/problemset/problem/117/C
 */
 
public class Main {
    static boolean[][]grid;
    static boolean[]visited;
    static boolean flag;
    static int node1;
    static int node2;
    static int node3;
    static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(in);
		String s = rd.readLine();
		n = Integer.parseInt(s);
		grid = new boolean[n][n];
		visited = new boolean[n];
		int i = 0;
		while(i < n){
			s = rd.readLine();
			char[]temp = s.toCharArray();
			for (int j = 0; j < n; j++) {
				if(temp[j] == '1'){
					grid[i][j] = true;
				}
			}
			i++;
		}
		flag = false;
		for (int j = 0; j < n; j++) {
			if(!visited[j]){
				visited[j] = true;
				dfs(j , j);
			}
		}
		if(flag){
			System.out.println(node1 +" "+ node2 +" "+ node3);
		}else{
			System.out.println("-1");
		}
        
	}
	static void dfs(int parent , int current){
		for (int i = 0; i < n; i++) { 
			if (grid[current][i]) {
				if (grid[i][parent]) {
					flag = true;
					node1 = parent + 1;
					node2 = current + 1;
					node3 = i + 1;
					return;
				}
				if (!visited[i]) {
					visited[i] = true;
					dfs(current, i);
					if (flag)
						return;
				}
			}
		}
	}
	

}
