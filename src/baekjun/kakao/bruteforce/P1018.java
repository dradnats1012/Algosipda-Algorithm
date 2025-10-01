package baekjun.kakao.bruteforce;

import java.io.*;
import java.util.*;

public class P1018 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static String[] board;
    private static String[] ans = {"WBWBWBWB", "BWBWBWBW"};

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        board = new String[n];

        for(int i = 0; i < n; i++){
            board[i] = br.readLine();
        }

        int count = 100000000;

        for(int i = 0; i <= n - 8; i++){
            for(int j = 0; j <= m - 8; j++){
                int result = check(i, j, board);
                count = Math.min(count, result);
            }
        }

        System.out.println(count);
    }

    private static int check(int sRow, int sCol, String[] chess){
        int wCount = 0;

        for(int i = 0 ; i < 8; i ++){
            int row = sRow + i;
            for(int j = 0; j < 8; j++){
                int col = sCol + j;

                if(chess[row].charAt(col) != ans[row % 2].charAt(j)){
                    wCount++;
                }
            }
        }

        return Math.min(wCount, 64 - wCount);
    }
}


/*
체스판 다시 칠하기

m x n 보드
8 x 8 크기의 체스판 만들어야 함
 */