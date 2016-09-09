import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=930
 */

public class Main {
    static int n;
    static int n2;
    static boolean[][]row;
    static boolean[][]column;
    static boolean[][]square;
    static int[][]grid;
    static boolean flag = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		String s;
		int i;
		boolean first = false;
		while((s=br.readLine())!= null){
			if(first){
				System.out.println();
			}
			first = true;
			flag = false;
			i = 0;
			n = Integer.parseInt(s);
			n2 = n*n;
			row = new boolean[n2][n2+1];
			column = new boolean[n2][n2+1];
			square = new boolean[n2][n2+1];
			grid = new int[n2][n2];
			while(i < n2){
				s = br.readLine();
				transform(i, s);
				i++;
			}
			solution(0, 0);
			print();
			s = br.readLine();
		}
		
	}
	static void transform(int i , String s){
		String[]input = s.split(" ");
		int temp;
		for (int j = 0; j < n2 ; j++) {
			temp = Integer.parseInt(input[j]);
			if(temp != 0){
				row[i][temp] = true;
				column[j][temp]= true;
				square[(n*(i/n))+(j/n)][temp]= true;
				grid[i][j] = temp;
				
			}
		}
	}
	static void solution(int i , int j){
		if(j >= n2){
			solution(i+1,0);
			return;
		}
		if(i == n2){
			flag = true;
			return;
		}
		if(grid[i][j] != 0){
			solution(i , j+1);
			return;
		}
		for (int j2 = 1; j2 < (n2+1); j2++) {
			if(!row[i][j2] && !column[j][j2] && !square[(n*(i/n))+(j/n)][j2]){
				row[i][j2] = true;
				column[j][j2]= true;
				square[(n*(i/n))+(j/n)][j2] = true;
				grid[i][j]= j2;
				solution(i , j+1);
				if(flag){
					return ;
				}
				grid[i][j]= 0;
				row[i][j2] = false;
				column[j][j2]= false;
				square[(n*(i/n))+(j/n)][j2] = false;
				
			}
				
		}
		return;
	}
	static void print(){
		if(!flag){
			System.out.println("NO SOLUTION");
			return;
		}
		for (int i = 0; i < n2; i++) {
			for (int j = 0; j < n2-1; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.print(grid[i][n2-1]);
			System.out.println();
		}
		
	}
	

}
