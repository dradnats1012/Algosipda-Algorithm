package baekjun.kakao.kruskal_prim;

import java.io.*;
import java.util.*;

public class P1922 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] parent;

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());        // 컴퓨터
        int m = Integer.parseInt(br.readLine());        // 연결개수
        int edges[][] = new int[m][3];

        parent = new int[n + 1];

        for(int i = 0; i < m; i++){
            String[] input = br.readLine().split(" ");
            edges[i][0] = Integer.parseInt(input[0]);   // a 컴
            edges[i][1] = Integer.parseInt(input[1]);   // b 컴
            edges[i][2] = Integer.parseInt(input[2]);   // 가중치
        }

        Arrays.sort(edges, new Comparator<int[]>() {    // 정렬
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });

        for(int i = 0; i < n + 1; i++){
            parent[i] = i;
        }

        int result = 0;
        int count = 0;
        for(int i = 0; i < edges.length; i++){
            if(union(edges[i][0], edges[i][1])){
                result += edges[i][2];
                count++;
            }
            if(count == n - 1) break;
        }

        System.out.println(result);
    }

    private static int find(int x){
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
네트워크 연결
컴퓨터를 연결하는데 필요한 비용이 주어졌을 때 모든 컴퓨터를 연결하는데 필요한 최소 비용 출력
모든 컴퓨트럴 연결할 수 없는 경우는 없음

N : 컴퓨터의 수
M : 연결할 수 있는 선의 수
a 컴퓨터 b 컴퓨터 c 비용
 */