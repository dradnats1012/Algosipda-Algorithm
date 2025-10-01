package baekjun.kakao.greedy_knapsack;

import java.io.*;
import java.util.*;

public class P12865 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static class Mulgun{
        int w;
        int v;

        public Mulgun(int w, int v){
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 물건 수
        int k = Integer.parseInt(st.nextToken());   // 가방 용량

        Mulgun[] mulguns = new Mulgun[n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            mulguns[i] = new Mulgun(w, v);  // 물건 가방에 넣음
        }

        int[] dp = new int[k + 1];

        for(int i = 0; i < n; i++){
            int w = mulguns[i].w;
            int v = mulguns[i].v;

            for(int bag = k; bag >= w; bag--){      // 현재 무게를 뺀거에서 더한거 확인용
                int tmp = dp[bag - w] + v;          // 지금꺼 담음
                if(tmp > dp[bag]) dp[bag] = tmp;    // 그게 더 크면 갱신
            }
        }

        System.out.println(dp[k]);
    }
}


/*
평범한 배낭
n개의 물건
각 물건 무게 w, 가치 v
최대 k만큼의 무게
배낭에 넣을 수 있는 물건들의 가치의 최댓값

용량이 작은데 가치가 높은 물건을 넣어햐됨
물건은 못쪼갬

가치를 무게로 나눠서 가장 큰 순서? -> 용량 넘치면 그 다음 높은걸로? -> 오류날것 같음
이전 최적해에다가 물건을 넣어보면서 가장 작은거 갱신 -> dp 아닌가
 */