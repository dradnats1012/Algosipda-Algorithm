package baekjun.kakao.bruteforce;

import java.io.*;
import java.util.*;

public class P1107 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<Integer> gojang;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        gojang = new ArrayList<>();
        if (m > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                gojang.add(Integer.parseInt(st.nextToken()));
            }
        }

        if(n == 100){
            System.out.println(0);
            return;
        }

        int count;
        int min = Math.abs(n - 100);

        for(int i = 0; i <= 1000000; i++){
            String s = String.valueOf(i);

            boolean check = true;
            for(int j = 0; j < s.length(); j++){
                if(gojang.contains(s.charAt(j) - '0')){
                    check = false;
                    break;
                }
            }

            if (!check) continue;

            count = s.length() + Math.abs(i - n);
            min = Math.min(min, count);

        }

        System.out.println(min);
    }
}

/*
리모컨
버튼 0 ~ 9, +, -
채널 0에서 -를 누르면 가만히 있음
채널 N으로 가야함
현재 채널은 100
어떤 버튼이 고장났는지 주어졌을때 버튼을 최소 몇 번 눌러야 하는지??

n : 이동하려고 하는 채널
m : 고장난 버튼의 개수

 */