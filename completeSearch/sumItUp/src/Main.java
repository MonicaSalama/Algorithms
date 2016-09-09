import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=515
 */

public class Main {
   static int sum ;
   static int[]numbers;
   static boolean possible;
   static int n;
   static int t;
   static LinkedList<Integer> answer = new LinkedList<Integer>();
   static ArrayList<String> string = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String s;
		String[]input;
		while(true){
			sum = 0;
			possible = false;
			s = br.readLine();
			input = s.split(" ");
			t = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			if(n==0){
				break;
			}
			numbers = new int[n];
			for (int i = 0; i < n; i++) {
				numbers[i] = Integer.parseInt(input[i+2]); 
			}
			sumIt(0);
			answerPrint();
			
		}
		sum = 0;
	}
	static void sumIt(int i){
		int temp;
		int z ;
		int index = 1;
		if(sum == t){
			print();
			return;
		}
		if(sum > t){
			return;
		}
		if(i == n){
			return;
		}
		for (int j = i; j < numbers.length; j++) {
			index = 1;
			z = 1;
			temp = numbers[j];
			while(j+1 < n && temp == numbers[j+1]){
				z++;
				j++;
			}
			while(index <= z && sum < t){
				answer.add(numbers[j]);
				sum = sum + numbers[j]; 
				sumIt(j+1);
				index++;
			}
			for (int j2 = 0; j2 < index-1; j2++) {
				sum = sum - numbers[j];
				answer.removeLast();
			}
		}
		
	}
	static void print(){
		possible = true;
		Iterator<Integer> it = answer.iterator();
		String s = "";
		while((it.hasNext())){
			s = s +it.next();
			if(it.hasNext()){
				s = s+"+";
			}
		}
		string.add(s);
	}
	static void answerPrint(){
		System.out.println("Sums of "+t+":");
		if(!possible){
			System.out.println("NONE");
			return;
		}
		Collections.sort(string, Collections.reverseOrder());
		Iterator<String> t = string.iterator();
		while(t.hasNext()){
			System.out.println(t.next());
		}
		string.clear();
	}
	

}
