package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reverse = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = reverse;
            reverse = slow;
            slow = next;
        }

        while (reverse != null) {
            if (reverse.val != head.val) {
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
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
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeLinkedList_234().isPalindrome(new ListNode(1)));
        System.out.println(new PalindromeLinkedList_234().isPalindrome(new ListNode(1, new ListNode(2))));
        System.out.println(new PalindromeLinkedList_234().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
        System.out.println(new PalindromeLinkedList_234().isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));


    }
}
