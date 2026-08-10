/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int count1=0;
        int count2=0;

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1!=null){
            count1++;
            temp1=temp1.next;
        }

        while(temp2!=null){
            count2++;
            temp2=temp2.next;
        }
        temp1 = headA;
        temp2=headB;
        int diff=Math.abs(count2-count1);
        if(count2>count1){
            for(int i=0;i<diff;i++){
                temp2=temp2.next;
            }
        }
        else{
            for(int i=0;i<diff;i++){
                temp1=temp1.next;
            }
        }

        while(temp1!=null && temp2!=null){
            if(temp1==temp2) return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }
}