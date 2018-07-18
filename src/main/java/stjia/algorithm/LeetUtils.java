package stjia.algorithm;

import jdk.nashorn.api.tree.IfTree;

import java.util.ArrayList;
import java.util.List;

public class LeetUtils {

    public static boolean canJump(int[] nums) {
        int lenth = nums.length;
        boolean[] isCanJumps = new boolean[lenth];
        isCanJumps[lenth - 1] = true;
        //从后往前计算每个点是否可以跳到最后一步，以前面所得到的boolean可最终得到第一个位置是否可以跳到最后一个位置
        for (int i = lenth - 2; i >= 0; i--) {
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
     * 两数相加 --  给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
     *
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

    /**
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                while (j > 0 && nums[j - 1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                    j--;
                }
            }
        }
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        return midTraversal(root, results);
    }

    private static List<Integer> midTraversal(TreeNode node, List<Integer> resultList) {
        if (node == null) return resultList;
        resultList = midTraversal(node.left, resultList);
        resultList.add(node.val);
        resultList = midTraversal(node.right, resultList);
        return resultList;
    }

    /**
     * 二叉树的序列化与反序列化
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     *
     */
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//
//    }
//
//    /**
//     * 反序列化
//     */
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//
//    }

    /**
     * 回溯算法
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] isUsed = new boolean[board.length][board[0].length]; //boolean 初始为false
                if (dfs(board, word, i, j, 0, isUsed)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归查找
     *
     * @param board
     * @param word
     * @param i
     * @param j
     * @param index
     * @param isUsed 在此之前所有已用状态
     * @return
     */
    private static boolean dfs(char[][] board, String word, int i, int j, int index, boolean[][] isUsed) {
        if (index >= word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index) || isUsed[i][j]) {
            return false;
        }

//        用时置为true
        isUsed[i][j] = true;
        //上下左右取点判断
        boolean result = dfs(board, word, i + 1, j, index + 1, isUsed) || dfs(board, word, i - 1, j, index + 1, isUsed)
                || dfs(board, word, i, j - 1, index + 1, isUsed) || dfs(board, word, i, j + 1, index + 1, isUsed);
        //用完，回溯时将未占用的恢复
        isUsed[i][j] = false;
        return result;
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
