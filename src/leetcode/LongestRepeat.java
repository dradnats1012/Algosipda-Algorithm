package leetcode;


public class LongestRepeat {
    public static void main(String[] args) {
        String s = "AABB";
        int k = 2;

        System.out.println(charcaterReplacement(s, k));
    }

    public static int charcaterReplacement(String s, int k) {
        int length = s.length();
        int max = 0;

        for (char c = 'A'; c <= 'Z'; c++) {
            int i = 0, j = 0, replaced = 0;
            while(j < length) {
                if (k >= length - 1) {  // k가 최대 길이와 같으면 길이와 같음
                    return length;
                }else if(s.charAt(j) == c){ // 같으면 길이를 하나 증가
                    j++;
                }
                else if (replaced < k){     // 대체가 k보다 작으면 일단 하나 올림
                    j++;
                    replaced++;
                }
                else if (s.charAt(i) == c){     //
                    i++;
                } else {
                    i++;
                    replaced--;
                }
                max = Math.max(max, j -1);
            }
        }

        return max;
    }
}
