package baekjun.nsalgo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11497 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] arr;
    private static int[] result;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());            // 배열 크기
            arr = new int[m];
            result = new int[m];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {                         // 배열 넣기
                arr[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);       // 오름차순 정렬

            int left = 0;
            int right = m - 1;
            for (int k = 0; k < m; k++) {       // 가운데가 가장 큰 수 좌우로 내려감
                if (k % 2 == 0) {
                    result[left] = arr[k];
                    left++;
                } else {
                    result[right] = arr[k];
                    right--;
                }
            }

            int min = -100000;

            for(int l = 1; l < m; l++){
                min = Math.max(min, Math.abs(result[l] - result[l-1]));
            }
            System.out.println(min);
        }
    }
}



/*
N개의 통나무를 원형으로
각 인접한 통나무의 높이 차가 최소가 되도록
난이도 -> 인접한 두 통나무 간의 높이의 차의 최댓값
한 줄에 주어진 통나무들로 만들 수 있는 최소 난이도 출력

순열 조합?
가장 차이가 덜 나는 배열을 찾아서 최소 난이도 출력 -> 브루트 포스? 이러면 시간초과 나지 않을까
가장 큰 수 양 옆에는 2,3번쨰로 큰 수가 나와야 함
 */