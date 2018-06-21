package stjia.algorithm;

import java.util.List;

public class LeetUtils {

    public static boolean canJump(int[] nums) {
        int lenth = nums.length;
        boolean[] isCanJumps = new boolean[lenth];
        isCanJumps[lenth - 1] = true;
        //从后往前计算每个点是否可以跳到最后一步，以前面所得到的boolean可最终得到第一个位置是否可以跳到最后一个位置
        for(int i = lenth - 2; i >= 0; i--) {
            if (nums[i] >= lenth - 1 - i) {
                isCanJumps[i] = true;
                continue;
            }
            boolean isCanjump = false;
            for (int j = 1; j <= nums[i]; j++) {
                if (isCanJumps[i + j]) {
                    isCanjump = true;
                    break;
                }
            }
            isCanJumps[i] = isCanjump;
        }
        return isCanJumps[0];
    }

    /**
     *两数相加 --  给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     * @param l1 第一个链表
     * @param l2 第二个链表
     * @return 结果
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //链头
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        // 进位
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {

            ListNode cur = new ListNode(0);
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            //处理进位
            carry = sum / 10;
            prev.next = cur;
            prev = cur;

            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }

    //所需数据结构
    static class ListNode {
        int val;
        ListNode next;

        @SuppressWarnings("unused")
        ListNode(int x) {
            val = x;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
