package archives;

class LinkedList {
    int val;
    LinkedList next;
    LinkedList(int x) { val = x; }
}

public class ReverseLinkedList {
    public static LinkedList reverse(LinkedList head) {
        LinkedList p = null;
        LinkedList q = head;
        LinkedList r = head;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
    }
    public static void main(String[] args) { //测试: 输入链表1->2->3 输出结果3 2 1
        LinkedList p1 = new LinkedList(1);
        LinkedList p2 = new LinkedList(2);
        LinkedList p3 = new LinkedList(3);
        p1.next = p2;
        p2.next = p3;
        LinkedList rev = reverse(p1);
        while (rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }

    }
}
