import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=38
 */

public class Main {
   static int[]numbers = new int[9];
   static long max;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader x = new BufferedReader(isr);	
		String s;
		String[]input;
		long n;
		long k;
		while((s=x.readLine())!= null){
			max = 0;
			 input = s.split(" ");
			 for (int i = 0; i < input.length; i++) {
				numbers[i]= Integer.parseInt(input[i]);
			}
			 getMoves();
		}


	}
	static void getMoves(){
		long temp[] = new long[6];
		String[]s = {"BCG", "BGC", "CBG", "CGB", "GBC", "GCB" };
		long min ;
		int index = 0;
		temp[0] = numbers[3]+numbers[6]+numbers[2]+numbers[8]+numbers[1]+numbers[4];
		temp[1] = numbers[3]+numbers[6]+numbers[1]+numbers[7]+numbers[2]+numbers[5];
		temp[2] = numbers[5]+numbers[8]+numbers[0]+numbers[6]+numbers[1]+numbers[4];
		temp[3] = numbers[5]+numbers[8]+numbers[1]+numbers[7]+numbers[0]+numbers[3];
		temp[4]=  numbers[4]+numbers[7]+numbers[0]+numbers[6]+numbers[2]+numbers[5];
		temp[5]=  numbers[4]+numbers[7]+numbers[2]+numbers[8]+numbers[0]+numbers[3];
		min = temp[0];
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] < min){
				min = temp[i];
				index = i;
			}
		}
		System.out.println(s[index]+" "+temp[index]);
		
	}

}
