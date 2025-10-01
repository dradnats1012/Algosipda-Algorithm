package baekjun.kakao.unionfind;

import java.io.*;
import java.util.*;

public class P1765 {

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
        a = find(a);
        b = find(b);
        if(a == b) return;

        if(size[a] < size[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        size[a] += size[b];
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[2 * n + 1];
        size = new int[2 * n + 1];

        for (int i = 1; i <= 2 * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String tp = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (tp.equals("F")) {
                union(a, b);
                union(a + n, b + n);        // 친구가 되면 친구의 적도 나의 적임
            } else {
                union(a, b + n);                // 나의 적은 b의 친구, b의 적은 내 친구
                union(a + n, b);
            }
        }

        Set<Integer> roots = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            roots.add(find(i));
        }

        System.out.println(roots.size());
    }
}


/*
닭싸움 팀 정하기
친구의 친구는 친구
원수의 원수도 친구
F는 친구
E는 적

원수 관리는 어떻게 하지

 */