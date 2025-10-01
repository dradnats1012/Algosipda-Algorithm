package baekjun.kakao.dijkstrafloid;

import java.io.*;
import java.util.*;

public class P2458 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] check = new boolean[n][n];

        int a, b;
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            check[a][b] = true;
        }

        for(int k = 0; k < n; k++){             // 중간
            for(int i = 0; i < n; i++){         // 시작
                for(int j = 0; j < n; j++){     // 도착
                    if(check[i][k] && check[k][j]){     // 중간이 연결되면 시작과 끝도 연결
                        check[i][j] = true;
                    }
                }
            }
        }

        int[] count = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(check[i][j] || check[j][i]){
                    count[i]++;
                }
            }
        }

        int answer = 0;
        for(int num : count){
            if(num == n - 1) answer++;
        }

        System.out.println(answer);
    }
}

/*
키 순서
n 명의 학생 키 비교 결과 주어짐
학생들의 키는 모두 다름
m : 키를 비교한 횟수

자신의 키가 몇번쨰인지 알 수 있는 학생의 수 출력

나보다 큰 사람 + 나보다 작은 사람 = N - 1 이 되어야함
 */