import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=691
 */

public class Main {
   static boolean[]row;
   static boolean[]column;
   static boolean[]dig1;
   static boolean[]dig2;
   static int[]Q = new int[8];
   static int max =8;
   static int solution = 1;
   static PrintWriter out = new PrintWriter(System.out);
   static ArrayList<String> answer = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	    InputStreamReader x = new InputStreamReader(System.in);
	    BufferedReader y = new BufferedReader(x);
	    int i = 0;
	    int n = Integer.parseInt(y.readLine());
	    String[] input;
	    String s;
	    int r;
	    int c;
	    while(i < n){
	    	if(i!= 0){
	    		out.println();
	    	}
	    	y.readLine();
	    	row = new boolean[9];
	    	column = new boolean[9];
	    	dig1 = new boolean[17];
	    	dig2 = new boolean[17];
	    	s = y.readLine();
	    	input = s.split(" ");
	    	r = Integer.parseInt(input[0]);
	    	c = Integer.parseInt(input[1]);
	    	set(r,c);
	    	out.println("SOLN       COLUMN");
	    	out.println(" #      1 2 3 4 5 6 7 8\n");
			solution = 1;
	    	queens(1);
	    	print();
	    	i++;
	    }
	    out.close();

	}
	static void set(int i , int j){
		row[i] = true;
		column[j]= true;
		dig1[i+j]= true;
		dig2[max+i-j]= true;
		Q[j-1]= i;
	}
	static void queens(int i){
		if(i == 9){
			add();
			return;
			
		}
		if (!row[i]) {
			for (int j = 1; j < max + 1; j++) {
                 if(!column[j] && !dig1[j+i] && !dig2[max+i-j]){
                	 row[i] = true;
                	 column[j] = true;
                	 dig1[i+j]= true;
                	 dig2[max+i-j] = true;
                	 Q[j-1] = i;
                	 queens(i+1);
                	 row[i] = false;
                	 column[j] = false;
                	 dig1[i+j]= false;
                	 dig2[max+i-j] = false;	 
                 }
			}
			return;
		}
		queens(i+1);
	}
 
	static void add(){
		String s = "";
		for (int i = 0; i < Q.length-1; i++) {
			s= s+Q[i]+ " ";
		}
		 s = s+Q[Q.length-1];
		 answer.add(s);
	}
	static void print(){
		Collections.sort(answer);
		Iterator<String> t = answer.iterator();
		while(t.hasNext()){
			if(solution < 10){
				out.print(" "+ solution +"      ");
			}else{
				out.print(solution+"      ");
			}
			out.println(t.next());

			solution++;
		}
		answer.clear();
	}
}

