package baekjun.kakao.dijkstrafloid;

import java.io.*;
import java.util.*;

public class P10282 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    static class Node implements Comparable<Node> {
        int end;
        int sec;

        public Node(int end, int sec) {
            this.end = end;
            this.sec = sec;
        }

        @Override
        public int compareTo(Node n) {
            return this.sec - n.sec;
        }
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());       // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken());       // 의존성 개수
            int c = Integer.parseInt(st.nextToken());       // 해킹컴 번호

            int[] result = new int[n + 1];                  // 경로값
            List<Node>[] list = new List[n + 1];            // 연결 정보
            boolean[] visited = new boolean[n + 1];         // 방문 여부

            for (int j = 1; j <= n; j++) {                    // 배열 초기화
                list[j] = new ArrayList<>();
                result[j] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());   // 출발
                int b = Integer.parseInt(st.nextToken());   // 도착
                int s = Integer.parseInt(st.nextToken());   // 시간
                list[b].add(new Node(a, s));                // 의존성 반대로임 a가 b 에 의존
            }

            PriorityQueue<Node> q = new PriorityQueue<>();  // 우선순위큐로 가장 짧은 거리 가져옴
            result[c] = 0;                                  // 해킹컴 자신
            q.offer(new Node(c, 0));                   // 해킹컴부터 시작

            while (!q.isEmpty()) {
                Node now = q.poll();
                visited[now.end] = true;                    // 방문처리 -> 가장 짧은거를 가져오면 최단 거리이기 때문에 이후 반복 방지
                for (Node node : list[now.end]) {
                    if (!visited[node.end]) {
                        if (result[now.end] + node.sec < result[node.end]) {    // 기존보다 새로운 경로가 짧을 떄
                            result[node.end] = result[now.end] + node.sec;      // 갱신
                            q.offer(new Node(node.end, result[node.end]));      // 큐에 추가
                        }
                    }
                }
            }

            int count = 0;
            int max = 0;
            for (int j = 1; j <= n; j++) {
                if (result[j] != Integer.MAX_VALUE) {
                    count++;
                    max = Math.max(max, result[j]);
                }
            }

            System.out.println(count + " " + max);
        }
    }
}


/*
해킹
컴퓨터 a 가 b에 의존한다면 감염됨 -> 단방향
t : 테스트 케이스의 개수 (최대 100)
n : 컴퓨터 개수
d : 의존성 개수
c : 해킹당한 컴퓨터 번호

a, b, s : 컴퓨터 a가 b를 의존, b가 감염되면 s초 후에 a도 감염됨

테스트케이스마다 감염되는 컴퓨터 수, 마지막 컴퓨터가 감염되기까지 걸리는 시간 출력
 */