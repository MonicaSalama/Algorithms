import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=465
 */


public class Main {
    static boolean[] prime = new boolean[32];
    static boolean[]taken;
    static int[]sequence;
    static int n;
    static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader x = new InputStreamReader(System.in);
		BufferedReader y = new BufferedReader(x);
		String s;
		set();
		int i = 1;
		while((s = y.readLine()) != null){
			if(i != 1)
				out.println("");
			n = Integer.parseInt(s);
			taken = new boolean[n+1];
			sequence = new int[n];
			sequence[0] = 1;
		    out.println("Case "+i +":");
			find(1);
			i++;
		}
		out.close();

	}
	
	static void set(){
		prime[2] = true;
		prime[3] = true;
		prime[5] = true;
		prime[7] = true;
		prime[11] = true;
		prime[13] = true;
		prime[17] = true;
		prime[19] = true;
		prime[23] = true;
		prime[29] = true;
		prime[31] = true;
		
	}
	static void find(int i){
		int temp = sequence[i-1];
		if(i == (n-1)){
			for (int j = 2; j < taken.length; j++) {
				if(!taken[j]){
					if(sumPrime(1, j) && sumPrime(j, sequence[n-2])){
						sequence[n-1] = j;
						print();
					}
					break;
				}
			}
			return;
		}
		for (int j = 2; j < n+1;  j++){
			if(!taken[j] && sumPrime(temp,j)){
				taken[j] = true;
				sequence[i] = j;
				find(i+1);
				taken[j] = false;
			}
			
		}
		return;
		
	}
	static boolean sumPrime(int x , int y){
		if(x+y < 32){
			return prime[x+y];
		}
		return false;
	}
	static void print(){
		for (int i = 0; i < sequence.length-1; i++) {
			out.print(sequence[i]+" ");
		}
		out.print(sequence[sequence.length-1]);
		out.println();
	}

}
