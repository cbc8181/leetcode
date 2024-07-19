// source: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// difficulty: Medium
// Author: Chen
// Date: Jul-19-2024

/****************************************************************************************************************************
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * 
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * Example 2:
 * Input: digits = ""
 * Output: []
 * 
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * Constraints:
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
**************************************************************************************************************************/

// Solution: use a linkedlist to store the result, and use a for loop to iterate the digits
// Time complexity: O(3^n * 4^m), Space complexity: O(3^n * 4^m)
class Solution {
    public List<String> letterCombinations(String digits) {
        
        LinkedList<String> output_arr = new LinkedList();

        if(digits.length() == 0){ 
            return output_arr;
        }

        output_arr.add("");

        String[] charmap = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        for(int i=0;i<digits.length(); i++){
            int index = Character.getNumericValue(digits.charAt(i));

            while(output_arr.peek().length() == i){
                String pemp = output_arr.remove();
                for(char c : charmap[index].toCharArray()){
                    output_arr.add(pemp + c);
                }
            }
        }

        return output_arr;
    }
}