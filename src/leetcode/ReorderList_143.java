package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ReorderList_143 {
    ListNode temp;
    boolean isStop;

    public void reorderList(ListNode head) {
        temp = head;
        isStop = false;
        reorder(head);
    }

    private void reorder(ListNode head) {
        if (head == null) return;
        reorder(head.next);

        if (!isStop) {
            ListNode next = temp.next;
            temp.next = head;
            head.next = next;
            temp = next;
        }
        if (temp != null && temp.next == head) {
            temp.next = null;
            isStop = true;
        }
    }

    public static void main(String[] args) {
        ReorderList_143 solution = new ReorderList_143();
        solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3))));
        solution.reorderList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        solution.reorderList(new ListNode(1, new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(3))))));
        solution.reorderList(new ListNode(4, new ListNode(5)));
        solution.reorderList(null);
    }

}
