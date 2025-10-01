package baekjun.nsalgo.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2503 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static final boolean[] possible = new boolean[1000];

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 123; i < 1000; i++) { // 가능한 수 찾기
            String str = Integer.toString(i);

            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0')
                continue;
            if (str.charAt(0) == str.charAt(1) || str.charAt(0) == str.charAt(2) || str.charAt(1) == str.charAt(2))
                continue;

            possible[i] = true;
        }

        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int ans = 123; ans < 1000; ans++) {
                if (possible[ans] == true) {
                    int ns = 0;
                    int nb = 0;

                    for (int k = 0; k < 3; k++) {
                        char numSp = Integer.toString(num).charAt(k);

                        for (int l = 0; l < 3; l++) {
                            char ansSp = Integer.toString(ans).charAt(l);

                            if (numSp == ansSp && k == l)
                                ns++;
                            else if (numSp == ansSp && k != l)
                                nb++;
                        }
                    }

                    if (ns == s && nb == b)
                        possible[ans] = true;
                    else
                        possible[ans] = false;
                }
            }
        }

        for (int a = 123; a < 1000; a++) {
            if (possible[a] == true)
                count++;
        }
        System.out.println(count);
    }
}
