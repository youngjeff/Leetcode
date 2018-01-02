package PartitionList;

import java.util.List;

public class Main {
    public  static void main(String[] args)
    {
        ListNode head = new ListNode(0);
        ListNode head_pre = head;
        for(int i=0;i<5;i++)
        {
            ListNode heada = new ListNode(i);
            head.next = heada;
            head = head.next;
        }
        Solution sl = new Solution();
        ListNode test = sl.partition(head_pre,3);
        System.out.print(test);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null)
        {
            return null;
        }
        ListNode Head1 = new ListNode(0);
        ListNode head1 = Head1;
        ListNode Head2 = new ListNode(0);
        ListNode head2 = Head2;
        while(head != null)
        {
            if(head.val <x)
            {
                Head1.next = head;
                Head1 = Head1.next;
                Head1.next = null;
            }
            else{
                Head2.next = head;
                Head2 = Head2.next;
                Head2.next = null;
            }
            head = head.next;
        }
        Head1.next = head2.next;
        return head1.next;
    }
}