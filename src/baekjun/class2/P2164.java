package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class P2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> cards = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            cards.add(i + 1);
        }

        while (cards.size() != 1) {
            cards.poll();
            cards.offerLast(cards.poll());
        }

        System.out.println(cards.peekLast());
    }
}
