package baekjun.kakao.dp;

import java.io.*;
import java.util.*;

public class P12015 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] C = new int[n];
        int len = 0;

        for (int x : arr) {
            int idx = Arrays.binarySearch(C, 0, len, x);    // 정렬된 C 배열에서 x 의 위치 찾음
            if (idx < 0) idx = -idx - 1;
            C[idx] = x;
            if (idx == len) len++;
        }

        System.out.println(len);
    }
}


/*
가장 긴 증가하는 부분 수열 2
재귀방식 -> 시간초과 뜸

private static int lis (List<Integer> arr){
        if(arr.isEmpty()) return 0;
        int ret = 0;
        for(int i = 0; i < arr.size(); i++){
            List<Integer> b = new ArrayList<>();
            for(int j = i + 1; j < arr.size(); j++){
                if(arr.get(i) < arr.get(j)){
                    b.add(arr.get(j));
                }
            }
            ret = Math.max(ret, 1 + lis(b));
        }

        return ret;
    }

더 빠른 해법
텅 빈 수열에서 시작
숫자 하나씩 추가하며 각 길이를 갖는 증가 수열 중 가장 마지막 수가 작은것을 저장
C[i] : 지금까지 만든 배열이 갖는 길이가 I인 증가 부분 수열 중 최소 마지막 값
이걸 어떻게 활용하지
C[] 는 항상 순증가
왜 항상 순증가지

C[k] : 길이가 k + 1인 증가 부분 수열들 중에서 가장 마지막 원소의 최소
마지막 값이 작을수록 유리

 */