package baekjun.kakao.twopointer;

import java.io.*;
import java.util.*;

public class P20922 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] arr;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int s = Integer.parseInt(st.nextToken());
            arr[i] = s;
        }

        int left = 0;
        int right = 0;
        int max = 0;

        while(left <= right){
            if(right < n){
                int newV = arr[right];              // 오른쪽 숫자 꺼내와
                int count = map.getOrDefault(newV, 0);      // 개수 가져와
                if(count < k){                     // 오른쪽에 들어온 숫자의 개수가 k이하
                    map.put(newV, count + 1);
                    right++;
                    max = Math.max(max, right - left);
                } else {               // 오른쪽에 들어온 숫자가 k초과 -> 왼쪽 버려야됨
                    int trash = arr[left];
                    left++;
                    map.put(trash, map.get(trash) - 1);
                }
            } else {
                if(left == right) break;
                int trash = arr[left];
                map.put(trash, map.get(trash) - 1);
                left++;
            }
        }

        System.out.println(max);
    }
}

/*
겹치는건 싫어
수열에서 같은 원소가 여러 개 들어있는 수열을 싫어함
같은 원소가 k개 이하로 들어있는 최장 연속 부분 수열의 길이

100,000 이하 양의 정수로 이루어진 길이가 n인 수열
같은 정수를 k개 이하로 포함한 최장 연속 부분 수열의 길이

- 개수 배열과 입력 배열을 분리? || 맵에 저장?
- 언제 오른쪽을 증가하고 언제 왼쪽을 증가할까
  - 오른쪽을 증가시키다가 k보다 많아지면 왼쪽을 증가?
  - 이건 k보다 작아진다는 보장이 있는가
  -
 */