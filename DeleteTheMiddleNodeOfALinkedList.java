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
    public ListNode deleteMiddle(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        temp = head;
        ListNode tt = new ListNode(-1);
        ListNode res = tt;
        for(int i = 0; i<len/2; i++){
            res.next = temp;
            res = res.next;
            temp = temp.next;
        }
        temp = temp.next;
        for(int i = len/2+1; i<len; i++){
            res.next = temp;
            res = res.next;
            temp = temp.next;
        }
        res.next = null;
        return tt.next;
    }
}
// Time Complexity : O(N)
// Space Complexity : O(N)

Optimal Approach
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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        ListNode node = slow;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //System.out.println(slow.val);
        
        
        slow.next = slow.next.next;
        
        
        return node;
    }
}

Time Complexity : O(N)
Space Complexity : O(1)
