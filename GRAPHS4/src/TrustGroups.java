import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;


public class TrustGroups {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2756
	 */
	
    static int p;
    static int t;
    static ArrayList<Integer>[]gr;
    static ArrayList<Integer>[]tr;
    static int[]vis;
	static boolean[]visited;
    static int num;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		
		Hashtable<String, Integer> names = new Hashtable<>();
		while (true) {
			String s = rd.readLine().trim();
			String[]in = s.split(" ");
			p = Integer.parseInt(in[0]);
			if(p == 0)
				break;
			t = Integer.parseInt(in[1]);
			names.clear();
			int i = 0;
			while(i < p){
				names.put(rd.readLine().trim(),i);
				gr[i] = new ArrayList<Integer>();
				tr[i] = new ArrayList<Integer>();
				i++;
			}
			i = 0;
			while(i < t){
				int f = names.get(rd.readLine().trim());
				int t =  names.get(rd.readLine().trim());
				gr[f].add(t);
				tr[t].add(f);
				i++;
			}
			System.out.println(check());
			
		}
		
		

	}
	static int check(){
		num = 0;
		visited = new boolean[p];
		vis = new int [p];
		int c = 0;
		for (int i = 0; i < p; i++) {
			if(!visited[i])
				dfs(i);
		}
		Arrays.fill(visited, false);
		for (int i = p-1; i >= 0; i--) {
			if(!visited[vis[i]]){
				dfs2(vis[i]);
				c++;
			}
		}
		return c;
	}
	static void dfs(int from ){
		visited[from] = true;
		for (int i = 0; i < tr[from].size(); i++) {
			if(!visited[tr[from].get(i)] ){
				dfs(tr[from].get(i));
			}
		}
		vis[num] = from;
		num++;
	}
	static void dfs2(int from ){
		visited[from] = true;
		for (int i = 0; i < gr[from].size(); i++) {
			if(!visited[gr[from].get(i)] ){
				dfs2(gr[from].get(i));
			}
		}
	}

}
