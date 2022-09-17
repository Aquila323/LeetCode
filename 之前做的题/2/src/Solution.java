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
    private ListNode headNode = null;
    private ListNode curResult = null;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int lastProm = 0;  // 当前Node前一个节点的进位标识
        ListNode firstCurPos = l1;
        ListNode secondCurPos = l2;
        while (firstCurPos != null || secondCurPos != null) {
            // 1.计算当前位val和进位符号
            int val = lastProm;
            if (firstCurPos != null) {
                val += firstCurPos.val;
            }
            if (secondCurPos != null) {
                val += secondCurPos.val;
            }

            lastProm = val / 10 == 1 ? 1 : 0;
            val = val % 10;

            // 2.创建新的Node并添加到result链表尾部
            ListNode tmpNode = new ListNode(val);
            addNodeToEnd(tmpNode);

            // 3.l1和l2当前指针都向后移动一位
            if (firstCurPos != null) {
                firstCurPos = firstCurPos.next;
            }
            if (secondCurPos != null) {
                secondCurPos = secondCurPos.next;
            }
        }
        if (lastProm != 0) {
            ListNode tmpNode = new ListNode(lastProm);
            addNodeToEnd(tmpNode);
        }
        return headNode;
    }

    private void addNodeToEnd(ListNode tmpNode) {
        if (tmpNode == null) {
            return;
        }
        if (headNode == null) {
            headNode = tmpNode;
        }
        if (curResult == null) {
            curResult = tmpNode;
        } else {
            curResult.next = tmpNode;
            curResult = tmpNode;
        }
    }
}