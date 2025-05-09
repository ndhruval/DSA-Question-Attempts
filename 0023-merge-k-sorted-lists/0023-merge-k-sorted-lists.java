class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode(0);
        ListNode x = ans;
        for (int i = 0; i < lists.length; i++) {
            ans.next = merge2Lists(lists[i], ans.next);
        }
        return x.next;
    }

    public static ListNode merge2Lists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;

        return dummy.next;
    }
}
