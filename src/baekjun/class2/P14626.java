package baekjun.class2;

import java.io.*;
import java.util.*;

public class P14626 {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] arr;

    public static void main(String[] args) throws IOException{
        arr = br.readLine().split("");
        int sum = 0;
        int pos = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("*")){
                pos = i;
            } else {
                if(i % 2 == 0){
                    sum += Integer.parseInt(arr[i]);
                } else{
                    sum += 3 * Integer.parseInt(arr[i]);
                }
            }
        }

        for(int i = 0; i <= 9; i++){
            int plus;
            if(pos % 2 == 0){
                plus = i;
            } else {
                plus = i * 3;
            }

            if((sum + plus) % 10 == 0){
                System.out.println(i);
                return;
            }
        }
    }
}

/*
ISBN
마지막 숫자 체크기호
앞에서부터 각 자리마다 1 3 1 3 번갈아가면서 곱한거 더하고 10으로 나눈 나머지가 0이 되도록 하는 숫자 m사용

 */