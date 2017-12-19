package RemoveDuplicatesfromSortedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {
}



class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newhead = head;
        if(head == null)
        {
            return head;
        }
        while(head.next != null)
        {
            if (head.val == head.next.val)
            {
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }
        return newhead;
    }
}