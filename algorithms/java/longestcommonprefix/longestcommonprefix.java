// source: https://leetcode.com/problems/longest-common-prefix/
// Author: Chen
// Date: Jul-10-2024

/****************************************************************************************************************************
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "". 
 * 
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings. 
 * 
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 * 
 **************************************************************************************************************************/

// Solution: Horizontal scanning approach to find the longest common prefix
// O(minLen * n) time complexity, where n is the number of strings in the input array and minLen is the length of the shortest string in the input array
// O(1) space complexity
class Solution {
    public String longestCommonPrefix(String[] strs) {
         if(strs.length == 1) 
            return strs[0];

        int strsMinLen = Integer.MAX_VALUE;

        for(int i=0; i< strs.length; i++){
            strsMinLen = Math.min(strsMinLen, strs[i].length());
        }

        int index =0;
        for( ; index < strsMinLen; index++){
            
            char c = strs[0].charAt(index);

            for(int j=1 ; j< strs.length; j++){
                if(c != strs[j].charAt(index)){
                    return strs[j].substring(0, index);
                }
            }
        }

        return strs[0].substring(0, index);
        }
    }

// Solution: Sorting approach to find the longest common prefix
// O(nlog(n)) time complexity, where n is the length of the longest string in the input array
// O(n) space complexity
class Solution {
    public String longestCommonPrefix(String[] strs) {
       if(strs.length == 1){
            return strs[0];
       }
        Arrays.sort(strs);

        int minLen = Math.min(strs[0].length(), strs[strs.length -1].length());
        
        for(int i=0; i< minLen; i++){
            if(strs[0].charAt(i) != strs[strs.length -1].charAt(i)){
                return strs[0].substring(0,i);
            }
        }

        return strs[0].substring(0, minLen);

    }
}