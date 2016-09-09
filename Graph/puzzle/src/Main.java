import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 11513 - 9 Puzzle
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2508
 */

public class Main {
    static Hashtable<String, String> solutions = new Hashtable<String, String>();
    static HashSet<String> visited = new HashSet<String>();
    static Queue<String> q =  new LinkedList<String>();
    static Queue<String> moves = new LinkedList<String>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		q.add("123456789");
		moves.add("");
		solutions.put("123456789", "");
		visited.add("123456789");
		generation();
		InputStreamReader x = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(x);
		boolean flag = true;
		while(true){
			int i = 0;
			int z = 0;
			String testCase = "";
			while (i < 3){
				String s = rd.readLine();
				String[] input = s.split(" ");
				if(input[0].equals("0")){
					flag = false;
					break;
				}
				for (int j = 0; j < 3; j++) {
					testCase += input[j];
				}
				i++;
			}
			if(!flag)
				break;
			String answer = solutions.get(testCase);
			if(answer != null){
				System.out.println((answer.length()/2)+" "+answer);
			}else{
				System.out.println("Not solvable");
			}
		}
	}
    static void generation(){
    	while (!q.isEmpty()) {
    		String current = q.poll();
    		String steps = moves.poll();
			char[] arr;
			char temp;
			String next;
			String move;
			String nextMove = "";
			for (int i = 2; i < 9; i+=3) {
				arr = current.toCharArray();
				temp = arr[i];
				arr[i] = arr[i - 2];
				arr[i - 2] = arr[i - 1];
				arr[i - 1] = temp;
				next = new String(arr);
				if (!visited.contains(next)) {
					move = "H" + ((i / 3) +1);
					nextMove = move + steps;
					visited.add(next);
					solutions.put(next, nextMove );
					q.add(next);
					moves.add(nextMove);
				}
				
			}
			for (int i = 0; i < 3; i++) {
				move = "V";
				arr = current.toCharArray();
				temp = arr[i];
				arr[i] = arr[i+6];
				arr[i+6]=arr[i+3];
				arr[i+3] = temp;
				next = new String(arr);
				if (!visited.contains(next)) {
					move =  "V"+ (i+1);
					nextMove = move + steps;
					visited.add(next);
					solutions.put(next, nextMove );
					q.add(next);
					moves.add(nextMove);
				}	
			}
		}
    	
    }
}
