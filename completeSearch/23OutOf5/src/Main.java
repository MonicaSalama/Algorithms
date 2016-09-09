import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1285
 */
public class Main {
	static PrintWriter out = new PrintWriter(System.out);
    static boolean[]taken;
    static int[]numbers = new int[5];
    static boolean possible;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String s;
		String[]input;
		while(!((s = br.readLine()).equals("0 0 0 0 0"))){
			taken = new boolean[5];
			possible = false;
			input = s.split(" ");
			for (int i = 0; i < 5; i++) {
				numbers[i]= Integer.parseInt(input[i]);
			}
			begin();
			print();
		}
		out.close();
	}
	static void print(){
		if(possible){
			out.println("Possible");
		}else{
			out.println("Impossible");
		}
	}
	static void check(int i , int answer){
		if(possible){
			return;	
		}
		if(i == 5 && answer == 23){
			possible = true;
			return;
		}
		if(i == 5){
			return;
		}
		for(int j = 0 ; j < 5 ; j++){
			if(!taken[j]){
				taken[j] = true;
				check(i+1 , answer + numbers[j]);	
				check(i+1 , answer - numbers[j]);
				check(i+1 , answer * numbers[j]);
	         	taken[j] = false;	
			}
			
		}
		return;
	}
	static void begin(){
		for (int i = 0; i < 5; i++) {
			taken[i]= true;
			check(1 , numbers[i]);
			if(possible){
				return;
			}
			taken[i]= false;
		}
	}
	

}
