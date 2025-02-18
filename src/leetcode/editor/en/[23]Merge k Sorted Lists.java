//You are given an array of k linked-lists lists, each linked-list is sorted in 
//ascending order. 
//
// Merge all the linked-lists into one sorted linked-list and return it. 
//
// 
// Example 1: 
//
// 
//Input: lists = [[1,4,5],[1,3,4],[2,6]]
//Output: [1,1,2,3,4,4,5,6]
//Explanation: The linked-lists are:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//merging them into one sorted list:
//1->1->2->3->4->4->5->6
// 
//
// Example 2: 
//
// 
//Input: lists = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: lists = [[]]
//Output: []
// 
//
// 
// Constraints: 
//
// 
// k == lists.length 
// 0 <= k <= 10⁴ 
// 0 <= lists[i].length <= 500 
// -10⁴ <= lists[i][j] <= 10⁴ 
// lists[i] is sorted in ascending order. 
// The sum of lists[i].length will not exceed 10⁴. 
// 
//
// Related Topics Linked List Divide and Conquer Heap (Priority Queue) Merge 
//Sort 👍 20073 👎 741

package leetcode.editor.en;
 class MergeKSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode L1 = new ListNode(2);
        L1.next = new ListNode();
        ListNode L2 = new ListNode(1);
        L2.next = new ListNode(3);
        ListNode[] lists = {L1,L2};
        ListNode merge = solution.mergeKLists(lists);
        while(merge != null) {
            System.out.print(merge.val +"->");
            merge = merge.next;
        }

    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        //  1.lists is a ListNode <ListNode> ,we can get the first ListNode through head
        //  also we could get the second listlists through the first dot next;
        //  2. merge all linklist priorly then sort them.
        //  Or get one merge one until the last.
        int n = lists.length;
        if (n == 0) return null;
        ListNode dummy = new ListNode(Integer.MIN_VALUE), head = dummy;
        for (ListNode tem : lists) {
            head = mergeTwoLinkedList(head, tem);
        }
        return dummy.next;

    }
    public ListNode mergeTwoLinkedList(ListNode l1,ListNode l2) {
        ListNode dummyHead = new ListNode(),accessPoint = dummyHead;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                accessPoint.next = l1;
                l1 = l1.next;
            } else {
                accessPoint.next = l2;
                l2 = l2.next;
            }
            accessPoint = accessPoint.next;
        }
        if (l1 != null) {
            accessPoint.next = l1;
        }
        if (l2 != null) {
            accessPoint.next = l2;
        }
        return dummyHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}