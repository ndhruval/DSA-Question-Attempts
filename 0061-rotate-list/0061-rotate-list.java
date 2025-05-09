class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        int c = 1;
        while (temp.next != null) {
            c++;
            temp = temp.next;
        }

        k = k % c;
        if (k == 0) return head;

        temp.next = head; // make it circular

        int d = c - k;
        ListNode temp2 = head;
        for (int i = 1; i < d; i++) {
            temp2 = temp2.next;
        }

        ListNode temp3 = temp2.next;
        temp2.next = null;

        return temp3;
    }
}
