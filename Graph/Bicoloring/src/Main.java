import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * 10004 - Bicoloring
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=945
 */

public class Main {
	static ArrayList<Integer>[] vertices;
    static int[]color;
    static int n;
    static int c1 = 5;
    static boolean[]temp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(x);
        while(true){
        	 String s = rd.readLine();
             String[]input = s.split(" ");
        	n = Integer.parseInt(input[0]);
        	if(n==0){
        		break;
        	}
        	vertices = new ArrayList[n];
        	for (int k = 0; k < n; k++) {
				vertices[k] = new ArrayList<Integer>();
			}
        	temp = new boolean[n];
        	color = new int[n];
        	s = rd.readLine();
        	input = s.split(" ");
        	int l = Integer.parseInt(input[0]);
        	int j = 0;
        	while(j<l){
        		s = rd.readLine();
            	input = s.split(" ");
            	int f = Integer.parseInt(input[0]);
            	int z = Integer.parseInt(input[1]);
            	vertices[f].add(z);
            	vertices[z].add(f);
            	j++;
        	}
        	if(!check()){
        		System.out.println("NOT BICOLORABLE.");
        	}else{
        		System.out.println("BICOLORABLE.");
        	}
        	
        }    
	}
	static boolean check(){
		for (int i = 0; i < n; i++) {
			if(color[i]==0){
				color[i] = 1;
				if(!bicoloring(i)){
					return false;
				}
			}
		}
		return true;
	}
	static boolean bicoloring(int v){
		boolean flag = true;
		ArrayList<Integer> arr = vertices[v];
		for (int i = 0; i < arr.size(); i++) {
			int adjNode = arr.get(i);
			if(color[adjNode] == color[v]){
				return false;
			}
			if (color[adjNode]== 0) {
				color[adjNode] = c1 - color[v];
				flag = flag && bicoloring(adjNode);
			}	
		}
		return flag;
	}

}
