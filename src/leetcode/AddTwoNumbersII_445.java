package leetcode;

public class AddTwoNumbersII_445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l2 = reverse(l2);
        l1 = reverse(l1);
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (l2 != null || l1 != null || carry == 1) {
            int sum = carry;
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            result.next = new ListNode(sum % 10, null);
            result = result.next;
            carry = sum / 10;
        }
        return reverse(head.next);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(new AddTwoNumbersII_445().addTwoNumbers(ListNode.from(7, 2, 4, 3), ListNode.from(5, 6, 4)));
    }
}
