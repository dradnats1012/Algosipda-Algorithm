package baekjun.class2;

import java.io.*;
import java.util.*;

public class P1966 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());           // 문서의 개수
            int m = Integer.parseInt(st.nextToken());           // 중요한 문서
            int num = 0;

            st = new StringTokenizer(br.readLine());

            Queue<Integer> q = new PriorityQueue<>();
            for(int j = 0; j < n; j++){
                int check = Integer.parseInt(st.nextToken());

                if(j == m){
                    num = check;
                }

                q.add(check);
            }

            for(int k = 1; k <= n; k++){
                if(q.poll() == num){
                    System.out.println(k);
                }
            }
        }

    }
}


/*
프린터 큐
현재 큐의 가장 앞에 있는 문서의 중요도 확인
나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면 인쇄하지 않고 가장 뒤에 배치

T : 테스트케이스의 수
N : 문서의 개수,  M : 특정 문서가 현재 큐에 몇번쨰에 있는지
중요도 차례대로

아 중복되는 수가 있어서 순서도 고려해야 함
 */