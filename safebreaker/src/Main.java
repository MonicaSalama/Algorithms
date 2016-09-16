package safebreaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
 static int[]digits;
 static int[]correctPosition;
 static int[]correctDigits;
 static int answer = 0;
 static boolean flag;
 static int G;
 static boolean intermediate;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader rd = new InputStreamReader(System.in);
		BufferedReader x = new BufferedReader(rd);
		String s = x.readLine();
		String[]input = s.split(" ");
		int N = Integer.parseInt(input[0]);
		int i = 0;
		int j;
		while(i<N){
		    s = x.readLine();
			input = s.split(" ");
			G = Integer.parseInt(input[0]); 
			digits = new int[G*4];
			correctDigits =  new int[G];
			correctPosition = new int[G];
			j = 0;
			flag = false;
			intermediate = false;
			while(j<G){
				s = x.readLine();
				input = s.split(" ");
				int index = 0;
				for (int k = j*4; index < 4; k++) {
					digits[k] =Integer.parseInt(""+input[0].charAt(index));
					index++;
				}
				correctPosition[j]= Integer.parseInt(""+input[1].charAt(0));
				correctDigits[j]= Integer.parseInt(""+input[1].charAt(2));
				j++;
			}
			int[]nums = new int[4];
			getCode(nums, 0);
			if(intermediate){
				System.out.println("indeterminate");
			}else if(flag){
				System.out.println(answer);
			}else{
				System.out.println("impossible");
			}
			i++;
		}

	}
	static void getCode(int[]digit,int i){
		if(intermediate){
			return;
		}
		if(i == 4){
			if (check(digit)) {
				if (!flag) {
					flag = true;
					answer = digit[3] + digit[2] * 10 + digit[1] * 100
							+ digit[0] * 1000;
				} else {
					intermediate = true;
				}
			}
			return;
		}
      	for (int j = 0; j < 10; j++) {
			digit[i] = j;
			getCode(digit, i + 1);
		}	
		
		return;
	}
	static boolean check(int[]digit){
	   boolean[]correctP;
	   boolean[]correct;
	   int p = 0;
	   int d = 0;
	   for (int i = 0; i < G; i++) {
		correct = new boolean[4];
		correctP= new boolean[4];
		p = 0;
		d = 0;
		for (int j = i*4; j < i*4+4; j++) {
			if(digit[j%4] == digits[j]){
				correctP[j%4]=true;
				correct[j%4]= true;
				p++;
			}
		}
		if(p != correctPosition[i]){
			return false;
		}
		for (int j = i*4; j < i*4+4; j++) {
				for (int k = 0; k < 4; k++) {
					if (!correct[k] && digits[j] == digit[k] && !correctP[j%4]) {
						correct[k] = true;
						d++;
						k = 4;
					}
				}
			
		}
		if(d!=correctDigits[i]){
			return false;
		}
	}
	   return true;
	}
	

}
