import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * C. Dungeons and Candies
 * http://codeforces.com/contest/436/problem/C
 */

public class Main {
    
    static char[][][] ar;
    static int k;
    static int n;
    static int m;
    static int w;
    static ArrayList<Integer>[] p;
    static ArrayList<edge> list;
    static boolean[]visited;

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader rd = new BufferedReader(r);
        String[] in = rd.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        k = Integer.parseInt(in[2]);
        w = Integer.parseInt(in[3]);
        ar = new char[k + 1][n][m];
        list = new ArrayList<edge>();
        int i = 1;
        int j = 0;
        while (i < k + 1) {
            j = 0;
            while (j < n) {
                ar[i][j] = rd.readLine().toCharArray();
                j++;
            }
            i++;
        }
        graph();
        kruskal();

    }

    static void graph() {
        for (int i = 1; i < k; i++) {
            list.add(new edge(0, i, n * m));
            for (int j = i + 1; j < k + 1; j++) {
                int count = 0;
                for (int j1 = 0; j1 < n; j1++) {
                    for (int j2 = 0; j2 < m; j2++) {
                        if (ar[i][j1][j2] != ar[j][j1][j2]) {
                            count++;
                        }
                    }
                }
                list.add(new edge(i, j, w * count));
            }
        }
        list.add(new edge(0, k, n * m));
    }

    static void kruskal() {
        visited = new boolean[k+1];
        p = new ArrayList[k + 1];
        for (int i = 0; i < k+1; i++) {
            p[i] = new ArrayList<Integer>();
        }
        long cost = 0;
        disj s = new disj();
        s.init(k + 1);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            edge e = list.get(i);
            if (s.union(e.n1, e.n2)) {
                cost += e.c;
                p[e.n1].add(e.n2);
                p[e.n2].add(e.n1);
            }
        }
        System.out.println(cost);
        print(0);

    }

    static void print(int i) {
        visited[i] = true;
        for (int j = 0; j < p[i].size(); j++) {
            int num = p[i].get(j);
            if (!visited[num]) {
                System.out.println(num + " " + i);
                print(num);
            }
        }
    }

}

class edge implements Comparable<edge> {
    int n1;
    int n2;
    int c;

    edge(int n1, int n2, int c) {
        this.n1 = n1;
        this.n2 = n2;
        this.c = c;
    }

    @Override
    public int compareTo(edge o) {
        // TODO Auto-generated method stub
        return c - o.c;
    }
}

class disj {
    int[] parent;

    void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    boolean union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if (pi == pj)
            return false;
        parent[pj] = pi;
        return true;

    }

    int find(int i) {
        if (parent[i] == i)
            return i;
        return (parent[i] = find(parent[i]));
    }
}