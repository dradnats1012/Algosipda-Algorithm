package baekjun.kakao.binarysearch;

import java.io.*;
import java.util.*;

public class P16401 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = Arrays.stream(arr).max().getAsInt();
        int total;
        int mid;

        while(left <= right){
            total = 0;
            mid = (left + right) / 2;
            for(int i = 0; i < n; i++){
                if(arr[i] >= mid) total += arr[i] / mid;   // 나눠줄 수 있음
            }

            if(total >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(right);
    }
}


/*
m : 조카의 수
n : 과자의 수
과자 n개의 길이 주어짐

조카들에게 같은 길이의 막대 과자를 나눠줘야 함
그 중 최대 출력

중간값으로 나눠줄 수 있는 과자의 개수를 셈
- 과자의 개수가 조카보다 많으면
  - 더 크게 쪼갤 수 있음 -> left 갱신
- 과자의 개수가 조카보다 적으면
  - 더 작게 쪼개야 함 -> right 갱신
 */
