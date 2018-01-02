package RemoveDuplicatesfromSortedListII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        ListNode tempa = new ListNode(1);
        ListNode test = tempa;
        for(int i=0;i<5;i++)
        {
            ListNode temp = new ListNode(i);
            tempa.next = temp;
            tempa = tempa.next;
        }
        System.out.print(test);
        ListNode head = sl.deleteDuplicates(test);
        System.out.print(head);
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        if(head.next != null && head.val == head.next.val)
        {
            while (head.next!=null && head.val == head.next.val)
            {
                head = head.next;
            }
            return deleteDuplicates(head.next);
        }else {
            head.next = deleteDuplicates(head.next);
        }
        return head;

    }
}