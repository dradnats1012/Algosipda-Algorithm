package baekjun.nsalgo.week11;

import java.io.*;
import java.util.*;

public class P19638 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int count = 0;

        for(int i = 0; i < n; i++){
            q.add(Integer.parseInt(br.readLine()));
        }

        while(count <= t){
            int num = q.poll();
            if(h > num){               // 다 나보다 작음
                System.out.println("YES");
                System.out.println(count);
                return;
            }else if(num == 1 || count == t){           // 기회 없음
                System.out.println("NO");
                System.out.println(num);
                return;
            }else {
                q.add(num/2);
                count++;
            }
        }
    }
}


/*
N : 인구 수
H : 센티의 키
T : 뿅망치 횟수

정렬하고 처음부터 반복문
 */