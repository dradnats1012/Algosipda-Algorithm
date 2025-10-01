package baekjun.kakao.unionfind;

import java.io.*;
import java.util.*;

public class P4195 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] parent;
    private static int[] size;

    private static int find(int x){
        if(parent[x] == x) return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static int union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return size[a];
        if(size[a] < size[b]){
            int tmp = a;
            a = b;
            b = tmp;
        }

        parent[b] = a;
        size[a] += size[b];
        return size[a];
    }

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int f = Integer.parseInt(br.readLine());

            parent = new int[f * 2];
            size = new int[f * 2];

            Map<String, Integer> id = new HashMap<>();
            int next = 0;

            for(int j = 0; j < f; j++){
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!id.containsKey(a)) {        // 맵에 없으면 추가
                    id.put(a, next);
                    parent[next] = next;
                    size[next] = 1;
                    next++;
                }if(!id.containsKey(b)){
                    id.put(b, next);
                    parent[next] = next;
                    size[next] = 1;
                    next++;
                }

                int aID = id.get(a);
                int bID = id.get(b);

                int nSize = union(aID, bID);
                System.out.println(nSize);
            }
        }
    }
}

/*
친구 네트워크
친구 관계가 생긴 순서대로 주어졌을 때, 친구 네트워크에 몇 명이 있는지 구하기

t : 테스트 케이스
f : 친구 관계의 수 <= 100,000
f개 줄 : 친구 관계가 생긴 순서대로
 */