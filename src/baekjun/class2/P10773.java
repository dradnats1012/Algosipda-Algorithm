package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int input;
        int total = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                stack.pop();
            } else {
                stack.push(input);
            }
        }

        int h = stack.size();

        for (int j = 0; j < h; j++) {
            total += stack.pop();
        }

        System.out.println(total);
    }
}
