import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=2511
 */

public class Main {
	int n;
	int m;
	double[] location;
	double[] answer;

	boolean valid(double distance) {
		int accessPoints = n;
		double[] points = new double[n];
		boolean[] visited = new boolean[m];
		for (int i = location.length - 1; i >= 0; i--) {
			if (visited[0]) {
				return true;
			}
			if (accessPoints == 0) {
				return false;
			}
			if (!visited[i]) {
				points[n - accessPoints] = location[i] - distance;
				visited[i] = true;
				int j = i - 1;
				while (j >= 0
						&& Math.abs(location[j] - points[n - accessPoints]) <= distance) {
					visited[j] = true;
					j--;
				}
				i = j + 1;
				accessPoints--;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main t = new Main();
		try{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int numTest = Integer.parseInt(br.readLine());
		int i = 0;
		String input;
		String[] numbers;
		t.answer = new double[numTest];
		while (i < numTest) {
			input = br.readLine();
			numbers = input.split(" ");
			t.n = Integer.parseInt(numbers[0]);
			t.m = Integer.parseInt(numbers[1]);
			t.location = new double[t.m];
			int j = 0;
			while (j < t.m) {
				t.location[j] = Double.parseDouble(br.readLine());
				j++;
			}
			Arrays.sort(t.location);
			t.answer[i] = t.wifi();
			i++;
		}
		for (int j = 0; j < t.answer.length; j++) {

			System.out.printf("%.1f\n", Math.round(t.answer[j] * 10.0) / 10.0);
		}
		}catch(Exception e){
			System.out.println("error");
		}
		

	}

	double wifi() {
		double min = Math.pow(Math.E, -9);
		double low = 0;
		double high = location[m - 1];
		while (Math.abs(high - low) > min) {
			double mid = (low + high) / 2.0;
			if (valid(mid)) {
				high = mid;
			} else {
				low = mid;
			}
		}
		return low;
	}

}
