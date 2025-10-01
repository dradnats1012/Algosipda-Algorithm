package baekjun.kakao;

import java.io.*;
import java.util.*;

public class P14938 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] arr;
    private static int INF = 1000000000;
    private static int[][] distance;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());               // 지역
        int m = Integer.parseInt(st.nextToken());               // 범위
        int r = Integer.parseInt(st.nextToken());               // 길

        arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        distance = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++){                             // 초기화
            Arrays.fill(distance[i], INF);
            distance[i][i] = 0;
        }

        for(int i = 0; i < r; i++){                              // 거리 넣기
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if(l < distance[a][b]){
                distance[a][b] = l;
                distance[b][a] = l;
            }
        }

        for(int k = 1; k <= n; k++){                                // 플로이드
            for(int i = 1; i <= n; i++){
                if(distance[i][k] == INF) continue;
                for(int j = 1; j <= n; j++){
                    if(distance[k][j] == INF) continue;
                    int nd = distance[i][k] + distance[k][j];
                    if(nd < distance[i][j]) {
                        distance[i][j] = nd;
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                if(distance[i][j] <= m) sum+= arr[j];
            }
            ans = Math.max(ans, sum);
        }

        System.out.println(ans);
    }
}


/*
서강그라운드

각 지역에 아이템 몇개인지
어디로 낙하해야 수색 범위 내에서 가장 많은 아이템인지

일정한 길이 l -> 1 <= l <= 15
양방향 통행 가능
수색범위 m -> 1 <= m <= 15
얻을 수 있는 아이템의 최대 개수

플로이드?
 */