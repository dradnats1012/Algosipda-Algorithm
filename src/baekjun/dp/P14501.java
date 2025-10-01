package baekjun.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] tArr = new int[n + 1];
        int[] pArr = new int[n + 1];
        int[] resultArr = new int[n + 1];

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            tArr[i] = Integer.parseInt(st.nextToken());
            pArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < n; j++){
            if(j + tArr[j] <= n){       // 퇴사날 이전이면
                resultArr[j + tArr[j]] = Math.max(resultArr[j + tArr[j]], resultArr[j] + pArr[j]);      // 기존보다 큰 경우 갱신
            }
            resultArr[j + 1] = Math.max(resultArr[j], resultArr[j + 1]);
        }

        System.out.println(resultArr[n]);
    }
}
