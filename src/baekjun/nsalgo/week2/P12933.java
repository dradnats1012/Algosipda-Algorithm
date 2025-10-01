package baekjun.nsalgo.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        boolean[] v = new boolean[str.length];
        int k = 0;
        char[] duck = {'q', 'u', 'a', 'c', 'k'};
        int count = 0;
        if (str[0] != 'q' || str.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < str.length; i++) {
            List<Character> arr = new ArrayList<>();
            for (int j = 0; j < str.length; j++) {
                if (!v[j] && str[j] == duck[k]) {
                    k++;
                    arr.add(str[j]);
                    v[j] = true;
                    if (k == 5) {
                        k = 0;
                    }
                }
            }
            if(arr.size() != 0){
                if(arr.get(arr.size() - 1) != 'k'){
                    System.out.println(-1);
                    return;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
