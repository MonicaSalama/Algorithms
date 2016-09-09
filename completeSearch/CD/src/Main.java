import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=565
 */

public class Main {
    static int N;
    static int tracks;
    static int[]duration;
    static int sum;
    static int max;
    static int tracksMax;
    static boolean flag;
    static LinkedList<Integer> answer = new LinkedList<Integer>();
    static String string = "";
	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String s;
		String[]input;
		while((s= br.readLine())!= null){
			string = "";
			flag = false;
			sum = 0;
		    max = 0;
		    tracksMax = 0;
			input = s.split(" ");
			N = Integer.parseInt(input[0]);
			tracks = Integer.parseInt(input[1]);
			duration = new int[tracks];
			for (int i = 0; i < tracks; i++) {
				duration[i] = Integer.parseInt(input[i+2]); 
			}
			maxTracks(0);
			System.out.println(string+"sum:"+max);
			answer.clear();
			
		}
	}
	static void maxTracks(int i){
		if(sum > N){
			return;
		}
		if(i == tracks){
			if(sum >= max){
				saveMax(sum);
				max = sum;
			}
			return;
		}
		for (int j = i; j < tracks; j++) {
			sum = sum + duration[j];
			answer.add(duration[j]);
			if(sum <= N && sum >= max){
				saveMax(sum);
				max = sum;
			}
			maxTracks(j+1);
			sum = sum - duration[j];
			answer.removeLast();
		}
		return;
	}
	static void saveMax(int sum){
		Iterator<Integer> it = answer.iterator();
		String s = "";
		while((it.hasNext())){
			s = s +it.next()+" ";
		}
		
		if(sum > max){
			string = s;
		}
		else if(s.length() > string.length()){
			string = s;
		}
	}
	

}
