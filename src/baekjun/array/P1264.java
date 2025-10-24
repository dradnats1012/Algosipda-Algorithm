package baekjun.array;

import java.io.*;
import java.util.*;

public class P1264 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static String[] vowels = {"a", "e", "i", "o", "u", "A", "E", "I", "O", "U"};

    public static void main(String[] args) throws IOException{

        while(true){
            String[] line = br.readLine().split("");
            if(line[0].equals("#")) return;

            int count = 0;
            for(int i = 0; i < line.length; i++){
                for(int j = 0; j < 10; j++){
                    if(line[i].equals(vowels[j])){
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}

/*
모음의 개수
모음 배열에 저장해놓고 포함하는지 돌리기?
 */