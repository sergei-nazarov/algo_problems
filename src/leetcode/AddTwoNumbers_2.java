package leetcode;

import org.w3c.dom.NodeList;

import java.util.List;

public class AddTwoNumbers_2 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode next = result;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;

            int sum = first + second + carry;
            next.next = new ListNode(sum % 10);
            carry = sum / 10;
            next = next.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode listNode2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        System.out.println(new AddTwoNumbers_2().addTwoNumbers(listNode1, listNode2));
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return val + (next == null ? "" : "," + next);
        }
    }

}
