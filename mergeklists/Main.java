package nod.mergeklists;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Main {

}
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
        {
            return null;
        }
        int i=0;
        while(i<lists.length)
        {
            if(lists[i] != null)
            {
                break;
            }
            i++;
        }
        if(i == lists.length)
        {
            return null;
        }else
        {
            return divide(lists, 0, lists.length-1);
        }
    }
    public ListNode divide(ListNode[] lists,int left,int right){
        if (left < right)
        {
            int middle = (left + right) / 2;
            return mergeTwolists(divide(lists, left, middle), divide(lists,middle+1, right));
        }
        return lists[left];
    }
    public ListNode mergeTwolists(ListNode n1, ListNode n2)
    {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(n1!= null && n2 != null)
        {
            if(n1.val < n2.val)
            {
                result.next = n1;
                n1 = n1.next;
            }
            else{
                result.next = n2;
                n2 = n2.next;
            }
            result = result.next;
        }
        if(n1 != null)
        {
            result.next = n1;
        }
        else {
            result.next = n2;
        }
        return temp.next;
    }
}
//归并排序，就是将一个串分成两个，然后按大小排序，