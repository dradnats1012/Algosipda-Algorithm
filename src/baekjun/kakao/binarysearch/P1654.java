package baekjun.kakao.binarysearch;

import java.io.*;
import java.util.*;

public class P1654 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[] arr;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());
        long left = 1;
        long right = 0;

        arr = new long[k];
        for(int i = 0; i < k; i++){
            arr[i] = Long.parseLong(br.readLine());
            right = Math.max(right, arr[i]);
        }

        long mid;
        long count;

        while(left <= right){
            mid = (left + right) / 2;
            count = 0;

            for(int i = 0; i < k; i++){
                count += arr[i] / mid;
            }

            if(count < n){      // 덜 잘림 -> 큼 -> 더 작게 -> right 갱신
                right = mid - 1;
            } else if(count >= n) {  // 더/딱맞게 잘림 ->
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}


/*
K : 가지고 있는 랜선 개수
N : 필요한 랜선 개수
이미 가지고 있는 각 랜선의 길이 입력
만들 수 있는 최대 랜선의 길이?
 */