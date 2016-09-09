import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1415
 */
public class Main {
	 LinkedList  list = new LinkedList();
	 int[]marbles;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main t = new Main();
		try{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String input;
		String []numbers;
		int N;
		int Q;
        while(true){
        	input = br.readLine();
			numbers = input.split(" ");
			N = Integer.parseInt(numbers[0]);
			Q = Integer.parseInt(numbers[1]);
			if(N == 0 && Q == 0){
				t.print();
				break;
			}
			t.list.add(Q);
			int i = 0;
			t.marbles = new int[N];
			while(i < N){
				t.marbles[i] =  Integer.parseInt(br.readLine());
				i++;
			}
			Arrays.sort(t.marbles);
			i = 0;
			while(i < Q){
				int temp = Integer.parseInt(br.readLine());
				t.list.add(temp);
				int answer = t.search(temp);
				t.list.add(answer);
				i++;
			}
			
        }
		}catch(Exception e){
		}

	}
	int search(int num){
		int low = 0;
		int high = marbles.length-1;
		int mid ;
		while(high - low > 0){
			mid = (high+low)/2;
			if(marbles[mid] >= num){
				high = mid;
			}else if(marbles[mid] < num){
				low = mid+1;
			}
		}
		if(marbles[high] == num){
			return high+1;
		}
		return -1;
	}
	void print(){
		ListIterator y = list.listIterator();
		int index = 1;
		while(y.hasNext()){
			int q = (int) y.next();
			System.out.printf("CASE# %d:\n",index);
			int i = 0;
			while(i < q){
				System.out.print(y.next());
				int answer = (int)y.next();
				if(answer== -1){
					System.out.println(" not found");
				}else{
					System.out.println(" found at "+answer);
				}
				i++;
			}
			index++;
		}
	}
	

	

}
