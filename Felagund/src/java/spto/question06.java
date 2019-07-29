package spto;

import spto.datastructure.ListNode;

import java.util.Stack;

public class question06 {
    public static void main (String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        System.out.println("printListReversingly_Iterativity() is below: ");
        printListReversingly_Recursively(p1);
        System.out.println("printListReversingly_Recursively() is below: ");
        printListReversingly_Recursively(p1);
    }
    public static void printListReversingly_Iterativity(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p=p.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }
    }
    public static void printListReversingly_Recursively(ListNode head) {
        if(head != null) {
            if(head.next != null) {
                printListReversingly_Recursively(head.next);
            }
            System.out.println(head.val + " ");
        }
    }
}
