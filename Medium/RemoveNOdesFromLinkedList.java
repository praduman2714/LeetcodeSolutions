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
    public ListNode removeNodes(ListNode head) {
        
        ListNode temp = reverseLL(head);
        ListNode curr = temp;
        int max = curr.val;
        while(curr.next != null){
            if(curr.next.val < max){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
                max = curr.val;
            }
        }
        return reverseLL(temp);
        
    }
    public ListNode reverseLL(ListNode head){
        if(head == null) return head;
        ListNode prev = null;
        //ListNode temp = head;
        while(head != null){
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        
        return prev;
    }
}