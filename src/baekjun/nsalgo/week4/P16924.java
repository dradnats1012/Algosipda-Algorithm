package baekjun.nsalgo.week4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class P16924 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static String[][] arr;
    static boolean[][] visited;
    static int n, m;

    static ArrayList<String> result = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new String[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().split("");
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (arr[i][j].equals("*")) {
                    int size = getMaxCrossSize(i, j);
                    if (size > 0) {
                        for (int k = 1; k <= size; k++) {
                            result.add((i + 1) + " " + (j + 1) + " " + k);
                            markVisited(i, j, k);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j].equals("*") && !visited[i][j]) {
                    bw.write("-1\n");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write(result.size() + "\n");
        for (String s : result) {
            bw.write(s + "\n");
        }
        bw.flush();
    }

    static int getMaxCrossSize(int x, int y) {
        int size = 0;
        while (true) {
            size++;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d] * size;
                int ny = y + dy[d] * size;

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || !arr[nx][ny].equals("*")) {
                    return size - 1;
                }
            }
        }
    }

    // 십자가 좌표 방문 표시
    static void markVisited(int x, int y, int size) {
        visited[x][y] = true;
        for (int s = 1; s <= size; s++) {
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d] * s;
                int ny = y + dy[d] * s;
                visited[nx][ny] = true;
            }
        }
    }
}