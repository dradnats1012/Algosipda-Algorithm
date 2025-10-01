package baekjun.nsalgo.week11;

import java.io.*;
import java.util.*;

public class P18405 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] arr;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int n, k, s, x, y;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        List<int[]> first = new ArrayList<>();

        for(int i = 1; i <= n; i++){                            // 처음 바이러스
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] != 0){                             // 바이러스면
                    first.add(new int[] {arr[i][j], i, j, 0});  // 해당 값, 좌표, 시간
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        first.sort(Comparator.comparingInt(a -> a[0]));     // 바이러스 숫자기준 오름차순
        Queue<int[]> q = new ArrayDeque<>();
        for(int[] v : first){
            q.add(v);
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            int num = now[0];   // 바이러스 숫자
            int nX = now[1];    // x좌표
            int nY = now[2];    // y좌표
            int t = now[3];     // 시간
            if(t == s) break;   // 종료 조건

            for(int dir = 0; dir <4; dir++){
                int nnX = nX + dx[dir];
                int nnY = nY + dy[dir];
                if(nnX < 1 || nnY < 1 || nnX > n || nnY > n) continue;

                if(arr[nnX][nnY] == 0){     // 전염 안된곳
                    arr[nnX][nnY] = num;
                    q.add(new int[]{num, nnX, nnY, t + 1});
                }
            }
        }

        System.out.println(arr[x][y]);
    }
}


/*
백준 18405 경쟁적 전염

N x N 시험관
특정 위치 바이러스 존재 가능
바이러스 종류 1 ~ K
1초마다 상하좌우 방향으로 증식 -> 번호가 낮은 종류의 바이러스부터 증식 -> 이미 바이러스가 있는 칸에는 증식 불가
S초가 지난 후 (X,Y) 에 존재하는 바이러스의 종류 출력
시작 (1,1)

BFS
숫자가 낮은것부터 할 필요가 있을까?
처음부터 하되 이미 바이러스가 존재하면 작은 바이러스로 치환

언제 바뀐 바이러스인지 구분해야함
visited 배열이 필요할듯?
방문에 대한 갱신은 언제해야되지?
*/