import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 352 - The Seasonal War -UVA-
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=288
 */
public class Main {
    static boolean[][]arr;
    static boolean[][]visited;
    static int[]dx = {-1,-1,0,1,1, 1, 0,-1};
    static int[]dy = { 0, 1,1,1,0,-1,-1,-1};
    static int size;
    static int counter;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader x = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(x);
        String s ;
        int index = 1;
        while((s=rd.readLine())!= null){
        	String[]input = s.split(" ");
        	size = Integer.parseInt(input[0]);
        	arr = new boolean[size][size];
        	visited = new boolean[size][size];
        	int i = 0;
        	counter = 0;
        	while(i < size){
        		s = rd.readLine();
        		char[]c = s.	toCharArray();
        		for (int j = 0; j < c.length; j++) {
					int temp = Integer.parseInt(""+c[j]);
					if(temp == 0){
						arr[i][j] = false;
					}else{
						arr[i][j] = true;
					}
				}
        		i++;
        	}
        	count();
        	System.out.println("Image number "+index+" contains "+counter+" war eagles.");
        	index++;
        }
	}
	static void count(){
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(arr[i][j] && !visited[i][j]){
					visited[i][j]= true;
					counter++;
					neighbors(i, j);
				}
			}
			
		}
	}
	static void neighbors(int i , int j){
		int x;
		int y;
		for (int j2 = 0; j2 < dx.length; j2++) {
			x = i+dx[j2];
			y = j+dy[j2];
			if(legal(x,y)){
				visited[x][y]= true;
				neighbors(x, y);
			}
		}
	}
	static boolean legal(int i , int j){
		if(i >= 0 && j >= 0 && i < size && j < size && arr[i][j] && !visited[i][j]){
			return true;
		}
		return false;
	}

}
