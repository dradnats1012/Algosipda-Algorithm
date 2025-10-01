package baekjun.kakao.unionfind;

import java.io.*;
import java.util.*;

public class P1976 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] parent;
    private static int[] size;
    private static int[] dir;

    private static int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;      // 같은 집합
        if(size[a] < size[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        size[a] += size[b];
    }

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        size = new int[n + 1];

        for(int i = 1; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 1; i <= n; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                int v = Integer.parseInt(st.nextToken());
                if(i == j) continue;
                if(v == 1){
                    union(i, j);
                }
            }
        }

        dir = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            dir[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m - 1; i++){
            if(find(dir[i]) != find(dir[i + 1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}


/*
여행 가자

N : 도시의 개수 <= 200
두 도시 사이에 길이 있을수도 없을수도 있음
여행 일정이 주어졌을때 이 여행 경로가 가능한지

M : 여행 계획에 속한 도시들의 수 <= 1000
n개의 정수
i번째 줄 j번쨰 수가 1이면 연결 0이면 연결X
마지막줄 여행계획

갈수 있다 -> 같은 집합에 있다
갈수 없다 -> 다른 집합에 있다

 */