import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1160
 */


public class Main {
    static PrintWriter out = new PrintWriter(System.out);
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader x = new BufferedReader(isr);	
		String s;
		String[]input;
		long n;
		long k;
		while((s=x.readLine())!= null){
			 input = s.split(" ");
			 n = Long.parseLong(input[0]);
			 k = Long.parseLong(input[1]);
			 out.println(numDigits(findWay(n, k)));
		}
	    out.close();

	}
	static BigInteger findWay(long n , long k){
		long temp = n - k;
		long num2;
		long stop;
		if(k > temp){
			stop = k;
			num2 = temp;
		}else{
			num2 = k;
			stop = temp;
		}
		BigInteger answer = BigInteger.ONE;
		BigInteger fact = BigInteger.ONE;
		BigInteger j = BigInteger.valueOf(num2);
		BigInteger i = BigInteger.valueOf(n);
		while(i.compareTo(BigInteger.valueOf(stop)) == 1){
			answer = answer.multiply(i);
			if(answer.mod((fact.multiply(j))) == BigInteger.ZERO){
				answer = answer.divide((fact.multiply(j)));
				fact = BigInteger.ONE;
			}else if(answer.mod(j) == BigInteger.ZERO){
				answer = answer.divide(j);
			}else{
				fact = fact.multiply(j);
			}
			
			i = i.subtract(BigInteger.ONE);
			j = j.subtract(BigInteger.ONE);
			
		}
		return answer;
	}

	static int numDigits(BigInteger num){
		int digitNum = 0;
		while(num.compareTo(BigInteger.ZERO)!= 0){
			digitNum ++;
			num = num.divide(BigInteger.valueOf(10));
		}
		return digitNum;
	}
	
		

}
