package baekjun.kakao.dijkstrafloid;

import java.io.*;
import java.util.*;

public class P1753 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        int[] result = new int[V + 1];          // 최단 경로값
        List<Node>[] list = new List[V + 1];    // 연결 정보 저장
        boolean[] visited = new boolean[V + 1]; // 방문 여부 저장

        for(int i = 1; i <= V; i++){            // 배열 초기화
            list[i] = new ArrayList<>();
            result[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());   // 출발
            int v = Integer.parseInt(st.nextToken());   // 도착
            int w = Integer.parseInt(st.nextToken());   // 가중치
            list[u].add(new Node(v, w));                // 인접 리스트(u에서 출발, v 도착, 가중치 w)
        }

        PriorityQueue<Node> q = new PriorityQueue<>();  // 다익 -> 우선순위큐
        result[K] = 0;                                  // 출발점 갱신
        q.offer(new Node(K,0));

        while(!q.isEmpty()){
            Node now = q.poll();                        // 현재 노드 뽑기
            visited[now.end] = true;                    // 방문 여부 갱신
            for(Node node : list[now.end]){             // 연결정보 뽑아오기(우선순위로)
                if(!visited[node.end]){                 // 방문하지 않았고
                    if(result[now.end] + node.weight < result[node.end]){   // 거리가 더 짧으면
                        result[node.end] = result[now.end] + node.weight;
                        q.offer(new Node(node.end, result[node.end]));
                    }
                }
            }
        }

        for(int i = 1; i <= V; i++){
            if(result[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(result[i]);
            }
        }
    }
}


/*
최단경로

주어진 시작점에서 다른 모든 정점으로의 최단 경로

v : 정점의 개수
e : 간선의 개수
k : 시작 정점의 번호

각 간선 (u, v, w) e개 주어짐
u 에서 v 로 가는 가중치 w인 간선
u와 v는 서로 다름
0 < w <= 10

i 번 정점으로의 최단 경로 경로값 출력
자신은 0
경로가 없으면 INF
 */