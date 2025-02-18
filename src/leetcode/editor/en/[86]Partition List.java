//Given the head of a linked list and a value x, partition it such that all 
//nodes less than x come before nodes greater than or equal to x. 
//
// You should preserve the original relative order of the nodes in each of the 
//two partitions. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [2,1], x = 2
//Output: [1,2]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 200]. 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics Linked List Two Pointers 👍 7581 👎 918

package leetcode.editor.en;
 class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode partition = solution.partition(head, 3);
        while(partition != null) {
            System.out.print(partition.val + "->");
            partition = partition.next;
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
    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;
        //1.according to value x, divide LinkList into two linklists which the first less than x, the second greater than or equal x.
        //2. merge two linklist.
        ListNode dummy = head, lessList = new ListNode(),greatList = new ListNode();
        ListNode lessHead = lessList, greaterHead = greatList;
        while(dummy != null) {
            if (dummy.val < x) {
                lessList.next = new ListNode(dummy.val);
                lessList = lessList.next;
            } else {
                greatList.next = new ListNode(dummy.val);
                greatList = greatList.next;
            }
            // 不能直接让 p 指针前进，
            // p = p.next
            // 断开原链表中的每个节点的 next 指针
//            ListNode temp = p.next;
//            p.next = null;
//            p = temp;
            dummy = dummy.next;
        }


        lessList.next = greaterHead.next;
        return lessHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}