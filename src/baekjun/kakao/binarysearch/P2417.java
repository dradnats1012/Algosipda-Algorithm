package baekjun.kakao.binarysearch;

import java.io.*;

public class P2417 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        long n = Long.parseLong(br.readLine());
        long min = 0;
        long max = n;
        long mid;
        long ans = 0;

        while(min <= max){
            mid = (min + max) / 2;
            if(n <= Math.pow(mid,2)){
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(ans);
    }
}

/*
정수가 주어지면 정수 제곱근 구하기
0 <= n < 2 ^ 63 -> long의 최대치

(min + max) / 2 를 제곱
- n 보다 작으면
  - min을 (min + max) / 2로 갱신
- n 보다 크면
  - max를 (min + max) / 2로 갱신

- 언제까지?
  - 작고 크고의 경계값 중 큰 값
  - 결국 중간에서 만남

- 정확히 제곱으로 떨어질 경우는?
*/