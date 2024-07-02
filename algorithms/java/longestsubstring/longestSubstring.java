// source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Author: Chen
// Date: Jul-2-2024

/****************************************************************************************************************************
 * Given a string s, find the length of the longest substring without repeating characters.
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
**************************************************************************************************************************/

// Solution 1: use HashMap to store the character and its index,
//            then update the start index of the substring when a repeating character is found
// O(n) time complexity, O(n) space complexity
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character,Integer> hashmap = new HashMap();
        for(int i=0, j=0; i<s.length() ; i++ ){
            if( hashmap.containsKey(s.charAt(i)) ){
                j = Math.max(hashmap.get(s.charAt(i)) + 1, j);
            }
            hashmap.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }

        return max;
    }
}

// Solution 2: Brute force, check all the substrings
// O(n^2) time complexity, O(1) space complexity
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int p = 0 , q = 0;
        int max = 0;
        while(p< s.length()){
            q = p + 1;

            while(q < s.length()){
                boolean flag = false;
                for(int i = q - 1; i >= p ; i--){
                    if ( s.charAt(q) == s.charAt(i) ){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    break;
                }else{
                    q++;
                }
            }

            if(q-p > maxlen){
                maxlen = q - p;
            }

            p++;
        }

        return max;
    }
}