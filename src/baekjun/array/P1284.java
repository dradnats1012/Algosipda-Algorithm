package baekjun.array;

import java.io.*;
import java.util.*;

public class P1284 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] size = {4, 2, 3, 3, 3, 3, 3, 3, 3, 3};

    public static void main(String[] args) throws IOException{
        while(true){
            String n = br.readLine();
            if(n.equals("0")) return;

            int pan = 2;

            String[] nums = n.split("");
            for(int i = 0; i < nums.length; i++){
                pan += size[Integer.parseInt(nums[i])];
            }

            pan += nums.length - 1;

            System.out.println(pan);
        }
    }
}


/*
집주소
각 숫자 사이 여백 1
1은 2
0은 4
나머지는 3을 차지
경계는 1씩 차이 -> 2차이
10 사이즈 배열 만들어서 사이즈 저장해놓고 더하면 될듯
 */