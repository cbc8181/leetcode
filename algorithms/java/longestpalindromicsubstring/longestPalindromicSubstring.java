// source: https://leetcode.com/problems/longest-palindromic-substring/
// Author: Chen
// Date: Jul-3-2024

/****************************************************************************************************************************
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
**************************************************************************************************************************/

// Solution: iterate through the string, expand from the middle to find the longest palindrome
// O(n^2) time complexity, O(1) space complexity
class Solution {
    public String longestPalindrome(String s) {
      
        if(s == null || s.length() < 1) return "";
       
        int start = 0;
        int end = 0;

        for(int i=0; i< s.length(); i++){
            int len1 = expandFromMiddle(i, i ,s);
            int len2 = expandFromMiddle(i, i+1, s);
            int len = Math.max(len1, len2);

            if(len > end - start){
                start = i - (len - 1)  / 2;
                end = i + len /2;
            }
        }

        // return String.format("%d, %d", start, end);
        return s.substring(start,end + 1);

    }

    public int expandFromMiddle(int i, int j, String s){
        
        if(s== null || i > j) return 0;

        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j) ){
            i--;
            j++;
        }

        int length = j - i - 1;

        return length;
    }
}