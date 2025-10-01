package baekjun.kakao.dfsbfs;

import java.io.*;
import java.util.*;

public class P5014 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] move;  // 클릭 수 저장할 배열
    private static int[] dir = new int[2];  // 위아래

    public static void main(String[] args) throws IOException{
        Queue<Integer> q = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        move = new int[f + 1];
        boolean[] check = new boolean[f + 1];   // 방문 여부
        q.add(s);
        check[s] = true;
        move[s] = 0;

        while(!q.isEmpty()){
            int pos = q.poll();     // 현재 위치
            if(pos == g) {          // 도착 했으면
                System.out.println(move[pos]);      // 클릭 수 출력
                return;
            }

            for(int i = 0; i < 2; i++){
                int next = pos + dir[i];
                if(next > f || next < 1) continue;

                if(!check[next]){       // 방문하지 않았으면
                    check[next] = true;
                    q.add(next);
                    move[next] = move[pos] + 1; // 기존 위치에서 클릭수 += 1
                }
            }
        }

        System.out.println("use the stairs");
    }
}


/*
스타트링크

f : 건물의 층수
g : 도착지
s : 현재 층수
u : 버튼을 누르면 위로 u만큼
d : 버튼을 누르면 아래로 d만큼

강호가 s -> g 로 가기위해 눌러야 하는 버튼의 수의 최솟값
이동 불가인 경우 `use the stairs`


 */