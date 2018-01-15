package LinkedListCycleII;

public class Main {
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null )
        {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
            {
                ListNode s1 = head;
                while(s1 != slow)
                {
                    s1 = s1.next;
                    slow = slow.next;
                }
                return s1;
            }
        }
        return null;

    }
}