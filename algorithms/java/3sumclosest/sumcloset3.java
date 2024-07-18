// source: https://leetcode.com/problems/3sum-closest/
// difficulty: Medium
// Author: Chen
// Date: Jul-18-2024

/****************************************************************************************************************************
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * 
 * Example 1:
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 * Constraints:
 * 3 <= nums.length <= 500
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
**************************************************************************************************************************/

// Solution: sort the array, then use two pointers to find the closest sum
// Time complexity: O(n^2), Space complexity: O(1)
class Solution {

    public int threeSumClosest(int[] nums, int target) {

        int near = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i=0 ; i<nums.length - 2; i++){

            int j = i +1;
            int k = nums.length -1;
            
            while( j <  k){
                int sum = nums[i] + nums[j] + nums[k];

                if(sum == target){
                    return sum;
                }else if( sum < target ){

                    if( target - sum < diff){
                        diff = target - sum;
                        near = sum;
                    }
                    
                    j++;
                }else {

                    if(sum - target < diff){
                        diff = sum - target;
                        near = sum;
                    }

                    k--;
                }

            }

        }

        return near;
    }
}