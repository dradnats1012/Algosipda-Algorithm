package baekjun.kakao.dfsbfs;

import java.io.*;
import java.util.*;

public class P2206 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dx = {0, 0, -1, 1};       // 상하좌우
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] map;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < n+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m+1; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        q.add(new int[]{1,1});      // 출발지 입력

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

            }
        }
    }
}


/*
벽 부수고 이동하기
n x m 행렬
0 : 이동할 수 있는 곳
1 : 벽

(1,1) 에서 (N,M) 까지 최단경로
벽 한개까지 부술 수 있음
상하좌우 이동
최단거리 출력
불가능할 경우 -1
 */