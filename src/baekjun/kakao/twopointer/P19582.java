package baekjun.kakao.twopointer;

import java.io.*;
import java.util.*;

public class P19582 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        long sum = 0L;        // 지금까지의 합
        long max = 0L;        // 지금까지중 최대
        boolean skip = false;

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());           // 이전 상금 상한선
            long p = Long.parseLong(st.nextToken());           // 현재 대회 상금

            if(sum <= x){                                       // 그냥 더해도 됨, 최대 갱신
                sum += p;
                max = Math.max(max, p);
            } else {
                if(skip){                                       // 스킵 썼음
                    System.out.println("Zzz");
                    return;
                }
                skip = true;
                if (p <= max && sum - max <= x) {
                    sum = sum - max + p;
                }
            }
        }

        System.out.println("Kkeo-eok");
    }
}

/*
200년간 폐관수련했더니 PS 최강자가 된 건에 대하여

대회마다 상금 상한 존재
모은 상금의 합이 그 대회의 상금 상한을 초과한다면 참가 불가
순서 정해짐 시간 안겹침
2개 이상의 대회를 참가할 수 없으면 안됨
적어도 n - 1개의 대회에 참가할 수 있는지

n : 올해 열리는 대회의 수
x : 대회에 참가하지 전까지 모은 상금의 합
p : 얻는 상금
 */