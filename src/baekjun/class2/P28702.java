package baekjun.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> arr = new ArrayList<>();
        String ans = "";

        for(int j = 0; j < 3; j++){
            arr.add(br.readLine());
        }

        for(int k = 0; k < 3; k++){
            if(arr.get(k).matches("[+-]?\\d*(\\.\\d)?")){
                int i = Integer.parseInt(arr.get(k)) + 3 - k;

                if(i % 3 == 0){
                    ans = "Fizz";
                    if(i % 5 == 0){
                        ans = "FizzBuzz";
                    }
                } else if(i%5==0){
                    ans = "Buzz";
                } else ans = Integer.toString(i);
            }
        }

        System.out.println(ans);
    }
}
