package baekjun.nsalgo.week12;

import java.io.*;
import java.util.*;

public class P19941 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String[] bench = br.readLine().split("");
        boolean[] eat = new boolean[bench.length];
        int count = 0;

        for(int i = 0; i < bench.length; i++){
            if(bench[i].equals("P")){
                for(int j = -k; j <= k; j++){
                    if((i + j) >= 0 && (i + j) < n && bench[i + j].equals("H") && !eat[i + j]){
                        eat[i + j] = true;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}


/*
범위 k 내에 있는 가장 왼쪽에 있는 햄버거를 선점 후 카운트 증가
 */