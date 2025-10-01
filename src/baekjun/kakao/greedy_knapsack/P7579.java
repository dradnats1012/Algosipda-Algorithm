package baekjun.kakao.greedy_knapsack;

import java.io.*;
import java.util.*;

public class P7579 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static class Cost{
        int m;
        int c;
        public Cost(int m, int c){
            this.m = m;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());           // 앱개수
        int m = Integer.parseInt(st.nextToken());           // 확보해야되는 메모리

        int[] aArr = new int[n];            // 사용중인거
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cArr = new int[n];            // 비활성화 비용
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            cArr[i] = Integer.parseInt(st.nextToken());
            sum += cArr[i];
        }

        int[] dp = new int[sum + 1];    // 최대 메모리

        for(int i = 0; i < n; i++){
            int w = cArr[i];
            int v = aArr[i];

            for(int c = sum; c >= w; c--){
                dp[c] = Math.max(dp[c], dp[c - w] + v);     // 이전과 비교
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++){
            if(dp[i] >= m){     // 커지면 종료
                ans = i;
                break;
            }
        }

        System.out.println(ans);
    }
}

/*
앱
n개의 앱
각각 m 바이트 메모리, 재실행 시 c
새로운 앱 b를 위해 추가로 M 바이트의 메모리가 필요
현재 활성화된 앱 중 몇개를 비활성화해야함
배활성화 했을 경우의 비용 c의 합을 최소화

비용이 활성화 비용이 가장 크면서 종료 비용이 작은거
이것도 dp가 아닌가
 */