package leetcode.q21;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = Integer.MIN_VALUE;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int temp_min = 0;

        while (!(l1.next == null && l2.next == null)) {
            if (l1.next == null)
                temp_min = l2.val;
            else if (l2.next == null)
                temp_min = l1.val;
            else {
                if (l1.val == l2.val) {
                    temp_min = l1.val;
                    l1 = l1.next;
                } else {
                    temp_min = Math.min(l1.val, l2.val);
                    if (temp_min == l1.val)
                        l1 = l1.next;
                    else
                        l2 = l2.next;
                }
            }
            result.val = temp_min;
            result.next = new ListNode();
            result = result.next;
        }

        return result;
    }
}
