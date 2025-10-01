package baekjun.kakao.bruteforce;

import java.io.*;
import java.util.*;

public class P14500 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int temp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j + 3 < m){  // 가로
                    temp = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3];
                    max = Math.max(max, temp);
                }
                if(i + 3 < n){  // 세로
                    temp = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j];
                    max = Math.max(max, temp);
                }
                if(i + 1 < n && j + 1 < m){  // 정사각형
                    temp = paper[i][j] + paper[i][j + 1] + paper[i + 1][j] + paper[i + 1][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < n && j + 1 < m) {   // ㄴ 기본
                    temp = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 2][j + 1];
                    max = Math.max(max, temp);
                }

                if (i + 2 < n && j + 1 < m) {   // ㄴ 좌우
                    temp = paper[i+2][j] + paper[i][j+1] + paper[i+1][j + 1] + paper[i + 2][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < n && j + 1 < m) {   // ㄴ 상항
                    temp = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < n && j + 1 < m) {   // ㄴ 상하 좌우
                    temp = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // ㄴ 오른쪽 회전
                    temp = paper[i][j] + paper[i+1][j] + paper[i][j+1] + paper[i][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // ㄴ 오른쪽 회전 상하
                    temp = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // ㄴ 오른쪽 회전 상하 좌우
                    temp = paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2] + paper[i][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // ㄴ 오른쪽 좌우
                    temp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 2 < n && j + 1 < m) {   // z
                    temp = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < n && j + 1 < m) {   // z
                    temp = paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // z
                    temp = paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // z
                    temp = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // ㅗ 기본
                    temp = paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < n && j + 2 < m) {   // ㅜ
                    temp = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < n && j + 1 < m) {   // ㅏ
                    temp = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+1][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < n && j + 1 < m) {   // ㅓ
                    temp = paper[i][j+1] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j + 1];
                    max = Math.max(max, temp);
                }
            }
        }

        System.out.println(max);
    }

}

/*
테트로미노
- 겹치면 안됨
- 도형은 연결되어 있어야 함
- 정사각형의 변끼리 연결되어 있어야 함

n x m 종이
각각의 칸에는 정수가 하나씩 있음
테트로미노가 놓인 칸에 ㅇ쓰여 있는 수들의 합을 최대로

아 한칸중 최대였음
 */