package koreatech._20240706judge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class ProblemK {
    static List<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k = Integer.parseInt(br.readLine());

        findNums(k);

        bw.write(nums.size() + "\n");
        bw.flush();
        bw.close();
    }

    private static boolean checkThree(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '3') {
                return false;
            }
        }

        return true;
    }

    private static List<Integer> findNums(int k){
        for(int i = (int)Math.pow(10, k - 1); i < (int)Math.pow(10, k); i++){
            if(i % 3 != 0 && checkThree(Integer.toString(i))){
                nums.add(i);
            }
        }

        return nums;
    }
}
