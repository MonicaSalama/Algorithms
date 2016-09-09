import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 10047 - The Monocycle
 * https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=988
 */

public class Main {
	static int r;
	static int c;
    static boolean[][][][]visited;
    static char[][]grid;
    static int rStart;
    static int cStart;
    static Queue<Integer> rPosition = new LinkedList<Integer>();
    static Queue<Integer> cPosition =  new LinkedList<Integer>();
    static Queue<Integer> color =  new LinkedList<Integer>();
    static Queue<Integer> direction =  new LinkedList<Integer>();
    static Queue<Integer> time =  new LinkedList<Integer>();
    static int[] dr = {-1, 1, 0, 0};
    static int[]dc  = { 0, 0,-1, 1};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStreamReader x = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(x);
		int testCase = 1;
		boolean fl = false;
		while(true){
			String s = rd.readLine();
			String[]input = s.split(" ");
			r = Integer.parseInt(input[0]);
			if(r == 0)
				break;
			
			c = Integer.parseInt(input[1]);
			visited = new boolean[r][c][5][4];
			grid = new char[r][c];
			if(fl)
				System.out.println();
			fl = true; 
			boolean flag = false;
			int i = 0;
			while(i < r){
				s = rd.readLine();
				grid[i] = s.toCharArray();
				if(!flag && ((cStart = s.indexOf('S'))!= -1)){
					flag = true;
					rStart = i;	
				}
				i++;
			}
			rPosition.add(rStart);
			cPosition.add(cStart);
			color.add(0);
			direction.add(0);
			time.add(0);
			int temp = bfs();
			System.out.println("Case #"+testCase);
			if(temp == -1){
				System.out.println("destination not reachable");
			}else{
				System.out.println("minimum time = "+temp+" sec");
			}
			rPosition.clear();
			cPosition.clear();
			color.clear();
			direction.clear();
			time.clear();
			testCase++;
			
		}

	}
	static int bfs(){
		int t;
		int direct;
		int col;
		int i;
		int j;
		while(!rPosition.isEmpty()){
			i = rPosition.poll();
			j = cPosition.poll();
			col = color.poll();
			direct = direction.poll();
			t = time.poll();
			if(grid[i][j]=='T' && col == 0)
				return t;
			if(valid(i+dr[direct], j + dc[direct] , (col+1)%5, direct)){
				visited[i+dr[direct]][j + dc[direct]][(col+1)%5][direct] = true;
				rPosition.add(i+dr[direct]);
				cPosition.add(j + dc[direct]);
				color.add((col+1)%5);
				direction.add(direct);
				time.add(t+1);
			}
			if(direct == 0 || direct == 1){
				addQ(i, j, col, 2, t);
				addQ(i, j, col, 3, t);
			}else{
				addQ(i, j, col, 0, t);
				addQ(i, j, col, 1, t);
			}
		}
		return -1;
	}
	static boolean valid (int i , int j , int color , int direction){
		if(i > -1 && i < r && j > -1 && j < c && grid[i][j]!= '#' && !visited[i][j][color][direction])
			return true;
		return false;
	}
	static void addQ(int i , int j , int col  , int direct ,int t){
		if(!visited[i][j][col][direct]){
			visited[i][j][col][direct] = true;
			rPosition.add(i);
			cPosition.add(j);
			color.add(col);
			direction.add(direct);
			time.add(t+1);
		}
	}

}
