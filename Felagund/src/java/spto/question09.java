package spto;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class question09 {

    private LinkedList<Integer> queue = new LinkedList<>();

    public void push(int element) {
        queue.add(element);
        for(int i = 0;i < queue.size() - 1;i++) {
            queue.add(queue.poll());
        }
    }

    public int pop () {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
    public static void main (String[] args) {
        question09 q = new question09();
        q.push(1);
        q.push(2);
        q.push(4);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}

