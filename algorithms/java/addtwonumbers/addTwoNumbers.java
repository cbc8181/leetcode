// source: https://leetcode.com/problems/add-two-numbers/
// Author: Chen
// Date: Jun-28-2024

/****************************************************************************************************************************
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
**************************************************************************************************************************/

// Solution: iterate through the two linked lists, add the two numbers and carry,
//           then create a new node with the sum % 10 and update the carry
// O(n) time complexity, O(n) space complexity

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        ListNode res = new ListNode();
        ListNode cur = res;

        while(p!= null || q!=null){
            int x = p != null? p.val : 0;
            int y = q != null? q.val : 0;

            int num = carry + x + y;

            cur.next = new ListNode(num % 10);
            carry = num / 10;

            if(p!=null) p=p.next;
            if(q!=null) q=q.next;
            cur = cur.next;
        }

        if(carry != 0){
            cur.next = new ListNode(carry);
        }

        return res.next;
    }
}
