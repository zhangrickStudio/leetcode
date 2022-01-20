import javax.swing.JWindow;

/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode node =  new ListNode();
            ListNode temp = node;
            int jinwei = 0;
            while(null != l1 || null != l2 || 0 != jinwei ){
                // 先加上一次进位
                int sum = 0 + jinwei;
                // 进位置0
                jinwei = 0;

                if(null != l1){
                    sum += l1.val;
                    l1 = l1.next;
                }
                if(null!= l2){
                    sum += l2.val;
                    l2 = l2.next;
                }
                
                // 获取新的进位
                jinwei = sum /10;

                temp.next = new ListNode(sum%10);
                temp = temp.next;

            }
            
            return node.next;
    }
}

// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }
// @lc code=end
