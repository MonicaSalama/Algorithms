import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 6010 - Dice on a Board
 * https://icpcarchive.ecs.baylor.edu/index.php?option=onlinejudge&page=show_problem&problem=4021
 */

public class Main {
	static char[][] grid;
	static int n;
	static int m;
	static String s;
	static int x_s, y_s, x, y;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
	
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader rd = new BufferedReader(r);
		int test = Integer.parseInt(rd.readLine().trim());
		while (test > 0) {
			String input = rd.readLine();
			String[] in = input.split(" ");
			n = Integer.parseInt(in[0]);
			m = Integer.parseInt(in[1]);
			grid = new char[n][m];
			s = rd.readLine();
			int i = 0;
			while (i < n) {
				grid[i] = rd.readLine().toCharArray();
				i++;
			}
			fun();
			solv();
			test--;
		}

	}

	static void fun() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 'S') {
					x_s = i;
					y_s = j;
				} else if (grid[i][j] == 'T') {
					x = i;
					y = j;
				}

			}

		}
	}

	static int end(String S) {
		int l = Integer.parseInt(S);
		return (l % 10 - 1);
	}

	static void solv() {
		int max = n * m - 1;
		int[][][][] dist = new int[n][m][6][6];
		String[][] dice = new String[6][6];
		int d = end(s);
		dice[d] = rotate(s);
		String S = right(s);
		d = end(S);
		dice[d] = rotate(S);
		S = left(s);
		d = end(S);
		dice[d] = rotate(S);
		S = backward(s);
		d = end(S);
		dice[d] = rotate(S);
		S = forward(s);
		d = end(S);
		dice[d] = rotate(S);
		S = forward(S);
		d = end(S);
		dice[d] = rotate(S);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int j2 = 0; j2 < 6; j2++) {
					for (int k = 0; k < 6; k++) {
						dist[i][j][j2][k] = Integer.MAX_VALUE / 2;
					}
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (dice[i][j]!= null && dice[i][j].equals(s)) {
					dist[x_s][y_s][i][j] = 0;
					break;
				}

			}
		}
		int c = 0;
		boolean flag = true;
		while (c < max && flag) {
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int j2 = 0; j2 < 6; j2++) {
						for (int k = 0; k < 6; k++) {
							if (grid[i][j] == '.'
									|| grid[i][j] == 'T'
									|| dist[i][j][j2][k] == Integer.MAX_VALUE / 2)
								continue;
							String temp;
							int t;
							int w;
							if (check(i, j + 1)) {
								temp = right(dice[j2][k]);
								t = end(temp);
								w = num(i, j + 1, temp);
								if (dist[i][j + 1][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									dist[i][j + 1][t][get(temp)] = dist[i][j][j2][k]
											+ w;
								}
							}
							if (check(i, j - 1)) {
								temp = left(dice[j2][k]);
								t = end(temp);
								w = num(i, j - 1, temp);
								if (dist[i][j - 1][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									dist[i][j - 1][t][get(temp)] = dist[i][j][j2][k]
											+ w;

								}
							}
							if (check(i + 1, j)) {
								temp = forward(dice[j2][k]);
								t = end(temp);
								w = num(i + 1, j, temp);
								if (dist[i + 1][j][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									dist[i + 1][j][t][get(temp)] = dist[i][j][j2][k]
											+ w;

								}
							}
							if (check(i - 1, j)) {
								temp = backward(dice[j2][k]);
								t = end(temp);
								w = num(i - 1, j, temp);
								if (dist[i - 1][j][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									dist[i - 1][j][t][get(temp)] = dist[i][j][j2][k]
											+ w;

								}
							}
						}
					}

				}
			}
			c++;
		}
		boolean inf = true;
		int tem = Integer.MAX_VALUE / 2;
		for (int k = 0; k < 6; k++) {
			for (int k2 = 0; k2 < 6; k2++) {
				if (dist[x][y][k][k2] != Integer.MAX_VALUE / 2) {
					inf = false;
				}
			}
		}
		if (inf) {
			System.out.println("Impossible");
		} else if (!flag) {
			for (int k = 0; k < 6; k++) {
				for (int k2 = 0; k2 < 6; k2++) {
					if (dist[x][y][k][k2] < tem) {
						tem = dist[x][y][k][k2];
					}
				}
			}
			System.out.println(-1 * tem);
		} else {
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int j2 = 0; j2 < 6; j2++) {
						for (int k = 0; k < 6; k++) {
							if (grid[i][j] == '.'
									|| grid[i][j] == 'T'
									|| dist[i][j][j2][k] == Integer.MAX_VALUE / 2)
								continue;
							String temp;
							int t;
							int w;
							if (check(i, j + 1)) {
								temp = right(dice[j2][k]);
								t = end(temp);
								w = num(i, j + 1, temp);
								if (dist[i][j + 1][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									break;
								}
							}
							if (check(i, j - 1)) {
								temp = left(dice[j2][k]);
								t = end(temp);
								w = num(i, j - 1, temp);
								if (dist[i][j - 1][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									break;

								}
							}
							if (check(i + 1, j)) {
								temp = forward(dice[j2][k]);
								t = end(temp);
								w = num(i + 1, j, temp);
								if (dist[i + 1][j][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									break;

								}
							}
							if (check(i - 1, j)) {
								temp = backward(dice[j2][k]);
								t = end(temp);
								w = num(i - 1, j, temp);
								if (dist[i - 1][j][t][get(temp)] > dist[i][j][j2][k]
										+ w) {
									flag = true;
									break;
								}
							}
						
						}

					}
				}
			}
			if (flag)
				System.out.println("Infinity");
			else {
				tem = Integer.MAX_VALUE / 2;
				for (int k = 0; k < 6; k++) {
					for (int k2 = 0; k2 < 6; k2++) {
						if (dist[x][y][k][k2] < tem) {
							tem = dist[x][y][k][k2];
						}
					}
				}
				System.out.println(-1 * tem);
			}
		}

	}

	static int num(int i, int j, String temp) {
		if (grid[i][j] == 'T')
			return 0;
		int num = Integer.parseInt(temp);
		num = num % 10;
		int g = Integer.parseInt(grid[i][j] + "");
		if (num == g)
			return (-1 * (num + g));
		return num + g;

	}

	static String[] rotate(String s) {
		String[] d = new String[6];
		String S;
		d[get(s)] = s;
		char[] ar = s.toCharArray();
		char[] arr = new char[6];
		arr[4] = ar[4];
		arr[5] = ar[5];
		arr[0] = ar[3];
		arr[1] = ar[2];
		arr[2] = ar[0];
		arr[3] = ar[1];
		S = new String(arr);
		d[get(S)] = S;
		arr[0] = ar[1];
		arr[1] = ar[0];
		arr[2] = ar[3];
		arr[3] = ar[2];
		S = new String(arr);
		d[get(S)] = S;
		arr[0] = ar[2];
		arr[1] = ar[3];
		arr[2] = ar[1];
		arr[3] = ar[0];
		S = new String(arr);
		d[get(S)] = S;
		return d;
	}

	static int get(String s) {
		String t = s.charAt(0) + "";
		return (Integer.parseInt(t) - 1);

	}

	static boolean check(int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= m)
			return false;
		if (grid[i][j] == '.' || grid[i][j] == 'S')
			return false;
		return true;
	}

	static String right(String s) {
		char[] arr = s.toCharArray();
		char[] dice = new char[6];
		dice[0] = arr[4];
		dice[1] = arr[5];
		dice[2] = arr[2];
		dice[3] = arr[3];
		dice[4] = arr[1];
		dice[5] = arr[0];
		return new String(dice);
	}

	static String left(String s) {
		char[] arr = s.toCharArray();
		char[] dice = new char[6];
		dice[0] = arr[5];
		dice[1] = arr[4];
		dice[2] = arr[2];
		dice[3] = arr[3];
		dice[4] = arr[0];
		dice[5] = arr[1];
		return new String(dice);
	}

	static String backward(String s) {
		char[] arr = s.toCharArray();
		char[] dice = new char[6];
		dice[0] = arr[0];
		dice[1] = arr[1];
		dice[2] = arr[4];
		dice[3] = arr[5];
		dice[4] = arr[3];
		dice[5] = arr[2];
		return new String(dice);
	}

	static String forward(String s) {
		char[] arr = s.toCharArray();
		char[] dice = new char[6];
		dice[0] = arr[0];
		dice[1] = arr[1];
		dice[2] = arr[5];
		dice[3] = arr[4];
		dice[4] = arr[2];
		dice[5] = arr[3];
		return new String(dice);
	}

}
