package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double total = 0;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(br.readLine()));
        }

        int size = deque.size();
        int cut = (int)Math.round(size * 0.15);

        List<Integer> list = new ArrayList<>(deque);
        Collections.sort(list);
        Deque<Integer> sortedDeque = new ArrayDeque<>(list);

        for (int j = 0; j < cut; j++) {
            sortedDeque.removeFirst();
            sortedDeque.removeLast();
        }

        int afterSize = sortedDeque.size();
        while (sortedDeque.size() != 0) {
            total += sortedDeque.removeLast();
        }

        int everage = (int)Math.round(total / afterSize);

        System.out.println(everage);
    }
}
