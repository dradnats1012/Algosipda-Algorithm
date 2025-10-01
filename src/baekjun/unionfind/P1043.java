package baekjun.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class P1043 {
    static int[] parent;
    static boolean[] truth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 사람의 수
        int m = Integer.parseInt(st.nextToken());   // 파티의 수

        parent = new int[n + 1];        // 자기 자신 부모 설정 -> 초기화하는거
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCount = Integer.parseInt(st.nextToken());   // 진실을 아는 사람의 수
        truth = new boolean[n + 1];

        for (int i = 0; i < knowCount; i++) {
            int person = Integer.parseInt(st.nextToken());
            truth[person] = true; // 진실을 아는 사람 저장
        }

        List<List<Integer>> parties = new ArrayList<>();    // 파티 정보
        for (int j = 0; j < m; j++) {
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());

            List<Integer> party = new ArrayList<>();
            int firstPerson = -1; // 첫 번째 사람 저장

            for (int k = 0; k < partyPeople; k++) {
                int num = Integer.parseInt(st.nextToken());
                party.add(num);

                if (firstPerson == -1) {
                    firstPerson = num; // 첫 번째 사람 선택
                } else {
                    union(firstPerson, num); // 같은 파티 내 사람들은 연결
                }
            }
            parties.add(party);
        }

        Set<Integer> truthRootSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (truth[i]) {
                truthRootSet.add(find(i)); // 진실을 아는 사람들의 루트 노드
            }
        }

        int count = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;

            for (int person : party) {
                if (truthRootSet.contains(find(person))) {
                    canLie = false; // 진실을 아는 그룹에 속하면 거짓말 불가
                    break;
                }
            }

            if (canLie) count++;
        }

        System.out.println(count);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);
        return parent[x];
    }
}
