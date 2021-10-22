package leetcode.q21;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
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
        ListNode firstNode = new ListNode(0);
        ListNode currentNode;

        currentNode = firstNode;
        int temp_min;

        if (l1 == null && l2 == null) return null;

        while (true) {
            if (l1 == null) {
                temp_min = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                temp_min = l1.val;
                l1 = l1.next;
            } else {
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

            currentNode.val = temp_min;

            if (l1 == null && l2 == null) break;

            currentNode.next = new ListNode(0);
            currentNode = currentNode.next;
        }
        return firstNode;
    }
}
