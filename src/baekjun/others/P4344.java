package baekjun.others;

import java.io.*;
import java.util.*;

public class P4344 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int total = 0;
            int[] nums = new int[n];
            int count = 0;

            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
                total += nums[j];
            }

            double avg = total / n;

            for (int k = 0; k < n; k++) {
                if (nums[k] > avg) {
                    count++;
                }
            }

            double percent = (double)count / (double)n * 100;

            System.out.printf("%.3f%%\n", percent);
        }
    }
}


/*
평균은 넘겠지
C : 테스트케이스의 개수
케이스마다
학생수 N
N명의 점수
0 <= 점수 <= 100
평균을 넘는 학생들의 비율
 */