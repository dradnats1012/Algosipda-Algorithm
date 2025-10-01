package baekjun.kakao.kruskal_prim;

import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {            // 간선 저장 클래스
    int w;              // 정점
    int cost;           // 가중치

    Edge(int w, int cost){
        this.w = w;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){       // 오름차순 정렬
        return this.cost - o.cost;
    }
}

public class Prim {

    private static List<Edge>[] graph;

    private static int prim(int start, int n){
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> pq = new PriorityQueue<>();     // 우선순위큐
        pq.offer(new Edge(start,0));                   // 시작점 넣기

        int total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.w;
            int cost = edge.cost;

            if(visited[v]) continue;            // 방문 했으면 건너뜀

            visited[v] = true;
            total+= cost;

            for(Edge e : graph[v]){
                if(!visited[e.w]){
                    pq.add(e);
                }
            }
        }

        return total;
    }
}

/*
프림(Prim) : 최소 신장 트리를 구하는 알고리즘
- 임의의 시작점에서 시작 -> 현재까지 연결되지 않은 정점들에 대해 가중치가 가장 작은 정점 연결
- 트리 집합 단계적 확장
- 새로운 정점을 연결할 때마다 새로운 정점에서 갈 수 있는 연결되지 않은 정ㅁ점에 댛나 간선 추가
- 우선 순위 큐로 가중치 우선도 판단하는듯

1. 임의의 정점을 시작점으로
2. 가중치가 가장 작은 점과 연결 -> 집합이 됨
3. 집합에서 갈 수 있는 가중치 가장 작은 정점 연결
4. 연결될 때까지 반복
 */