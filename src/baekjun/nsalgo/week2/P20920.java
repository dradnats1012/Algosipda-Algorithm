package baekjun.nsalgo.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m)
                continue;

            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> wordList = new ArrayList<>(count.keySet());

        wordList.sort((word1, word2) -> {
            int freq1 = count.get(word1);
            int freq2 = count.get(word2);

            if (freq1 != freq2) {
                return Integer.compare(freq2, freq1);
            } else if (word1.length() != word2.length()) {
                return Integer.compare(word2.length(), word1.length());
            } else {
                return word1.compareTo(word2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append('\n');
        }

        System.out.print(sb);
    }
}
