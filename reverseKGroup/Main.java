package nod.reverseKGroup;

import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        ListNode listnode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listnode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        Solution sl = new Solution();
        ListNode head = sl.reverseKGroup(listnode1,3);
        System.out.println(head.val+"  "+head.next.val+"  "+head.next.next.val);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int cnt = 0;
        // get next group
        while (cur != null && cnt != k) {
            cur = cur.next;
            cnt++;
        }
        if (cnt == k) {
            cur = reverseKGroup(cur, k);
            // reverse
            while (0 <= --cnt) {
                ListNode tmp = head.next;
                System.out.println("0000" + "head     "  + head.val +"   head.next   " + head.next.val+"  "+"   cur     "+cur.val);

                head.next = cur;
                System.out.println("1111" + "head     "  + head.val +"   head.next   " + head.next.val+"  "+"   cur     "+cur.val);
                cur = head;
                System.out.println("2222" + "head     "  + head.val +"   head.next   " + head.next.val+"  "+"   cur     "+cur.val);
                head = tmp;
                System.out.println("3333" + "head     "  + head.val +"   head.next   " + head.next.val+"  "+"   cur     "+cur.val);

            }
            head = cur;
        }
//        System.out.println("3333" + "head" + head.val +"head.next" + head.next+"  "+"cur"+cur.val);
        return head;
    }
}