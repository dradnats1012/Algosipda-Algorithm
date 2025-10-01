package baekjun.kakao.dijkstrafloid;

import java.io.*;
import java.util.*;

public class P1389 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dis = new int[n+1][n+1];    // 관계 거리

        for(int i = 1; i <= n; i++){        // 거리 초기화
            for(int j = 1; j <= n; j++){
                if(i == j){
                    dis[i][j] = 0;
                } else dis[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dis[a][b] = 1;      // 관계 추가
            dis[b][a] = 1;
        }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(dis[i][j] > dis[i][k] + dis[k][j]){
                        dis[i][j] =  dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        int ans = 1;
        int v = INF;
        int sum;

        for(int i = 1; i <= n; i++){
            sum = 0;
            for(int j = 1; j <= n; j++){
                sum += dis[i][j];
            }
            if(v > sum){
                v = sum;
                ans = i;
            }
        }

        System.out.println(ans);
    }
}


/*
케빈 베이컨
n : 유저 수
m : 친구 관계의 수
 */