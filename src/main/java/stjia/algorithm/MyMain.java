package stjia.algorithm;

import stjia.algorithm.LeetUtils.ListNode;

public class MyMain {
    public static void main(String[] args) {
//        System.out.println("hello world");
//        ListNode l1=new ListNode(2);
//        ListNode l2=new ListNode(4);
//        ListNode l3=new ListNode(3);
//        l1.next=l2;
//        l2.next=l3;
//
//        ListNode l4=new ListNode(5);
//        ListNode l5=new ListNode(6);
//        ListNode l6=new ListNode(4);
//        l4.next=l5;
//        l5.next=l6;
//
//        ListNode result = LeetUtils.addTwoNumbers(l1, l4);
//        printListNode(result);

        char[][] chars = new char[][]{{'a','b','c', 'e'},{'s','f','e','s'},{'a','d','e','e'}};
        boolean istrue = LeetUtils.exist(chars, "abceseeefs");
        System.out.println(istrue);

        int[][] ints = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        LeetUtils.setZeroes(ints);
        printArray(ints);
    }

    private static void printListNode(ListNode node){
        System.out.print("[");
        if (node != null) System.out.print(node.val);
        while (node.next != null) {
            System.out.print(",");
            System.out.print(node.val);
        }
        System.out.print("]");
    }

    private static void printArray(int[][] ints){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0 ; i < ints.length; i++) {
            stringBuilder.append("[");
            for (int j = 0; j < ints[0].length; j++) {
                stringBuilder.append(ints[i][j] + ",");
            }
            stringBuilder.append("]");
            stringBuilder.append(";");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
}


