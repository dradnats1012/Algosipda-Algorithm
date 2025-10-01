package baekjun.kakao.unionfind;

import java.io.*;
import java.util.*;

public class P1717 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] parent;
    private static int[] size;

    private static int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b){
        a = find(a);            // 각각 부모 찾음
        b = find(b);
        if(a == b) return;      // 부모가 같음 -> 이미 같은 집합

        if(size[a] < size[b]){  // 항상 큰쪽이 a로 오도록
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        size[a] += size[b];
    }

    public static void main (String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        size = new int[n + 1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int tp = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(tp == 0){
                union(a, b);
            }else {
                if(find(a) == find(b))
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
        }


    }
}

/*
집합의 표현

초기 n + 1 개의 집합
합집합 연산, 두 원소가 같은 집합에 포함되어 있는지 확인하는 연산

m : 입력으로 주어지는 연산의 개수
m개의 줄
0 a b : 합집합 -> a가 포함된 집합과 b가 포함된 집합을 합침
1 a b : a와 b가 같은 집합에 포함되어 있는지를 확인
1로 시작하는 입력에 대해서 a와 b가 같은 집합에 포함되어 있으면 YES 아니면 NO

처음에는 각자 다른 집합
이차원배열로 합치기? -> 매번 리스트 탐색해서 시간초과가 난다

union find
union -> 합집합
find -> 부모 찾기
항상 부모를 찾아서 연결해줌
 */
