package baekjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] tomatoes = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();
        int count = -1;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    tomatoes[i][j][k] = tomato;
                    if (tomato == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        int[][] directions = {
            {1, 0, 0}, {-1, 0, 0}, {0, 1, 0},
            {0, -1, 0}, {0, 0, 1}, {0, 0, -1}
        };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] temp = queue.poll();
                int h = temp[0];
                int n = temp[1];
                int m = temp[2];

                for (int[] dir : directions) {
                    int nh = h + dir[0];
                    int nn = n + dir[1];
                    int nm = m + dir[2];

                    if (nh >= 0 && nh < H && nn >= 0 && nn < N && nm >= 0 && nm < M) {
                        if (tomatoes[nh][nn][nm] == 0) {
                            tomatoes[nh][nn][nm] = 1;
                            queue.add(new int[]{nh, nn, nm});
                        }
                    }
                }
            }
            count++;
        }

        // 모든 토마토가 익었는지 확인
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomatoes[i][j][k] == 0) {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }

        System.out.println(count);
    }
}