package baekjun.nsalgo.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class P2531 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] arr;       // 초밥 담는 배열

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());   // 접시 수
        int d = Integer.parseInt(st.nextToken());   // 가짓수
        int k = Integer.parseInt(st.nextToken());   // 연속접시 수
        int c = Integer.parseInt(st.nextToken());   // 쿠폰번호

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> temp = new HashSet<>();
        int max = 0;
        int count;

        for (int j = 0; j < n; j++) {
            temp.clear();
            temp.add(arr[j]);           // 초기값 넣기

            for (int l = 1; l < k; l++) {
                int index = (j + l) % n;
                temp.add(arr[index]);
            }

            if (!temp.contains(c)) {
                count = temp.size() + 1;
                max = Math.max(max, count);
            } else {
                count = temp.size();
                max = Math.max(max, count);
            }

        }
        System.out.println(max);
    }
}
