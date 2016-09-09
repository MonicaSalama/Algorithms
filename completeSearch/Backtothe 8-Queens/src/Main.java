import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2026
 */

public class Main {
	static PrintWriter out = new PrintWriter(System.out);
	static boolean[]row;
    static boolean[]dig1;
    static boolean[]dig2;
    static int[]columnPosition = new int[9];
    static int max =8;
    static int moves = 0;
    static int min = (int) Math.pow(10, 5);

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader br = new InputStreamReader(System.in);
		BufferedReader r = new BufferedReader(br);
		String s;
		int index = 1;
		while((s= r.readLine())!= null){
			set(s);
			min = (int) Math.pow(10, 5);
			row = new boolean[9];
	    	dig1 = new boolean[17];
	    	dig2 = new boolean[17];
	    	backQueens(1);
	    	System.out.print("Case "+index+": ");
			System.out.println(min);
			index++;
		}

	}
	static void set(String input){
		String []temp = input.split(" ");
		for (int i = 0; i < temp.length; i++) {
			columnPosition[i+1] = Integer.parseInt(temp[i]);
		}
	}
	static void backQueens(int j){
		boolean flag;
		if(j == 9){
			if(moves < min){
				min = moves;
			}
			return;
		}
		for (int i = 1; i < max+1; i++) {
			flag = false;
			if(!row[i] && !dig1[i+j] && !dig2[max+i-j]){
				row[i] = true;
				dig1[i+j] = true;
				dig2[max+i-j] = true;
				if(Math.abs(columnPosition[j]-i) != 0){
					moves++;
					flag = true;
				}
				backQueens(j+1);
				row[i] = false;
				dig1[i+j] = false;
				dig2[max+i-j] = false;
				if(flag){
					moves--;
				}	
			}
		}
		return;
		
	}
	

}
