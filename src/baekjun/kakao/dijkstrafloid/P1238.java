package baekjun.kakao.dijkstrafloid;

import java.io.*;
import java.util.*;

public class P1238 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[][] dis;
    private static int INF = 1000000000;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        dis = new int[n + 1][n + 1];    // 거리를 저장할 배열

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++) {
                if (i == j)
                    dis[i][j] = 0;
                else
                    dis[i][j] = INF;
            }
        }

        int[][] data = new int[m][3];
        int start, end, t;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            data[i] = new int[]{start,end,t};
        }

        for(int i = 0; i < m; i++){
            int from = data[i][0];
            int to = data[i][1];
            int time = data[i][2];
            dis[from][to] = Math.min(dis[from][to], time);
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(dis[i][k] == INF || dis[k][j] == INF) continue;
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dis[i][x] != INF && dis[x][i] != INF){
                max = Math.max(dis[i][x] + dis[x][i], max);
            }
        }

        System.out.println(max);
    }
}


/*
파티
마을 n개
학생 n명

m개의 단방향 도로
i 번쨰 길을 지나는데 Ti의 시간 소비
파티를 갔다가 다시 돌아와야함
단방향이라서 오고 가는 길이 다를 수 있음
가장 많은 시간을 소비하는 학생은?

플로이드 워셜일듯
n : 마을/학생의 개수
m : 간선의 개수
x : 파티가 열리는 마을
 */