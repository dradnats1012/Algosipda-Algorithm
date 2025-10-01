package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P10816 {
    private static List<Integer> sgArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sgArr.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(sgArr);

        List<Integer> mArr = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
            mArr.add(Integer.parseInt(st.nextToken()));
        }

        for (int j = 0; j < M; j++) {
            int low = findFirst(mArr.get(j));
            int high = findLast(mArr.get(j));
            sb.append(high - low).append(" ");
        }
        System.out.println(sb);
    }

    public static int findFirst(int key) {
        int low = 0;
        int high = sgArr.size();
        int mid;

        while (low < high) {
            mid = (low + high) / 2;

            if (sgArr.get(mid) >= key) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static int findLast(int key) {
        int low = 0;
        int high = sgArr.size();
        int mid;

        while (low < high) {
            mid = (low + high) / 2;

            if (key < sgArr.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
