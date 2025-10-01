package baekjun.nsalgo.week8;

import java.io.*;
import java.util.*;

public class P1743 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] arr;
    private static boolean[][] visited;
    private static int n,m,k;
    private static ArrayDeque<int[]> q = new ArrayDeque<>();
    private static final int[] di = {-1,0,1,0};
    private static final int[] dj = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int r,c;
        int maxGarbage = 0;

        arr = new boolean[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr[r][c] = true;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(arr[i][j] && !visited[i][j]){
                    maxGarbage = Math.max(maxGarbage, bfs(i,j));
                }
            }
        }

        System.out.println(maxGarbage);
    }

    private static int bfs(int i, int j){
        int count = 1;
        visited[i][j] = true;
        q.offer(new int[] {i,j});

        while(!q.isEmpty()){
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            for(int d = 0; d < 4; d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if(1<=ni && ni <= n && 1 <= nj && nj <= m && !visited[ni][nj]){
                    if(arr[ni][nj] && !visited[ni][nj]){
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni,nj});
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
