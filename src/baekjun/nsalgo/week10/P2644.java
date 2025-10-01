package baekjun.nsalgo.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2644 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static boolean[] check;
    private static List<Integer>[] relation;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        relation = new ArrayList[n + 1];
        check = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());   // 앞
        int y = Integer.parseInt(st.nextToken());   // 뒤
        int l = Integer.parseInt(br.readLine());    // 개수

        for (int j = 0; j < l; j++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            relation[p].add(c);     //  자식 삽입
            relation[c].add(p);     //  부모 삽입
        }

        dfs(x, y, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int end, int count) {
        if (start == end) {
            result = count;
            return;
        }

        check[start] = true;
        for (int i = 0; i < relation[start].size(); i++) {
            int next = relation[start].get(i);
            if (!check[next]) {
                dfs(next, end, count + 1);
            }
        }
    }
}
