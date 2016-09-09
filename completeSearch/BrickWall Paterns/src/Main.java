import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=841
 */

public class Main {
    static long[]numPattern ;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader x = new BufferedReader(isr);
		int length;
		while(true){
		    length = Integer.parseInt(x.readLine());
		    if(length == 0){
		    	break;
		    }
		    numPattern = new long[length+1];
		    System.out.println(patterns(length));
		}
	}
	static long patterns(int length){
		long num = 0;
		if(length == 1 || length == 0){
			return 1;
		}
		if(numPattern[length] == 0){
			num = patterns(length -1) + patterns(length - 2);
			numPattern[length] = num;
		}else{
			return numPattern[length];
		}
		
		return num;
	}

}
