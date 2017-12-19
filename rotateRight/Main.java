package rotateRight;

public class Main {
    public static void main(String[] args)
    {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next  = a2;
        a2.next  = a3;
       a2.next  = a3;a3.next  = a4;a4.next  = a5;a5.next  = null;
        Solution sl = new Solution();
        ListNode data = sl.rotateRight(a1,1);
        while(data.next != null)
        {
            System.out.println(data.val);
            data = data.next;
        }
        System.out.println(data.val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        if(head.next == null)
            return head;
        int i = 0;
        ListNode data = head;
        while(data.next!=null)
        {
            data = data.next;
            i++;
        }
        i++;
        if(k==0 || k % i==0)
        {
            return head;
        }
        k = k % i;k = i - k;
        ListNode body = head;

        while(--k>0)
        {
            head = head.next;
        }

        ListNode newhead = head.next,temp = head.next;
        head.next = null;
        while(newhead.next!=null)
        {
            newhead = newhead.next;
        }
        newhead.next = body;
        return temp;
    }
}