package baekjun.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int k = 0; k < t; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            String[][] grid = new String[h][w];

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    grid[i][j] = String.valueOf(line.charAt(j));
                }
            }

            int count = 0;
            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(grid[i][j].equals("#")){
                        dfs(grid, i, j, h, w);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(String[][] grid, int x, int y, int h, int w) {
        if(x < 0 || x >= h || y < 0 || y >= w || !grid[x][y].equals("#")){
            return;
        }

        grid[x][y] = ".";

        dfs(grid, x - 1, y, h, w);
        dfs(grid, x + 1, y, h, w);
        dfs(grid, x, y - 1, h, w);
        dfs(grid, x, y + 1, h, w);
    }
}
