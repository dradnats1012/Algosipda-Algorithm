package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        List<Integer> A = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int j = 0; j < M; j++){
            if(binarySearch(A, Integer.parseInt(st.nextToken())) >= 0){
                sb.append(1 + "\n");
            }
            else{
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb);
    }

    public static int binarySearch(List<Integer> A, int key) {
        int low = 0;
        int high = A.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(key < A.get(mid)){
                high = mid - 1;
            } else if(key > A.get(mid)){
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
