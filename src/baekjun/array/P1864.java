package baekjun.array;

import java.io.*;
import java.util.*;

public class P1864 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] arr = {"-", "\\", "(", "@", "?", ">", "&", "%", "/"};

    public static void main(String[] args) throws IOException{
        while(true){
            String[] input = br.readLine().split("");
            if(input[0].equals("#")) return;
            int total = 0;

            for(int i = 0; i < input.length; i++){      //
                for(int j = 0; j < arr.length; j++){
                    if(input[i].equals("/")) {
                        total -= (int)Math.pow(8, (input.length - i - 1));
                        break;
                    }
                    else if(input[i].equals(arr[j])){
                        total += j * (int)Math.pow(8, (input.length - i - 1));
                    }
                }
            }
            System.out.println(total);
        }
    }
}

/*
문어 숫자
문자에 대응하는 위치에 저장해두기 -> -1은? -> 조건처리 ㄱ
 */