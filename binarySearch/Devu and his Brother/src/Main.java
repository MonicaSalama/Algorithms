import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * http://codeforces.com/problemset/problem/439/D
 */
public class Main {
    long[]a;
    long[]b;
    long min = (long) Math.pow(20, 9);
    long max = 0;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main t = new Main();
        try{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String[]input;
        input = (br.readLine()).split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        t.a = new long[n];
        t.b = new long[m];
        input = (br.readLine()).split(" ");
        long temp;
        for (int i = 0; i < input.length; i++) {
            temp = Long.parseLong(input[i]);
            t.a[i] = temp;
            if(temp < t.min){
                t.min = temp;
            }
        }
        input = (br.readLine()).split(" ");
        for (int i = 0; i < input.length; i++) {
            temp = Long.parseLong(input[i]);
            t.b[i] = temp;
            if(temp > t.max){
                t.max = temp;
            }
        }
        if(t.min < t.max){
            System.out.printf("%d\n", t.minStep());
        }else{
            System.out.println("0");
        }
    }catch(Exception e){
        
     }
    }

    long minStep(){
        long low = min - 10;
        long high = max + 10;
        long t1;
        long t2;
        long steps1 = 0;
        long steps2 = 0;
        while(high - low > 0 ) {
            t1 = low + ((high - low) / 3);
            t2 = low + (2* (high - low) / 3);
            steps1 = numberSteps(t1);
            steps2= numberSteps(t2);
            if(steps1 > steps2){
                low = t1+1;
            }else{
                high = t2;
            }
        }
        return steps1;
    }
    long numberSteps(long num){
        long steps = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] < num){
                steps = steps + num - a[i];
            }
        }
        for (int i = b.length-1; i >= 0 ; i--) {
            if(b[i] > num){
                steps = steps + b[i] - num; 
            }
            
        }
        return steps;
    }
}