package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Deque<Integer> q = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop")) {
                if (q.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(q.poll());
                }
            } else if (command.equals("size")) {
                System.out.println(q.size());
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (command.equals("front")) {
                if (q.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(q.element());
                }
            } else if (command.equals("back")) {
                if (q.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(q.peekLast());
                }
            }
        }
    }
}
