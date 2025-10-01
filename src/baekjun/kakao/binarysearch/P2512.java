package baekjun.kakao.binarysearch;

import java.io.*;
import java.util.*;

public class P2512 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }
        int m = Integer.parseInt(br.readLine());

        int left = 0;
        int right = m;
        int mid;
        int sum;

        while(left <= right){
            if(total <= m) {     // 전부 배정 가능
                System.out.println(Arrays.stream(arr).max().getAsInt());
                return;
            }
            // 전부 배정 불가능
            sum = 0;
            mid = (left + right) / 2;
            for(int i = 0; i < n; i++){
                if(arr[i] < mid){
                    sum += arr[i];
                }else {
                    sum += mid;
                }
            }
            if(sum > m){
                right = mid - 1;
            } else left = mid + 1;
        }

        System.out.println(right);
    }
}


/*
총액 이하 가능한 최대의 예산 배정

1. 모든 요청이 배정될 수 있는 경우 요청 금액 그대로 배정
2. 모든 요청 배절될 수 없는 경우 상한액을 계산 -> 그 이상인 예산 요청에는 상한액 배정, 상한액 이하는 요청한 금액만큼

n : 지방의 수
각 지방의 예상요청 정수 n 개
m : 총 예산

배정된 예산 중 최대 정수 출력

다 더했을때 총 예산보다 작으면 -> 요청 중 최대값
다 더했을때 총 예산보다 크면
  - 중간 값 찾기
    - 요청보다 중간값이 크면 -> 요청값을 더함
    - 요청보다 중간값이 작으면 -> 중간값을 더함
    - 모든 합이 총 예산의 아래가 되어야 함
        - 모든 합이 총 예산보다 크면 -> 상한이 너무 큼 -> 상한을 줄여야 함 -> right를 갱신
        - 모든 합이 총 예산보다 작으면 -> 상한을 늘려야 함 -> left를 갱신
 */