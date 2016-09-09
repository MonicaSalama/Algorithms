import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 532 - Dungeon Master
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=473
 */

public class Main {
    static int l;
    static int r;
    static int c;
    static char[][][]grid;
    static boolean[][][]visited;
    static int startC;
    static int startL;
    static int startR;
    static int[]dr = {0, 0,-1, 1, 0, 0};
    static int[]dc = {1,-1, 0, 0, 0, 0};
    static int[]dl = {0, 0, 0, 0, 1,-1};
    static Queue<Integer> lPosition = new LinkedList<Integer>();
    static Queue<Integer> rPosition = new LinkedList<Integer>();
    static Queue<Integer> cPosition = new LinkedList<Integer>();
    static Queue<Integer> steps = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader x = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(x);
		while(true){
			String s = rd.readLine();
			String[]input = s.split(" ");
			l = Integer.parseInt(input[0]);
			if(l == 0)
				break;
			r = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			grid = new char[l][r][c];
			visited = new boolean[l][r][c];
			int i = 0;
			boolean start = false;
			while(i < l){
				int j = 0;
				while(j < r){
					s = rd.readLine();
					grid[i][j] = s.toCharArray();
					if(!start && ((startC = s.indexOf('S'))!= -1)){
						start = true;
						startR = j;
						startL = i;
					}
					j++;
				}
				rd.readLine();
				i++;
			}
			lPosition.add(startL);
			rPosition.add(startR);
			cPosition.add(startC);
			steps.add(0);
			int temp = bfs();
			if(temp != -1){
				System.out.println("Escaped in "+temp+" minute(s).");
			}else{
				System.out.println("Trapped!");
			}
			lPosition.clear();
			rPosition.clear();
			cPosition.clear();
			steps.clear();
			
		}	

	}
	static int bfs(){
		int numSteps;
		int level;
		int row;
		int coul;
		while(!lPosition.isEmpty()){
			numSteps = steps.poll();
			level = lPosition.poll();
			row = rPosition.poll();
			coul = cPosition.poll();
			for (int i = 0; i < dc.length; i++) {
				int z = level + dl[i];
				int x = row + dr[i];
				int y = coul + dc[i];
				if(valid(z, x, y)){
					if(grid[z][x][y]== 'E'){
						return numSteps+1;
					}
					visited[z][x][y] = true;
					lPosition.add(z);
					rPosition.add(x);
					cPosition.add(y);
					steps.add(numSteps+1);
				}
			}
		
		}
		return -1;
		
	}
	static boolean valid(int i , int j , int k){
		if(i > -1 && i < l && j > -1 && j < r && k > -1 && k < c && grid[i][j][k] != '#' && !visited[i][j][k]){
			return true;
		}
		return false;
	}
	

}
