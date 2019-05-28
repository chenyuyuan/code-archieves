class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class test2 {
    public static ListNode reverse(ListNode head) {
        ListNode p = null;
        ListNode q = head;
        ListNode r = head;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
    public static void main(String[] args) { //测试: 输入链表1->2->3 输出结果3 2 1
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p1.next = p2;
        p2.next = p3;
        ListNode rev = reverse(p1);
        while (rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }

    }
}
