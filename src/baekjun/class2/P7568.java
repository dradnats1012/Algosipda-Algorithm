package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int[][] inputArr = new int[N][2];
        int[] resultArr = new int[N];
        int count;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            inputArr[i][0] = Integer.parseInt(st.nextToken());
            inputArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int j = 0; j < N; j++) {
            count = 0;
            for (int k = 0; k < N; k++) {
                if (inputArr[j][0] < inputArr[k][0]
                    && inputArr[j][1] < inputArr[k][1]) {
                    count++;
                }
            }
            resultArr[j] = count + 1;
        }

        for (int l = 0; l < N; l++) {
            System.out.print(resultArr[l] + " ");
        }
    }
}
