package baekjun.kakao.dfsbfs;

import java.io.*;
import java.util.*;

public class P17141 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[][] map;
    private static int[] selected;      // 조합으로 선택된 배열 저장
    private static List<Point> virus;   //
    private static Queue<Point> q;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int n, m;
    private static int result = Integer.MAX_VALUE;

    private static class Point{         // 위치 저장용 클래스
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        virus = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2){     // 바이러스면
                    map[i][j] = 0;
                    virus.add(new Point(i, j));
                }
                if(map[i][j] == 1){     // 벽이면
                    map[i][j] = -1;
                }
            }
        }

        selected = new int[m];
        comb(0, 0);

        if(result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    private static void comb(int start, int count){     // 조합 찾기
        if(count == m){                                 // m개의 숫자를 가진 조합
            result = Math.min(result, countTime());     // 최소시간 갱신
            return;
        }
        for(int i = start; i < virus.size(); i++){
            map[virus.get(i).x][virus.get(i).y] = 2;        //
            selected[count] = i;    // 바이러스 자리 선택
            comb(i + 1, count + 1);         // 재귀로 조합 만들기
            map[virus.get(i).x][virus.get(i).y] = 0;
        }
    }

    private static int countTime(){
        int[][] time = new int[n][n];
        q = new ArrayDeque<>();

        for(int i = 0; i < m; i++){
            q.offer(virus.get(selected[i]));    // 바이러스 위치 초기화
        }

        while(!q.isEmpty()){
            Point now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;    // 경계값
                if(map[nx][ny] != 0 || time[nx][ny] != 0) continue;     // 빈칸

                q.offer(new Point(nx, ny));                 // 큐에 추가
                time[nx][ny] = time[now.x][now.y] + 1;      // 기존 거리 + 1
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if (map[i][j] == -1) continue;      // 벽

                if(time[i][j] == 0 && map[i][j] == 0){      // 바이러스 전부 안퍼지면
                    return Integer.MAX_VALUE;
                }

                max = Math.max(max, time[i][j]);
            }
        }

        return max;
    }
}


/*
연구소 2
m : 연구소 특정 위치 바이러스 개수
n x n 정사각형
빈칸과 벽으로 잉루어짐
상하좌우 인접 빈칸으로 동시 복제

총 바이러스의 개수중 m개 뽑기


 */