package leetcode;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {

    }

    public int rob(int[] nums){
        int n = nums.length;

        if (n == 1) { // 집이 하나면 그 집만 털 수 있음
            return nums[0];
        }
        int[] withoutFirst = Arrays.copyOfRange(nums, 1, nums.length);

        int[] withoutLast = Arrays.copyOfRange(nums, 0, nums.length - 1);

        return Math.max(findRob(withoutFirst), findRob(withoutLast));
    }

    public int findRob(int[] nums){
        int n = nums.length;

        if (n == 1) {           // 하나면 그대로 털기
            return nums[0];
        }

        if(n == 2){             // 두개면 큰거 털기
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];  // dp용 배열 생성

        dp[0] = nums[0];        // 첫번째 저장
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            // i-1 번째 집까지
            // i 번째 + i-2번째 집
        }

        return dp[n - 1];
    }
}
