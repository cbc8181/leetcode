// source: https://leetcode.com/problems/3sum/
// difficulty: Medium
// Author: Chen
// Date: Jul-11-2024

/****************************************************************************************************************************
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation: 
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * 
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * 
 * Example 3:
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 * 
 * Constraints:
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
**************************************************************************************************************************/

// Solution: sort the array, then use two pointers to find the sum of three numbers
// O(n^2) time complexity, O(1) space complexity
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        int x=  Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip the same `nums[i]` to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip the same `nums[left]` and `nums[right]` to avoid duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}


// Solution: use hashmap to store the complement of the target
// O(n^2) time complexity, O(n) space complexity
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        for(int i =0; i < nums.length - 2; i++){
            int target = -nums[i];

            HashMap<Integer,Integer> hsmap = new HashMap<>();
            for(int j= i+1; j<nums.length; j++){
                int complement = target - nums[j];

                if(hsmap.containsKey(complement)){
                    List<Integer> newlist = Arrays.asList(nums[i], complement, nums[j]);
                    Collections.sort(newlist);
                    
                    boolean flag = false;
                    for(List<Integer> tmpres : res){
                        if(tmpres.equals(newlist)){
                            flag = true;
                            break;
                        }
                    }

                    if(!flag){
                        res.add(newlist);
                    }
                }

                hsmap.put(nums[j], j);
            }
        }
        return res;

    }
}