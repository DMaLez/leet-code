package easy;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

import static easy.MergeTwoSortedLists.mergeTwoListsWrapper;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by
 * splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {

    public static int[] mergeTwoListsWrapper(int[] list1, int[] list2) {
        return toArray(mergeTwoLists(toList(list1), toList(list2)));
    }

    /**
     * Runtime: 1 ms, faster than 80.19% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 43.5 MB, less than 21.99% of Java online submissions for Merge Two Sorted Lists.
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode runner = list1;
        ListNode previous = list1;
        while (list2 != null) {
            while (runner != null && list2.val > runner.val) {
                previous = runner;
                runner = runner.next;
            }
            ListNode newNodeInList1 = new ListNode(list2.val);
            newNodeInList1.next = runner;
            list2 = list2.next;
            if (runner == list1) {
                list1 = newNodeInList1;
            } else {
                previous.next = newNodeInList1;
            }
            runner = list1;
            previous = list1;
        }
        return list1;
    }

    public static ListNode mergeTwoListsBadWrapper(int[] list1, int[] list2) {
        return mergeTwoListsBad(toList(list1), toList(list2));
    }

    /**
     * Runtime: 11 ms, faster than 6.24% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 43.5 MB, less than 16.87% of Java online submissions for Merge Two Sorted Lists.
     */
    public static ListNode mergeTwoListsBad(ListNode list1, ListNode list2) {
        List<Integer> resultList = new ArrayList<>();
        ListNode head = list1;
        while (head != null) {
            resultList.add(head.val);
            head = head.next;
        }
        head = list2;
        while (head != null) {
            resultList.add(head.val);
            head = head.next;
        }
        return toList(resultList.stream().sorted().mapToInt(i -> i).toArray());
    }

    public static int[] toArray(ListNode list) {
        List<Integer> array = new ArrayList<>();
        ListNode head = list;
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        return array.stream().mapToInt(i -> i).toArray();
    }

    public static ListNode toList(int[] array) {
        if (array.length == 0) {
            return null;
        }
        ListNode head = new ListNode();
        head.val = array[0];
        ListNode list = head;
        for (int i = 1; i < array.length; i++) {
            head.next = new ListNode(array[i]);
            head = head.next;
        }
        return list;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }


}
