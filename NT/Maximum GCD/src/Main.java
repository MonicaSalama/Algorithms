import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
	
	/*
	 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2927
	 */
	
    static int[]numbers;
    static int max;
    static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(rd);
		int num = Integer.parseInt(br.readLine());
		int index = 0;
		String[]input;
		while(index < num){
			max = 0;
			input = (br.readLine()).split(" ");
			numbers = new int[input.length];
			for (int i = 0; i < input.length; i++) {
				numbers[i]= Integer.parseInt(input[i]);
			}
			solution();
			out.println(max);
			index++;
		}
		out.close();
	}
	static int GCD(int a , int b){
       if(b == 0){
    	   return a;
       }
       return GCD(b,a%b);
	}
    static void solution(){
    	int temp;
    	for (int i = 0; i < numbers.length-1; i++) {
    		for (int j = i+1; j < numbers.length; j++) {
				temp = GCD(Math.max(numbers[i], numbers[j]), Math.min(numbers[i], numbers[j]));
				if(temp > max){
					max = temp;
				}
			}
			
		}
    }

}
