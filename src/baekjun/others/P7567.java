package baekjun.others;

import java.io.*;
import java.util.*;

public class P7567 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        String[] arr = br.readLine().split("");
        int ans = 0;
        for(int i = 0; i < arr.length; i++){
            if(i == 0) ans += 10;
            else if (arr[i - 1].equals(arr[i])) ans += 5;
            else ans += 10;
        }

        System.out.println(ans);
    }
}



/*
그릇

그릇 높이 10cm
포개면 5cm만 증가
반대방향이면 10cm 증가
( 는 바로 놓인 상태
) 는 거꾸로 놓인 상태

이전과 비교해서 같으면 5만 증가 다르면 10 증가
 */
