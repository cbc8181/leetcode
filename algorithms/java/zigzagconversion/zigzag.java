// source: https://leetcode.com/problems/zigzag-conversion/
// Author: Chen
// Date: Jul-3-2024

/****************************************************************************************************************************
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * 
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
**************************************************************************************************************************/

// Solution: different rows have same step, the step is (numRows - 1) * 2
//           for the middle rows, there is another character between two characters, the index is i + step - 2 * r
// O(n) time complexity, O(n) space complexity
class Solution {
    public String convert(String s, int numRows) {
    
        if(numRows ==1) return s; 

        int step = (numRows -1) * 2;
        StringBuilder res = new StringBuilder();
        
        for(int r=0; r<numRows; r++){
            for(int i=r; i<s.length();i += step){
                res.append( s.charAt(i) );
                if (r > 0 && r < numRows - 1 && (i + step - 2 * r) < s.length()) {
                    res.append(s.charAt(i + step - 2 * r));
                }
            }
        }

        return res.toString();
    }
}