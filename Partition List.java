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
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode prev = smaller;
        ListNode greater = new ListNode(0);
        ListNode nextt = greater;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                prev.next = temp;
                prev = prev.next;
                temp = temp.next;
            }else{
               nextt.next = temp;
                nextt = nextt.next;
                temp =temp.next;
                
            }
        }
        prev.next = greater.next;
        nextt.next = null;
        return smaller.next;
    }
}