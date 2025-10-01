package baekjun.kakao.unionfind;

import java.io.*;
import java.util.*;

public class P1043 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] parent;
    private static int[] size;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());               // 사람의 수
        int m = Integer.parseInt(st.nextToken());               // 파티의 수

        parent = new int[n + 1];
        size = new int[n + 1];

        for(int i = 0; i <= n; i++){
            parent[i] = i;
            size[i] = 1;
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());       // 진실아는사람
        List<Integer> truth = new ArrayList<>();
        for(int i = 0; i < t; i++){
            truth.add(Integer.parseInt(st.nextToken()));
        }

        for(int p : truth) {        // 합쳐
            union(0, p);
        }

        List<List<Integer>> party = new ArrayList<>();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            List<Integer> people = new ArrayList<>();

            for(int j = 0; j < count; j++){
                people.add(Integer.parseInt(st.nextToken()));
            }
            party.add(people);

            for(int k = 1; k < people.size(); k++){
                union(people.get(0), people.get(k));            // 같은 파티 참석자
            }
        }

        int root = find(0);
        int ans = 0;

        for(List<Integer> p : party){
            boolean lie = true;
            for(int pl : p){
                if(find(pl) == root){
                    lie = false;
                    break;
                }
            }
            if(lie) ans++;
        }

        System.out.println(ans);
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

    private static int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}


/*
거짓말

사람 수 N
진실을 아는 사람의 수와 번호
m개의 줄
각 파티마다 오는 사람의 수와 번호
 */