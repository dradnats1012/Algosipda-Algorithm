package baekjun.kakao.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10026 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        map = new String[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split("");
        }

        int aCount = 0;
        int bCount = 0;

        for (int i = 0; i < n; i++) {     // 정상
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {         // 방문 체크
                    dfs(i, j);
                    aCount++;
                }
            }
        }

        visited = new boolean[n][n];        // 방문 배열 초기화
        for (int i = 0; i < n; i++) {         // 색약용 R,G 통합
            for (int j = 0; j < n; j++) {
                if (map[i][j].equals("G")) {
                    map[i][j] = "R";
                }
            }
        }

        for (int i = 0; i < n; i++) {     // 색약
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {     // 방문 안한것만
                    dfs(i, j);
                    bCount++;
                }
            }
        }

        System.out.println(aCount + " " + bCount);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;       // 방문표시
        String color = map[x][y];    // 색깔 추출

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(!visited[nx][ny] && map[nx][ny].equals(color)) {
                dfs(nx, ny);
            }
        }
    }
}

/*
적록색약
r,g,b 중 하나를 색칠한 칸들이 존재
구역은 같은 색으로 이루어짐
상하 좌우로 인접해 있는 경우 같은 구역
빨간색과 초록색의 차이를 거의 느끼지 못함

 */
