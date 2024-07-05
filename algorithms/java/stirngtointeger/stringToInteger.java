// source: https://leetcode.com/problems/string-to-integer-atoi/
// Author: Chen
// Date: Jul-5-2024

/****************************************************************************************************************************
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

 * The algorithm for myAtoi(string s) is as follows:

 * Whitespace: Ignore any leading whitespace (" ").
 * Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither present.
 * Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
 * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, 
 * integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
 * Return the integer as the final result.
 * 
 * Example 1:
 * Input: s = "42"
 * Output: 42
 * 
 * Example 2:
 * Input: s = " -042"
 * Output: -42
 * 
 * Example 3:
 * Input: s = "1337c0d3"
 * Output: 1337
 * 
**************************************************************************************************************************/

// Solution: iterate through the string, and convert the string to integer
// O(n) time complexity, O(1) space complexity
class Solution {
    public int myAtoi(String s) {
        
        int index =0;
        while(index<s.length() && s.charAt(index) == ' '){
            index++;
        }

        if(index == s.length()){
            return 0;
        }

        int sign = 1;
        if(s.charAt(index) == '+' || s.charAt(index) == '-'){
            if(s.charAt(index) == '-'){
                sign = -1;
            }
            index++;
        }

        int res = 0;
        while(index<s.length()){

            int digit = s.charAt(index) - '0';

            if(digit < 0 || digit > 9)
                break;
            
            if(res > Integer.MAX_VALUE / 10 || 
                res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10){
                
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;

            index++;

        }

        return res*sign;
    }
}