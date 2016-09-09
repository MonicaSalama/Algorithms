import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 11396 - Claw Decomposition
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2391
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
        	vertices = new ArrayList[n+1];
        	for (int k = 1; k < n+1; k++) {
				vertices[k] = new ArrayList<Integer>();
			}
        	temp = new boolean[n+1];
        	color = new int[n+1];
        	while(true){
        		s = rd.readLine();
            	input = s.split(" ");
            	int f = Integer.parseInt(input[0]);
            	if(f == 0)
            		break;
            	int z = Integer.parseInt(input[1]);
            	vertices[f].add(z);
            	vertices[z].add(f);
        	}
        	if(!check()){
        		System.out.println("NO");
        	}else{
        		System.out.println("YES");
        	}
        	
        }    
	}
	static boolean check(){
		for (int i = 1; i < n+1; i++) {
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
		for (int i = 1; i < arr.size(); i++) {
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
