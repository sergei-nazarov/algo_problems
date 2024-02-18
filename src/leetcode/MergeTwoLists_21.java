package leetcode;

import leetcode.AddTwoNumbers_2.ListNode;

public class MergeTwoLists_21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            } else if (list2 == null) {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            } else if (list2.val > list1.val) {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            result = result.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        evoke(new ListNode(1, new ListNode(2, new ListNode(4))),
                new ListNode(1, new ListNode(3, new ListNode(4))));
        evoke(null, null);
        evoke(null, new ListNode(0));
    }

    static void evoke(ListNode node1, ListNode node2) {
        System.out.println(node1 + " - " + node2 + " : "
                + new MergeTwoLists_21().mergeTwoLists(node1, node2));
    }

}
