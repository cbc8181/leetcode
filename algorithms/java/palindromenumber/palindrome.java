// source: https://leetcode.com/problems/palindrome-number/
// Author: Chen
// Date: Jul-6-2024

/****************************************************************************************************************************
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * 
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * 
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * 
**************************************************************************************************************************/

// Solution:  Reverse half of the number, and compare the first half with the second half
// O(log10(n)) time complexity, O(1) space complexity
class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0){
            return true;
        }

        if(x < 0 || x % 10 == 0){
            return false;
        }

        int reverse = 0;
        while( x > reverse ){
            int pop = x % 10;
            reverse = reverse * 10 + pop;
            x = x / 10;
        }

        if( x == reverse || x == reverse / 10){
            return true;
        }

        return false;
    }
}