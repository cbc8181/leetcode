// source: https://leetcode.com/problems/reverse-integer/
// Author: Chen
// Date: Jul-4-2024

/****************************************************************************************************************************
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 * 
 * Example 1:
 * Input: x = 123
 * Output: 321
 * 
 * Example 2:
 * Input: x = -123
 * Output: -321
 * 
**************************************************************************************************************************/

// Solution: pop the last digit of x, push it to the reverse, and check if the reverse is overflow
// O(log(x)) time complexity, O(1) space complexity
// n=log(x) -- n is the number of digits in x
class Solution {
    public int reverse(int x) {
        int pop = 0;
        int reverse = 0;

        while(x!=0){
            pop = x % 10;
            x = x / 10;

            if( reverse > Integer.MAX_VALUE / 10 || reverse == Integer.MAX_VALUE / 10 && pop > 7)
                return 0;
            
            if( reverse < Integer.MIN_VALUE / 10 || reverse == Integer.MIN_VALUE / 10 && pop < -8)
                return 0;
            
            reverse = reverse * 10 + pop;
        }

        return reverse;
    }
}