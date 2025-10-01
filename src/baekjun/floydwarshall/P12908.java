package baekjun.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P12908 {
    public static Node[] nodes;
    public static long[][] distance;
    public static int xs, ys, xe, ye;
    public static int INF = Integer.MAX_VALUE;

    public static class Node {  // 각 좌표를 저장하는 Node 클래스
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        nodes = new Node[8];            // 노드 저장 배열
        distance = new long[8][8];      // 플로이드 워셜 배열

        xs = Integer.parseInt(st.nextToken());  // 시작 위치
        ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        xe = Integer.parseInt(st.nextToken());  // 도착 위치
        ye = Integer.parseInt(st.nextToken());

        nodes[0] = new Node(xs, ys);
        nodes[7] = new Node(xe, ye);
        for (int i = 0; i < 8; i++) {
            Arrays.fill(distance[i], INF);      // 배열 초기화
        }

        distance[0][7] = distance[7][0] = Math.abs(xs - xe) + Math.abs(ys - ye);    // 거리 계산
        for (int i = 1; i < 7; i += 2) {                                            // 텔레포트 입력 받기 - 2개씩 입력 들어와서 += 2
            st = new StringTokenizer(br.readLine(), " ");
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));        // 좌표 노드 저장
            nodes[i + 1] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            distance[i][i + 1] = distance[i + 1][i] = Math.min(
                Math.abs(nodes[i].x - nodes[i + 1].x) + Math.abs(nodes[i].y - nodes[i + 1].y), 10);         // 텔포 10초 걸림
        }

        for (int i = 0; i < 8; i++) {                                                           // 반복하면서 거리 갱신
            for (int j = 0; j < 8; j++) {
                distance[i][j] = Math.min(distance[i][j],                                       // 기존 거리와 비교해서 짧은거
                    Math.abs(nodes[i].x - nodes[j].x) + Math.abs(nodes[i].y - nodes[j].y));
            }
        }

        for (int k = 0; k < 8; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]); // 중간 거리 비교
                }
            }
        }

        System.out.println(distance[0][7]);
    }
}