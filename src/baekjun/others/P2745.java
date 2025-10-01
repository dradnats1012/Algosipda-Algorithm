package baekjun.others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());

        System.out.println(converter(n, b));
    }

    private static int converter(String n, int b) {
        char[] nums = n.toCharArray();
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 'A') {
                answer = answer * b + (nums[i] - 'A' + 10);
            } else {
                answer = answer * b + (nums[i] - '0');
            }
        }

        return answer;
    }
}
