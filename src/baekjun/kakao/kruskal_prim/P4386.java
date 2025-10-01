package baekjun.kakao.kruskal_prim;

import java.io.*;
import java.util.*;

public class P4386 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static class Star{
        double x;
        double y;

        public Star(double x, double y){
            this.x = x;
            this.y = y;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int to;
        double weight;
        public Edge(int to, double weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge ot){
            return Double.compare(this.weight, ot.weight);
        }
    }

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        Star[] stars = new Star[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);  // 별들 넣음
        }

        boolean[] visit = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        visit[0] = true;
        for(int i = 1; i < n; i++){
            pq.add(new Edge(i, distance(stars[0], stars[i])));  // 거리 구함
        }

        double total = 0;
        int count = 1;

        while(count < n) {          // 다 이을때까지
            Edge e = pq.poll();
            if(visit[e.to]) continue;   // 이미 별자리에 있음
            visit[e.to] = true;
            total += e.weight;
            count++;

            for(int i = 0; i < n; i++){
                if(!visit[i]){
                    pq.add(new Edge(i, distance(stars[e.to], stars[i])));  // 새로운 별에 있는 연결 추가
                }
            }
        }

        System.out.printf(Locale.US, "%.2f%n", total);
    }

    private static double distance(Star a, Star b){
        return Math.hypot(a.x - b.x, a.y - b.y);
    }
}


/*
별자리 만들기
n개의 별들을 이어서 별자리를 하나 만들기
- 서로 다른 두 별을 일직선ㅇ로
- 모든 별은 직간접적으로 이어져야 함
별자리를 만드는 최소 비용

n : 별의 개수
x, y 좌표 실수 - 최대 소수점 둘째
절대/상대 오차는 0.01까지 허용

 */