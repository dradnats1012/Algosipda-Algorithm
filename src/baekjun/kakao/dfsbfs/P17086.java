package baekjun.kakao.dfsbfs;

import java.io.*;
import java.util.*;

public class P17086 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){         // 초기화
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = -1;
                if(map[i][j] == 1) {      // 상어
                    distance[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];     // 방향 정하기
                int ny  = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if(distance[nx][ny] != -1) continue;    // 방문함
                distance[nx][ny] = distance[x][y] + 1;  // 최단 갱신
                q.add(new int[]{nx, ny});
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(distance[i][j] > max) max = distance[i][j];
            }
        }

        System.out.println(max);
    }
}

/*
N x M 크기
아기상어 여러마리
안전거리 : 가장 거리가 가까운 아기 상어와의 거리
이동은 8방향 가능

BFS
북 북동 동 동남 남 남서 서 북서

 */