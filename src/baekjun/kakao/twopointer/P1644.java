package baekjun.kakao.twopointer;

import java.io.*;
import java.util.*;

public class P1644 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] sosu;
    private static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        sosu = new boolean[n + 1];
        for(int i = 2; i <= n; i++) {
            sosu[i] = true;             // 처음은 다 소수임(1빼고)
        }

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(!sosu[i]) continue;      // 소수가 아니면 패스
            for(int j = 2; i * j <= n; j++) sosu[i * j] = false;    // 배수를 !소수로
        }

        for(int i = 2; i <= n; i++){
            if(sosu[i]){
                prime.add(i);
            }
        }

        int count = 0;
        int sum = 0;
        int left = 0;
        int right = 0;

        while(true) {                       // 투포인터
            if(sum >= n){                   // 합보다 크면
                if(sum == n) count++;
                sum -= prime.get(left++);   // 왼쪽 뺌
            }else {                         // 합보다 작으면
                if(right == prime.size()){
                    break;
                }
                sum += prime.get(right++);  // 오른쪽 더함
            }
        }

        System.out.println(count);
    }
}


/*
소수의 연속합

하나 이상의 연속된 소수의 합
한 소수는 한번만 사용

*/
