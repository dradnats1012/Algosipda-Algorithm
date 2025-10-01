package baekjun.kakao.dijkstrafloid;

import java.io.*;
import java.util.*;

public class P11404 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] distance;
    private static int INF = 1000000000;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        distance = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){            // 거리 배열 초기화
            for(int j = 1; j <= n; j++){
                if(i == j) {
                    distance[i][j] = 0;
                } else distance[i][j] = INF;
            }
        }

        int[][] data = new int[m][3];
        int a, b, c;
        for(int i = 0; i < m; i++){
            // 데이터 배열 data[i][0] : 출발, data[i][1] : 도착, data[i][2] : 가중치
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            data[i] = new int[]{a, b, c};
        }

        for(int i = 0; i < m; i++){
            int from = data[i][0];
            int to = data[i][1];
            int cost = data[i][2];
            distance[from][to] = Math.min(distance[from][to], cost); // 여러 간선 있을 경우 최소값
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(distance[i][k] == INF || distance[k][j] == INF) continue;
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(distance[i][j] == INF)
                    System.out.print(0 + " ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }
}


/*
플로이드

n : 도시의 개수
m : 버스의 개수
버스정보 a, b, c
a : 출발 도시 번호
b : 도착 도시 번호
c : 버스타는데 필요한 비용

그래프 그대로 출력

순서
1. 그래프 초기화
2. 그래프 데이터 저장
3. 3중 반복 업데이트
 */