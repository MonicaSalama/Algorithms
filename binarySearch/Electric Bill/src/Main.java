import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=3342
 */
public class Main {
    int[] range = {100 , 10000 , 1000000};
    int[]left = {100,9900,990000};
    int[]price = {2,3,5 ,7};
    int max ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main t = new Main();
		try{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input;
		String []numbers;
		long A;
		long B;
        while(true){
        	input = br.readLine();
			numbers = input.split(" ");
			A = Long.parseLong(numbers[0]);
			B = Long.parseLong(numbers[1]);
			if(A == 0 && B == 0){
				break;
			}
			System.out.println(t.money(t.search(t.TotalHours(A), B)));
        }
		}catch(Exception e){
			
		}
		
	}
	long TotalHours(long A){
		if(A <= range[0]*price[0]){
			max = 0;
		}else if(A <= left[0]*price[0]+left[1]*price[1]){
			max = 1;
		}else if (A <= left[0]*price[0]+left[1]*price[1]+left[2]*price[2]){
			max = 2;
		}else{
			max = 3;
		}
		long temp = A;
		long hours = 0;
		for (int i = 0;i < max && i < left.length ; i++) {
			hours = hours + left[i];
			temp = temp - left[i]* price[i];
		}
		hours = hours + temp/price[max] ;
		
		return hours;
	}
	
		long search(long hours , long B){
		long low = 0;
		long high = hours/2;
		long mid;
		long answer1;
		long answer2;
		while(low < high){
			mid = (high+low)/2;
			answer1 = money(mid);
			answer2 = money(hours-mid);
			if(answer2 - answer1 < B){
				high = mid;
			}else if(answer2 - answer1 > B){
				low = mid+1;
			}else{
				return mid;
			}
			
		}
		
		return low;
	}
	

	
	long money(long hours){
		int i = 0;
		long sum = 0;

		while(i < 3  && hours - left[i] >= 0){
			sum = sum + price[i]*left[i];
			hours = hours - left[i];
			i++;
		}
		
       sum = sum + hours*price[i];
       return sum;
		
	}

}
