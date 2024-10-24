public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution();

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2 );
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3 );
        list2.next.next = new ListNode(4);

        System.out.println(solution.mergeTwoLists(list1,list2));


    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // Create a dummy node to simplify edge cases
            ListNode dummy = new ListNode(-1);
            ListNode current = dummy;

            // Traverse both lists and append the smaller node to the result list
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    current.next = list1;
                    list1 = list1.next;
                } else {
                    current.next = list2;
                    list2 = list2.next;
                }
                current = current.next;
            }

            // If one of the lists is not fully traversed, append the remaining part
            if (list1 != null) {
                current.next = list1;
            } else {
                current.next = list2;
            }

            // Return the merged list starting from the node after dummy
            return dummy.next;
        }
    }


}