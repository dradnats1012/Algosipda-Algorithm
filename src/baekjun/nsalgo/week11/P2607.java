package baekjun.nsalgo.week11;

import java.io.*;

public class P2607 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        String base = br.readLine();
        int result = 0;

        int[] baseCount = new int[26];
        for(int i = 0; i < base.length(); i++){
            baseCount[base.charAt(i) - 'A']++;
        }

        String word;
        int[] wordCount;
        int sum;

        for(int i = 0; i < n - 1; i++){
            word = br.readLine();
            wordCount = new int[26];
            for(int j = 0; j < word.length(); j++){
                wordCount[word.charAt(j) - 'A']++;
            }

            sum = 0;
            for(int k = 0; k < 26; k++){
                sum += Math.abs(baseCount[k] - wordCount[k]);
            }
            int lenDiff = Math.abs(base.length() - word.length());

            if(sum == 0 || sum == 1 || (sum == 2 && lenDiff == 0)){
                result++;
            }
        }

        System.out.println(result);
    }
}


/*
비슷한 단어

첫째 줄 : 단어의 개수 N
둘째 줄 : 기준 단어
셋째 줄 ~ 마지막 줄 : 비교당할 단어들

기준 단어를 split 해서 배열에 저장

(n-1만큼 반복)
비교 당할 단어를 split 해서 배열에 있는지 확인
    if(있으면) 해당 배열 제거
    else(없으면) count++
count가 -1, 0, 1 이면 비슷한 단어


*/
