package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, -2, -1};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();


        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right =  nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<> (result);
    }
}
