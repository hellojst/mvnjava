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
}


