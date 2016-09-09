import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 10150 - Doublets
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1091
 */

public class Main {
    static HashSet<String> word = new HashSet<String>(); 
    static Hashtable<String, String> parent = new Hashtable<String, String>();
    static HashSet<String> visited = new HashSet<String>();
    static Queue<String> q = new LinkedList<String>();
    static String source;
    static String destination;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(x);
        String s ;
        String[]input ;
        boolean flag = false;
        while (true) {
			while (!(s=rd.readLine().trim()).equals("")) {
				word.add(s);
			}
			while ((s=rd.readLine())!= null) {
				if(flag){
	        		System.out.println();
	        	}
				input = s.split(" ");
				source = input[0];
				destination = input[1];
				q.add(source);
				sequence();
				parent.clear();
				q.clear();
				visited.clear();
				flag = true;
			}
			break;
		} 

	}
	static void sequence(){
		
		while (!q.isEmpty()) {
			String wo = q.poll();
			if (wo.equals(destination)) {
				print(wo);
				return;
			}
			char[] w = wo.toCharArray();
			for (int i = 0; i < w.length; i++) {
				char c = w[i];
				while (w[i] > 'a') {
					w[i]--;
					String temp = new String(w);
					if (word.contains(temp) && !visited.contains(temp)) {
						q.add(temp);
						parent.put(temp, wo);
						visited.add(temp);
					}
				}
				w[i] = c;
				while (w[i] < 'z') {
					w[i]++;
					String temp = new String(w);
					if (word.contains(temp) && !visited.contains(temp)) {
						q.add(temp);
						parent.put(temp, wo);
						visited.add(temp);
					}
				}
				w[i] = c;
			}
		}
		System.out.println("No solution.");
	
	}
	static void print(String w){
		if(w.equals(source)){
			System.out.println(source);
			return;
		}
		print(parent.get(w));
		System.out.println(w);
	}

}
