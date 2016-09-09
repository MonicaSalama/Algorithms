import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=580
 */

public class Main {
    static int n;
    static boolean[]rooks;
    static boolean[][]input;
    static int maxRooks;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader x = new BufferedReader(isr);	
		String s;
		char[]g;
		int index;
		while(true){
			maxRooks = 0;
			index = 0;
			 n =Integer.parseInt(x.readLine());
			 if(n==0){
				 break;
			 }
			 input = new boolean[n][n];
			 while(index < n){
				 s = x.readLine();
				 g = s.toCharArray();
				 for (int i = 0; i < g.length; i++) {
					if(g[i] == 'X'){
						input[index][i]= true;
					}
				}
				 index++;
			 }
			 maxRooks();
			 System.out.println(maxRooks);
		}
	  
	}
	static void maxRooks(){
		int n2 = n*n;
		
		for (int i = 0; i < (1<<n2) ; i++) {
			rooks = new boolean[n2];
			for (int j = 0; j < n2; j++) {
				if((i & (1<<j)) != 0){
					rooks[n2-j-1]= true;
				}
			}
			if(check() && ((Integer.bitCount(i) > maxRooks))){
				maxRooks = Integer.bitCount(i);
			}
			
		}
	}
	static boolean check(){
		boolean[]column = new boolean[n];
		boolean[][]grid = new boolean[n][n];
		boolean row = false;
		int z = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(input[i][j] && rooks[z]){
					return false;
				}
				grid[i][j] = rooks[z];
				z++;
				
			}
		}
		for (int i = 0; i < n; i++) {
			row = false;
			for (int j = 0; j < n; j++) {
				if(input[i][j]){
					row = false;
					column[j]= false;;
				}
				if(grid[i][j]){
					if(column[j] || row){
						return false;
					}else{
						column[j] = true;
						row = true;
					}
				
				}
			}
		}
		return true;
		
	}
	

}
