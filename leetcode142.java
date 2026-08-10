/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;

        int ans = 0;
        temp = head;

        while (temp != slow) {
            temp = temp.next;
            slow = slow.next;
        }

        return temp;

    }
}

------------------------------------------------------------------------------------------------
//Hashset Method
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode temp = head;

        while(temp!=null){
            if(set.contains(temp)){
                return temp;
            }
            else{
                set.add(temp);
            }
            temp=temp.next;
        }
        return null;
    }
}

