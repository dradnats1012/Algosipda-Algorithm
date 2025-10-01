package baekjun.kakao.greedy_knapsack;

import java.io.*;
import java.util.*;

public class P1202 {

    private static class Jewel {
        int m;
        int v;
        public Jewel(int m, int v){
            this.m = m;
            this.v = v;
        }
    }

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       // 보석수
        int k = Integer.parseInt(st.nextToken());       // 가방수

        Jewel[] jewels = new Jewel[n];
        for(int i = 0; i < n; i++){                     // 각 보석
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());   // 무게
            int v = Integer.parseInt(st.nextToken());   // 가격
            jewels[i] = new Jewel(m, v);
        }

        int[] bags = new int[k];
        for(int j = 0; j < k; j++){                     // 가방 무게
            bags[j] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparing(j -> j.m));    // 무게 오름차순
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 가격비싼순

        long total = 0;
        int id = 0;

        for(int b : bags){  // 용량 작은순
            while(id < n && jewels[id].m <= b) {    // 가방보다 작을때
                pq.offer(jewels[id].v);             // 그 가격 넣음
                id++;
            }

            if(!pq.isEmpty()){
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}


/*
보석 도둑

보석 N개
각 보석 무게 M, 가격 V
가방 K개
각 가방에 담을 수 있는 최대 무게는 C
가방에는 최대 한개의 보석
훔칠 수 있는 보석의 최대 가격

최대 1개의 보석 -> 가방 용량에서 가장 가까운 보석을 담아야 함
가방, 보석을 오름차순으로 정렬
가방보다 가벼운 보석들 중 가장 큰 보석 넣기

 */