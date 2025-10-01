package leetcode;

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {      // 1개 이하면 그대로 반환
            return s;
        }

        int maxLen = 1;                     // 가장 긴 길이 저장
        String maxStr = s.substring(0, 1);  // 첫번째 문자 자르기

        for (int i = 0; i < s.length(); i++) {      // 전수 조사
            for (int j = i + maxLen; j <= s.length(); j++) {    // i + maxLen 부터 시작
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {    // maxLen보다 크고 팰린드롬수
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String str) {  // 팰린드롬 판단
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {      // 이중 포인터
            if (str.charAt(left) != str.charAt(right)) {    // 다르면 팰린드롬 아님
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
