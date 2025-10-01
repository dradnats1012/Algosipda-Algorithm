package baekjun.kakao.kruskal_prim;

import java.io.*;
import java.util.*;

public class Kruskal {

    public static int[] parent;
    public static int[] size;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        int V = Integer.parseInt(input[0]);     // 정점
        int E = Integer.parseInt(input[1]);     // 간선
        int edges[][] = new int[E][3];          // 정점 정보, 가중치
        parent = new int[V + 1];

        for(int i = 0; i < E; i++){
            String[] input2 = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(input2[0]);       // 정점 1
            edges[i][1] = Integer.parseInt(input2[1]);       // 정점 2
            edges[i][2] = Integer.parseInt(input2[2]);       // 가중치
        }

        Arrays.sort(edges, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[2], o2[2]);       // 가중치 비료
            }
        });

        for(int i = 0; i < V + 1; i++){
            parent[i] = -1;
        }

        int result = 0;
        int count = 0;
        for(int i = 0; i < edges.length; i++){
            if(union(edges[i][0], edges[i][1])){
                result += edges[i][2];
                count++;
            }
            if(count == V - 1) break;
        }

        System.out.println(result);
    }

    private static int find (int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static boolean union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) {            // 다른 집합 연결
            parent[b] = a;
            return true;
        }

        return false;
    }
}


/*
Spanngin Tree(신장 트리)
: 무방향 그래프 G(V,E)에서 E에 속한 간선들로 사이클을 포함하지 않으며 모든 정점 V를 연결한 부분 그래프
n개의 정점을 갖는 그래프에서 신장 트리에 속하는 간선수는 N-1, 사이클 없음

MST(Minimum Spanning Tree) 최소 신장 트리
: 간선들의 가중치 합이 최소인 신장 트리

Kruskal (크루스칼) : 최소 신장 트리를 구하는 알고리즘
- 탐욕적으로 최소비용으로 연결
- 모든 간선을 가중치 기준 오름차순 정렬
- 순서대로 모든 정점이 연결될 떄까지
- union-find로 구현 가능
- 간선 정렬 로직이 시간 복잡도 좌우

 */