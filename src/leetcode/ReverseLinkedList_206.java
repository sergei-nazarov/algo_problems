package leetcode;

public class ReverseLinkedList_206 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode current = this;
            while (current != null) {
                sb.append(current.val);
                if (current.next != null) {
                    sb.append("-");
                }
                current = current.next;
            }
            return sb.toString();
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList_206 solution = new ReverseLinkedList_206();

// Список: 1 -> 2 -> 3 -> null
        System.out.println(solution.reverseList(new ListNode(1, new ListNode(2, new ListNode(3)))));
// Список: 4 -> 5 -> null
        System.out.println(solution.reverseList(new ListNode(4, new ListNode(5))));
// Пустой список: null
        System.out.println(solution.reverseList(null));
    }
}
