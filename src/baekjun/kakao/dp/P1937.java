package baekjun.kakao.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1937 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] arr;
    private static int[][] dp;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    private static int dfs(int x, int y) {
        if(dp[x][y] != 0) return dp[x][y];      // 이미 계산됨

        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (arr[nx][ny] > arr[x][y]) {       // 이동가능
                dp[x][y] = Math.max(dp[x][y], 1 + dfs(nx, ny));
            }
        }

        return dp[x][y];
    }
}


/*
욕심쟁이 판다
n x n 대나무숲
대나무를 먹으면 상하좌우로 이동
옮긴 지역에 전 지역보다 대나무가 많이 있어야 함

어떤 지점에 처음 풀어놓아야 하고 어떤 곳으로 이동을 시켜야 판다가 최대한 많은 칸 방문?
판다가 이동할 수 있는 칸의 최댓값

이차원 배열 + dfs?
현재 위치와 네방향을 비교해서 크면 이동후 count++
가장 작은곳으로 간다고 제일 많이 이동하는건 아님

완전탐색의 경우
모든 칸에서 시작을 하면서 dfs로 훑으며 저장
1 -> 7 -> 15
7 -> 15

4 -> 5 -> 11 -> 15      // 최장거리수열?
5 -> 11 -> 15
11 -> 15

이동하는 위치에 속하는 값들의 최대는 구할 필요가 없다?
아니면 구해서 활용
아 구해서 저장하면 되겠다
 */