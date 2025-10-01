package baekjun.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P6236 {
    private static int[] money;
    private static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        money = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int start = Arrays.stream(money).max().getAsInt();
        int totalSum = Arrays.stream(money).sum();  // 모든 지출 합
        int end = totalSum; // 모든 지출의 합을 최댓값으로

        System.out.println(binarySearch(start, end));
    }

    private static int binarySearch(int start, int end) {
        int answer = end;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = findMoney(mid);

            if (count <= m) {       // 출금횟수가 m보다 작거나 같으면 좌측 탐색
                answer = mid;
                end = mid - 1;
            } else {                // 출금횟수가 m보다 크면 우측 탐색
                start = mid + 1;
            }
        }

        return answer;
    }

    private static int findMoney(int k) {
        int count = 1;
        int remain = k;

        for (int j : money) {
            if (remain < j) {
                count++;
                remain = k;
            }
            remain -= j;
        }

        return count;
    }
}