package baekjun.unionfind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P10451 {
    static int[] parents;
    static int cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            parents = new int[n + 1];
            cycle = 0;
            for (int i = 1; i < n + 1; i++) {
                parents[i] = i;
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                int a = i;
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            sb.append(cycle + "\n");
        }

        System.out.println(sb.toString());
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            cycle++;

        else if (x > y)
            parents[x] = y;
        else
            parents[y] = x;
    }

    private static int find(int x) {
        if (parents[x] == x)
            return x;

        return find(parents[x]);
    }
}


/*
순열 사이클
1 ~ N 정수 N개
순열 사이클의 개수 -> 배열에 있는 숫자의 개수

*/