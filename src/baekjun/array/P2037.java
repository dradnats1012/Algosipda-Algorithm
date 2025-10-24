package baekjun.array;

import java.io.*;
import java.util.*;

public class P2037 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr = {0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7};
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        
    }
}

/*
문자메시지
영어 메시지 치는데 걸리는 최소 시간
1번은 공백

같은 칸에 있는 문자인 경우를 어떻게 판단?
p : 버튼을 한번 누르는데 걸리는 시간
w : 같은 숫자인 문자를 연속으로 찍기 위해 기다리는 시간
 */