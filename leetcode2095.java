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
        if(head==null) return head;
        if(head.next==null) return null;
        if(head.next.next==null) {
            head.next=null;
            return head;
        }
        ListNode fast=head;
        ListNode slow =head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp = head;
        while(temp.next!=slow){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        slow.next=null;
        return head;
    }
}

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
        if(head==null || head.next==null) return null;
        ListNode fast=head;
        ListNode slow = null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(slow==null) slow=head;
            else  slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
        
    }
}