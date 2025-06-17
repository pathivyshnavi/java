class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class LinkedListMergeSort {

    // Main function to sort linked list using merge sort
    public static ListNode mergeSort(ListNode head) {
        // Base case: if head is null or only one element
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into halves
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;

        // Break the list at the middle
        middle.next = null;

        // Step 2: Recursively sort the left and right halves
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMiddle);

        // Step 3: Merge the sorted halves
        return sortedMerge(left, right);
    }

    // Utility function to merge two sorted linked lists
    private static ListNode sortedMerge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode result;

        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }

        return result;
    }

    // Utility function to get the middle of the linked list using slow-fast pointers
    private static ListNode getMiddle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        // Create linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Original List:");
        printList(head);

        head = mergeSort(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
