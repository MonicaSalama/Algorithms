import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1415
 */
public class Main {
     int[]height;
     int[]q;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader x = new BufferedReader(isr);
		Main t = new Main();
		int N = Integer.parseInt(x.readLine());
		String[] n = (x.readLine()).split(" ");
		t.height = new int[N];
		for (int i = 0; i < n.length; i++) {
			t.height[i] = Integer.parseInt(n[i]);
		}
		int Q = Integer.parseInt(x.readLine());
		t.q = new int[Q];
		n = (x.readLine()).split(" ");
		for (int i = 0; i < n.length; i++) {
			t.q[i] = Integer.parseInt(n[i]);
		}
		t.answer();
	}
	void answer(){
		int shorter;
		int taller;
		for(int i = 0; i < q.length ; i++){
			shorter = searchShorter(q[i]);
			taller = searchTaller(q[i]);
			if(shorter >= 0 && shorter < height.length && height[shorter] < q[i]){
				System.out.print(height[shorter]+" ");
			}else{
				System.out.print("X ");
			}
			if(taller >= 0 && taller <height.length && height[taller] > q[i]){
				System.out.println(height[taller]);
			}else{
				System.out.println("X");
			}
			
		}
		return;
	}
	int searchShorter(int n){
		int low = 0;
		int high = height.length-1;
		int mid;
		while(high > low){
			mid = (int) Math.ceil((high+low)/2.0);
			if(height[mid] >= n){
				high = mid-1;
			}else{
				low = mid;
			}
		}
		return low;
		
	}
	int searchTaller(int n){
		int low = 0;
		int high = height.length-1;
		int mid;
		while(high > low){
			mid = (high+low)/2;
			if(height[mid] > n){
				high = mid;
			}else{
				low = mid+1;
			}
		}
		return high;
	}
	

}
